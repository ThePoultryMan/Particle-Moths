package io.github.thepoultryman.particlemoths;

import net.minecraft.entity.player.PlayerEntity;

import java.util.Random;

public class MothSpawnHelper {
    private static final Random random = new Random();

    public static boolean shouldSpawnMoth() {
        return ParticleMoths.CONFIG.spawnMoths;
    }

    public static double[] getSpawnCoordinates(PlayerEntity player) {
        int[] spawnBound = {ParticleMoths.CONFIG.xSpawnDistance, ParticleMoths.CONFIG.ySpawnDistance, ParticleMoths.CONFIG.zSpawnDistance};
        double spawnX = player.getX() + random.nextDouble(-spawnBound[0], spawnBound[0]);
        double spawnY = player.getY() + random.nextDouble(-spawnBound[1], spawnBound[1]);
        double spawnZ = player.getZ() + random.nextDouble(-spawnBound[2], spawnBound[2]);

        return new double[] {spawnX, spawnY, spawnZ};
    }

    public static double[] getVelocity() {
        if (!ParticleMoths.CONFIG.movementConfig.specificVelocities) {
            double velocity = random.nextDouble(-0.75f, 0.75f) * (ParticleMoths.CONFIG.movementConfig.xVelocity / 100f);
            return new double[] {velocity, velocity, velocity};
        } else {
            double velocityX = random.nextDouble(-0.75f, 0.75f) * (ParticleMoths.CONFIG.movementConfig.xVelocity / 100f);
            double velocityY = random.nextDouble(-0.75f, 0.75f) * (ParticleMoths.CONFIG.movementConfig.yVelocity / 100f);
            double velocityZ = random.nextDouble(-0.75f, 0.75f) * (ParticleMoths.CONFIG.movementConfig.zVelocity / 100f);
            return new double[] {velocityX, velocityY, velocityZ};
        }
    }
}
