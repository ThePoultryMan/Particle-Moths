package io.github.thepoultryman.particlemoths.config;

import io.github.thepoultryman.cactusconfig.ConfigManager;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import net.minecraft.text.TranslatableText;

public class ParticleMothsConfig extends ConfigManager {
    public OptionHolder general = new OptionHolder(new TranslatableText("config.particlemoths.tabs.general"), null);
    private boolean spawnMoths;

    public ParticleMothsConfig(String fileName) {
        super(fileName);
    }

    @Override
    public void loadConfig() {
        super.loadConfig();

        this.getAndSetBooleanOption(general, "general.spawn_moths", true,
                () -> (boolean) this.getConfigOption("general.spawn_moths"),
                (spawn) -> this.setConfigOption("general.spawn_moths", spawn));
    }
}
