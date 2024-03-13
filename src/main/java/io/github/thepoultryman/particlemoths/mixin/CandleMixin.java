package io.github.thepoultryman.particlemoths.mixin;

import io.github.thepoultryman.particlemoths.MothSpawnHelper;
import io.github.thepoultryman.particlemoths.config.ParticleMothsConfig;
import net.minecraft.block.AbstractCandleBlock;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractCandleBlock.class)
public class CandleMixin {
    @Shadow @Final public static BooleanProperty LIT;

    @Inject(at = @At("TAIL"), method = "randomDisplayTick")
    private void particlemoths$spawnMothByCandle(BlockState state, World world, BlockPos pos, RandomGenerator random, CallbackInfo ci) {
        if (ParticleMothsConfig.spawnMoths(ParticleMothsConfig.MothSpawnMode.BLOCKS) && ParticleMothsConfig.candles && state.get(LIT))
            MothSpawnHelper.spawnMothByBlock(world, pos);
    }
}
