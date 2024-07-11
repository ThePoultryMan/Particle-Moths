package io.github.thepoultryman.particlemoths;

import io.github.thepoultryman.particlemoths.config.ParticleMothsConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

public class MothParticle extends RisingParticle {
    SpriteSet sprites;

    protected MothParticle(ClientLevel clientLevel, double d, double e, double f, double g, double h, double i, SpriteSet sprites) {
        super(clientLevel, d, e, f, g, h, i);
        this.sprites = sprites;
        this.setSpriteFromAge(this.sprites);
        this.setAlpha(0f);
    }

    @Override
    protected int getLightColor(float tint) {
        if (!ParticleMothsConfig.glowingMoths)
            return super.getLightColor(tint);
        else {
            return 240;
        }
    }

    @Override
    public void tick() {
        if (this.age == this.getLifetime() / 2)
            this.setParticleSpeed(this.getVelocityForAge(this.xd),
                    this.getVelocityForAge(this.yd),
                    this.getVelocityForAge(this.zd));
        super.tick();

        this.setSpriteFromAge(sprites);
        float maxAgeFraction = this.lifetime / 5f;
        if (this.age < maxAgeFraction)
            this.setAlpha(this.alpha + (1f / maxAgeFraction));
        else if (this.age > maxAgeFraction * 4f) {
            float calculatedAlpha = this.alpha - (1 / maxAgeFraction);
            if (calculatedAlpha < 0f || calculatedAlpha > 1f) {
                this.setAlpha(0f);
            } else {
                this.setAlpha(calculatedAlpha);
            }
        }
    }

    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    private double getVelocityForAge(double velocity) {
        return velocity + (MothHelper.floatRange(-0.15f, 0.15f) / 100f);
    }

    @Environment(EnvType.CLIENT)
    public record Factory(SpriteSet sprites) implements ParticleProvider<SimpleParticleType> {
        @Override
        public @NotNull Particle createParticle(SimpleParticleType particleOptions, ClientLevel clientLevel, double d, double e, double f, double g, double h, double i) {
            return new MothParticle(clientLevel, d, e, f, g, h, i, sprites);
        }
    }
}