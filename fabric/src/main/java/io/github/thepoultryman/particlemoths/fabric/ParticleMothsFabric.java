package io.github.thepoultryman.particlemoths.fabric;

import io.github.thepoultryman.particlemoths.ParticleMoths;
import io.github.thepoultryman.particlemoths.mixins.SimpleParticleTypeInvoker;
import net.fabricmc.api.ClientModInitializer;
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
    }
}