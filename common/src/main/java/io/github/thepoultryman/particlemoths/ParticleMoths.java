package io.github.thepoultryman.particlemoths;

import dev.architectury.injectables.annotations.ExpectPlatform;
import io.github.thepoultryman.particlemoths.config.ParticleMothsConfig;
import net.minecraft.core.particles.SimpleParticleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParticleMoths {
    public static final String MOD_ID = "particlemoths";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        LOGGER.info("Initializing (Particle) Moths");
        ParticleMothsConfig.init(MOD_ID, ParticleMothsConfig.class);
    }

    @ExpectPlatform
    public static SimpleParticleType getOptions() {
        throw new RuntimeException("Should not be called");
    }
}
