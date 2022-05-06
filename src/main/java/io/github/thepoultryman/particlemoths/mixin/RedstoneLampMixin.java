package io.github.thepoultryman.particlemoths.mixin;

import io.github.thepoultryman.particlemoths.MothSpawnHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Random;

@Mixin(RedstoneLampBlock.class)
public abstract class RedstoneLampMixin extends Block {
    public RedstoneLampMixin(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        MothSpawnHelper.spawnMothByBlock(world, pos);
    }
}
