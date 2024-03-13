package io.github.thepoultryman.particlemoths.mixin;

import io.github.thepoultryman.particlemoths.MothSpawnHelper;
import io.github.thepoultryman.particlemoths.config.ParticleMothsConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LanternBlock.class)
public abstract class LanternMixin extends Block {
    public LanternMixin(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, RandomGenerator random) {
        super.randomDisplayTick(state, world, pos, random);
        if (ParticleMothsConfig.spawnMoths(ParticleMothsConfig.MothSpawnMode.BLOCKS) && ParticleMothsConfig.lanterns)
            MothSpawnHelper.spawnMothByBlock(world, pos);
    }
}
