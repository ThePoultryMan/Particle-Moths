package io.github.thepoultryman.particlemoths.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import io.github.thepoultryman.cactusconfig.screen.ConfigScreen;
import io.github.thepoultryman.particlemoths.ParticleMoths;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;

public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return (ConfigScreenFactory<Screen>) parent -> new ConfigScreen(new TranslatableText("config.particlemoths.title"), parent,
                ParticleMoths.CONFIG.general);
    }
}
