package justmc.entity

import justmc.annotation.*
import justmc.value.*
import kotlin.*

/**
 * Сталкивается на местоположении
 * Проверяет, сталкивается ли сущность с блоками, шалкерами, лодками и границей мира на указанном местоположении.
 */
@Action("if_entity_collides_at_location")
external fun Entity.collidesAtLocation(location: Location): Boolean

/**
 * Сталкивается используя кастомный хитбокс
 * Проверяет, сталкивается ли сущность с блоками, шалкерами, лодками и границей мира используя кастомный хитбокс.
 */
@Action("if_entity_collides_using_hitbox")
external fun Entity.collidesUsingHitbox(
    min: Location,
    max: Location
): Boolean

/**
 * Сталкивается с сущностью
 * Проверяет, сталкивается ли хитбокс сущности с хитбоксом другой указанной сущности.
 */
@Action("if_entity_collides_with_entity")
external fun Entity.collidesWithEntity(
    nameOrUuid: Text = "",
    checkType: EntityCollisionCheckType = EntityCollisionCheckType.CONTAINS
): Boolean

/**
 * Существует
 * Проверяет, находится ли существо в мире.
 */
@Action("if_entity_exists")
external fun Entity.exists(): Boolean

/**
 * Имеет доступный путь
 * Проверяет, может ли сущность построить путь до указанной точки или цели
 */
@Action("if_entity_has_available_path")
external fun Entity.hasAvailablePath(): Boolean

/**
 * Имеет кастомный тег
 * Проверяет, имеет ли существо кастомный тег с указанным значением.
 */
@Action("if_entity_has_custom_tag")
external fun Entity.hasCustomTag(
    tag: Text = "",
    tagValue: List<Text> = emptyList(),
    compareType: EntityCompareType = EntityCompareType.EQUALS
): Boolean

/**
 * Имеет эффект от зелья
 * Проверяет, имеет ли существо эффект от зелья.
 */
@Action("if_entity_has_potion_effect")
external fun Entity.hasPotionEffect(
    vararg potions: Potion,
    checkMode: EntityCheckMode = EntityCheckMode.ANY
): Boolean

/**
 * Внутри региона
 * Проверяет, находится ли сущность в определённом регионе.
 */
@Action("if_entity_in_area")
external fun Entity.inArea(
    location1: Location,
    location2: Location,
    ignoreYAxis: Boolean = false,
    intersectType: EntityIntersectType = EntityIntersectType.POINT,
    checkType: EntityCollisionCheckType = EntityCollisionCheckType.CONTAINS
): Boolean

/**
 * Замаскирована
 * Проверяет, замаскирована ли сущность.
 */
@Action("if_entity_is_disguised")
external fun Entity.isDisguised(): Boolean

/**
 * Касается поверхности блока
 * Проверяет, касается ли существо поверхности блока.
 */
@Action("if_entity_is_grounded")
external fun Entity.isGrounded(): Boolean

/**
 * Является предметом
 * Проверяет, является ли существо предметом.
 */
@Action("if_entity_is_item")
external fun Entity.isItem(): Boolean

/**
 * Имеет Minecraft-тег
 * Проверяет, имеет ли сущность указанный Minecraft-тег (например, "aquatic").
 */
@Action("if_entity_is_minecraft_tagged")
external fun Entity.isMinecraftTagged(
    namespace: Text = ""
): Boolean

/**
 * Является мобом
 * Проверяет, является ли существо мобом.
 */
@Action("if_entity_is_mob")
external fun Entity.isMob(): Boolean

/**
 * Рядом с местоположением
 * Проверяет, находится ли существо рядом с указанным местоположением.
 */
@Action("if_entity_is_near_location")
external fun Entity.isNearLocation(
    location: Location,
    range: Double,
    ignoreYAxis: Boolean = false
): Boolean

/**
 * Является снарядом
 * Проверяет, является ли существо снарядом.
 */
@Action("if_entity_is_projectile")
external fun Entity.isProjectile(): Boolean

/**
 * Сущность оседлала сущность
 * Проверяет, оседлала ли сущность любую из других указанных сущностей.
 */
@Action("if_entity_is_riding_entity")
external fun Entity.isRidingEntity(
    vararg entityIds: Text,
    compareMode: EntityCompareMode = EntityCompareMode.TYPE
): Boolean

/**
 * Стоит на блоке
 * Проверяет, стоит ли сущность на определённом блоке или местоположении.
 */
@Action("if_entity_is_standing_on_block")
external fun Entity.isStandingOnBlock(
    vararg blocks: Item,
    onlySolid: Boolean = false
): Boolean

/**
 * Тип существа равен
 * Проверяет, равен ли тип существа типу в сундуке.
 */
@Action("if_entity_is_type")
external fun Entity.isType(vararg entityTypes: Item): Boolean

/**
 * Является нежитью
 * Проверяет, является ли существо нежитью.
 */
@Action("if_entity_is_undead")
external fun Entity.isUndead(): Boolean

/**
 * Является транспортом
 * Проверяет, является ли существо транспортом.
 */
@Action("if_entity_is_vehicle")
external fun Entity.isVehicle(): Boolean

/**
 * Имя равно
 * Проверяет, равно ли имя существа имени в сундуке.
 */
@Action("if_entity_name_equals")
external fun Entity.nameEquals(vararg namesOrUuids: Text): Boolean

/**
 * Причина появления равна
 * Проверяет, равна ли причина появления существа определённому значению.
 */
@Action("if_entity_spawn_reason_equals")
external fun Entity.spawnReasonEquals(
    reason: EntityReason = EntityReason.BEEHIVE
): Boolean
