package io.github.thepoultryman.particlemoths.fabric;

import io.github.thepoultryman.particlemoths.Particle_Moths;
import net.fabricmc.api.ModInitializer;

public class Particle_MothsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Particle_Moths.init();
    }
}