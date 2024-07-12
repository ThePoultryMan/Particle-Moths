package io.github.thepoultryman.particlemoths.mixins.torches;

import io.github.thepoultryman.particlemoths.MothSpawnHelper;
import io.github.thepoultryman.particlemoths.config.ParticleMothsConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RedstoneTorchBlock.class)
public class WallRedstoneTorchMixin {
    @Shadow @Final public static BooleanProperty LIT;

    @Inject(at = @At("TAIL"), method = "animateTick")
    public void particlemoths$spawnMothByRedstoneTorch(BlockState state, Level level, BlockPos pos, RandomSource random, CallbackInfo ci) {
        if (ParticleMothsConfig.spawnMoths(ParticleMothsConfig.MothSpawnMode.BLOCKS) && ParticleMothsConfig.redstoneTorches && state.getValue(LIT))
            MothSpawnHelper.spawnMothByBlock(level, pos);
    }
}