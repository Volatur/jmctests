package justmc.entity

import justmc.annotation.*

enum class EntityAgeLock {
    ENABLE,
    DISABLE,
    DONT_CHANGE
}

enum class EntityAngleUnit {
    DEGREES,
    RADIANS
}

enum class EntityAnimalVariant {
    COLD,
    WARM,
    TEMPERATE
}

enum class EntityArmorStandArms {
    ENABLE,
    DISABLE,
    DONT_CHANGE
}

enum class EntityArmorStandBasePlate {
    ENABLE,
    DISABLE,
    DONT_CHANGE
}

enum class EntityAttributeType {
    MAX_HEALTH,
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
    MAX_ABSORPTION,
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

enum class EntityAxolotlType {
    LUCY,
    WILD,
    GOLD,
    CYAN,
    BLUE
}

enum class EntityBillboardType {
    FIXED,
    VERTICAL,
    HORIZONTAL,
    CENTER
}

enum class EntityBiome {
    DESERT,
    JUNGLE,
    PLAINS,
    SAVANNA,
    SNOW,
    SWAMP,
    TAIGA
}

enum class EntityBodyColor {
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
    BLACK,
    DO_NOT_CHANGE
}

enum class EntityBodyPart {
    HEAD,
    BODY,
    LEFT_ARM,
    RIGHT_ARM,
    LEFT_LEG,
    RIGHT_LEG
}

enum class EntityCatType {
    TABBY,
    BLACK,
    RED,
    SIAMESE,
    BRITISH_SHORTHAIR,
    CALICO,
    PERSIAN,
    RAGDOLL,
    WHITE,
    JELLIE,
    ALL_BLACK
}

enum class EntityCheckMode {
    ANY,
    ALL
}

enum class EntityCollisionCheckType {
    CONTAINS,
    OVERLAPS
}

enum class EntityCompareMode {
    TYPE,
    NAME_OR_UUID
}

enum class EntityCompareType {
    EQUALS,
    CONTAINS,
    STARTS_WITH,
    ENDS_WITH
}

enum class EntityCowType {
    RED,
    BROWN
}

enum class EntityDamageType {
    DAMAGE,
    CRITICAL_DAMAGE,
    MAGICAL_DAMAGE
}

enum class EntityDigging {
    EMERGE,
    DIG_DOWN
}

enum class EntityDisplayModelType {
    NONE,
    THIRDPERSON_LEFTHAND,
    THIRDPERSON_RIGHTHAND,
    FIRSTPERSON_LEFTHAND,
    FIRSTPERSON_RIGHTHAND,
    HEAD,
    GUI,
    GROUND,
    FIXED
}

enum class EntityDisplayRotation {
    LEFT_ROTATION,
    RIGHT_ROTATION
}

enum class EntityDyeColor {
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

enum class EntityEquipmentSlot {
    HAND,
    OFF_HAND,
    FEET,
    LEGS,
    CHEST,
    HEAD,
    BODY,
    SADDLE
}

enum class EntityFacing {
    NORTH,
    EAST,
    SOUTH,
    WEST,
    UP,
    DOWN
}

enum class EntityFoxType {
    RED,
    SNOW
}

enum class EntityFrogVariant {
    TEMPERATE,
    WARM,
    COLD
}

enum class EntityGene {
    MAIN,
    HIDDEN,
    BOTH
}

enum class EntityGeneType {
    NORMAL,
    LAZY,
    WORRIED,
    PLAYFUL,
    BROWN,
    WEAK,
    AGGRESSIVE
}

enum class EntityHandType {
    MAIN,
    OFF
}

enum class EntityHookSlot {
    MAIN_HAND,
    OFF_HAND
}

enum class EntityHorseColor {
    WHITE,
    CREAMY,
    CHESTNUT,
    BROWN,
    DARK_BROWN,
    GRAY,
    BLACK,
    DO_NOT_CHANGE
}

enum class EntityHorseStyle {
    NONE,
    WHITE,
    WHITEFIELD,
    WHITE_DOTS,
    BLACK_DOTS,
    DO_NOT_CHANGE
}

enum class EntityIntersectType {
    POINT,
    HITBOX
}

enum class EntityItemHand {
    MAIN_HAND,
    OFF_HAND
}

enum class EntityLaunchAxis {
    YAW,
    YAW_AND_PITCH
}

enum class EntityLlamaType {
    CREAMY,
    WHITE,
    BROWN,
    GRAY
}

enum class EntityMannequinHand {
    RIGHT,
    LEFT
}

enum class EntityMannequinModel {
    CLASSIC,
    SLIM,
    UNSET
}

enum class EntityMerchantRecipeMode {
    MERGE,
    APPEND
}

enum class EntityMergingMode {
    SPACES,
    CONCATENATION,
    SEPARATE_LINES
}

enum class EntityModificationMode {
    ADD,
    REMOVE
}

enum class EntityNautilusVariant {
    TEMPERATE,
    WARM
}

enum class EntityOxidizingState {
    WAXED,
    UNSET
}

enum class EntityParrotType {
    RED,
    BLUE,
    GREEN,
    CYAN,
    GRAY
}

enum class EntityParticleMode {
    REGULAR,
    AMBIENT,
    NONE
}

enum class EntityPatchTarget {
    BODY,
    CAPE,
    ELYTRA
}

enum class EntityPattern {
    KOB,
    SUNSTREAK,
    SNOOPER,
    DASHER,
    BRINELY,
    SPOTTY,
    FLOPPER,
    STRIPEY,
    GLITTER,
    BLOCKFISH,
    BETTY,
    CLAYFISH,
    DO_NOT_CHANGE
}

enum class EntityPatternColor {
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
    BLACK,
    DO_NOT_CHANGE
}

enum class EntityPhase {
    CIRCLING,
    STRAFING,
    FLY_TO_PORTAL,
    LAND_ON_PORTAL,
    LEAVE_PORTAL,
    BREATH_ATTACK,
    SEARCH_FOR_BREATH_ATTACK_TARGET,
    ROAR_BEFORE_ATTACK,
    CHARGE_PLAYER,
    DYING,
    HOVER
}

enum class EntityPose {
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

enum class EntityProfession {
    NONE,
    ARMORER,
    BUTCHER,
    CARTOGRAPHER,
    CLERIC,
    FARMER,
    FISHERMAN,
    FLETCHER,
    LEATHERWORKER,
    LIBRARIAN,
    MASON,
    NITWIT,
    SHEPHERD,
    TOOLSMITH,
    WEAPONSMITH
}

enum class EntityRabbitType {
    BROWN,
    WHITE,
    BLACK,
    BLACK_AND_WHITE,
    GOLD,
    SALT_AND_PEPPER,
    THE_KILLER_BUNNY
}

enum class EntityReason {
    BEEHIVE,
    BREEDING,
    BUILD_IRONGOLEM,
    BUILD_SNOWMAN,
    BUILD_WITHER,
    COMMAND,
    CURED,
    CUSTOM,
    DEFAULT,
    DISPENSE_EGG,
    DROWNED,
    EGG,
    ENDER_PEARL,
    EXPLOSION,
    FROZEN,
    INFECTION,
    JOCKEY,
    LIGHTNING,
    MOUNT,
    NATURAL,
    NETHER_PORTAL,
    OCELOT_BABY,
    PATROL,
    PIGLIN_ZOMBIFIED,
    RAID,
    REINFORCEMENTS,
    SHEARED,
    SHOULDER_ENTITY,
    SILVERFISH_BLOCK,
    SLIME_SPLIT,
    SPAWNER,
    SPAWNER_EGG,
    TRAP,
    VILLAGER_DEFENSE,
    VILLAGE_INVASION
}

enum class EntityReturnValue {
    VALUE,
    BASE_VALUE,
    DEFAULT_VALUE
}

enum class EntityRoll {
    ROLL_OUT,
    ROLL_UP
}

enum class EntityRotationMode {
    SET,
    ADD,
    ADD_LOCAL
}

enum class EntityServerType {
    MOJANG,
    SERVER,
    SERVER_DEFAULT
}

enum class EntitySnifferState {
    IDLING,
    FEELING_HAPPY,
    SCENTING,
    SNIFFING,
    SEARCHING,
    DIGGING,
    RISING
}

enum class EntitySoundVariant {
    ANGRY,
    BIG,
    CLASSIC,
    CUTE,
    GRUMPY,
    PUGLIN,
    SAD
}

enum class EntityTextAlignment {
    CENTER,
    LEFT,
    RIGHT
}

enum class EntityTransformMode {
    SET,
    ADD
}

enum class EntityTriState {
    NOT_SET,
    TRUE,
    FALSE
}

enum class EntityValueType {
    ANY_VALUE,
    NBT_STRING
}

enum class EntityWaitType {
    MIN_MAX_WAIT,
    WAIT,
    MIN_WAIT,
    MAX_WAIT
}

enum class EntityWeatheringState {
    UNAFFECTED,
    EXPOSED,
    WEATHERED,
    OXIDIZED
}

enum class EntityWolfType {
    ASHEN,
    SNOWY,
    RUSTY,
    BLACK,
    CHESTNUT,
    SPOTTED,
    STRIPED,
    PALE
}
