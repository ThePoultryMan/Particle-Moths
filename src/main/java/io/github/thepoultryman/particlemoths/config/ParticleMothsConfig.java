package io.github.thepoultryman.particlemoths.config;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.DoubleSliderControllerBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import dev.isxander.yacl3.impl.controller.IntegerFieldControllerBuilderImpl;
import dev.isxander.yacl3.impl.controller.TickBoxControllerBuilderImpl;
import io.github.thepoultryman.particlemoths.ParticleMoths;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ParticleMothsConfig {
    private static final ConfigClassHandler<ParticleMothsConfig> CONFIG_HANDLER = ConfigClassHandler.createBuilder(ParticleMothsConfig.class)
            .id(new Identifier(ParticleMoths.MOD_ID, "config"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve(ParticleMoths.MOD_ID + ".json"))
                    .build())
            .build();

    @SerialEntry
    public boolean spawnMoths;
    @SerialEntry
    public boolean glowingMoths;
    @SerialEntry
    public boolean specificVelocities;
    @SerialEntry
    public double xVelocity;
    @SerialEntry
    public double yVelocity;
    @SerialEntry
    public double zVelocity;

    @SerialEntry
    public double mothCount;
    @SerialEntry
    public double spawnProbability;
    @SerialEntry
    public int xSpawnDistance;
    @SerialEntry
    public int ySpawnDistance;
    @SerialEntry
    public int zSpawnDistance;
    @SerialEntry
    public int negHeightLimit;
    @SerialEntry
    public int posHeightLimit;

    @SerialEntry
    public boolean spawnByBlocks;
    @SerialEntry
    public double blockSpawnProbability;
    @SerialEntry
    public int xBlockSpawnDistance;
    @SerialEntry
    public int yBlockSpawnDistance;
    @SerialEntry
    public int zBlockSpawnDistance;
    @SerialEntry
    public boolean torches;
    @SerialEntry
    public boolean redstoneTorches;
    @SerialEntry
    public boolean redstoneLamps;
    @SerialEntry
    public boolean lanterns;
    @SerialEntry
    public boolean candles;

    public Screen getScreen(Screen parent) {
        return YetAnotherConfigLib.createBuilder()
                .title(Text.translatable("config.particlemoths.title"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("config.particlemoths.tabs.general"))
                        .option(Option.<Boolean>createBuilder()
                                .name(Text.translatable("cactus_config.option.general.spawnMoths"))
                                .description(OptionDescription.of(Text.translatable("cactus_config.option.desc.general.spawnMoths")))
                                .binding(true, () -> this.spawnMoths, (value) -> this.spawnMoths = value)
                                .controller(TickBoxControllerBuilderImpl::new)
                                .build())
                        .option(Option.<Boolean>createBuilder()
                                .name(Text.translatable("cactus_config.option.general.glowingMoths"))
                                .description(OptionDescription.of(Text.translatable("cactus_config.option.desc.general.glowingMoths")))
                                .binding(false, () -> this.glowingMoths, (value) -> this.glowingMoths = value)
                                .controller(TickBoxControllerBuilderImpl::new)
                                .build())
                        .group(OptionGroup.createBuilder()
                                .name(Text.translatable("cactus_config.separator.movementConfig"))
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("cactus_config.option.general.specificVelocities"))
                                        .description(OptionDescription.of(Text.translatable("cactus_config.option.desc.general.specificVelocities")))
                                        .binding(false, () -> this.specificVelocities, (value) -> this.specificVelocities = value)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Double>createBuilder()
                                        .name(Text.translatable("cactus_config.option.general.xVelocity"))
                                        .binding(100.0, () -> this.xVelocity, (value) -> this.xVelocity = value)
                                        .controller(option -> DoubleSliderControllerBuilder.create(option).range(-500.0, 500.0).step(1.0))
                                        .build())
                                .option(Option.<Double>createBuilder()
                                        .name(Text.translatable("cactus_config.option.general.yVelocity"))
                                        .binding(100.0, () -> this.yVelocity, (value) -> this.yVelocity = value)
                                        .controller(option -> DoubleSliderControllerBuilder.create(option).range(-500.0, 500.0).step(1.0))
                                        .build())
                                .option(Option.<Double>createBuilder()
                                        .name(Text.translatable("cactus_config.option.general.zVelocity"))
                                        .binding(100.0, () -> this.zVelocity, (value) -> this.zVelocity = value)
                                        .controller(option -> DoubleSliderControllerBuilder.create(option).range(-500.0, 500.0).step(1.0))
                                        .build())
                                .build())
                        .build())
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("config.particlemoths.tabs.spawning"))
                        .option(Option.<Double>createBuilder()
                                .name(Text.translatable("cactus_config.option.spawning.mothCount"))
                                .description(OptionDescription.of(Text.translatable("cactus_config.option.desc.spawning.mothCount")))
                                .binding(15.0, () -> this.mothCount, (value) -> this.mothCount = value)
                                .controller(option -> DoubleSliderControllerBuilder.create(option).range(0.0, 99.0).step(1.0))
                                .build())
                        .option(Option.<Double>createBuilder()
                                .name(Text.translatable("cactus_config.option.spawning.spawnProbability"))
                                .description(OptionDescription.of(Text.translatable("cactus_config.option.desc.spawning.spawnProbability")))
                                .binding(13.0, () -> this.spawnProbability, (value) -> this.spawnProbability = value)
                                .controller(option -> DoubleSliderControllerBuilder.create(option).range(1.0, 100.0).step(1.0))
                                .build())
                        .group(OptionGroup.createBuilder()
                                .name(Text.translatable("cactus_config.separator.spawnDistances"))
                                .option(Option.<Integer>createBuilder()
                                        .name(Text.translatable("cactus_config.option.spawning.xSpawnDistance"))
                                        .binding(30, () -> this.xSpawnDistance, (value) -> this.xSpawnDistance = value)
                                        .controller(IntegerFieldControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Integer>createBuilder()
                                        .name(Text.translatable("cactus_config.option.spawning.ySpawnDistance"))
                                        .binding(30, () -> this.ySpawnDistance, (value) -> this.ySpawnDistance = value)
                                        .controller(IntegerFieldControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Integer>createBuilder()
                                        .name(Text.translatable("cactus_config.option.spawning.zSpawnDistance"))
                                        .binding(30, () -> this.zSpawnDistance, (value) -> this.zSpawnDistance = value)
                                        .controller(IntegerFieldControllerBuilderImpl::new)
                                        .build())
                                .build())
                        .group(OptionGroup.createBuilder()
                                .name(Text.translatable("cactus_config.separator.heightLimits"))
                                .option(Option.<Integer>createBuilder()
                                        .name(Text.translatable("cactus_config.option.spawning.negHeightLimit"))
                                        .binding(-10, () -> this.negHeightLimit, (value) -> this.negHeightLimit = value)
                                        .controller(IntegerFieldControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Integer>createBuilder()
                                        .name(Text.translatable("cactus_config.option.spawning.posHeightLimit"))
                                        .binding(192, () -> this.posHeightLimit, (value) -> this.posHeightLimit = value)
                                        .controller(IntegerFieldControllerBuilderImpl::new)
                                        .build())
                                .build())
                        .build())
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("config.particlemoths.tabs.blockSpawning"))
                        .option(Option.<Boolean>createBuilder()
                                .name(Text.translatable("cactus_config.option.blockSpawning.spawnByBlocks"))
                                .binding(true, () -> this.spawnByBlocks, (value) -> this.spawnByBlocks = value)
                                .controller(TickBoxControllerBuilderImpl::new)
                                .build())
                        .option(Option.<Double>createBuilder()
                                .name(Text.translatable("cactus_config.option.blockSpawning.blockSpawnProbability"))
                                .description(OptionDescription.of(Text.translatable("cactus_config.option.desc.blockSpawning.blockSpawnProbability")))
                                .binding(15.0d, () -> this.blockSpawnProbability, (value) -> this.blockSpawnProbability = value)
                                .controller((option) -> DoubleSliderControllerBuilder.create(option).range(2.0, 100.0d).step(1.0))
                                .build())
                        .group(OptionGroup.createBuilder()
                                .name(Text.translatable("cactus_config.separator.spawnDistances"))
                                .option(Option.<Integer>createBuilder()
                                        .name(Text.translatable("cactus_config.option.blockSpawning.xBlockSpawnDistance"))
                                        .binding(3, () -> this.xBlockSpawnDistance, (value) -> this.xBlockSpawnDistance = value)
                                        .controller(IntegerFieldControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Integer>createBuilder()
                                        .name(Text.translatable("cactus_config.option.blockSpawning.yBlockSpawnDistance"))
                                        .binding(3, () -> this.yBlockSpawnDistance, (value) -> this.yBlockSpawnDistance = value)
                                        .controller(IntegerFieldControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Integer>createBuilder()
                                        .name(Text.translatable("cactus_config.option.blockSpawning.zBlockSpawnDistance"))
                                        .binding(3, () -> this.zBlockSpawnDistance, (value) -> this.zBlockSpawnDistance = value)
                                        .controller(IntegerFieldControllerBuilderImpl::new)
                                        .build())
                                .build())
                        .group(OptionGroup.createBuilder()
                                .name(Text.translatable("cactus_config.separator.allowedBlocksSeparator"))
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("cactus_config.option.blockSpawning.torches"))
                                        .binding(true, () -> this.torches, (value) -> this.torches = value)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("cactus_config.option.blockSpawning.redstoneTorches"))
                                        .binding(true, () -> this.redstoneTorches, (value) -> this.redstoneTorches = value)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("cactus_config.option.blockSpawning.redstoneLamps"))
                                        .binding(true, () -> this.redstoneLamps, (value) -> this.redstoneLamps = value)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("cactus_config.option.blockSpawning.lanterns"))
                                        .binding(true, () -> this.lanterns, (value) -> this.lanterns = value)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("cactus_config.option.blockSpawning.candles"))
                                        .binding(true, () -> this.candles, (value) -> this.candles = value)
                                        .controller(TickBoxControllerBuilderImpl::new)
                                        .build())
                                .build())
                        .build())
                .build().generateScreen(parent);
    }

    public void save() {
        CONFIG_HANDLER.save();
    }

    public boolean load() {
        return CONFIG_HANDLER.load();
    }
}
