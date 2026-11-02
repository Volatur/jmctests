package justmc

import justmc.value.*
import justmc.annotation.*

enum class EyeOfEnderDeath {
    DROP,
    SHATTER,
    RANDOM
}

enum class FireworkMovement {
    UPWARDS,
    DIRECTIONAL
}

enum class ItemFrameRotation {
    NONE,
    CLOCKWISE_45,
    CLOCKWISE,
    CLOCKWISE_135,
    FLIPPED,
    FLIPPED_45,
    COUNTER_CLOCKWISE,
    COUNTER_CLOCKWISE_45
}

enum class BlockFace {
    NORTH,
    EAST,
    SOUTH,
    WEST,
    UP,
    DOWN
}

enum class CraftingRecipeType {
    SHAPED,
    SHAPELESS
}

enum class CraftingCategory {
    BUILDING,
    REDSTONE,
    EQUIPMENT,
    MISC
}

enum class CookingRecipeType {
    FURNACE,
    BLASTING,
    SMOKING,
    CAMPFIRE
}

enum class CookingCategory {
    FOOD,
    BLOCKS,
    MISC
}

enum class WeatherType {
    CLEAR,
    RAINING,
    THUNDER
}

enum class WorldDifficulty {
    PEACEFUL,
    EASY,
    NORMAL,
    HARD
}

enum class Gamerule {
    DISABLE_RAIDS,
    DO_DAYLIGHT_CYCLE,
    DO_ENTITY_DROPS,
    DO_FIRE_TICK,
    DO_IMMEDIATE_RESPAWN,
    DO_INSOMNIA,
    DO_MOB_LOOT,
    DO_MOB_SPAWNING,
    DO_PATROL_SPAWNING,
    DO_TILE_DROPS,
    DO_TRADER_SPAWNING,
    DO_WEATHER_CYCLE,
    DROWNING_DAMAGE,
    FALL_DAMAGE,
    FIRE_DAMAGE,
    FORGIVE_DEAD_PLAYERS,
    KEEP_INVENTORY,
    MOB_GRIEFING,
    PROJECTILES_CAN_BREAK_BLOCKS,
    SHOW_DEATH_MESSAGES,
    NATURAL_REGENERATION,
    UNIVERSAL_ANGER,
    PLAYERS_SLEEPING_PERCENTAGE,
    REDUCED_DEBUG_INFO,
    FREEZE_DAMAGE,
    RANDOM_TICK_SPEED,
    MAX_ENTITY_CRAMMING,
    SPAWN_RADIUS,
    LAVA_SOURCE_CONVERSION,
    WATER_SOURCE_CONVERSION,
    TNT_EXPLOSION_DROP_DECAY,
    BLOCK_EXPLOSION_DROP_DECAY,
    MOB_EXPLOSION_DROP_DECAY,
    DO_LIMITED_CRAFTING,
    PLAYERS_NETHER_PORTAL_DEFAULT_DELAY,
    PLAYERS_NETHER_PORTAL_CREATIVE_DELAY,
    SNOW_ACCUMULATION_HEIGHT,
    SPAWN_CHUNK_RADIUS,
    DO_WARDEN_SPAWNING,
    ENDER_PEARLS_VANISH_ON_DEATH,
    DO_VINES_SPREAD,
    ALLOW_FIRE_TICKS_AWAY_FROM_PLAYER,
    TNT_EXPLODER,
    LOCATOR_BAR,
    SPAWN_MONSTERS,
    PVP,
    SPAWNER_BLOCKS_WORK
}

enum class WebRequestType {
    GET,
    POST,
    PUT,
    DELETE,
    HEAD,
    PATCH
}

enum class WebContentType {
    TEXT_PLAIN,
    APPLICATION_JSON
}

/**
 * Глобальный объект для управления миром, спавном сущностей, рецептами и веб-запросами в JustMC.
 */
object World {

    // --- Entity Spawning ---

    @Action("game_spawn_mob")
    external fun spawnMob(
        mob: Item,
        location: Location,
        health: Double = 20.0,
        customName: Text = "",
        potionEffects: Potion? = null,
        mainHand: Item? = null,
        helmet: Item? = null,
        chestplate: Item? = null,
        leggings: Item? = null,
        boots: Item? = null,
        offHand: Item? = null,
        naturalEquipment: Boolean = false
    )

    @Action("game_spawn_item")
    external fun spawnItem(
        item: Item,
        location: Location,
        customName: Text = "",
        applyMotion: Boolean = true,
        canMobPickup: Boolean = true,
        canPlayerPickup: Boolean = true
    )

    @Action("game_spawn_vehicle")
    external fun spawnVehicle(vehicle: Item, location: Location, customName: Text = "")

    @Action("game_spawn_experience_orb")
    external fun spawnExperienceOrb(
        experienceAmount: Double,
        location: Location,
        customName: Text = ""
    )

    @Action("game_launch_projectile")
    external fun launchProjectile(
        projectile: Item,
        location: Location,
        customName: Text = "",
        speed: Double = 1.0,
        inaccuracy: Double = 0.0,
        trail: Particle? = null
    )

    @Action("game_spawn_shulker_bullet")
    external fun spawnShulkerBullet(location: Location, customName: Text = "")

    @Action("game_spawn_armor_stand")
    external fun spawnArmorStand(
        location: Location,
        customName: Text = "",
        helmet: Item? = null,
        chestplate: Item? = null,
        leggings: Item? = null,
        boots: Item? = null,
        rightHand: Item? = null,
        leftHand: Item? = null,
        gravity: Boolean = true,
        marker: Boolean = false,
        small: Boolean = false,
        showArms: Boolean = false,
        basePlate: Boolean = true,
        invisible: Boolean = false
    )

    @Action("game_spawn_end_crystal")
    external fun spawnEndCrystal(
        location: Location,
        customName: Text = "",
        showBottom: Boolean = true
    )

    @Action("game_spawn_eye_of_ender")
    external fun spawnEyeOfEnder(
        location: Location,
        destination: Location,
        lifespan: Double = 80.0,
        customName: Text = "",
        endOfLifespan: EyeOfEnderDeath = EyeOfEnderDeath.RANDOM
    )

    @Action("game_spawn_text_display")
    external fun spawnTextDisplay(
        spawnLocation: Location,
        displayedText: Text,
        customName: Text = "",
        mergingMode: TextMerging = TextMerging.SPACES
    )

    @Action("game_spawn_item_display")
    external fun spawnItemDisplay(
        spawnLocation: Location,
        customName: Text = "",
        displayedItem: Item
    )

    @Action("game_spawn_block_display")
    external fun spawnBlockDisplay(
        spawnLocation: Location,
        block: Item,
        customName: Text = ""
    )

    @Action("game_spawn_interaction_entity")
    external fun spawnInteraction(
        location: Location,
        width: Double = 1.0,
        height: Double = 1.0,
        customName: Text = "",
        responsive: Boolean = true
    )

    @Action("game_create_explosion")
    external fun createExplosion(
        location: Location,
        power: Double = 4.0,
        fire: Boolean = false,
        breakBlocks: Boolean = true,
        nameOrUuid: Text = ""
    )

    @Action("game_spawn_primed_tnt")
    external fun spawnPrimedTnt(
        location: Location,
        tntPower: Double = 4.0,
        fuseDuration: Double = 80.0,
        customName: Text = "",
        block: Item? = null
    )

    @Action("game_spawn_evoker_fangs")
    external fun spawnEvokerFangs(location: Location, customName: Text = "")

    @Action("game_launch_firework")
    external fun launchFirework(
        firework: Item,
        location: Location,
        movement: FireworkMovement = FireworkMovement.UPWARDS,
        instant: Boolean = false
    )

    @Action("game_spawn_lightning_bolt")
    external fun spawnLightningBolt(location: Location)

    @Action("game_spawn_effect_cloud")
    external fun spawnEffectCloud(
        location: Location,
        effects: Potion? = null,
        radius: Double = 3.0,
        duration: Double = 600.0,
        particle: Particle? = null,
        customName: Text = ""
    )

    @Action("game_spawn_falling_block")
    external fun spawnFallingBlock(
        location: Location,
        block: Item,
        name: Text = "",
        shouldExpire: Boolean = true
    )

    @Action("game_spawn_item_frame")
    external fun spawnItemFrame(
        spawnLocation: Location,
        item: Item? = null,
        rotation: ItemFrameRotation = ItemFrameRotation.NONE,
        blockFace: BlockFace = BlockFace.NORTH,
        glowing: Boolean = false,
        visible: Boolean = true,
        fixed: Boolean = false
    )

    @Action("game_spawn_painting")
    external fun spawnPainting(
        spawnLocation: Location,
        art: Text,
        blockFace: BlockFace = BlockFace.NORTH
    )

    // --- Crafting Recipes ---

    @Action("game_add_custom_crafting_recipe")
    external fun addCraftingRecipe(
        name: Text,
        replaceVanilla: Boolean = false,
        items: List<Item>,
        inputOnlyTypes: Boolean = false,
        result: Item,
        recipeType: CraftingRecipeType = CraftingRecipeType.SHAPED,
        category: CraftingCategory = CraftingCategory.MISC
    )

    @Action("game_add_custom_transmute_recipe")
    external fun addTransmuteRecipe(
        name: Text,
        replaceVanilla: Boolean = false,
        input: List<Item>,
        inputOnlyType: Boolean = false,
        material: Item,
        materialOnlyType: Boolean = false,
        result: Item,
        category: CraftingCategory = CraftingCategory.MISC
    )

    @Action("game_add_custom_cooking_recipe")
    external fun addCookingRecipe(
        name: Text,
        replaceVanilla: Boolean = false,
        input: List<Item>,
        inputOnlyType: Boolean = false,
        result: Item,
        experience: Double = 0.0,
        cookingTime: Double = 200.0,
        recipeType: CookingRecipeType = CookingRecipeType.FURNACE,
        category: CookingCategory = CookingCategory.MISC
    )

    @Action("game_add_custom_smithing_transform_recipe")
    external fun addSmithingTransformRecipe(
        name: Text,
        replaceVanilla: Boolean = false,
        template: Item,
        templateOnlyType: Boolean = false,
        base: Item,
        baseOnlyType: Boolean = false,
        addition: Item,
        additionOnlyType: Boolean = false,
        result: Item,
        copyDataComponents: Boolean = true
    )

    @Action("game_add_custom_smithing_trim_recipe")
    external fun addSmithingTrimRecipe(
        name: Text,
        replaceVanilla: Boolean = false,
        template: Item,
        templateOnlyType: Boolean = false,
        base: Item,
        baseOnlyType: Boolean = false,
        addition: Item,
        additionOnlyType: Boolean = false,
        trim: Item,
        copyDataComponents: Boolean = true
    )

    @Action("game_add_custom_stonecutting_recipe")
    external fun addStonecuttingRecipe(
        name: Text,
        replaceVanilla: Boolean = false,
        input: List<Item>,
        inputOnlyType: Boolean = false,
        result: Item
    )

    @Action("game_remove_custom_recipe")
    external fun removeRecipe(vararg names: Text, removeVanilla: Boolean = false)

    @Action("game_clear_custom_recipes")
    external fun clearCustomRecipes()

    // --- World Settings ---

    @Action("game_set_world_time")
    external fun setTime(time: Double)

    @Action("game_set_world_weather")
    external fun setWeather(weatherType: WeatherType, weatherDuration: Double = 6000.0)

    @Action("game_set_world_difficulty")
    external fun setDifficulty(difficulty: WorldDifficulty)

    @Action("game_set_world_gamerule")
    external fun setGamerule(gamerule: Gamerule, value: Text)

    inline fun setGamerule(gamerule: Gamerule, value: Boolean) =
        setGamerule(gamerule, if (value) "true" else "false")

    inline fun setGamerule(gamerule: Gamerule, value: Number) =
        setGamerule(gamerule, value.toString())

    @Action("game_set_world_simulation_distance")
    external fun setSimulationDistance(distance: Double)

    @Action("game_set_block_drops_enabled")
    external fun setBlockDropsEnabled(enable: Boolean = true)

    // --- Web Requests ---

    @Action("game_send_web_request")
    external fun sendWebRequest(
        url: Text,
        contentBody: Text = "",
        requestType: WebRequestType = WebRequestType.GET,
        contentType: WebContentType = WebContentType.TEXT_PLAIN,
        headers: Map<Text, Text> = emptyMap()
    )

    // --- World Conditions ---

    @Action("if_game_chunk_is_loaded")
    external fun isChunkLoaded(location: Location): Boolean

    @Action("if_game_has_player")
    external fun hasPlayer(vararg namesOrUuids: Text, checkMode: CheckMode = CheckMode.ANY): Boolean

    @Action("if_game_has_entity")
    external fun hasEntity(vararg namesOrUuids: Text, checkMode: CheckMode = CheckMode.ANY): Boolean

    // --- Chunk Custom Tags & Utilities ---

    object Chunk {
        @Action("game_chunk_get_custom_tag", returns = ["variable"])
        external fun getCustomTag(location: Location, tagName: Text, defaultValue: Any? = null): Any?

        @Action("game_chunk_get_custom_tags", returns = ["variable"])
        external fun getCustomTags(location: Location): Map<Text, Text>

        @Action("game_chunk_set_custom_tag")
        external fun setCustomTag(location: Location, tagNames: List<Text>, tagValues: List<Text>)

        inline fun setCustomTag(location: Location, tagName: Text, tagValue: Text) =
            setCustomTag(location, listOf(tagName), listOf(tagValue))

        @Action("game_chunk_remove_custom_tag")
        external fun removeCustomTag(location: Location, tagNames: List<Text>)

        inline fun removeCustomTag(location: Location, vararg tagNames: Text) =
            removeCustomTag(location, tagNames.toList())

        @Action("game_chunk_remove_custom_tags")
        external fun removeCustomTags(location: Location)

        @Action("if_game_chunk_has_custom_tag")
        external fun hasCustomTag(
            location: Location,
            tag: Text,
            tagValue: Text,
            compareType: CompareType = CompareType.EQUALS
        ): Boolean

        @Action("if_game_chunk_is_loaded")
        external fun isLoaded(location: Location): Boolean
    }
}