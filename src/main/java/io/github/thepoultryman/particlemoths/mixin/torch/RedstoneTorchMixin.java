package io.github.thepoultryman.particlemoths.mixin.torch;

import io.github.thepoultryman.particlemoths.MothSpawnHelper;
import io.github.thepoultryman.particlemoths.config.ConfigValues;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(RedstoneTorchBlock.class)
public class RedstoneTorchMixin {
    @Shadow @Final public static BooleanProperty LIT;

    @Inject(at = @At("TAIL"), method = "randomDisplayTick")
    public void particlemoths$spawnMothByRedstoneTorch(BlockState state, World world, BlockPos pos, Random random, CallbackInfo ci) {
        if (ConfigValues.spawnByBlocks && ConfigValues.Torches.redstoneTorch && state.get(LIT))
            MothSpawnHelper.spawnMothByBlock(world, pos);
    }
}
