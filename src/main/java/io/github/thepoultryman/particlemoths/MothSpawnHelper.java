package io.github.thepoultryman.particlemoths;

import java.util.Random;

public class MothSpawnHelper {
    private static final Random random = new Random();

    public static boolean shouldSpawnMoth() {
        return ParticleMoths.CONFIG.spawnMoths;
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
