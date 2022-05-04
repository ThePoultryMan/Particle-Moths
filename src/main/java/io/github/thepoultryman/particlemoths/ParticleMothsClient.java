package io.github.thepoultryman.particlemoths;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;

public class ParticleMothsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier(ParticleMoths.MOD_ID, "particle/moth"));
        }));

        ParticleFactoryRegistry.getInstance().register(ParticleMoths.MOTH, MothParticle.Factory::new);
    }
}
