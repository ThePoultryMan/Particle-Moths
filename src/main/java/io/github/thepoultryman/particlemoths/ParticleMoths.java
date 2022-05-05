package io.github.thepoultryman.particlemoths;

import io.github.thepoultryman.particlemoths.config.ParticleMothsConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ParticleMoths implements ClientModInitializer {
	public static final String MOD_ID = "particlemoths";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static ParticleMothsConfig CONFIG;

	public static final DefaultParticleType MOTH = FabricParticleTypes.simple();

	@Override
	public void onInitializeClient() {
		LOGGER.info("Initializing (Particle) Moths");

		AutoConfig.register(ParticleMothsConfig.class, Toml4jConfigSerializer::new);
		CONFIG = AutoConfig.getConfigHolder(ParticleMothsConfig.class).getConfig();

		Registry.register(Registry.PARTICLE_TYPE, new Identifier(MOD_ID, "moth"), MOTH);
		ParticleFactoryRegistry.getInstance().register(ParticleMoths.MOTH, MothParticle.Factory::new);

		ClientTickEvents.END_CLIENT_TICK.register(this::createMothParticle);
	}

	private void createMothParticle(MinecraftClient client) {
		if (client.world == null || !MothSpawnHelper.shouldSpawnMoth()) return;

		World world = client.world;
		PlayerEntity player = client.player;
		Random random = world.getRandom();
		double velocity = world.getRandom().nextDouble(-0.75D, 0.75D);
		double spawnX = player.getX() + random.nextDouble(-30, 30);
		double spawnY = player.getY() + random.nextDouble(-30, 30);
		double spawnZ = player.getZ() + random.nextDouble(-30, 30);

		if (!CONFIG.movementConfig.specificVelocities) {
			velocity *= (CONFIG.movementConfig.xVelocity / 100f);
			world.addParticle((ParticleEffect) Registry.PARTICLE_TYPE.get(new Identifier("particlemoths:moth")),
					spawnX, spawnY, spawnZ, velocity, velocity, velocity);
		} else {
			world.addParticle((ParticleEffect) Registry.PARTICLE_TYPE.get(new Identifier("particlemoths:moth")),
					spawnX, spawnY, spawnZ,
					velocity * (CONFIG.movementConfig.xVelocity / 100f),
					velocity * (CONFIG.movementConfig.yVelocity / 100f),
					velocity * (CONFIG.movementConfig.zVelocity / 100f));
		}
	}
}
