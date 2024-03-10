package io.github.thepoultryman.particlemoths;

import io.github.thepoultryman.particlemoths.config.ParticleMothsConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParticleMoths implements ClientModInitializer {
	public static final String MOD_ID = "particlemoths";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final DefaultParticleType MOTH = FabricParticleTypes.simple();

	public static final ParticleMothsConfig CONFIG = new ParticleMothsConfig();

	@Override
	public void onInitializeClient() {
		LOGGER.info("Initializing (Particle) Moths");
		CONFIG.load();

		Registry.register(Registries.PARTICLE_TYPE, new Identifier(MOD_ID, "moth"), MOTH);
		ParticleFactoryRegistry.getInstance().register(ParticleMoths.MOTH, MothParticle.Factory::new);

		ClientTickEvents.END_CLIENT_TICK.register(this::createMothParticle);
	}

	private void createMothParticle(MinecraftClient client) {
		if (client.world == null || !MothSpawnHelper.shouldSpawnMoth(client)) return;

		World world = client.world;
		PlayerEntity player = client.player;

		BlockPos spawnPos = MothSpawnHelper.getSpawnCoordinates(player.getBlockPos());
		if (!MothSpawnHelper.isValidMothSpawn(world, spawnPos, client)) return;
		double[] velocities = MothSpawnHelper.getVelocity();

		world.addParticle((ParticleEffect) Registries.PARTICLE_TYPE.get(new Identifier("particlemoths:moth")),
				spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), velocities[0], velocities[1], velocities[2]);
	}
}
