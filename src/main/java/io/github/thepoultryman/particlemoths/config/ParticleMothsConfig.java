package io.github.thepoultryman.particlemoths.config;

import io.github.thepoultryman.cactusconfig.ConfigManager;
import io.github.thepoultryman.cactusconfig.OptionHolder;
import net.minecraft.text.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParticleMothsConfig extends ConfigManager {
    public OptionHolder generalTab = new OptionHolder(Text.translatable("config.particlemoths.tabs.general"), null);
    public boolean spawnMoths;
    public boolean glowingMoths;
    public boolean specificVelocities;
    public double xVelocity;
    public double yVelocity;
    public double zVelocity;
    public OptionHolder spawningTab = new OptionHolder(Text.translatable("config.particlemoths.tabs.spawning"), null);
    public double mothCount;
    public double spawnProbability;
    public int xSpawnDistance;
    public int ySpawnDistance;
    public int zSpawnDistance;
    public int negHeightLimit;
    public int posHeightLimit;
    public OptionHolder blockSpawningTab = new OptionHolder(Text.translatable("config.particlemoths.tabs.block_spawning"), null);
    public boolean spawnByBlocks;
    public double blockSpawnProbability;
    public int xBlockSpawnDistance;
    public int yBlockSpawnDistance;
    public int zBlockSpawnDistance;
    public Map<String, Boolean> allowedBlocks = new HashMap<>();

    public ParticleMothsConfig(String fileName, boolean loadOnServer) {
        super(fileName, loadOnServer);
    }

    @Override
    public void load() {
        this.fillBlockMap();

        this.getAndCreateBooleanOption(generalTab, "general.spawn_moths", true, () -> this.spawnMoths, this::spawnMoths, false);
        this.getAndCreateBooleanOption(generalTab, "general.glowing_moths", false, () -> this.glowingMoths, this::setGlowingMoths, true);
        this.generalTab.addSpruceSeparator("general.movement_config", true, false);
        this.getAndCreateBooleanOption(generalTab, "general.movement_config.specific_velocities", true,
                () -> this.specificVelocities, this::useSpecificVelocities, true);
        this.getAndCreateSliderOption(generalTab, "general.movement_config.x_velocity", 100D, -500D, 500D, 1f,
                () -> this.xVelocity, (velocity) -> this.setVelocity("x", velocity), false);
        this.getAndCreateSliderOption(generalTab, "general.movement_config.y_velocity", 100D, -500D, 500D, 1f,
                () -> this.yVelocity, (velocity) -> this.setVelocity("y", velocity), false);
        this.getAndCreateSliderOption(generalTab, "general.movement_config.z_velocity", 100D, -500D, 500D, 1f,
                () -> this.zVelocity, (velocity) -> this.setVelocity("z", velocity), false);

        this.getAndCreateSliderOption(spawningTab, "spawning.moth_count", 15D, 0D, 99D, 1f,
                () -> this.mothCount, this::setMothCount, true);
        this.getAndCreateSliderOption(spawningTab, "spawning.spawn_probability", 13D, 1D, 100D, 1f,
                () -> this.spawnProbability, this::setSpawnProbability, true);
        this.spawningTab.addSpruceSeparator("spawning.spawn_distances", true, false);
        this.getAndCreateIntegerOption(spawningTab, "spawning.spawn_distances.x_spawn_distance", 30,
                () -> this.xSpawnDistance, (distance) -> this.setSpawnDistance("x", distance), false);
        this.getAndCreateIntegerOption(spawningTab, "spawning.spawn_distances.y_spawn_distance", 30,
                () -> this.ySpawnDistance, (distance) -> this.setSpawnDistance("y", distance), false);
        this.getAndCreateIntegerOption(spawningTab, "spawning.spawn_distances.z_spawn_distance", 30,
                () -> this.zSpawnDistance, (distance) -> this.setSpawnDistance("z", distance), false);
        this.spawningTab.addSpruceSeparator("spawning.height_limits", true, false);
        this.getAndCreateIntegerOption(spawningTab, "spawning.height_limits.neg_height", -10,
                () -> this.negHeightLimit, (limit) -> this.setHeightLimit("neg", limit), false);
        this.getAndCreateIntegerOption(spawningTab, "spawning.height_limits.pos_height", 192,
                () -> this.posHeightLimit, (limit) -> this.setHeightLimit("pos", limit), false);

        this.getAndCreateBooleanOption(blockSpawningTab, "block_spawning.spawn_by_blocks", true,
                () -> this.spawnByBlocks, this::spawnByBlocks,false);
        this.getAndCreateSliderOption(blockSpawningTab, "block_spawning.block_spawn_probability", 15D, 2D, 100D, 1f,
                () -> this.blockSpawnProbability, this::setBlockSpawnProbability, true);
        this.getAndCreateIntegerOption(blockSpawningTab, "block_spawning.x_block_spawn_distance", 3,
                () -> this.xBlockSpawnDistance, (distance) -> this.setBlockSpawnDistance("x", distance), false);
        this.getAndCreateIntegerOption(blockSpawningTab, "block_spawning.y_block_spawn_distance", 3,
                () -> this.yBlockSpawnDistance, (distance) -> this.setBlockSpawnDistance("y", distance), false);
        this.getAndCreateIntegerOption(blockSpawningTab, "block_spawning.z_block_spawn_distance", 3,
                () -> this.zBlockSpawnDistance, (distance) -> this.setBlockSpawnDistance("z", distance), false);
        this.blockSpawningTab.addSpruceSeparator("block_spawning.allowed_blocks", true, false);
        for (Map.Entry<String, Boolean> entry : allowedBlocks.entrySet()) {
            this.getAndCreateBooleanOption(blockSpawningTab, "block_spawning.allowed_blocks." + entry.getKey(), true,
                    entry::getValue, (allowed) -> this.setAllowedBlock(entry.getKey(), allowed), false);
        }
    }

    @Override
    public boolean canReset() {
        return true;
    }

    @Override
    public void reset() {
        this.spawnMoths(true);
        this.setGlowingMoths(false);
        this.useSpecificVelocities(true);
        this.setVelocity("x", 100D);
        this.setVelocity("y", 100D);
        this.setVelocity("z", 100D);
        this.setMothCount(15D);
        this.setSpawnProbability(13D);
        this.setSpawnDistance("x", 30);
        this.setSpawnDistance("y", 30);
        this.setSpawnDistance("z", 30);
        this.setHeightLimit("neg", -10);
        this.setHeightLimit("pos", 192);
        this.spawnByBlocks(true);
        this.setBlockSpawnProbability(15D);
        this.setBlockSpawnDistance("x", 3);
        this.setBlockSpawnDistance("y", 3);
        this.setBlockSpawnDistance("z", 3);
        for (Map.Entry<String, Boolean> entry : allowedBlocks.entrySet()) {
            this.setAllowedBlock(entry.getKey(), true);
        }
    }

    private void spawnMoths(boolean spawn) {
        this.spawnMoths = spawn;
        this.setConfigOption("general.spawn_moths", spawn);
    }

    private void setGlowingMoths(boolean glow) {
        this.glowingMoths = glow;
        this.setConfigOption("general.glowing_moths", glow);
    }

    private void useSpecificVelocities(boolean specificVelocities) {
        this.specificVelocities = specificVelocities;
        this.setConfigOption("general.movement_config.specific_velocities", specificVelocities);
    }

    private void setVelocity(String axisString, double velocity) {
        String path = "general.movement_config." + axisString + "_velocity";
        switch (axisString) {
            case "x" -> this.xVelocity = velocity;
            case "y" -> this.yVelocity = velocity;
            default -> this.zVelocity = velocity;
        }
        this.setConfigOption(path, velocity);
    }

    private void setMothCount(double count) {
        this.mothCount = count;
        this.setConfigOption("spawning.moth_count", count);
    }

    private void setSpawnProbability(double probability) {
        this.spawnProbability = probability;
        this.setConfigOption("spawning.spawn_probability", probability);
    }

    private void setSpawnDistance(String axisString, int distance) {
        String path = "spawning.spawn_distances." + axisString + "_spawn_distance";
        switch (axisString) {
            case "x" -> this.xSpawnDistance = distance;
            case "y" -> this.ySpawnDistance = distance;
            default -> this.zSpawnDistance = distance;
        }
        this.setConfigOption(path, distance);
    }

    private void setHeightLimit(String type, int limit) {
        String path = "spawning.height_limits." + type + "_height";
        if (type.equals("neg"))
            this.negHeightLimit = limit;
        else
            this.posHeightLimit = limit;
        this.setConfigOption(path, limit);
    }

    private void spawnByBlocks(boolean spawn) {
        this.spawnByBlocks = spawn;
        this.setConfigOption("block_spawning.spawn_by_blocks", spawn);
    }

    private void setBlockSpawnProbability(double probability) {
        this.blockSpawnProbability = probability;
        this.setConfigOption("block_spawning.setBlockSpawnProbablity", probability);
    }

    private void setBlockSpawnDistance(String axisString, int distance) {
        String path = "block_spawning." + axisString + "_block_spawn_distance";
        switch (axisString) {
            case "x" -> this.xBlockSpawnDistance = distance;
            case "y" -> this.yBlockSpawnDistance = distance;
            default -> this.zBlockSpawnDistance = distance;
        }
        this.setConfigOption(path, distance);
    }

    private void fillBlockMap() {
        List<String> blockList = List.of("redstone_lamps", "lanterns", "candles", "torches", "redstone_torches");
        for (String block : blockList) {
            this.allowedBlocks.put(block, true);
        }
    }

    private void setAllowedBlock(String name, boolean allowed)  {
        String path = "block_spawning.allowed_blocks." + name;
        this.allowedBlocks.replace(name, allowed);
        this.setConfigOption(path, allowed);
    }
}
