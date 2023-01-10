# Particle Moths

Adds moths to Minecraft using particles.

## Spawning
Moths don't technically spawn because they're actually particles. However, for the sake of simplicity I will refer to this "adding of particles" as spawning.

### Caves
Moths will attempt to spawn in a radius around the player, with the size being defined in the config. If the place where moths attempt to spawn has rain or is in water, then the moths won't spawn.

### Blocks
Moths also have a chance to spawn by certain light-emitting blocks. Similarly to the cave spawning, if a moth tries to spawn in rain or water, it won't be spawned.

<details>
<summary>Blocks That Spawn Moths</summary>

* Regular Torches (Includes soul torches)
* Lanterns
* **Spawn Moths When Lit**
  * Redstone Torches
  * Redstone Lamps
  * Candles
</details>

## Configuration

Below are all the settings available, which give the user almost complete control over the mod.

<details>
<summary>All Configuration Settings</summary>

* Spawn Moths
* Glowing Moths
* Specific Velocities - If true, the speed of the Moths will be calculated individually on each axis.
* (X, Y, Z) Velocity - The speed moths will travel at on each axis.
* Moth Count
* Spawn Probability - The chance that a moth will spawn.
* (X, Y, Z) Spawn Distance - The uppermost distance moths can spawn from the player.
* (Negative & Positive) Height Limit - The lowermost and uppermost that moths can spawn.
* Spawn By Blocks
* Block Spawn Probability
* (X, Y, Z) Block Spawn Distance - The uppermost distance that moths can spawn from blocks.
* [Toggles for the blocks that moths can spawn at. (List seen above.)]
</details>

<details>
<summary><h2>Gifs</h2></summary>

_Configuration: 100 Block Spawn Probability_  
![100_block_probability_example](https://user-images.githubusercontent.com/66281330/185761252-750b02e8-a14f-4de8-a3bb-ddb62463033e.gif)

_Configuration: Glowing moths are on. Moth Count and Spawn Probability are both 50._  
![cave_example](https://user-images.githubusercontent.com/66281330/185761484-46e25fa1-4239-489a-af7c-6f22f339e92a.gif)
</details>
