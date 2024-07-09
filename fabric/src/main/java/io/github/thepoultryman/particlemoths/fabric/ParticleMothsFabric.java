package io.github.thepoultryman.particlemoths.fabric;

import io.github.thepoultryman.particlemoths.ParticleMoths;
import net.fabricmc.api.ModInitializer;

public class ParticleMothsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ParticleMoths.init();
    }
}