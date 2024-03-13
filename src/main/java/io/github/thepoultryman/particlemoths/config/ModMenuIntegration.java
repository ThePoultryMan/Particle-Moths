package io.github.thepoultryman.particlemoths.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import io.github.thepoultryman.particlemoths.ParticleMoths;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return (parent) -> ParticleMothsConfig.getScreen(parent, ParticleMoths.MOD_ID);
    }
}
