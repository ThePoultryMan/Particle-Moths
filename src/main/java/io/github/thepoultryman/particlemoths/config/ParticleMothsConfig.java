package io.github.thepoultryman.particlemoths.config;

import io.github.thepoultryman.cactusconfig.ConfigManager;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import io.github.thepoultryman.cactusconfig.Options;
import io.github.thepoultryman.cactusconfig.util.CactusUtil;
import net.minecraft.text.Text;

public class ParticleMothsConfig extends ConfigManager {
    @Options.OptionHolder
    public OptionHolder general = new OptionHolder(Text.translatable("config.particlemoths.tabs.general"), null);
    @Options.Boolean(tab = "general")
    public boolean spawnMoths;
    @Options.Boolean(tab = "general", defaultValue = false, tooltip = true)
    public boolean glowingMoths;
    @Options.Separator(tab = "general")
    private final CactusUtil.ConfigOption movementConfig = new CactusUtil.ConfigOption(true, false);
    @Options.Boolean(tab = "general", tooltip = true)
    public boolean specificVelocities;
    @Options.Slider(tab = "general", min = -500d, max = 500d, defaultValue = 100d)
    public double xVelocity;
    @Options.Slider(tab = "general", min = -500d, max = 500d, defaultValue = 100d)
    public double yVelocity;
    @Options.Slider(tab = "general", min = -500d, max = 500d, defaultValue = 100d)
    public double zVelocity;
    @Options.OptionHolder
    public OptionHolder spawning = new OptionHolder(Text.translatable("config.particlemoths.tabs.spawning"), null);
    @Options.Slider(tab = "spawning", min = 0d, max = 99d, defaultValue = 15d, tooltip = true)
    public double mothCount;
    @Options.Slider(tab = "spawning", min = 1d, max = 100d, defaultValue = 13d, tooltip = true)
    public double spawnProbability;
    @Options.Separator(tab = "spawning")
    private final CactusUtil.ConfigOption spawnDistances = new CactusUtil.ConfigOption(true, false);
    @Options.Integer(tab = "spawning", defaultValue = 30)
    public int xSpawnDistance;
    @Options.Integer(tab = "spawning", defaultValue = 30)
    public int ySpawnDistance;
    @Options.Integer(tab = "spawning", defaultValue = 30)
    public int zSpawnDistance;
    @Options.Separator(tab = "spawning")
    private final CactusUtil.ConfigOption heightLimits = new CactusUtil.ConfigOption(true, false);
    @Options.Integer(tab = "spawning", defaultValue = -10)
    public int negHeightLimit;
    @Options.Integer(tab = "spawning", defaultValue = 192)
    public int posHeightLimit;
    @Options.OptionHolder
    public OptionHolder blockSpawning = new OptionHolder(Text.translatable("config.particlemoths.tabs.blockSpawning"), null);
    @Options.Boolean(tab = "blockSpawning")
    public boolean spawnByBlocks;
    @Options.Slider(tab = "blockSpawning", min = 2d, max = 100d, tooltip = true, defaultValue = 15d)
    public double blockSpawnProbability;
    @Options.Integer(tab = "blockSpawning", defaultValue = 3)
    public int xBlockSpawnDistance;
    @Options.Integer(tab = "blockSpawning", defaultValue = 3)
    public int yBlockSpawnDistance;
    @Options.Integer(tab = "blockSpawning", defaultValue = 3)
    public int zBlockSpawnDistance;
    @Options.Separator(tab = "blockSpawning")

    private final CactusUtil.ConfigOption allowedBlocksSeparator = new CactusUtil.ConfigOption(true, false);
    @Options.Boolean(tab = "blockSpawning")
    public boolean redstoneLamps;
    @Options.Boolean(tab = "blockSpawning")
    public boolean lanterns;
    @Options.Boolean(tab = "blockSpawning")
    public boolean candles;
    @Options.Boolean(tab = "blockSpawning")
    public boolean torches;
    @Options.Boolean(tab = "blockSpawning")
    public boolean redstoneTorches;

    public ParticleMothsConfig(String fileName, boolean loadOnServer) {
        super(fileName, loadOnServer);
    }

    @Override
    public boolean canReset() {
        return true;
    }
}
