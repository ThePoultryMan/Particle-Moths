package io.github.thepoultryman.particlemoths.config.screen;

import dev.lambdaurora.spruceui.screen.SpruceScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.LiteralText;

import javax.annotation.Nullable;

public class ConfigScreen extends SpruceScreen {
    private final Screen parent;

    public ConfigScreen(@Nullable Screen parent) {
        super(new LiteralText("Particle Moth Config"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        super.init();
    }
}
