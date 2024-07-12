package io.github.thepoultryman.particlemoths.mixins;

import io.github.thepoultryman.particlemoths.MothSpawnHelper;
import io.github.thepoultryman.particlemoths.config.ParticleMothsConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RedstoneLampBlock.class)
public abstract class RedstoneLampMixin extends BlockMixin {
    @Shadow @Final public static BooleanProperty LIT;

    @Override
    public void particlemoths$animateTickParent(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource, CallbackInfo ci) {
        if (ParticleMothsConfig.spawnMoths(ParticleMothsConfig.MothSpawnMode.BLOCKS) && ParticleMothsConfig.redstoneLamps && blockState.getValue(LIT))
            MothSpawnHelper.spawnMothByBlock(level, blockPos);
    }
}