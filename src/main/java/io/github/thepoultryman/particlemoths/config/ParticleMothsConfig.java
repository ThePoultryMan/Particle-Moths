package io.github.thepoultryman.particlemoths.config;

import io.github.thepoultryman.particlemoths.ParticleMoths;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = ParticleMoths.MOD_ID)
public class ParticleMothsConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip(count = 2)
    public boolean glowingMoths = false;

    @ConfigEntry.Gui.CollapsibleObject
    public MovementConfig movementConfig = new MovementConfig();

    public static class MovementConfig {
        @ConfigEntry.Gui.Tooltip(count = 4)
        public boolean specificVelocities = false;
        public double xVelocity = 1D;
        public double yVelocity = 1D;
        public double zVelocity = 1D;
    }
}
