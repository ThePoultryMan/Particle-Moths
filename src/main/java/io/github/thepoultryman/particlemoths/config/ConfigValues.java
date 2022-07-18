package io.github.thepoultryman.particlemoths.config;

public class ConfigValues {
    public static boolean spawnMoths = true;
    public static boolean glowingMoths = false;

    public static int mothCount = 15;
    public static int spawnProbability = 13;
    public static int xSpawnDistance = 30;
    public static int ySpawnDistance = 30;
    public static int zSpawnDistance = 30;

    public static boolean spawnByBlocks = true;
    public static int blockSpawnProbability = 15;
    public static int xBlockSpawnDistance = 3;
    public static int yBlockSpawnDistance = 3;
    public static int zBlockSpawnDistance = 3;

    public static class MovementConfig {
        public static boolean specificVelocities = true;
        public static int xVelocity = 100;
        public static int yVelocity = 100;
        public static int zVelocity = 100;
    }

    public static class HeightLimits {
        public static int posHeight = 192;
        public static int negHeight = -10;
    }

    public static class AllowedBlocks {
        public static boolean redstoneLamp = true;
        public static boolean lanterns = true;
        public static boolean candles = true;
    }

    public static class Torches {
        public static boolean torch = true;
        public static boolean redstoneTorch = true;
    }
}
