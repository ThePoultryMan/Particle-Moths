package io.github.thepoultryman.particlemoths.mixins;

import net.minecraft.core.particles.SimpleParticleType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SimpleParticleType.class)
public interface SimpleParticleTypeInvoker {
    @Invoker("<init>")
    static SimpleParticleType SimpleParticleType(boolean bl) {
        throw new AssertionError("This should've been replaced by Mixin!");
    };
}
