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
    @ConfigEntry.Gui.Tooltip
    public boolean glowingMoths = false;
    @ConfigEntry.Category("general")
    @ConfigEntry.Gui.CollapsibleObject
    public MovementConfig movementConfig = new MovementConfig();

    @ConfigEntry.Category("spawning")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(max = 100)
    public int mothCount = 15;
    @ConfigEntry.Category("spawning")
    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
    public int spawnProbability = 13;
    @ConfigEntry.Category("spawning")
    public int xSpawnDistance = 30;
    @ConfigEntry.Category("spawning")
    public int ySpawnDistance = 30;
    @ConfigEntry.Category("spawning")
    public int zSpawnDistance = 30;

    @ConfigEntry.Category("blockSpawning")
    public int xBlockSpawnDistance = 5;
    @ConfigEntry.Category("blockSpawning")
    public int yBlockSpawnDistance = 5;
    @ConfigEntry.Category("blockSpawning")
    public int zBlockSpawnDistance = 5;

    public static class MovementConfig {
        @ConfigEntry.Gui.Tooltip
        public boolean specificVelocities = true;
        @ConfigEntry.BoundedDiscrete(min = -500, max = 500)
        public int xVelocity = 100;
        @ConfigEntry.BoundedDiscrete(min = -500, max = 500)
        public int yVelocity = 100;
        @ConfigEntry.BoundedDiscrete(min = -500, max = 500)
        public int zVelocity = 100;
    }
}
