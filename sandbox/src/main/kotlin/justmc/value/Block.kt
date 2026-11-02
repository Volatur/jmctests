package justmc.value

import justmc.*
import justmc.annotation.*
import justmc.event.ComparisonMode
import kotlin.*

/**
 * Вариант возвращаемого типа блока.
 */
enum class BlockMaterialType {
    ID, ID_WITH_DATA, NAME, ITEM
}

/**
 * Тип уровня освещения.
 */
enum class LightLevelType {
    TOTAL, SKY, BLOCKS
}

/**
 * Сторона таблички.
 */
enum class SignSide {
    FRONT,
    BACK,
    ALL
}

/**
 * Строка таблички.
 */
enum class SignLine {
    FIRST, SECOND, THIRD, FOURTH, ALL
}

enum class TreeType {
    TREE,
    BIG_TREE,
    REDWOOD,
    TALL_REDWOOD,
    BIRCH,
    JUNGLE,
    SMALL_JUNGLE,
    COCOA_TREE,
    JUNGLE_BUSH,
    RED_MUSHROOM,
    BROWN_MUSHROOM,
    SWAMP,
    ACACIA,
    DARK_OAK,
    MEGA_REDWOOD,
    MEGA_PINE,
    TALL_BIRCH,
    CHORUS_PLANT,
    CRIMSON_FUNGUS,
    WARPED_FUNGUS,
    AZALEA,
    MANGROVE,
    TALL_MANGROVE,
    CHERRY,
    PALE_OAK,
    PALE_OAK_CREAKING
}

enum class BlockPowerMode {
    DIRECT,
    INDIRECT
}

enum class GrowthType {
    STAGE_NUMBER,
    PERCENTAGE
}

enum class GrowthUnit {
    GROWTH_STAGE,
    GROWTH_PERCENTAGE
}

enum class CampfireSlot {
    FIRST,
    SECOND,
    THIRD,
    FOURTH
}

enum class PotSherdSide {
    BACK,
    LEFT,
    RIGHT,
    FRONT
}

enum class PotWobbleStyle {
    POSITIVE,
    NEGATIVE
}

enum class CreakingHeartState {
    UPROOTED,
    DORMANT,
    AWAKE
}

enum class CopperGolemPose {
    STANDING,
    SITTING,
    RUNNING,
    STAR
}

enum class PotentSulfurState {
    DRY,
    WET,
    DORMANT,
    ERUPTING,
    CONTINUOUS
}

enum class SignTextColor {
    WHITE,
    ORANGE,
    MAGENTA,
    LIGHT_BLUE,
    YELLOW,
    LIME,
    PINK,
    GRAY,
    LIGHT_GRAY,
    CYAN,
    PURPLE,
    BLUE,
    BROWN,
    GREEN,
    RED,
    BLACK
}

enum class PlayerHeadReceiveType {
    NAME_OR_UUID,
    VALUE
}

enum class PlayerHeadReturnValue {
    NAME,
    UUID,
    VALUE
}

enum class TileBlockNbtType {
    ANY_VALUE,
    NBT_STRING
}

enum class SignCheckSide {
    ANY,
    FRONT,
    BACK
}

enum class SignLines {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    ALL,
    ANY
}

enum class TextCheckMode {
    CONTAINS,
    EQUALS
}

enum class CheckMode {
    ANY,
    ALL
}

enum class CompareType {
    EQUALS,
    CONTAINS,
    STARTS_WITH,
    ENDS_WITH
}

/**
 * Обертка блока на определенном местоположении.
 * Доступна через свойство `location.block`.
 */
@InlineClass
class Block(val location: Location) {

    val material: Text inline get() = Companion.getMaterial(location)

    var type: Item
        inline get() = Item(Companion.getMaterial(location, BlockMaterialType.ID))
        inline set(value) { set(value) }

    inline fun getMaterial(type: BlockMaterialType): Text = Companion.getMaterial(location, type)

    val growth: Double inline get() = Companion.getGrowth(location)

    var growthLevel: Double
        inline get() = growth
        inline set(value) { setGrowth(value) }

    inline fun getGrowth(growthUnit: GrowthUnit = GrowthUnit.GROWTH_STAGE): Double =
        Companion.getGrowth(location, growthUnit)

    val power: Double inline get() = Companion.getPower(location)

    var powerLevel: Double
        inline get() = power
        inline set(value) { setAnaloguePower(value) }

    var isPowered: Boolean
        inline get() = power > 0.0
        @JvmName("setIsPoweredProp")
        inline set(value) { setPowered(value) }

    var age: Double
        inline get() = 0.0
        @JvmName("setAgeProp")
        inline set(value) { setAge(value) }

    val lightLevel: Double inline get() = Companion.getLightLevel(location)

    inline fun getLightLevel(type: LightLevelType): Double = Companion.getLightLevel(location, type)

    val allData: Text inline get() = Companion.getAllData(location)

    var data: Text
        inline get() = allData
        @JvmName("setDataProp")
        inline set(value) { setData(value) }

    inline fun getAllData(hideUnspecified: Boolean = false): Text = Companion.getAllData(location, hideUnspecified)

    inline fun getData(tagName: Text): Text = Companion.getData(location, tagName)

    inline operator fun get(tagName: Text): Text = getData(tagName)
    inline operator fun set(data: Text, value: Text) { setSingleData(data, value) }
    inline operator fun set(side: SignSide, line: SignLine, text: Text) {
        setSignText(side, text, when (line) {
            SignLine.FIRST -> 1.0
            SignLine.SECOND -> 2.0
            SignLine.THIRD -> 3.0
            SignLine.FOURTH -> 4.0
            SignLine.ALL -> 1.0
        })
    }
    inline operator fun plusAssign(item: Item) { fillContainer(item) }
    inline operator fun minusAssign(item: Item) { removeContainerItems(item) }
    inline operator fun set(slot: Double, item: Item) { setItemInSlot(item, slot) }

    var container: List<Item>
        inline get() = containerContents
        @JvmName("setContainerProp")
        inline set(value) { setContainer(value) }

    val containerContents: List<Item> inline get() = Companion.getContainerContents(location)

    inline fun getContainerContents(ignoreEmptySlots: Boolean = true): List<Item> =
        Companion.getContainerContents(location, ignoreEmptySlots)

    val containerName: Text inline get() = Companion.getContainerName(location)

    val containerLock: Text inline get() = Companion.getContainerLock(location)

    inline fun getSignText(checkSide: SignSide = SignSide.ALL, signLine: SignLine = SignLine.ALL): Text =
        Companion.getSignText(location, checkSide, signLine)

    val lecternBook: Item inline get() = Companion.getLecternBook(location)

    val lecternPage: Double inline get() = Companion.getLecternPage(location)

    val brushableItem: Item inline get() = Companion.getBrushableItem(location)

    val potSherd: Item inline get() = Companion.getPotSherd(location)

    inline fun getPotSherd(side: PotSherdSide = PotSherdSide.FRONT): Item = Companion.getPotSherd(location, side)

    val sculkWarningLevel: Double inline get() = Companion.getSculkWarningLevel(location)

    val vaultDisplayedItem: Item inline get() = Companion.getVaultDisplayedItem(location)

    val vaultNextStateUpdateTime: Double inline get() = Companion.getVaultNextStateUpdateTime(location)

    val playerHeadOwner: Text inline get() = Companion.getPlayerHeadOwner(location)

    inline fun getPlayerHeadOwner(returnValue: PlayerHeadReturnValue = PlayerHeadReturnValue.NAME): Text =
        Companion.getPlayerHeadOwner(location, returnValue)

    inline fun getTileBlockNbt(
        path: Text = "",
        valueType: TileBlockNbtType = TileBlockNbtType.ANY_VALUE
    ): Any = Companion.getTileBlockNbt(location, path, valueType)

    inline fun getTileBlockCustomTag(tagName: Text, defaultValue: Any? = null): Text =
        Companion.getTileBlockCustomTag(location, tagName, defaultValue)

    inline fun getTileBlockCustomTags(): Map<Text, Text> = Companion.getTileBlockCustomTags(location)

    // --- Block Actions on single location ---

    inline fun set(block: Item, updateBlocks: Boolean = true) =
        Companion.set(block, listOf(location), updateBlocks)

    inline fun breakBlock(tool: Item? = null, dropExp: Boolean = true) =
        Companion.breakBlocks(tool, dropExp, location)

    inline fun setData(blockData: Text) = Companion.setData(location, blockData)

    inline fun setSingleData(data: Text, value: Text) = Companion.setSingleData(location, data, value)

    inline fun setPowered(powered: Boolean = true) = Companion.setPowered(location, powered)

    inline fun setAnaloguePower(powerLevel: Double) = Companion.setAnaloguePower(location, powerLevel)

    inline fun randomTick(times: Double = 1.0) = Companion.randomTick(location, times)

    inline fun update() = Companion.update(location)

    inline fun boneMeal(count: Double = 1.0) = Companion.boneMeal(location, count)

    inline fun setGrowth(growthStage: Double, growthType: GrowthType = GrowthType.STAGE_NUMBER) =
        Companion.setGrowth(location, growthStage, growthType)

    inline fun setAge(tick: Double) = Companion.setAge(location, tick)

    inline fun generateTree(treeType: TreeType = TreeType.TREE) = Companion.generateTree(location, treeType)

    inline fun setContainer(vararg items: Item) = Companion.setContainer(location, *items)

    inline fun setContainer(items: List<Item>) = Companion.setContainer(location, *items.toTypedArray())

    inline fun clearContainer() = Companion.clearContainer(location)

    inline fun fillContainer(vararg items: Item) = Companion.fillContainer(location, *items)

    inline fun fillContainer(items: List<Item>) = Companion.fillContainer(location, *items.toTypedArray())

    inline fun clearContainerItems(vararg items: Item) = Companion.clearContainerItems(location, *items)

    inline fun clearContainerItems(items: List<Item>) = Companion.clearContainerItems(location, *items.toTypedArray())

    inline fun setItemInSlot(item: Item, slot: Double) = Companion.setItemInSlot(location, item, slot)

    inline fun removeContainerItems(vararg items: Item) = Companion.removeContainerItems(location, *items)

    inline fun removeContainerItems(items: List<Item>) = Companion.removeContainerItems(location, *items.toTypedArray())

    inline fun replaceContainerItems(items: List<Item>, replace: Item, count: Double = 1.0) =
        Companion.replaceContainerItems(location, items, replace, count)

    inline fun setContainerName(name: Text) = Companion.setContainerName(location, name)

    inline fun setContainerLock(containerKey: Text) = Companion.setContainerLock(location, containerKey)

    inline fun setSignText(side: SignSide = SignSide.ALL, text: Text, line: Double = 1.0) =
        Companion.setSignText(location, side, text, line)

    inline fun setSignTextColor(
        side: SignSide = SignSide.ALL,
        glowing: Boolean = false,
        signTextColor: SignTextColor = SignTextColor.BLACK
    ) = Companion.setSignTextColor(location, side, glowing, signTextColor)

    inline fun setSignWaxed(waxed: Boolean = true) = Companion.setSignWaxed(location, waxed)

    inline fun setPlayerHead(
        nameOrUuid: Text,
        receiveType: PlayerHeadReceiveType = PlayerHeadReceiveType.NAME_OR_UUID
    ) = Companion.setPlayerHead(location, nameOrUuid, receiveType)

    inline fun setFurnaceCookTime(time: Double) = Companion.setFurnaceCookTime(location, time)

    inline fun setCampfireItem(
        item: Item,
        cookingTime: Double = 200.0,
        slot: CampfireSlot = CampfireSlot.FIRST
    ) = Companion.setCampfireItem(location, item, cookingTime, slot)

    inline fun setLecternBook(item: Item, page: Double = 1.0) = Companion.setLecternBook(location, item, page)

    inline fun setBrushableItem(item: Item) = Companion.setBrushableItem(location, item)

    inline fun setSpawnerEntity(entity: Item) = Companion.setSpawnerEntity(location, entity)

    inline fun setDecoratePotSherd(item: Item, side: PotSherdSide = PotSherdSide.FRONT) =
        Companion.setDecoratePotSherd(location, item, side)

    inline fun wobbleDecoratedPot(style: PotWobbleStyle = PotWobbleStyle.POSITIVE) =
        Companion.wobbleDecoratedPot(location, style)

    inline fun bloomSculkCatalyst(bloomLocation: Location, charge: Double = 1.0) =
        Companion.bloomSculkCatalyst(location, bloomLocation, charge)

    inline fun setSculkWarningLevel(warningLevel: Double) = Companion.setSculkWarningLevel(location, warningLevel)

    inline fun setSculkShrieking(shrieking: Boolean = true) = Companion.setSculkShrieking(location, shrieking)

    inline fun setSculkCanSummon(canSummon: Boolean = true) = Companion.setSculkCanSummon(location, canSummon)

    inline fun setVaultDisplayedItem(item: Item) = Companion.setVaultDisplayedItem(location, item)

    inline fun setVaultNextStateUpdateTime(time: Double) = Companion.setVaultNextStateUpdateTime(location, time)

    inline fun setDriedGhastHydration(hydration: Double) = Companion.setDriedGhastHydration(location, hydration)

    inline fun setCreakingHeartState(heartState: CreakingHeartState = CreakingHeartState.AWAKE) =
        Companion.setCreakingHeartState(location, heartState)

    inline fun setCreakingHeartNatural(natural: Boolean = true) = Companion.setCreakingHeartNatural(location, natural)

    inline fun setCopperGolemPose(pose: CopperGolemPose = CopperGolemPose.STANDING) =
        Companion.setCopperGolemPose(location, pose)

    inline fun setPotentSulfurState(state: PotentSulfurState = PotentSulfurState.DRY) =
        Companion.setPotentSulfurState(location, state)

    inline fun setBlockNbt(tagNames: List<Text>, tagValues: List<Text>) =
        Companion.setBlockNbt(location, tagNames, tagValues)

    inline fun setTileBlockCustomTag(tagName: Text, tagValue: Text) =
        Companion.setTileBlockCustomTag(location, tagName, tagValue)

    inline fun removeTileBlockCustomTag(tagName: Text) =
        Companion.removeTileBlockCustomTag(location, tagName)

    inline fun removeTileBlockCustomTags() =
        Companion.removeTileBlockCustomTags(location)

    // --- Block Conditions ---

    inline fun blockEquals(vararg blocks: Item): Boolean =
        Companion.blockEquals(location, *blocks)

    inline fun isPowered(powerMode: BlockPowerMode = BlockPowerMode.DIRECT): Boolean =
        Companion.isPowered(powerMode, location)

    inline fun isLocationInside(): Boolean =
        Companion.isLocationInBlock(location)

    inline fun containerHas(
        item: Item,
        checkMode: CheckMode = CheckMode.ALL,
        comparisonMode: ComparisonMode = ComparisonMode.EXACTLY
    ): Boolean = Companion.containerHas(location, *arrayOf(item), checkMode = checkMode, comparisonMode = comparisonMode)

    inline fun containerHas(
        vararg items: Item
    ): Boolean = Companion.containerHas(location, *items, checkMode = CheckMode.ALL, comparisonMode = ComparisonMode.EXACTLY)

    inline fun containerHasRoomFor(
        item: Item,
        checkMode: CheckMode = CheckMode.ALL
    ): Boolean = Companion.containerHasRoomFor(location, *arrayOf(item), checkMode = checkMode)

    inline fun containerHasRoomFor(
        vararg items: Item
    ): Boolean = Companion.containerHasRoomFor(location, *items, checkMode = CheckMode.ALL)

    inline fun signContains(
        text: Text,
        checkSide: SignCheckSide = SignCheckSide.ANY,
        checkMode: TextCheckMode = TextCheckMode.CONTAINS,
        lines: SignLines = SignLines.ANY
    ): Boolean = Companion.signContains(location, *arrayOf(text), checkSide = checkSide, checkMode = checkMode, lines = lines)

    inline fun signContains(
        vararg texts: Text
    ): Boolean = Companion.signContains(location, *texts, checkSide = SignCheckSide.ANY, checkMode = TextCheckMode.CONTAINS, lines = SignLines.ANY)

    inline fun hasCustomTag(
        tag: Text,
        tagValue: Any? = null,
        compareType: CompareType = CompareType.EQUALS
    ): Boolean = Companion.hasTileBlockCustomTag(location, tag, tagValue, compareType)

    companion object {
        // --- Getters ---

        @Action("set_variable_get_block_material", returns = ["variable"])
        external fun getMaterial(location: Location, valueType: BlockMaterialType = BlockMaterialType.ID): Text

        @Action("set_variable_get_block_growth", returns = ["variable"])
        external fun getGrowth(location: Location, growthUnit: GrowthUnit = GrowthUnit.GROWTH_STAGE): Double

        @Action("set_variable_get_block_power", returns = ["variable"])
        external fun getPower(location: Location): Double

        @Action("set_variable_get_light_level", returns = ["variable"])
        external fun getLightLevel(location: Location, valueType: LightLevelType = LightLevelType.TOTAL): Double

        @Action("set_variable_get_all_block_data", returns = ["variable"])
        external fun getAllData(location: Location, hideUnspecified: Boolean = false): Text

        @Action("set_variable_get_block_data", returns = ["variable"])
        external fun getData(location: Location, tagName: Text): Text

        @Action("set_variable_get_container_contents", returns = ["variable"])
        external fun getContainerContents(location: Location, ignoreEmptySlots: Boolean = true): List<Item>

        @Action("set_variable_get_container_name", returns = ["variable"])
        external fun getContainerName(location: Location): Text

        @Action("set_variable_get_container_lock", returns = ["variable"])
        external fun getContainerLock(location: Location): Text

        @Action("set_variable_get_sign_text", returns = ["variable"])
        external fun getSignText(
            location: Location,
            checkSide: SignSide = SignSide.ALL,
            signLine: SignLine = SignLine.ALL
        ): Text

        @Action("set_variable_get_lectern_book", returns = ["variable"])
        external fun getLecternBook(location: Location): Item

        @Action("set_variable_get_lectern_page", returns = ["variable"])
        external fun getLecternPage(location: Location): Double

        @Action("set_variable_get_brushable_block_item", returns = ["variable"])
        external fun getBrushableItem(location: Location): Item

        @Action("set_variable_get_decorate_pot_sherd", returns = ["variable"])
        external fun getPotSherd(location: Location, side: PotSherdSide = PotSherdSide.FRONT): Item

        @Action("set_variable_get_sculk_shrieker_warning_level", returns = ["variable"])
        external fun getSculkWarningLevel(location: Location): Double

        @Action("set_variable_get_vault_displayed_item", returns = ["variable"])
        external fun getVaultDisplayedItem(location: Location): Item

        @Action("set_variable_get_vault_next_state_update_time", returns = ["variable"])
        external fun getVaultNextStateUpdateTime(location: Location): Double

        @Action("set_variable_get_player_head_value", returns = ["variable"])
        external fun getPlayerHeadOwner(
            location: Location,
            returnValue: PlayerHeadReturnValue = PlayerHeadReturnValue.NAME
        ): Text

        @Action("set_variable_get_tile_block_nbt", returns = ["variable"])
        external fun getTileBlockNbt(
            location: Location,
            path: Text = "",
            valueType: TileBlockNbtType = TileBlockNbtType.ANY_VALUE
        ): Any

        @Action("set_variable_get_tile_block_custom_tag", returns = ["variable"])
        external fun getTileBlockCustomTag(
            location: Location,
            tagName: Text,
            defaultValue: Any? = null
        ): Text

        @Action("game_get_tile_block_custom_tags", returns = ["variable"])
        external fun getTileBlockCustomTags(location: Location): Map<Text, Text>

        // --- Single & Batch Block Actions ---

        @Action("game_set_block")
        external fun set(block: Item, locations: List<Location>, updateBlocks: Boolean = true)

        inline fun set(block: Item, vararg locations: Location, updateBlocks: Boolean = true) =
            set(block, locations.toList(), updateBlocks)

        @Action("game_break_block")
        external fun breakBlocks(tool: Item? = null, dropExp: Boolean = true, vararg locations: Location)

        @Action("game_set_block_data")
        external fun setData(location: Location, blockData: Text)

        @Action("game_set_block_single_data")
        external fun setSingleData(location: Location, data: Text, value: Text)

        @Action("game_set_block_powered")
        external fun setPowered(location: Location, powered: Boolean = true)

        @Action("game_set_block_analogue_power")
        external fun setAnaloguePower(location: Location, powerLevel: Double)

        @Action("game_random_tick_block")
        external fun randomTick(location: Location, times: Double = 1.0)

        @Action("game_update_block")
        external fun update(location: Location)

        @Action("game_bone_meal_block")
        external fun boneMeal(location: Location, count: Double = 1.0)

        @Action("game_block_growth")
        external fun setGrowth(
            location: Location,
            growthStage: Double,
            growthType: GrowthType = GrowthType.STAGE_NUMBER
        )

        @Action("game_set_age")
        external fun setAge(location: Location, tick: Double)

        @Action("game_generate_tree")
        external fun generateTree(location: Location, treeType: TreeType = TreeType.TREE)

        // --- Region Actions ---

        @Action("game_set_region")
        external fun setRegion(block: Item, pos_1: Location, pos_2: Location)

        @Action("game_replace_blocks_in_region")
        external fun replaceRegion(
            oldBlock: Item,
            pos_1: Location,
            pos_2: Location,
            newBlock: Item
        )

        @Action("game_clone_region")
        external fun cloneRegion(
            pos_1: Location,
            pos_2: Location,
            targetPos: Location,
            pastePos: Location? = null,
            ignoreAir: Boolean = false,
            copyEntity: Boolean = false
        )

        @Action("game_clear_region")
        external fun clearRegion(pos_1: Location, pos_2: Location)

        @Action("game_clear_exploded_blocks")
        external fun clearExploded(vararg location: Location)

        @Action("game_set_block_drops_enabled")
        external fun setDropsEnabled(enable: Boolean = true)

        // --- Container Actions ---

        @Action("game_set_container")
        external fun setContainer(location: Location, vararg items: Item)

        @Action("game_clear_container")
        external fun clearContainer(location: Location)

        @Action("game_fill_container")
        external fun fillContainer(location: Location, vararg items: Item)

        @Action("game_clear_container_items")
        external fun clearContainerItems(location: Location, vararg items: Item)

        @Action("game_set_item_in_container_slot")
        external fun setItemInSlot(location: Location, item: Item, slot: Double)

        @Action("game_remove_container_items")
        external fun removeContainerItems(location: Location, vararg items: Item)

        @Action("game_replace_container_items")
        external fun replaceContainerItems(
            location: Location,
            items: List<Item>,
            replace: Item,
            count: Double = 1.0
        )

        @Action("game_set_container_name")
        external fun setContainerName(location: Location, name: Text)

        @Action("game_set_container_lock")
        external fun setContainerLock(location: Location, containerKey: Text)

        // --- Specific Tile / Block State Actions ---

        @Action("game_set_sign_text")
        external fun setSignText(
            location: Location,
            side: SignSide = SignSide.ALL,
            text: Text,
            line: Double = 1.0
        )

        @Action("game_set_sign_text_color")
        external fun setSignTextColor(
            location: Location,
            side: SignSide = SignSide.ALL,
            glowing: Boolean = false,
            signTextColor: SignTextColor = SignTextColor.BLACK
        )

        @Action("game_set_sign_waxed")
        external fun setSignWaxed(location: Location, waxed: Boolean = true)

        @Action("game_set_player_head")
        external fun setPlayerHead(
            location: Location,
            nameOrUuid: Text,
            receiveType: PlayerHeadReceiveType = PlayerHeadReceiveType.NAME_OR_UUID
        )

        @Action("game_set_furnace_cook_time")
        external fun setFurnaceCookTime(location: Location, time: Double)

        @Action("game_set_campfire_item")
        external fun setCampfireItem(
            location: Location,
            item: Item,
            cookingTime: Double = 200.0,
            slot: CampfireSlot = CampfireSlot.FIRST
        )

        @Action("game_set_lectern_book")
        external fun setLecternBook(location: Location, item: Item, page: Double = 1.0)

        @Action("game_set_brushable_block_item")
        external fun setBrushableItem(location: Location, item: Item)

        @Action("game_set_spawner_entity")
        external fun setSpawnerEntity(location: Location, entity: Item)

        @Action("game_set_decorate_pot_sherd")
        external fun setDecoratePotSherd(
            location: Location,
            item: Item,
            side: PotSherdSide = PotSherdSide.FRONT
        )

        @Action("game_wobble_decorated_pot")
        external fun wobbleDecoratedPot(location: Location, style: PotWobbleStyle = PotWobbleStyle.POSITIVE)

        @Action("game_bloom_skulk_catalyst")
        external fun bloomSculkCatalyst(location: Location, bloomLocation: Location, charge: Double = 1.0)

        @Action("game_set_sculk_shrieker_warning_level")
        external fun setSculkWarningLevel(location: Location, warningLevel: Double)

        @Action("game_set_sculk_shrieker_shrieking")
        external fun setSculkShrieking(location: Location, shrieking: Boolean = true)

        @Action("game_set_sculk_shrieker_can_summon")
        external fun setSculkCanSummon(location: Location, can_summon: Boolean = true)

        @Action("game_set_vault_displayed_item")
        external fun setVaultDisplayedItem(location: Location, item: Item)

        @Action("game_set_vault_next_state_update_time")
        external fun setVaultNextStateUpdateTime(location: Location, time: Double)

        @Action("game_set_dried_ghast_hydration")
        external fun setDriedGhastHydration(location: Location, hydration: Double)

        @Action("game_set_creaking_heart_state")
        external fun setCreakingHeartState(
            location: Location,
            heartState: CreakingHeartState = CreakingHeartState.AWAKE
        )

        @Action("game_set_creaking_heart_natural")
        external fun setCreakingHeartNatural(location: Location, natural: Boolean = true)

        @Action("game_set_copper_golem_statue_pose")
        external fun setCopperGolemPose(
            location: Location,
            pose: CopperGolemPose = CopperGolemPose.STANDING
        )

        @Action("game_set_potent_sulfur_state")
        external fun setPotentSulfurState(
            location: Location,
            state: PotentSulfurState = PotentSulfurState.DRY
        )

        @Action("game_set_block_nbt")
        external fun setBlockNbt(location: Location, tagNames: List<Text>, tagValues: List<Text>)

        @Action("game_set_tile_block_custom_tag")
        external fun setTileBlockCustomTag(location: Location, tagName: Text, tagValue: Text)

        @Action("game_remove_tile_block_custom_tag")
        external fun removeTileBlockCustomTag(location: Location, tagName: Text)

        @Action("game_remove_tile_block_custom_tags")
        external fun removeTileBlockCustomTags(location: Location)

        // --- Block Conditions ---

        @Action("if_game_block_equals")
        external fun blockEquals(location: Location, vararg blocks: Item): Boolean

        @Action("if_game_block_powered")
        external fun isPowered(
            powerMode: BlockPowerMode = BlockPowerMode.DIRECT,
            vararg locations: Location
        ): Boolean

        @Action("if_game_location_in_block")
        external fun isLocationInBlock(location: Location): Boolean

        @Action("if_game_container_has")
        external fun containerHas(
            location: Location,
            vararg items: Item,
            checkMode: CheckMode = CheckMode.ALL,
            comparisonMode: ComparisonMode = ComparisonMode.EXACTLY
        ): Boolean

        inline fun containerHas(
            location: Location,
            item: Item,
            checkMode: CheckMode = CheckMode.ALL,
            comparisonMode: ComparisonMode = ComparisonMode.EXACTLY
        ): Boolean = containerHas(location, *arrayOf(item), checkMode = checkMode, comparisonMode = comparisonMode)

        @Action("if_game_container_has_room_for_item")
        external fun containerHasRoomFor(
            location: Location,
            vararg items: Item,
            checkMode: CheckMode = CheckMode.ALL
        ): Boolean

        inline fun containerHasRoomFor(
            location: Location,
            item: Item,
            checkMode: CheckMode = CheckMode.ALL
        ): Boolean = containerHasRoomFor(location, *arrayOf(item), checkMode = checkMode)

        @Action("if_game_sign_contains")
        external fun signContains(
            location: Location,
            vararg texts: Text,
            checkSide: SignCheckSide = SignCheckSide.ANY,
            checkMode: TextCheckMode = TextCheckMode.CONTAINS,
            lines: SignLines = SignLines.ANY
        ): Boolean

        inline fun signContains(
            text: Text,
            location: Location,
            checkSide: SignCheckSide = SignCheckSide.ANY,
            checkMode: TextCheckMode = TextCheckMode.CONTAINS,
            lines: SignLines = SignLines.ANY
        ): Boolean = signContains(location, *arrayOf(text), checkSide = checkSide, checkMode = checkMode, lines = lines)

        @Action("if_game_tile_block_has_custom_tag")
        external fun hasTileBlockCustomTag(
            location: Location,
            tag: Text,
            tagValue: Any? = null,
            compareType: CompareType = CompareType.EQUALS
        ): Boolean
    }
}

/**
 * Свойство для обращения к блоку на данном местоположении.
 */
val Location.block: Block inline get() = Block(this)
