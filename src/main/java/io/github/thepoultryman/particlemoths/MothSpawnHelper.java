package io.github.thepoultryman.particlemoths;

import net.minecraft.client.MinecraftClient;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Random;

public class MothSpawnHelper {
    private static final Random random = new Random();

    public static boolean shouldSpawnMoth(MinecraftClient client) {
        boolean basicCheck = ParticleMoths.CONFIG.spawnMoths && !client.isPaused();
        boolean probabilityCheck = random.nextInt(100 - ParticleMoths.CONFIG.mothCount) < ParticleMoths.CONFIG.spawnProbability;
        return basicCheck && probabilityCheck;
    }

    public static boolean isValidMothSpawn(World world, BlockPos pos, MinecraftClient client) {
        boolean initialCheck = !isInRainOrWater(world, pos) && isWithinHeightLimits(pos.getY());
        if (client.player != null)
            return initialCheck && !client.player.clientWorld.isSkyVisible(client.player.getBlockPos());
        else
            return false;
    }

    public static BlockPos getSpawnCoordinates(BlockPos pos) {
        int[] spawnBound = {ParticleMoths.CONFIG.xSpawnDistance, ParticleMoths.CONFIG.ySpawnDistance, ParticleMoths.CONFIG.zSpawnDistance};
        double spawnX = pos.getX() + random.nextDouble(-spawnBound[0], spawnBound[0]);
        double spawnY = pos.getY() + random.nextDouble(-spawnBound[1], spawnBound[1]);
        double spawnZ = pos.getZ() + random.nextDouble(-spawnBound[2], spawnBound[2]);

        return new BlockPos(spawnX, spawnY, spawnZ);
    }

    public static BlockPos getBlockSpawnCoordinates(BlockPos pos) {
        int[] spawnBound = {ParticleMoths.CONFIG.xBlockSpawnDistance, ParticleMoths.CONFIG.yBlockSpawnDistance, ParticleMoths.CONFIG.zBlockSpawnDistance};
        double spawnX = pos.getX() + random.nextDouble(-spawnBound[0], spawnBound[0]);
        double spawnY = pos.getY() + random.nextDouble(-spawnBound[1], spawnBound[1]);
        double spawnZ = pos.getZ() + random.nextDouble(-spawnBound[2], spawnBound[2]);

        return new BlockPos(spawnX, spawnY, spawnZ);
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

    public static void spawnMothByBlock(World world, BlockPos pos) {
        if (!ParticleMoths.CONFIG.spawnMoths || random.nextInt(100) > ParticleMoths.CONFIG.blockSpawnProbability) return;

        BlockPos spawnPos = getBlockSpawnCoordinates(pos);
        if (isInRainOrWater(world, spawnPos)) return;
        double[] velocities = MothSpawnHelper.getVelocity();

        world.addParticle((ParticleEffect) Registry.PARTICLE_TYPE.get(new Identifier("particlemoths:moth")),
                spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), velocities[0] / 5f, velocities[1] / 5f, velocities[2] / 5f);
    }

    public static boolean isInRainOrWater(World world, BlockPos pos) {
        return world.hasRain(pos) || world.isWater(pos);
    }

    public static boolean isWithinHeightLimits(int yLevel) {
        return yLevel >= ParticleMoths.CONFIG.heightLimits.negHeight && yLevel <= ParticleMoths.CONFIG.heightLimits.posHeight;
    }
}
