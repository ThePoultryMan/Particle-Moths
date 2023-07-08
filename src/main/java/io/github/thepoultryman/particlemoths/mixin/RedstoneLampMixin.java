package io.github.thepoultryman.particlemoths.mixin;

import io.github.thepoultryman.particlemoths.MothSpawnHelper;
import io.github.thepoultryman.particlemoths.ParticleMoths;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(RedstoneLampBlock.class)
public abstract class RedstoneLampMixin extends Block {
    @Shadow @Final public static BooleanProperty LIT;

    public RedstoneLampMixin(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, RandomGenerator random) {
        super.randomDisplayTick(state, world, pos, random);
        if (ParticleMoths.CONFIG.spawnByBlocks && ParticleMoths.CONFIG.redstoneLamps && state.get(LIT))
            MothSpawnHelper.spawnMothByBlock(world, pos);
    }
}
