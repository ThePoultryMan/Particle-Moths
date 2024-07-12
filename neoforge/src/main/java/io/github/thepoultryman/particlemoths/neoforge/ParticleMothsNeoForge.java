package io.github.thepoultryman.particlemoths.neoforge;

import io.github.thepoultryman.particlemoths.MothParticle;
import io.github.thepoultryman.particlemoths.MothSpawnHelper;
import io.github.thepoultryman.particlemoths.ParticleMoths;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(ParticleMoths.MOD_ID)
public class ParticleMothsNeoForge {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_REGISTER = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, ParticleMoths.MOD_ID);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> MOTH = PARTICLE_REGISTER.register("moth", () -> new SimpleParticleType(false));

    public ParticleMothsNeoForge() {
        ParticleMoths.init();
    }

    @EventBusSubscriber(modid = ParticleMoths.MOD_ID)
    private static class EventHandler {
        @SubscribeEvent
        public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(ParticleMoths.getOptions(), MothParticle.Factory::new);
        }

        @SubscribeEvent
        public static void clientPostTick(ClientTickEvent.Post event) {
            var minecraft = Minecraft.getInstance();

            if (minecraft.level == null || !MothSpawnHelper.shouldSpawnMoth(minecraft)) return;

            ClientLevel level = minecraft.level;
            LocalPlayer player = minecraft.player;

            if (player == null) return;

            BlockPos spawnPos = MothSpawnHelper.getSpawnCoordinates(player.getOnPos());
            if (!MothSpawnHelper.isValidMothSpawn(level, spawnPos, minecraft)) return;
            double[] velocities = MothSpawnHelper.getVelocity();

            level.addParticle(ParticleMoths.getOptions(),
                    spawnPos.getX(), spawnPos.getY(), spawnPos.getZ(), velocities[0], velocities[1], velocities[2]);
        }
    }
}