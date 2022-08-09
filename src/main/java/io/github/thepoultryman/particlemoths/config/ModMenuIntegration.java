package io.github.thepoultryman.particlemoths.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import io.github.thepoultryman.cactusconfig.screen.ConfigScreen;
import io.github.thepoultryman.cactusconfig.screen.ScreenCustomizer;
import io.github.thepoultryman.particlemoths.ParticleMoths;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;

public class ModMenuIntegration implements ModMenuApi {
    private final ScreenCustomizer screenCustomizer = new ScreenCustomizer(new TranslatableText("config.particlemoths.title"));

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        screenCustomizer.useOneOptionColumn();
        return (ConfigScreenFactory<Screen>) parent -> new ConfigScreen(screenCustomizer, parent, ParticleMoths.CONFIG,
                ParticleMoths.CONFIG.generalTab, ParticleMoths.CONFIG.spawningTab, ParticleMoths.CONFIG.blockSpawningTab);
    }
}
