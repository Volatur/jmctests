package justmc.player

import justmc.annotation.*

enum class PlayerAngleUnit {
    DEGREES,
    RADIANS
}

enum class PlayerAnimation {
    DAMAGE,
    WAKE_UP,
    TOTEM,
    JUMPSCARE
}

enum class PlayerAttributeType {
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
    HORSE_JUMP_STRENGTH,
    ZOMBIE_SPAWN_REINFORCEMENTS,
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
    GENERIC_MAX_HEALTH,
    GENERIC_MAX_ABSORPTION,
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

enum class PlayerCheckMode {
    ANY,
    ALL
}

enum class PlayerCheckType {
    CONTAINS,
    OVERLAPS
}

enum class PlayerCheckedSlots {
    ENTIRE_INVENTORY,
    MAIN_INVENTORY,
    UPPER_INVENTORY,
    HOTBAR,
    ARMOR
}

enum class PlayerClearMode {
    ENTIRE,
    MAIN,
    UPPER,
    HOTBAR,
    ARMOR
}

enum class PlayerColor {
    PINK,
    BLUE,
    RED,
    GREEN,
    YELLOW,
    PURPLE,
    WHITE
}

enum class PlayerCompareMode {
    TYPE,
    NAME_OR_UUID
}

enum class PlayerComparisonMode {
    IGNORE_STACK_SIZE,
    IGNORE_DURABILITY_AND_STACK_SIZE,
    EXACTLY,
    TYPE_ONLY
}

enum class PlayerDirection {
    DOWN,
    NORTH,
    SOUTH,
    WEST,
    EAST
}

enum class PlayerDisguise {
    ALL,
    EVERYONE_BUT_NOT_SELF,
    ONLY_SELF
}

enum class PlayerEquipment {
    MAIN_HAND,
    OFF_HAND
}

enum class PlayerFlightMode {
    RESPECT_GAMEMODE,
    KEEP_ORIGINAL
}

enum class PlayerFluidMode {
    NEVER,
    SOURCE_ONLY,
    ALWAYS
}

enum class PlayerFrame {
    TASK,
    GOAL,
    CHALLENGE
}

enum class PlayerGamemode {
    CREATIVE,
    SURVIVAL,
    ADVENTURE,
    SPECTATOR
}

enum class PlayerHandSlot {
    EITHER_HAND,
    MAIN_HAND,
    OFF_HAND
}

enum class PlayerHandType {
    MAIN,
    OFF
}

enum class PlayerInputType {
    FORWARD,
    BACKWARDS,
    LEFT,
    RIGHT,
    JUMP,
    SNEAK,
    SPRINT
}

enum class PlayerIntersectType {
    POINT,
    HITBOX
}

enum class PlayerInventoryType {
    CHEST,
    DISPENSER,
    DROPPER,
    FURNACE,
    WORKBENCH,
    CRAFTING,
    ENCHANTING,
    BREWING,
    PLAYER,
    CREATIVE,
    MERCHANT,
    ENDER_CHEST,
    ANVIL,
    SMITHING,
    BEACON,
    HOPPER,
    SHULKER_BOX,
    BARREL,
    BLAST_FURNACE,
    LECTERN,
    SMOKER,
    LOOM,
    CARTOGRAPHY,
    GRINDSTONE,
    STONECUTTER,
    COMPOSTER,
    CRAFTER
}

enum class PlayerLaunchAxis {
    YAW,
    YAW_AND_PITCH
}

enum class PlayerMenuType {
    CRAFTING,
    ANVIL,
    SMITHING,
    CARTOGRAPHY_TABLE,
    LOOM,
    GRINDSTONE,
    STONECUTTER,
    ENCHANTMENT
}

enum class PlayerMerging {
    SPACES,
    CONCATENATION,
    SEPARATE_LINES
}

enum class PlayerMode {
    SET,
    ADD
}

enum class PlayerMovementType {
    WALK,
    FLY
}

enum class PlayerParticleMode {
    REGULAR,
    AMBIENT,
    NONE
}

enum class PlayerPermission {
    OWNER,
    DEVELOPER,
    BUILDER,
    DEVELOPER_OR_BUILDER
}

enum class PlayerPose {
    STANDING,
    FALL_FLYING,
    SLEEPING,
    SWIMMING,
    SPIN_ATTACK,
    CROUCHING,
    LONG_JUMPING,
    DYING,
    CROAKING,
    USING_TONGUE,
    SITTING,
    ROARING,
    SNIFFING,
    EMERGING,
    DIGGING,
    SLIDING,
    SHOOTING,
    INHALING
}

enum class PlayerPosition {
    HEADER,
    FOOTER
}

enum class PlayerPrivilege {
    BUILDER,
    DEVELOPER,
    BUILDER_AND_DEVELOPER,
    WHITELISTED,
    OWNER
}

enum class PlayerReturnValue {
    VALUE,
    BASE_VALUE,
    DEFAULT_VALUE
}

enum class PlayerServerType {
    MOJANG,
    SERVER,
    SERVER_DEFAULT
}

enum class PlayerSettingMode {
    ADD,
    SET,
    REMOVE
}

enum class PlayerSide {
    FRONT,
    BACK,
    ALL
}

enum class PlayerSkyEffect {
    NONE,
    FOG,
    DARK_SKY,
    FOG_AND_DARK_SKY
}

enum class PlayerSlot {
    HAND,
    OFF_HAND,
    FEET,
    LEGS,
    CHEST,
    HEAD,
    BODY,
    SADDLE
}

enum class PlayerSource {
    MASTER,
    MUSIC,
    RECORD,
    WEATHER,
    BLOCK,
    HOSTILE,
    NEUTRAL,
    PLAYER,
    AMBIENT,
    VOICE
}

enum class PlayerStyle {
    PROGRESS,
    NOTCHED_6,
    NOTCHED_10,
    NOTCHED_12,
    NOTCHED_20
}

enum class PlayerType {
    SOLID,
    HOLLOW,
    WIREFRAME
}

enum class PlayerUnitOfMeasurement {
    POINTS,
    DISTANCE
}

enum class PlayerValueType {
    ANY_VALUE,
    NBT_STRING
}

enum class PlayerWeatherType {
    DOWNFALL,
    CLEAR
}
