package io.github.thepoultryman.particlemoths.config;

import io.github.thepoultryman.particlemoths.ParticleMoths;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = ParticleMoths.MOD_ID)
public class ParticleMothsConfig implements ConfigData {
    @ConfigEntry.Category("general")
    public boolean spawnMoths = true;

    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.Tooltip(count = 2)
    public boolean glowingMoths = false;

    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.CollapsibleObject
    public MovementConfig movementConfig = new MovementConfig();

    public static class MovementConfig {
        @ConfigEntry.Gui.Tooltip(count = 4)
        public boolean specificVelocities = true;
        @ConfigEntry.BoundedDiscrete(min = -500, max = 500)
        public int xVelocity = 100;
        @ConfigEntry.BoundedDiscrete(min = -500, max = 500)
        public int yVelocity = 100;
        @ConfigEntry.BoundedDiscrete(min = -500, max = 500)
        public int zVelocity = 100;
    }
}
