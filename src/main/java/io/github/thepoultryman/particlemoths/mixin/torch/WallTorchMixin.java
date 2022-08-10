package io.github.thepoultryman.particlemoths.mixin.torch;

import io.github.thepoultryman.particlemoths.MothSpawnHelper;
import io.github.thepoultryman.particlemoths.ParticleMoths;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WallTorchBlock.class)
public class WallTorchMixin {
    @Inject(at = @At("TAIL"), method = "randomDisplayTick")
    public void particlemoths$spawnMothByWallTorch(BlockState state, World world, BlockPos pos, RandomGenerator random, CallbackInfo ci) {
        if (ParticleMoths.CONFIG.spawnByBlocks && ParticleMoths.CONFIG.allowedBlocks.get("torches"))
            MothSpawnHelper.spawnMothByBlock(world, pos);
    }
}
