package io.github.thepoultryman.particlemoths;

import io.github.thepoultryman.particlemoths.config.ParticleMothsConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import java.util.Random;

public class MothSpawnHelper {
    private static final Random random = new Random();

    public static boolean shouldSpawnMoth(Minecraft client) {
        boolean basicCheck = ParticleMothsConfig.spawnMoths(ParticleMothsConfig.MothSpawnMode.WORLD) && !client.isPaused();
        boolean probabilityCheck = random.nextInt(100 - (int) ParticleMothsConfig.mothCount) < ParticleMothsConfig.spawnProbability;
        return basicCheck && probabilityCheck;
    }

    public static boolean isValidMothSpawn(Level level, BlockPos pos, Minecraft client) {
        boolean initialCheck = !isInRainOrWater(level, pos) && isWithinHeightLimits(pos.getY());
        if (client.player != null)
            return initialCheck && !client.player.clientLevel.canSeeSky(client.player.getOnPos());
        else
            return false;
    }

    public static BlockPos getSpawnCoordinates(BlockPos pos) {
        int[] spawnBound = {ParticleMothsConfig.xSpawnDistance, ParticleMothsConfig.ySpawnDistance, ParticleMothsConfig.zSpawnDistance};
        int spawnX = pos.getX() + random.nextInt(-spawnBound[0], spawnBound[0]);
        int spawnY = pos.getY() + random.nextInt(-spawnBound[1], spawnBound[1]);
        int spawnZ = pos.getZ() + random.nextInt(-spawnBound[2], spawnBound[2]);

        return new BlockPos(spawnX, spawnY, spawnZ);
    }

    public static BlockPos getBlockSpawnCoordinates(BlockPos pos) {
        int[] spawnBound = {ParticleMothsConfig.xBlockSpawnDistance, ParticleMothsConfig.yBlockSpawnDistance, ParticleMothsConfig.zBlockSpawnDistance};
        int spawnX = pos.getX() + random.nextInt(-spawnBound[0], spawnBound[0]);
        int spawnY = pos.getY() + random.nextInt(-spawnBound[1], spawnBound[1]);
        int spawnZ = pos.getZ() + random.nextInt(-spawnBound[2], spawnBound[2]);

        return new BlockPos(spawnX, spawnY, spawnZ);
    }

    public static double[] getVelocity() {
        if (!ParticleMothsConfig.specificVelocities) {
            double velocity = random.nextDouble(-0.75f, 0.75f) * ParticleMothsConfig.xVelocity;
            return new double[] {velocity, velocity, velocity};
        } else {
            double velocityX = random.nextDouble(-0.75f, 0.75f) * (ParticleMothsConfig.xVelocity / 100f);
            double velocityY = random.nextDouble(-0.75f, 0.75f) * (ParticleMothsConfig.yVelocity / 100f);
            double velocityZ = random.nextDouble(-0.75f, 0.75f) * (ParticleMothsConfig.zVelocity / 100f);
            return new double[] {velocityX, velocityY, velocityZ};
        }
    }

    public static void spawnMothByBlock(Level level, BlockPos pos) {
        if (!ParticleMothsConfig.spawnMoths(ParticleMothsConfig.MothSpawnMode.WORLD) || random.nextFloat(100f) > ParticleMothsConfig.blockSpawnProbability / 2f) return;

        ParticleMoths.LOGGER.info("continuing to spawn moth");

        BlockPos spawnPos = getBlockSpawnCoordinates(pos);
        if (isInRainOrWater(level, spawnPos)) return;
        double[] velocities = MothSpawnHelper.getVelocity();

        level.addParticle(ParticleMoths.getOptions(),
                spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), velocities[0] / 5f, velocities[1] / 5f, velocities[2] / 5f);
    }

    public static boolean isInRainOrWater(Level level, BlockPos pos) {
        return level.isRainingAt(pos) || level.isWaterAt(pos);
    }

    public static boolean isWithinHeightLimits(int yLevel) {
        return yLevel >= ParticleMothsConfig.negHeightLimit && yLevel <= ParticleMothsConfig.posHeightLimit;
    }
}