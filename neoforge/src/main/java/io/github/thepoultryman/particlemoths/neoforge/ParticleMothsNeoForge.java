package io.github.thepoultryman.particlemoths.neoforge;

import io.github.thepoultryman.particlemoths.ParticleMoths;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(ParticleMoths.MOD_ID)
public class ParticleMothsNeoForge {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_REGISTER = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, ParticleMoths.MOD_ID);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MOTH = PARTICLE_REGISTER.register("moth", () -> new SimpleParticleType(false));

    public ParticleMothsNeoForge() {
        ParticleMoths.init();
    }
}