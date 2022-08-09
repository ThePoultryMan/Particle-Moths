package io.github.thepoultryman.particlemoths;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class MothParticle extends AbstractSlowingParticle {
    SpriteProvider sprites;

    protected MothParticle(ClientWorld clientWorld, double d, double e, double f, double g, double h, double i, SpriteProvider sprites) {
        super(clientWorld, d, e, f, g, h, i);
        this.sprites = sprites;
        this.setSpriteForAge(this.sprites);
        this.setColorAlpha(0f);
    }

    @Override
    protected int getBrightness(float tint) {
        if (!ParticleMoths.CONFIG.glowingMoths)
            return super.getBrightness(tint);
        else {
            return 240;
        }
    }

    @Override
    public void tick() {
        if (this.age == this.getMaxAge() / 2)
            this.setVelocity(this.getVelocityForAge(this.velocityX),
                    this.getVelocityForAge(this.velocityY),
                    this.getVelocityForAge(this.velocityZ));
        super.tick();

        this.setSpriteForAge(sprites);
        float maxAgeFraction = this.maxAge / 5f;
        if (this.age < maxAgeFraction)
            this.setColorAlpha(this.colorAlpha + (1f / maxAgeFraction));
        else if (this.age > maxAgeFraction * 4f) {
            float calculatedAlpha = this.colorAlpha - (1 / maxAgeFraction);
            if (calculatedAlpha < 0f || calculatedAlpha > 1f) {
                this.setColorAlpha(0f);
            } else {
                this.setColorAlpha(calculatedAlpha);
            }
        }
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    private double getVelocityForAge(double velocity) {
        return velocity + this.random.nextFloat(-0.15f, 0.15f);
    }

    @Environment(EnvType.CLIENT)
    public record Factory(SpriteProvider sprites) implements ParticleFactory<DefaultParticleType> {
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            return new MothParticle(clientWorld, d, e, f, g, h, i, sprites);
        }
    }
}
