package io.github.thepoultryman.particlemoths.mixin.torch;

import io.github.thepoultryman.particlemoths.MothSpawnHelper;
import io.github.thepoultryman.particlemoths.ParticleMoths;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
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

@Mixin(RedstoneTorchBlock.class)
public class RedstoneTorchMixin {
    @Shadow @Final public static BooleanProperty LIT;

    @Inject(at = @At("TAIL"), method = "randomDisplayTick")
    public void particlemoths$spawnMothByRedstoneTorch(BlockState state, World world, BlockPos pos, RandomGenerator random, CallbackInfo ci) {
        if (ParticleMoths.CONFIG.spawnByBlocks && ParticleMoths.CONFIG.allowedBlocks.get("redstone_torches") && state.get(LIT))
            MothSpawnHelper.spawnMothByBlock(world, pos);
    }
}
