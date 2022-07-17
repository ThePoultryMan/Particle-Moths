package io.github.thepoultryman.particlemoths.config;

public class ParticleMothsConfig {
    public boolean spawnMoths = true;
    public boolean glowingMoths = false;
    public MovementConfig movementConfig = new MovementConfig();

    public int mothCount = 15;
    public int spawnProbability = 13;
    public int xSpawnDistance = 30;
    public int ySpawnDistance = 30;
    public int zSpawnDistance = 30;
    public HeightLimits heightLimits = new HeightLimits();

    public boolean spawnByBlocks = true;
    public int blockSpawnProbability = 15;
    public int xBlockSpawnDistance = 3;
    public int yBlockSpawnDistance = 3;
    public int zBlockSpawnDistance = 3;
    public AllowedBlocks allowedBlocks = new AllowedBlocks();

    public static class MovementConfig {
        public boolean specificVelocities = true;
        public int xVelocity = 100;
        public int yVelocity = 100;
        public int zVelocity = 100;
    }

    public static class HeightLimits {
        public int posHeight = 192;
        public int negHeight = -10;
    }

    public static class AllowedBlocks {
        public Torches torches = new Torches();
        public boolean redstoneLamp = true;
        public boolean lanterns = true;
        public boolean candles = true;
    }

    public static class Torches {
        public boolean torch = true;
        public boolean redstoneTorch = true;
    }
}
