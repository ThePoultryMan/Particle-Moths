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
        super.tick();
        this.setSpriteForAge(sprites);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    @Environment(EnvType.CLIENT)
    public record Factory(SpriteProvider sprites) implements ParticleFactory<DefaultParticleType> {
        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            return new MothParticle(clientWorld, d, e, f, g, h, i, sprites);
        }
    }
}
