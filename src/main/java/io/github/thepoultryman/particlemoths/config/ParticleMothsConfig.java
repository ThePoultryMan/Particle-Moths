package io.github.thepoultryman.particlemoths.config;

import io.github.thepoultryman.particlemoths.ParticleMoths;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = ParticleMoths.MOD_ID)
public class ParticleMothsConfig implements ConfigData {
    @ConfigEntry.Gui.Tooltip(count = 2)
    boolean glowingMoths = false;

    @ConfigEntry.Gui.CollapsibleObject
    MovementConfig movementConfig = new MovementConfig();

    static class MovementConfig {
        @ConfigEntry.Gui.Tooltip(count = 4)
        boolean specificVelocities = false;
        double xVelocity = 1D;
        double yVelocity = 1D;
        double zVelocity = 1D;
    }
}
