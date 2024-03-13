package io.github.thepoultryman.particlemoths.config;

import eu.midnightdust.lib.config.MidnightConfig;

public class ParticleMothsConfig extends MidnightConfig {
    @Entry(category = "general")
    public static MothSpawnMode spawnMoths = MothSpawnMode.ALL;
    @Entry(category = "general")
    public static boolean glowingMoths = false;
    @Comment(category = "general", centered = true)
    public static Comment movementConfig;
    @Entry(category = "general")
    public static boolean specificVelocities = false;
    @Entry(category = "general", isSlider = true, min = -500.0, max = 500.0, precision = 1)
    public static double xVelocity = 100.0;
    @Entry(category = "general", isSlider = true, min = -500.0, max = 500.0, precision = 1)
    public static double yVelocity = 100.0;
    @Entry(category = "general", isSlider = true, min = -500.0, max = 500.0, precision = 1)
    public static double zVelocity = 100.0;

    @Entry(category = "spawning", isSlider = true, min = 0.0, max = 99.0, precision = 1)
    public static double mothCount = 15.0;
    @Entry(category = "spawning", isSlider = true, min = 1.0, max = 100.0, precision = 1)
    public static double spawnProbability = 13.0;
    @Comment(category = "spawning", centered = true)
    public static Comment spawnDistances;
    @Entry(category = "spawning")
    public static int xSpawnDistance = 30;
    @Entry(category = "spawning")
    public static int ySpawnDistance = 30;
    @Entry(category = "spawning")
    public static int zSpawnDistance = 30;
    @Comment(category = "spawning", centered = true)
    public static Comment heightLimits;
    @Entry(category = "spawning")
    public static int negHeightLimit = -10;
    @Entry(category = "spawning")
    public static int posHeightLimit = 192;

    @Entry(category = "blockSpawning", isSlider = true, min = 2.0, max = 100.0, precision = 1)
    public static double blockSpawnProbability = 15.0;
    @Entry(category = "blockSpawning")
    public static int xBlockSpawnDistance = 3;
    @Entry(category = "blockSpawning")
    public static int yBlockSpawnDistance = 3;
    @Entry(category = "blockSpawning")
    public static int zBlockSpawnDistance = 3;
    @Comment(category = "blockSpawning", centered = true)
    public static Comment allowedBlocks;
    @Entry(category = "blockSpawning")
    public static boolean torches = true;
    @Entry(category = "blockSpawning")
    public static boolean redstoneTorches = true;
    @Entry(category = "blockSpawning")
    public static boolean redstoneLamps = true;
    @Entry(category = "blockSpawning")
    public static boolean lanterns = true;
    @Entry(category = "blockSpawning")
    public static boolean candles = true;

    public static boolean spawnMoths(MothSpawnMode type) {
        if (spawnMoths == MothSpawnMode.ALL) return true;
        switch (type) {
            case WORLD -> {
                return spawnMoths == MothSpawnMode.WORLD;
            }
            case BLOCKS -> {
                return spawnMoths == MothSpawnMode.BLOCKS;
            }
            default -> {
                return false;
            }
        }
    }

    public enum MothSpawnMode {
        ALL,
        WORLD,
        BLOCKS,
        NEVER;
    }
}
