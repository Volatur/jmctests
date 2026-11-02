package justmc.value

import justmc.annotation.*
import kotlin.jvm.JvmName

enum class ItemCompareMode {
    EXACTLY,
    TYPE_ONLY,
    IGNORE_STACK_SIZE,
    IGNORE_DURABILITY_AND_STACK_SIZE
}

enum class EnchantmentType {
    NORMAL,
    STORED,
    BOTH
}

enum class TagCompareMode {
    EQUALS,
    CONTAINS,
    STARTS_WITH,
    ENDS_WITH
}

enum class DurabilityType {
    DAMAGE,
    DAMAGE_PERCENTAGE,
    REMAINING,
    REMAINING_PERCENTAGE,
    MAXIMUM,
    MAX_DAMAGE
}

enum class LoreMode {
    MERGE,
    APPEND
}

enum class ContainerSettingMode {
    ADD,
    SET,
    REMOVE
}

enum class ItemRarity {
    NONE,
    COMMON,
    UNCOMMON,
    RARE,
    EPIC
}

enum class GlowingMode {
    TRUE,
    FALSE,
    NOT_SET
}

enum class AttributeSlot {
    ALL,
    MAIN_HAND,
    OFF_HAND,
    HEAD,
    CHEST,
    LEGGINGS,
    BOOTS,
    HAND,
    ARMOR,
    BODY
}

enum class AttributeOperation {
    ADD_NUMBER,
    ADD_SCALAR,
    MULTIPLY_SCALAR_1
}

enum class ItemAttribute {
    GENERIC_MAX_HEALTH,
    GENERIC_FOLLOW_RANGE,
    GENERIC_KNOCKBACK_RESISTANCE,
    GENERIC_MOVEMENT_SPEED,
    GENERIC_FLYING_SPEED,
    GENERIC_ATTACK_DAMAGE,
    GENERIC_ATTACK_KNOCKBACK,
    GENERIC_ATTACK_SPEED,
    GENERIC_ARMOR,
    GENERIC_ARMOR_TOUGHNESS,
    GENERIC_LUCK,
    HORSE_JUMP_STRENGTH,
    ZOMBIE_SPAWN_REINFORCEMENTS,
    MAX_HEALTH,
    MAX_ABSORPTION,
    FOLLOW_RANGE,
    KNOCKBACK_RESISTANCE,
    MOVEMENT_SPEED,
    FLYING_SPEED,
    ATTACK_DAMAGE,
    ATTACK_KNOCKBACK,
    ATTACK_SPEED,
    ARMOR,
    ARMOR_TOUGHNESS,
    LUCK,
    GENERIC_JUMP_STRENGTH,
    GENERIC_FALL_DAMAGE_MULTIPLIER,
    GENERIC_SAFE_FALL_DISTANCE,
    GENERIC_SCALE,
    GENERIC_STEP_HEIGHT,
    GENERIC_GRAVITY,
    PLAYER_BLOCK_INTERACTION_RANGE,
    PLAYER_ENTITY_INTERACTION_RANGE,
    PLAYER_BLOCK_BREAK_SPEED,
    GENERIC_BURNING_TIME,
    GENERIC_EXPLOSION_KNOCKBACK_RESISTANCE,
    GENERIC_MOVEMENT_EFFICIENCY,
    PLAYER_MINING_EFFICIENCY,
    PLAYER_SNEAKING_SPEED,
    PLAYER_SUBMERGED_MINING_SPEED,
    PLAYER_SWEEPING_DAMAGE_RATIO,
    GENERIC_OXYGEN_BONUS,
    GENERIC_WATER_MOVEMENT_EFFICIENCY,
    GENERIC_MAX_ABSORPTION,
    TEMP_RANGE,
    WAYPOINT_TRANSMIT_RANGE,
    WAYPOINT_RECEIVE_RANGE,
    CAMERA_DISTANCE,
    BOUNCINESS,
    FRICTION_MODIFIER,
    AIR_DRAG_MODIFIER,
    NAME_TAG_DISTANCE,
    BELOW_NAME_DISTANCE
}

enum class VisibilityFlag {
    ON,
    NO_CHANGE,
    OFF
}

enum class CustomModelDataValueType {
    FLOATS,
    BOOLEANS,
    STRINGS,
    COLORS
}

enum class CustomModelDataSetupMode {
    SET,
    ADD,
    REMOVE_ALL,
    REMOVE_FIRST,
    REMOVE_LAST
}

enum class AttackRangeProperty {
    MIN_RANGE,
    MAX_RANGE,
    MIN_CREATIVE_RANGE,
    MAX_CREATIVE_RANGE,
    HITBOX_MARGIN,
    MOB_FACTORY
}

enum class SwingAnimation {
    NONE,
    WHACK,
    STAB
}

enum class SwingAnimationProperty {
    DURATION,
    ANIMATION
}

enum class FoodProperty {
    NUTRITION,
    SATURATION
}

enum class WeaponProperty {
    ITEM_DAMAGE_PER_ATTACK,
    DISABLE_BLOCKING
}

enum class PlayerHeadReturn {
    NAME,
    UUID,
    VALUE
}

enum class ItemResultType {
    ID,
    TRANSLATION_KEY,
    ITEM
}

enum class TemplateReturn {
    TEXT,
    MAP
}

enum class BlockMaterialProperty {
    HARDNESS,
    BLAST_RESISTANCE,
    SLIPPERINESS
}

enum class BlockSoundSource {
    BREAK,
    PLACE,
    HIT,
    FALL,
    STEP
}

enum class ItemNbtFetchMode {
    ALL,
    CUSTOM_DATA
}

enum class ComponentHideMode {
    SET,
    ADD,
    REMOVE
}

enum class ParticleVisibility {
    REGULAR,
    AMBIENT,
    NONE
}

enum class ItemTypeFormat {
    ID,
    NAME,
    ITEM
}

@BuiltInValue("item")
class Item(
    var id: String,
    var count: Int = 1,
    var name: String? = null,
    var lore: List<String>? = null,
    var tags: Map<String, String>? = null,
    val unbreakable: Boolean = false,
    val glowing: Boolean = false,
    val components: Map<String, Any> = emptyMap()
) {
    companion object {
        /**
         * Получить максимальный размер стака предмета (set_variable_get_item_max_stack_size).
         */
        @Action("set_variable_get_item_max_stack_size", returns = ["variable"], thisArg = ["item"])
        external fun maxStack(item: Item): Double

        /**
         * Получить список предметов по Minecraft-тегу (set_variable_get_items_by_tag).
         */
        @Action("set_variable_get_items_by_tag", returns = ["variable"])
        external fun byTag(namespace: String, resultType: ItemResultType = ItemResultType.ITEM): List<Item>

        /**
         * Получить предмет из подозрительного блока (set_variable_get_brushable_block_item).
         */
        @Action("set_variable_get_brushable_block_item", returns = ["variable"])
        external fun brushableBlockItem(location: Location): Item

        /**
         * Получить отображаемый предмет сокровищницы (set_variable_get_vault_displayed_item).
         */
        @Action("set_variable_get_vault_displayed_item", returns = ["variable"])
        external fun vaultDisplayedItem(location: Location): Item

    }
}

// ============================================================================
// Свойства и геттеры для Item
// ============================================================================

/** Получить количество предметов в стаке (set_variable_get_item_amount). */
@Action("set_variable_get_item_amount", returns = ["variable"], thisArg = ["item"])
external fun Item.getAmount(): Double

@get:JvmName("getItemAmountProp")
val Item.amount: Double inline get() = getAmount()

@get:JvmName("getItemCountProp")
val Item.stackSize: Double inline get() = getAmount()

/** Получить максимальный размер стака предмета (set_variable_get_item_max_stack_size). */
@Action("set_variable_get_item_max_stack_size", returns = ["variable"], thisArg = ["item"])
external fun Item.getMaxStackSize(): Double

@get:JvmName("getItemMaxStackSizeProp")
val Item.maxStackSize: Double inline get() = getMaxStackSize()

@get:JvmName("getItemMaxStackProp")
val Item.maxStack: Double inline get() = getMaxStackSize()

/** Получить имя предмета (set_variable_get_item_name). */
@Action("set_variable_get_item_name", returns = ["variable"], thisArg = ["item"])
external fun Item.getName(): Text

@get:JvmName("getItemCustomNameProp")
val Item.customName: Text inline get() = getName()

/** Получить эффективное отображаемое имя в инвентаре (set_variable_get_item_effective_name). */
@Action("set_variable_get_item_effective_name", returns = ["variable"], thisArg = ["item"])
external fun Item.getEffectiveName(): Text

@get:JvmName("getItemEffectiveNameProp")
val Item.effectiveName: Text inline get() = getEffectiveName()

/** Получить тип предмета в виде текста или ID (set_variable_get_item_type). */
@Action("set_variable_get_item_type", returns = ["variable"], thisArg = ["type"])
external fun Item.getType(value: ItemTypeFormat = ItemTypeFormat.ID): Text

@get:JvmName("getItemMaterialIdProp")
val Item.materialId: Text inline get() = getType(ItemTypeFormat.ID)

@get:JvmName("getItemMaterialNameProp")
val Item.materialName: Text inline get() = getType(ItemTypeFormat.NAME)

/** Получить всё описание предмета (set_variable_get_item_lore). */
@Action("set_variable_get_item_lore", returns = ["variable"], thisArg = ["item"])
external fun Item.getLore(): List<Text>

@get:JvmName("getItemLoreProp")
val Item.itemLore: List<Text> inline get() = getLore()

/** Получить конкретную строку описания предмета (set_variable_get_item_lore_line). */
@Action("set_variable_get_item_lore_line", returns = ["variable"], thisArg = ["item"])
external fun Item.getLoreLine(line: Double): Text

/** Получить прочность предмета (set_variable_get_item_durability). */
@Action("set_variable_get_item_durability", returns = ["variable"], thisArg = ["item"])
external fun Item.getDurability(durabilityType: DurabilityType = DurabilityType.REMAINING): Double

@get:JvmName("getItemDurabilityProp")
val Item.durability: Double inline get() = getDurability(DurabilityType.REMAINING)

@get:JvmName("getItemMaxDurabilityProp")
val Item.maxDurability: Double inline get() = getDurability(DurabilityType.MAXIMUM)

@get:JvmName("getItemDamageProp")
val Item.damage: Double inline get() = getDurability(DurabilityType.DAMAGE)

/** Получить редкость предмета (set_variable_get_item_rarity). */
@Action("set_variable_get_item_rarity", returns = ["variable"], thisArg = ["item"])
external fun Item.getRarity(): Text

@get:JvmName("getItemRarityProp")
val Item.rarity: Text inline get() = getRarity()

/** Получить цвет предмета (set_variable_get_item_color). */
@Action("set_variable_get_item_color", returns = ["variable"], thisArg = ["item"])
external fun Item.getColor(): Text

@get:JvmName("getItemColorProp")
val Item.color: Text inline get() = getColor()

/** Получить CustomModelData предмета (set_variable_get_item_custom_model_data). */
@Action("set_variable_get_item_custom_model_data", returns = ["variable"], thisArg = ["item"])
external fun Item.getCustomModelData(): Double

@get:JvmName("getItemCustomModelDataProp")
val Item.customModelData: Double inline get() = getCustomModelData()

/** Получить модель предмета (set_variable_get_item_model_data). */
@Action("set_variable_get_item_model_data", returns = ["variable"], thisArg = ["item"])
external fun Item.getModel(): Text

@get:JvmName("getItemModelProp")
val Item.model: Text inline get() = getModel()

/** Получить стиль всплывающей подсказки (set_variable_get_item_tooltip_style). */
@Action("set_variable_get_item_tooltip_style", returns = ["variable"], thisArg = ["item"])
external fun Item.getTooltipStyle(): Text

@get:JvmName("getItemTooltipStyleProp")
val Item.tooltipStyle: Text inline get() = getTooltipStyle()

/** Получить звук ломания предмета (set_variable_get_item_break_sound). */
@Action("set_variable_get_item_break_sound", returns = ["variable"], thisArg = ["item"])
external fun Item.getBreakSound(): Sound

@get:JvmName("getItemBreakSoundProp")
val Item.breakSound: Sound inline get() = getBreakSound()

/** Получить спрайт предмета (set_variable_get_item_sprite). */
@Action("set_variable_get_item_sprite", returns = ["variable"], thisArg = ["item"])
external fun Item.getSprite(): Text

@get:JvmName("getItemSpriteProp")
val Item.sprite: Text inline get() = getSprite()

/** Получить остаток/превращение после использования (set_variable_get_item_use_remainder). */
@Action("set_variable_get_item_use_remainder", returns = ["variable"], thisArg = ["item"])
external fun Item.getUseRemainder(): Double

@get:JvmName("getItemUseRemainderProp")
val Item.useRemainder: Double inline get() = getUseRemainder()

/** Получить минимальный заряд атаки (set_variable_get_item_minimum_attack_charge). */
@Action("set_variable_get_item_minimum_attack_charge", returns = ["variable"], thisArg = ["item"])
external fun Item.getMinimumAttackCharge(): Double

@get:JvmName("getItemMinimumAttackChargeProp")
val Item.minimumAttackCharge: Double inline get() = getMinimumAttackCharge()

/** Получить содержимое предмета (set_variable_get_item_contents). */
@Action("set_variable_get_item_contents", returns = ["variable"], thisArg = ["item"])
external fun Item.getContents(): List<Item>

@get:JvmName("getItemContentsProp")
val Item.contents: List<Item> inline get() = getContents()

/** Получить содержимое мешка (set_variable_get_bundle_items). */
@Action("set_variable_get_bundle_items", returns = ["variable"], thisArg = ["bundle"])
external fun Item.getBundleItems(): List<Item>

@get:JvmName("getItemBundleItemsProp")
val Item.bundleItems: List<Item> inline get() = getBundleItems()

/** Получить эффекты зелий предмета (set_variable_get_item_potion_effects). */
@Action("set_variable_get_item_potion_effects", returns = ["variable"], thisArg = ["item"])
external fun Item.getPotionEffects(): List<Potion>

@get:JvmName("getItemPotionEffectsProp")
val Item.potionEffects: List<Potion> inline get() = getPotionEffects()

/** Получить хранимые зачарования книги (set_variable_get_item_stored_enchantments). */
@Action("set_variable_get_item_stored_enchantments", returns = ["variable"], thisArg = ["item"])
external fun Item.getStoredEnchantments(): Map<String, Double>

@get:JvmName("getItemStoredEnchantmentsProp")
val Item.storedEnchantments: Map<String, Double> inline get() = getStoredEnchantments()

/** Получить зачарования предмета (set_variable_get_item_enchantments). */
@Action("set_variable_get_item_enchantments", returns = ["variable"], thisArg = ["item"])
external fun Item.getEnchantments(enchantmentType: EnchantmentType = EnchantmentType.NORMAL): Map<String, Double>

@get:JvmName("getItemEnchantmentsProp")
val Item.enchantments: Map<String, Double> inline get() = getEnchantments(EnchantmentType.NORMAL)

/** Получить уровень конкретного зачарования (set_variable_get_item_enchantment). */
@Action("set_variable_get_item_enchantment", returns = ["variable"], thisArg = ["item"])
external fun Item.getEnchantmentLevel(
    enchantment: String,
    enchantmentType: EnchantmentType = EnchantmentType.BOTH
): Double

/** Получить значение кастомного тега (set_variable_get_item_custom_tag). */
@Action("set_variable_get_item_custom_tag", returns = ["variable"], thisArg = ["item"])
external fun Item.getCustomTag(
    tagName: String,
    defaultValue: String = ""
): String

/** Получить все кастомные теги предмета (set_variable_get_item_custom_tags). */
@Action("set_variable_get_item_custom_tags", returns = ["variable"], thisArg = ["item"])
external fun Item.getCustomTags(): Map<String, String>

@get:JvmName("getItemCustomTagsProp")
val Item.customTags: Map<String, String> inline get() = getCustomTags()

/** Получить NBT/компонентные данные предмета (set_variable_get_item_nbt_tags). */
@Action("set_variable_get_item_nbt_tags", returns = ["variable"], thisArg = ["item"])
external fun Item.getNbtTags(fetchMode: ItemNbtFetchMode = ItemNbtFetchMode.ALL): Map<String, Any>

/** Получить значение компонента предмета (set_variable_get_item_component). */
@Action("set_variable_get_item_component", returns = ["variable"], thisArg = ["item"])
external fun Item.getComponent(component: Text): Text

/** Получить блоки, которые предмет может ломать (set_variable_get_item_destroyable_blocks). */
@Action("set_variable_get_item_destroyable_blocks", returns = ["variable"], thisArg = ["item"])
external fun Item.getDestroyableBlocks(): List<Item>

@get:JvmName("getItemDestroyableBlocksProp")
val Item.destroyableBlocks: List<Item> inline get() = getDestroyableBlocks()

/** Получить блоки, на которые предмет можно устанавливать (set_variable_get_item_placeable_blocks). */
@Action("set_variable_get_item_placeable_blocks", returns = ["variable"], thisArg = ["item"])
external fun Item.getPlaceableBlocks(): List<Item>

@get:JvmName("getItemPlaceableBlocksProp")
val Item.placeableBlocks: List<Item> inline get() = getPlaceableBlocks()

/** Получить значение атрибута предмета (set_variable_get_item_attribute). */
@Action("set_variable_get_item_attribute", returns = ["variable"], thisArg = ["item"])
external fun Item.getAttribute(
    name: Text,
    attribute: ItemAttribute,
    slot: AttributeSlot = AttributeSlot.ALL,
    operation: AttributeOperation = AttributeOperation.ADD_NUMBER
): Double

/** Получить свойство блока предмета (set_variable_get_block_material_property). */
@Action("set_variable_get_block_material_property", returns = ["variable"], thisArg = ["block"])
external fun Item.getBlockMaterialProperty(property: BlockMaterialProperty): Double

@get:JvmName("getBlockHardnessProp")
val Item.hardness: Double inline get() = getBlockMaterialProperty(BlockMaterialProperty.HARDNESS)

@get:JvmName("getBlockBlastResistanceProp")
val Item.blastResistance: Double inline get() = getBlockMaterialProperty(BlockMaterialProperty.BLAST_RESISTANCE)

@get:JvmName("getBlockSlipperinessProp")
val Item.slipperiness: Double inline get() = getBlockMaterialProperty(BlockMaterialProperty.SLIPPERINESS)

/** Получить звук блока предмета (set_variable_get_block_sound). */
@Action("set_variable_get_block_sound", returns = ["variable"], thisArg = ["block"])
external fun Item.getBlockSound(source: BlockSoundSource): Sound

/** Получить текст страницы книги (set_variable_get_book_text). */
@Action("set_variable_get_book_text", returns = ["variable"], thisArg = ["book"])
external fun Item.getBookText(page: Double): Text

/** Получить владельца головы игрока (set_variable_get_player_head_owner). */
@Action("set_variable_get_player_head_owner", returns = ["variable"], thisArg = ["head"])
external fun Item.getHeadOwner(returnValue: PlayerHeadReturn): Text

@get:JvmName("getHeadOwnerNameProp")
val Item.headOwnerName: Text inline get() = getHeadOwner(PlayerHeadReturn.NAME)

@get:JvmName("getHeadOwnerUuidProp")
val Item.headOwnerUuid: Text inline get() = getHeadOwner(PlayerHeadReturn.UUID)

@get:JvmName("getHeadSkinValueProp")
val Item.headSkinValue: Text inline get() = getHeadOwner(PlayerHeadReturn.VALUE)

/** Получить данные компонента еды предмета (set_variable_get_item_food_properties). */
@Action("set_variable_get_item_food_properties", returns = ["variable"], thisArg = ["item"])
external fun Item.getFoodProperty(property: FoodProperty): Double

@get:JvmName("getFoodNutritionProp")
val Item.foodNutrition: Double inline get() = getFoodProperty(FoodProperty.NUTRITION)

@get:JvmName("getFoodSaturationProp")
val Item.foodSaturation: Double inline get() = getFoodProperty(FoodProperty.SATURATION)

/** Получить значение компонента оружия (set_variable_get_item_weapon). */
@Action("set_variable_get_item_weapon", returns = ["variable"], thisArg = ["item"])
external fun Item.getWeaponProperty(property: WeaponProperty): Double

@get:JvmName("getWeaponDamageProp")
val Item.itemDamagePerAttack: Double inline get() = getWeaponProperty(WeaponProperty.ITEM_DAMAGE_PER_ATTACK)

@get:JvmName("getWeaponDisableBlockingProp")
val Item.disableBlocking: Double inline get() = getWeaponProperty(WeaponProperty.DISABLE_BLOCKING)

/** Получить радиус атаки (set_variable_get_item_attack_range). */
@Action("set_variable_get_item_attack_range", returns = ["variable"], thisArg = ["item"])
external fun Item.getAttackRange(property: AttackRangeProperty): Double

/** Получить данные анимации замаха (set_variable_get_item_swing_animation). */
@Action("set_variable_get_item_swing_animation", returns = ["variable"], thisArg = ["item"])
external fun Item.getSwingAnimation(property: SwingAnimationProperty): Any

/** Получить список CustomModelData 1.21+ (set_variable_obtain_item_custom_model_data). */
@Action("set_variable_obtain_item_custom_model_data", returns = ["variable"], thisArg = ["item"])
external fun Item.obtainCustomModelData(valueType: CustomModelDataValueType): List<Any>

/** Получить местоположение магнетита компаса (set_variable_get_compass_lodestone). */
@Action("set_variable_get_compass_lodestone", returns = ["variable"], thisArg = ["item"])
external fun Item.getLodestoneLocation(): Location

@get:JvmName("getCompassLodestoneProp")
val Item.lodestoneLocation: Location inline get() = getLodestoneLocation()

// ============================================================================
// Условия (Conditions / if_variable_*)
// ============================================================================

/** Проверить равенство предметов (if_variable_item_equals). */
@Action("if_variable_item_equals", thisArg = ["value"])
external fun Item.isEqualTo(
    compare: Item,
    comparisonMode: ItemCompareMode = ItemCompareMode.EXACTLY
): Boolean

/** Проверить наличие тега на предмете (if_variable_item_has_tag). */
@Action("if_variable_item_has_tag", thisArg = ["item"])
external fun Item.hasTag(
    tag: Text,
    value: Text = "",
    compareType: TagCompareMode = TagCompareMode.EQUALS
): Boolean

/** Проверить наличие зачарования на предмете (if_variable_item_has_enchantment). */
@Action("if_variable_item_has_enchantment", thisArg = ["item"])
external fun Item.hasEnchantment(
    enchant: Text,
    level: Double = 0.0,
    enchantmentType: EnchantmentType = EnchantmentType.BOTH
): Boolean

/** Проверить наличие хранимого зачарования на предмете (if_variable_item_has_stored_enchantment). */
@Action("if_variable_item_has_stored_enchantment", thisArg = ["item"])
external fun Item.hasStoredEnchantment(
    enchant: Text,
    level: Double = 0.0
): Boolean

/** Проверить, является ли предмет блоком (if_variable_item_is_block). */
@Action("if_variable_item_is_block", thisArg = ["item"])
external fun Item.isBlock(): Boolean

@get:JvmName("getItemIsBlockProp")
val Item.isBlock: Boolean inline get() = isBlock()

/** Проверить, является ли блок полным (if_variable_block_is_solid). */
@Action("if_variable_block_is_solid", thisArg = ["item"])
external fun Item.isBlockSolid(): Boolean

@get:JvmName("getBlockIsSolidProp")
val Item.isSolidBlock: Boolean inline get() = isBlockSolid()

/** Проверить, имеет ли предмет Minecraft-тег (if_variable_item_is_minecraft_tagged). */
@Action("if_variable_item_is_minecraft_tagged", thisArg = ["item"])
external fun Item.hasMinecraftTag(namespace: Text): Boolean

/** Проверить, имеет ли блок Minecraft-тег (if_variable_block_is_minecraft_tagged). */
@Action("if_variable_block_is_minecraft_tagged", thisArg = ["item"])
external fun Item.isBlockMinecraftTagged(namespace: Text): Boolean

// ============================================================================
// Операторы и утилиты
// ============================================================================

/** Оператор умножения предмета на число: создает стак с указанным количеством. */
inline operator fun Item.times(amount: Double): Item = withAmount(amount)

inline operator fun Item.times(count: Int): Item = withAmount(count.toDouble())

/** Оператор индексатора для чтения кастомного тега: item["tag_name"]. */
inline operator fun Item.get(tagName: String): String = getCustomTag(tagName)

inline operator fun Item.set(tagName: String, tagValue: Any) = setCustomTag(tagName, tagValue)

/** Оператор проверки зачарования: if ("sharpness" in item). */
inline operator fun Item.contains(tagName: String): Boolean = hasTag(tagName)

// --- Builder / Setter методы ---

inline fun Item.setName(name: Text): Item = withName(name)
inline fun Item.setLore(vararg lore: Text): Item = withLore(*lore)
inline fun Item.setLore(lore: List<Text>): Item = withLore(lore)
inline fun Item.setAmount(amount: Double): Item = withAmount(amount)
inline fun Item.setAmount(count: Int): Item = withAmount(count.toDouble())
inline fun Item.setMaxStack(size: Double): Item = withMaxStackSize(size)
inline fun Item.setMaxStack(size: Int): Item = withMaxStackSize(size.toDouble())
inline fun Item.setMaxStackSize(size: Double): Item = withMaxStackSize(size)
inline fun Item.setMaxStackSize(size: Int): Item = withMaxStackSize(size.toDouble())
inline fun Item.setDurability(durability: Double, durabilityType: DurabilityType = DurabilityType.REMAINING): Item =
    withDurability(durability, durabilityType)
inline fun Item.setUnbreakable(unbreakable: Boolean = true): Item = withUnbreakable(unbreakable)
inline fun Item.setColor(color: Text): Item = withColor(color)
inline fun Item.setRarity(rarity: ItemRarity): Item = withRarity(rarity)
inline fun Item.setCustomModelData(model: Double): Item = withCustomModelData(model)
inline fun Item.setCustomModelData(model: Int): Item = withCustomModelData(model.toDouble())
inline fun Item.setCustomTag(tagName: Text, tagValue: Any): Item = withCustomTag(tagName, tagValue)

// ============================================================================
// Модификаторы и Builder API (with... / without...)
// ============================================================================

/** Установить количество предметов (set_variable_set_item_amount). */
@Action("set_variable_set_item_amount", returns = ["variable"], thisArg = ["item"])
external fun Item.withAmount(amount: Double): Item

inline fun Item.withAmount(count: Int): Item = withAmount(count.toDouble())

/** Установить максимальный размер стака предмета (set_variable_set_item_max_stack_size). */
@Action("set_variable_set_item_max_stack_size", returns = ["variable"], thisArg = ["item"])
external fun Item.withMaxStackSize(size: Double): Item

inline fun Item.withMaxStackSize(size: Int): Item = withMaxStackSize(size.toDouble())

/** Установить имя предмета (set_variable_set_item_name). */
@Action("set_variable_set_item_name", returns = ["variable"], thisArg = ["item"])
external fun Item.withName(text: Text): Item

/** Установить описание предмета (set_variable_set_item_lore). */
@Action("set_variable_set_item_lore", returns = ["variable"], thisArg = ["item"])
external fun Item.withLore(vararg lore: Text): Item

@Action("set_variable_set_item_lore", returns = ["variable"], thisArg = ["item"])
external fun Item.withLore(lore: List<Text>): Item

/** Установить строку описания предмета (set_variable_set_item_lore_line). */
@Action("set_variable_set_item_lore_line", returns = ["variable"], thisArg = ["item"])
external fun Item.withLoreLine(
    text: Text,
    line: Double,
    mode: LoreMode = LoreMode.MERGE
): Item

/** Удалить строку описания предмета (set_variable_remove_item_lore_line). */
@Action("set_variable_remove_item_lore_line", returns = ["variable"], thisArg = ["item"])
external fun Item.withoutLoreLine(line: Double): Item

/** Установить тип предмета (set_variable_set_item_type). */
@Action("set_variable_set_item_type", returns = ["variable"], thisArg = ["item"])
external fun Item.withType(type: Item): Item

/** Установить прочность предмета (set_variable_set_item_durability). */
@Action("set_variable_set_item_durability", returns = ["variable"], thisArg = ["item"])
external fun Item.withDurability(
    durability: Double,
    durabilityType: DurabilityType = DurabilityType.REMAINING
): Item

/** Установить неломаемость предмета (set_variable_set_item_unbreakable). */
@Action("set_variable_set_item_unbreakable", returns = ["variable"], thisArg = ["item"])
external fun Item.withUnbreakable(unbreakable: Boolean = true): Item

/** Добавить зачарование предмету (set_variable_add_item_enchantment). */
@Action("set_variable_add_item_enchantment", returns = ["variable"], thisArg = ["item"])
external fun Item.withEnchantment(
    enchantment: Text,
    level: Double = 1.0,
    enchantmentType: EnchantmentType = EnchantmentType.NORMAL
): Item

/** Удалить зачарование предмета (set_variable_remove_enchantment). */
@Action("set_variable_remove_enchantment", returns = ["variable"], thisArg = ["item"])
external fun Item.withoutEnchantment(
    enchantment: Text,
    enchantmentType: EnchantmentType = EnchantmentType.NORMAL
): Item

/** Установить карту зачарований предмету (set_variable_set_item_enchantments). */
@Action("set_variable_set_item_enchantments", returns = ["variable"], thisArg = ["item"])
external fun Item.withEnchantments(
    enchantments: Map<String, Double>,
    enchantmentType: EnchantmentType = EnchantmentType.NORMAL
): Item

/** Добавить хранимое зачарование предмету (set_variable_add_item_stored_enchantment). */
@Action("set_variable_add_item_stored_enchantment", returns = ["variable"], thisArg = ["item"])
external fun Item.withStoredEnchantment(enchantment: Text, level: Double = 1.0): Item

/** Удалить хранимое зачарование предмета (set_variable_remove_item_stored_enchantment). */
@Action("set_variable_remove_item_stored_enchantment", returns = ["variable"], thisArg = ["item"])
external fun Item.withoutStoredEnchantment(enchantment: Text): Item

/** Добавить эффекты зелий предмету (set_variable_add_item_potion_effects). */
@Action("set_variable_add_item_potion_effects", returns = ["variable"], thisArg = ["item"])
external fun Item.withPotionEffects(
    vararg potions: Potion,
    overwrite: Boolean = false,
    showIcon: Boolean = true,
    particleMode: ParticleVisibility = ParticleVisibility.REGULAR
): Item

/** Удалить эффекты зелий из предмета (set_variable_remove_item_potion_effects). */
@Action("set_variable_remove_item_potion_effects", returns = ["variable"], thisArg = ["item"])
external fun Item.withoutPotionEffects(vararg effects: Potion): Item

/** Установить цвет предмета (set_variable_set_item_color). */
@Action("set_variable_set_item_color", returns = ["variable"], thisArg = ["item"])
external fun Item.withColor(color: Text): Item

/** Переопределить свечение предмета (set_variable_set_item_glint_override). */
@Action("set_variable_set_item_glint_override", returns = ["variable"], thisArg = ["item"])
external fun Item.withGlint(glowing: GlowingMode = GlowingMode.TRUE): Item

inline fun Item.withGlint(enabled: Boolean): Item =
    withGlint(if (enabled) GlowingMode.TRUE else GlowingMode.FALSE)

/** Установить редкость предмета (set_variable_set_item_rarity). */
@Action("set_variable_set_item_rarity", returns = ["variable"], thisArg = ["item"])
external fun Item.withRarity(rarity: ItemRarity): Item

/** Установить данные модели предмета (set_variable_set_item_custom_model_data). */
@Action("set_variable_set_item_custom_model_data", returns = ["variable"], thisArg = ["item"])
external fun Item.withCustomModelData(model: Double): Item

inline fun Item.withCustomModelData(model: Int): Item = withCustomModelData(model.toDouble())

/** Удалить данные модели предмета (set_variable_remove_item_custom_model_data). */
@Action("set_variable_remove_item_custom_model_data", returns = ["variable"], thisArg = ["item"])
external fun Item.withoutCustomModelData(): Item

/** Установить модель предмета 1.21.4 (set_variable_set_item_model_data). */
@Action("set_variable_set_item_model_data", returns = ["variable"], thisArg = ["item"])
external fun Item.withModel(model: Text): Item

/** Установить стиль всплывающей подсказки (set_variable_set_item_tooltip_style). */
@Action("set_variable_set_item_tooltip_style", returns = ["variable"], thisArg = ["item"])
external fun Item.withTooltipStyle(style: Text): Item

/** Скрыть всплывающую подсказку (set_variable_set_item_hidden_tooltip). */
@Action("set_variable_set_item_hidden_tooltip", returns = ["variable"], thisArg = ["item"])
external fun Item.withHiddenTooltip(@Slot("tooltip_hidden") hidden: Boolean = true): Item

/** Установить звук ломания предмета (set_variable_set_item_break_sound). */
@Action("set_variable_set_item_break_sound", returns = ["variable"], thisArg = ["item"])
external fun Item.withBreakSound(breakSound: Sound): Item

/** Установить кастомный тег предмету (set_variable_set_item_custom_tag). */
@Action("set_variable_set_item_custom_tag", returns = ["variable"], thisArg = ["item"])
external fun Item.withCustomTag(tagName: Text, tagValue: Any): Item

/** Удалить кастомный тег предмета (set_variable_remove_item_custom_tag). */
@Action("set_variable_remove_item_custom_tag", returns = ["variable"], thisArg = ["item"])
external fun Item.withoutCustomTag(tagName: Text): Item

/** Удалить все кастомные теги предмета (set_variable_remove_item_custom_tags). */
@Action("set_variable_remove_item_custom_tags", returns = ["variable"], thisArg = ["item"])
external fun Item.withoutCustomTags(): Item

/** Установить предмету компонент (set_variable_set_item_component). */
@Action("set_variable_set_item_component", returns = ["variable"], thisArg = ["item"])
external fun Item.withComponent(component: Text, value: Text): Item

/** Удалить компоненты предмета (set_variable_unset_item_components). */
@Action("set_variable_unset_item_components", returns = ["variable"], thisArg = ["item"])
external fun Item.withoutComponents(vararg components: Text): Item

/** Скрыть компоненты предмета (set_variable_hide_item_components). */
@Action("set_variable_hide_item_components", returns = ["variable"], thisArg = ["item"])
external fun Item.withHiddenComponents(
    vararg components: Text,
    mode: ComponentHideMode = ComponentHideMode.SET
): Item

/** Добавить атрибут предмету (set_variable_set_item_attribute). */
@Action("set_variable_set_item_attribute", returns = ["variable"], thisArg = ["item"])
external fun Item.withAttribute(
    name: Text,
    attribute: ItemAttribute,
    amount: Double,
    slot: AttributeSlot = AttributeSlot.ALL,
    operation: AttributeOperation = AttributeOperation.ADD_NUMBER
): Item

/** Удалить атрибут у предмета (set_variable_remove_item_attribute). */
@Action("set_variable_remove_item_attribute", returns = ["variable"], thisArg = ["item"])
external fun Item.withoutAttribute(
    nameOrUuid: Text = "",
    attribute: ItemAttribute = ItemAttribute.GENERIC_ATTACK_DAMAGE
): Item

/** Установить броне шаблон (set_variable_set_armor_trim). */
@Action("set_variable_set_armor_trim", returns = ["variable"], thisArg = ["armor"])
external fun Item.withArmorTrim(material: Item, pattern: Item): Item

/** Установить данные компонента еды (set_variable_set_item_food_properties). */
@Action("set_variable_set_item_food_properties", returns = ["variable"], thisArg = ["item"])
external fun Item.withFoodProperties(
    nutrition: Double,
    saturation: Double,
    canAlwaysEat: Boolean = false
): Item

/** Установить данные компонента оружия (set_variable_set_item_weapon). */
@Action("set_variable_set_item_weapon", returns = ["variable"], thisArg = ["item"])
external fun Item.withWeapon(
    itemDamagePerAttack: Double,
    disableBlocking: Double = 0.0
): Item

/** Установить радиус атаки (set_variable_set_item_attack_range). */
@Action("set_variable_set_item_attack_range", returns = ["variable"], thisArg = ["item"])
external fun Item.withAttackRange(
    minReach: Double,
    @Slot("min_max") maxReach: Double,
    minCreativeReach: Double = minReach,
    maxCreativeReach: Double = maxReach,
    hitboxMargin: Double = 0.0,
    mobFactor: Double = 1.0
): Item

/** Установить минимальный заряд атаки (set_variable_set_item_minimum_attack_charge). */
@Action("set_variable_set_item_minimum_attack_charge", returns = ["variable"], thisArg = ["item"])
external fun Item.withMinimumAttackCharge(@Slot("minimum_attack_charge") charge: Double): Item

/** Установить данные анимации замаха (set_variable_set_item_swing_animation). */
@Action("set_variable_set_item_swing_animation", returns = ["variable"], thisArg = ["item"])
external fun Item.withSwingAnimation(
    duration: Double,
    animation: SwingAnimation
): Item

/** Установить предмету скольжение (set_variable_set_item_glider). */
@Action("set_variable_set_item_glider", returns = ["variable"], thisArg = ["item"])
external fun Item.withGlider(glider: Boolean = true): Item

/** Установить пробитие предмету (set_variable_set_item_piercing_weapon). */
@Action("set_variable_set_item_piercing_weapon", returns = ["variable"], thisArg = ["item"])
external fun Item.withPiercingWeapon(
    dealsKnockback: Boolean = false,
    dismounts: Boolean = false,
    sound: Sound? = null,
    hitSound: Sound? = null
): Item

/** Установить эффекты использования (set_variable_set_item_use_effects). */
@Action("set_variable_set_item_use_effects", returns = ["variable"], thisArg = ["item"])
external fun Item.withUseEffects(
    canSprint: Boolean = false,
    interactVibrations: Boolean = false,
    speedMultiplier: Double = 1.0
): Item

/** Установить превращение предмета при использовании (set_variable_set_item_use_remainder). */
@Action("set_variable_set_item_use_remainder", returns = ["variable"], thisArg = ["item"])
external fun Item.withUseRemainder(remainder: Double): Item

/** Установить блоки для ломания (set_variable_set_item_destroyable_blocks). */
@Action("set_variable_set_item_destroyable_blocks", returns = ["variable"], thisArg = ["item"])
external fun Item.withDestroyableBlocks(vararg destroyable: Item): Item

/** Установить блоки для установки (set_variable_set_item_placeable_blocks). */
@Action("set_variable_set_item_placeable_blocks", returns = ["variable"], thisArg = ["item"])
external fun Item.withPlaceableBlocks(vararg placeable: Item): Item

/** Установить флаги видимости предмету (set_variable_set_item_visibility_flags). */
@Action("set_variable_set_item_visibility_flags", returns = ["variable"], thisArg = ["item"])
external fun Item.withVisibilityFlags(
    hideDye: VisibilityFlag = VisibilityFlag.NO_CHANGE,
    hideEnchantments: VisibilityFlag = VisibilityFlag.NO_CHANGE,
    hideAttributes: VisibilityFlag = VisibilityFlag.NO_CHANGE,
    hideUnbreakable: VisibilityFlag = VisibilityFlag.NO_CHANGE,
    hidePlaceOn: VisibilityFlag = VisibilityFlag.NO_CHANGE,
    hideDestroys: VisibilityFlag = VisibilityFlag.NO_CHANGE,
    hidePotionEffects: VisibilityFlag = VisibilityFlag.NO_CHANGE,
    hideArmorTrim: VisibilityFlag = VisibilityFlag.NO_CHANGE
): Item

// ============================================================================
// Специальные расширения: Книги, Мешки, Контейнеры, Шаблоны
// ============================================================================

/** Установить текст книги на странице (set_variable_set_book_page). */
@Action("set_variable_set_book_page", returns = ["variable"], thisArg = ["book"])
external fun Item.withBookPage(
    text: Text,
    page: Double,
    mode: LoreMode = LoreMode.MERGE
): Item

/** Установить страницы книги (set_variable_set_book_pages). */
@Action("set_variable_set_book_pages", returns = ["variable"], thisArg = ["book"])
external fun Item.withBookPages(vararg text: Text): Item

/** Изменить содержимое мешка (set_variable_set_bundle_items). */
@Action("set_variable_set_bundle_items", returns = ["variable"], thisArg = ["bundle"])
external fun Item.withBundleItems(
    vararg items: Item,
    settingMode: ContainerSettingMode = ContainerSettingMode.SET
): Item

/** Установить содержимое контейнера/предмета (set_variable_set_item_contents). */
@Action("set_variable_set_item_contents", returns = ["variable"], thisArg = ["item"])
external fun Item.withContents(
    vararg items: Item,
    settingMode: ContainerSettingMode = ContainerSettingMode.SET
): Item

/** Установить местоположение магнетита компасу (set_variable_set_compass_lodestone). */
@Action("set_variable_set_compass_lodestone", returns = ["variable"], thisArg = ["item"])
external fun Item.setLodestone(location: Location, tracked: Boolean = true): Item

/** Удалить местоположение магнетита с компаса (set_variable_remove_compass_lodestone). */
@Action("set_variable_remove_compass_lodestone", returns = ["variable"], thisArg = ["item"])
external fun Item.removeLodestone(): Item

/** Установить код в шаблон (set_variable_set_template_code). */
@Action("set_variable_set_template_code", returns = ["variable"], thisArg = ["template"])
external fun Item.withTemplateCode(code: Any): Item

/** Изменить CustomModelData 1.21+ (set_variable_edit_item_custom_model_data). */
@Action("set_variable_edit_item_custom_model_data", returns = ["variable"], thisArg = ["item"])
external fun Item.editCustomModelData(
    data: Text,
    valueType: CustomModelDataValueType,
    setupMode: CustomModelDataSetupMode
): Item

// ============================================================================
// Взаимодействие с частицами и текстом
// ============================================================================

/** Установить материал частицы (set_variable_set_particle_material). */
@Action("set_variable_set_particle_material", returns = ["variable"], thisArg = ["particle"])
external fun Particle.setMaterial(material: Item): Particle

/** Установить стилизуемому тексту предмет при наведении (set_variable_set_component_item_hover). */
@Action("set_variable_set_component_item_hover", returns = ["variable"], thisArg = ["component"])
external fun TextComponent.hover(hover: Item): TextComponent
