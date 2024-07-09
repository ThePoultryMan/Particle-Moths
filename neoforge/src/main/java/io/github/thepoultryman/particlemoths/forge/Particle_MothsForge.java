package io.github.thepoultryman.particlemoths.forge;

import io.github.thepoultryman.particlemoths.Particle_Moths;
import net.minecraftforge.fml.common.Mod;

@Mod(Particle_Moths.MOD_ID)
public class Particle_MothsForge {
    public Particle_MothsForge() {
        Particle_Moths.init();
    }
}