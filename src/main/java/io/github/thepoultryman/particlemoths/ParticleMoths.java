package io.github.thepoultryman.particlemoths;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
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

public class ParticleMoths implements ModInitializer {
	public static final String MOD_ID = "particlemoths";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final DefaultParticleType MOTH = FabricParticleTypes.simple();

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing (Particle) Moths");

		Registry.register(Registry.PARTICLE_TYPE, new Identifier(MOD_ID, "moth"), MOTH);

		ClientTickEvents.END_CLIENT_TICK.register(this::createMothParticle);
	}

	private void createMothParticle(MinecraftClient client) {
		if (client.world == null) return;

		World world = client.world;
		PlayerEntity player = client.player;
		Random random = world.getRandom();
		double velocity = world.getRandom().nextDouble(-0.5D, 0.5D);
		double spawnX = player.getX() + random.nextDouble(-30, 30);
		double spawnY = player.getY() + random.nextDouble(-30, 30);
		double spawnZ = player.getZ() + random.nextDouble(-30, 30);
		world.addParticle((ParticleEffect) Registry.PARTICLE_TYPE.get(new Identifier("particlemoths:moth")),
				spawnX, spawnY, spawnZ, velocity, velocity, velocity);
	}
}
