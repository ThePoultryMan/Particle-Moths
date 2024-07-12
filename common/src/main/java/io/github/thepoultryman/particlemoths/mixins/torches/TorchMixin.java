package io.github.thepoultryman.particlemoths.mixins.torches;

import io.github.thepoultryman.particlemoths.MothSpawnHelper;
import io.github.thepoultryman.particlemoths.config.ParticleMothsConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TorchBlock.class)
public class TorchMixin {
    @Inject(at = @At("TAIL"), method = "animateTick")
    public void particlemoths$spawnMothByTorch(BlockState state, Level level, BlockPos pos, RandomSource random, CallbackInfo ci) {
        if (ParticleMothsConfig.spawnMoths(ParticleMothsConfig.MothSpawnMode.BLOCKS) && ParticleMothsConfig.torches)
            MothSpawnHelper.spawnMothByBlock(level, pos);
    }
}