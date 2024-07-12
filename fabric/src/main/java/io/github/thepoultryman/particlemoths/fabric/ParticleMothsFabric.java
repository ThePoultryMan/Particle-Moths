package io.github.thepoultryman.particlemoths.fabric;

import io.github.thepoultryman.particlemoths.MothParticle;
import io.github.thepoultryman.particlemoths.MothSpawnHelper;
import io.github.thepoultryman.particlemoths.ParticleMoths;
import io.github.thepoultryman.particlemoths.mixins.SimpleParticleTypeInvoker;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class ParticleMothsFabric implements ClientModInitializer {
    public static final SimpleParticleType MOTH = SimpleParticleTypeInvoker.SimpleParticleType(false);

    @Override
    public void onInitializeClient() {
        ParticleMoths.init();

        Registry.register(BuiltInRegistries.PARTICLE_TYPE, ResourceLocation.fromNamespaceAndPath(ParticleMoths.MOD_ID, "moth"), MOTH);
        ParticleFactoryRegistry.getInstance().register(ParticleMoths.getOptions(), MothParticle.Factory::new);

        ClientTickEvents.END_CLIENT_TICK.register(this::createMothParticle);
    }

    private void createMothParticle(Minecraft minecraft) {
        if (minecraft.level == null || !MothSpawnHelper.shouldSpawnMoth(minecraft)) return;

        ClientLevel level = minecraft.level;
        LocalPlayer player = minecraft.player;

        if (player == null) return;

        BlockPos spawnPos = MothSpawnHelper.getSpawnCoordinates(player.getOnPos());
        if (!MothSpawnHelper.isValidMothSpawn(level, spawnPos, minecraft)) return;
        double[] velocities = MothSpawnHelper.getVelocity();

        level.addParticle(ParticleMoths.getOptions(),
                spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), velocities[0], velocities[1], velocities[2]);
    }
}