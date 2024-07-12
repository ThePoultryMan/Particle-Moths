package io.github.thepoultryman.particlemoths.mixins;

import io.github.thepoultryman.particlemoths.MothSpawnHelper;
import io.github.thepoultryman.particlemoths.config.ParticleMothsConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LanternBlock.class)
public abstract class LanternMixin extends BlockMixin {
    @Override
    public void particlemoths$animateTickParent(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource, CallbackInfo ci) {
        // Should call super if lanterns ever get an animate tick override.
        if (ParticleMothsConfig.spawnMoths(ParticleMothsConfig.MothSpawnMode.BLOCKS) && ParticleMothsConfig.lanterns) {
            MothSpawnHelper.spawnMothByBlock(level, blockPos);
        }
    }
}

