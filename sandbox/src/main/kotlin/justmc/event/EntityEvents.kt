package justmc.event

import justmc.annotation.*
import justmc.player.Player
import justmc.entity.Entity
import justmc.value.*

/**
 * Существо ранит игрока
 *
 * Выполняет код, когда существо ранит игрока.
 */
@Event("entity_damage_player")
class EntityDamagePlayerEvent {
    val victim: Player get() = Player.VICTIM
    val damager: Entity get() = Entity.DAMAGER
    val damage: Double get() = GameValue.eventDamage()
    val cause: Text get() = GameValue.eventDamageCause()
    val finalDamage: Double get() = GameValue.eventFinalDamage()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_damage")
    external fun setDamage(damage: Double)
}

/**
 * Игрок получает урон от снаряда
 *
 * Выполняет код, когда снаряд ранит игрока.
 */
@Event("projectile_damage_player")
class ProjectileDamagePlayerEvent {
    val victim: Player get() = Player.VICTIM
    val shooter: Entity get() = Entity.SHOOTER
    val projectile: Entity get() = Entity.PROJECTILE
    val damage: Double get() = GameValue.eventDamage()
    val cause: Text get() = GameValue.eventDamageCause()
    val finalDamage: Double get() = GameValue.eventFinalDamage()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_damage")
    external fun setDamage(damage: Double)
}

/**
 * Моб убивает игрока
 *
 * Выполняет код, когда моб убивает игрока.
 */
@Event("mob_kill_player")
class MobKillPlayerEvent {
    val victim: Player get() = Player.VICTIM
    val killer: Entity get() = Entity.KILLER

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сущность создана
 *
 * Выполняет код, когда в мире появляется новая сущность.
 */
@Event("entity_spawn")
class EntitySpawnEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Удаление сущности
 *
 * Выполняет код, когда из мира удаляется сущность.
 */
@Event("entity_removed_from_world")
class EntityRemovedFromWorldEvent {
    val entity: Entity get() = Entity.DEFAULT
    val fromLocation: Location get() = GameValue.eventFromLocation()
    val location: Location get() = GameValue.eventNewLocation()
}

/**
 * Моб наносит урон мобу
 *
 * Выполняет код, когда моб наносит урон другому мобу.
 */
@Event("entity_damage_entity")
class EntityDamageEntityEvent {
    val victim: Entity get() = Entity.VICTIM
    val damager: Entity get() = Entity.DAMAGER
    val damage: Double get() = GameValue.eventDamage()
    val cause: Text get() = GameValue.eventDamageCause()
    val finalDamage: Double get() = GameValue.eventFinalDamage()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_damage")
    external fun setDamage(damage: Double)
}

/**
 * Моб убил моба
 *
 * Выполняет код, когда моб убил другого моба.
 */
@Event("entity_kill_entity")
class EntityKillEntityEvent {
    val victim: Entity get() = Entity.VICTIM
    val killer: Entity get() = Entity.KILLER

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сущность получает урон
 *
 * Выполняет код, когда сущность получает урон.
 */
@Event("entity_take_damage")
class EntityTakeDamageEvent {
    val entity: Entity get() = Entity.DEFAULT
    val damage: Double get() = GameValue.eventDamage()
    val cause: Text get() = GameValue.eventDamageCause()
    val finalDamage: Double get() = GameValue.eventFinalDamage()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_damage")
    external fun setDamage(damage: Double)
}

/**
 * Сущность исцеляется
 *
 * Выполняет код, когда сущность исцеляется.
 */
@Event("entity_heal")
class EntityHealEvent {
    val entity: Entity get() = Entity.DEFAULT
    val healAmount: Double get() = GameValue.eventHealAmount()
    val healCause: Text get() = GameValue.eventHealCause()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_heal")
    external fun setHeal(heal: Double)
}

/**
 * Сущность возрождается от тотема
 *
 * Выполняет код, когда сущность возрождается от Тотема бессмертия.
 */
@Event("entity_resurrect")
class EntityResurrectEvent {
    val entity: Entity get() = Entity.DEFAULT
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Урон от снаряда
 *
 * Выполняет код, когда снаряд наносит урон сущности.
 */
@Event("projectile_damage_entity")
class ProjectileDamageEntityEvent {
    val victim: Entity get() = Entity.VICTIM
    val shooter: Entity get() = Entity.SHOOTER
    val projectile: Entity get() = Entity.PROJECTILE
    val damage: Double get() = GameValue.eventDamage()
    val cause: Text get() = GameValue.eventDamageCause()
    val finalDamage: Double get() = GameValue.eventFinalDamage()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_damage")
    external fun setDamage(damage: Double)
}

/**
 * Снаряд убил сущность
 *
 * Выполняет код, когда снаряд убил сущность.
 */
@Event("projectile_kill_entity")
class ProjectileKillEntityEvent {
    val victim: Entity get() = Entity.VICTIM
    val killer: Entity get() = Entity.KILLER
    val projectile: Entity get() = Entity.PROJECTILE

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Попадание снаряда в блок
 *
 * Выполняет код, когда снаряд попадает в блок.
 */
@Event("projectile_hit")
class ProjectileHitEvent {
    val shooter: Entity get() = Entity.SHOOTER
    val projectile: Entity get() = Entity.PROJECTILE
    val block: Text get() = GameValue.eventBlock()
    val blockFace: Text get() = GameValue.eventBlockFace()
    val blockLocation: Location get() = GameValue.eventBlockLocation()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Снаряд столкнулся с сущностью
 *
 * Выполняет код, когда снаряд сталкивается с сущностью.
 */
@Event("projective_collide")
class ProjectiveCollideEvent {
    val projectile: Entity get() = Entity.PROJECTILE
    val target: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Фейерверк взрывается
 *
 * Выполняет код, когда взрывается фейерверк.
 */
@Event("firework_explode")
class FireworkExplodeEvent {
    val entity: Entity get() = Entity.DEFAULT
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val blocksInvolved: List<Location> get() = GameValue.eventBlocksInvolved()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Ломание висящего существа
 *
 * Выполняет код, когда ломается висящая сущность.
 */
@Event("hanging_break")
class HangingBreakEvent {
    val entity: Entity get() = Entity.DEFAULT
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val breakCause: Text get() = GameValue.eventHangingBreakCause()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Существо выбрасывает предмет
 *
 * Выполняет код, когда существо выбрасывает предмет.
 */
@Event("entity_drop_item")
class EntityDropItemEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Существо поднимает предмет
 *
 * Выполняет код, когда существо поднимает предмет.
 */
@Event("entity_pickup_item")
class EntityPickupItemEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Предмет исчез
 *
 * Выполняет код, когда предмет исчезает из мира спустя 5 минут после его создания.
 */
@Event("item_despawn")
class ItemDespawnEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Существо выполняет заклинание
 *
 * Выполняет код, когда существо выполняет заклинание.
 */
@Event("entity_spell_cast")
class EntitySpellCastEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Эндермен убегает
 *
 * Выполняет код, когда Эндермен телепортируется, чтобы избежать что-либо.
 */
@Event("enderman_escape")
class EndermanEscapeEvent {
    val entity: Entity get() = Entity.DEFAULT
    val teleportCause: Text get() = GameValue.eventTeleportCause()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Эндермен злится на игрока
 *
 * Выполняет код, когда Эндермен злится на игрока.
 */
@Event("enderman_attack_player")
class EndermanAttackPlayerEvent {
    val entity: Entity get() = Entity.DEFAULT
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Смерть сущности
 *
 * Выполняет код, когда сущность умирает.
 */
@Event("entity_death")
class EntityDeathEvent {
    val entity: Entity get() = Entity.DEFAULT
    val experience: Double get() = GameValue.eventExperience()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_experience")
    external fun setExperience(experience: Double)
}

/**
 * Урон транспорту
 *
 * Выполняет код, когда транспорт получает урон.
 */
@Event("vehicle_take_damage")
class VehicleTakeDamageEvent {
    val vehicle: Entity get() = Entity.DEFAULT
    val damager: Entity get() = Entity.DAMAGER
    val damage: Double get() = GameValue.eventDamage()
    val cause: Text get() = GameValue.eventDamageCause()
    val finalDamage: Double get() = GameValue.eventFinalDamage()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_damage")
    external fun setDamage(damage: Double)
}

/**
 * Блок начал падать
 *
 * Выполняет код, когда блок, затронутый гравитацией, превращается в падающий блок.
 */
@Event("block_fall")
class BlockFallEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сущность взаимодействует с миром
 *
 * Выполняет код, когда сущность взаимодействует с миром.
 */
@Event("entity_interact")
class EntityInteractEvent {
    val entity: Entity get() = Entity.DEFAULT
    val block: Text get() = GameValue.eventBlock()
    val blockFace: Text get() = GameValue.eventBlockFace()
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()
    val interaction: Text get() = GameValue.eventInteraction()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Раздатчик подстриг овцу
 *
 * Выполняет код, когда раздатчик срезает шерсть с овцы.
 */
@Event("dispenser_shear_sheep")
class DispenserShearSheepEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Овца отрастила шерсть
 *
 * Выполняет код, когда Овца отращивает шерсть.
 */
@Event("sheep_regrow_wool")
class SheepRegrowWoolEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Ведьма кидает зелье
 *
 * Выполняет код, когда Ведьма кидает зелье.
 */
@Event("witch_throw_potion")
class WitchThrowPotionEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сущность взрывается
 *
 * Выполняет код, когда сущность взрывается.
 */
@Event("entity_explode")
class EntityExplodeEvent {
    val entity: Entity get() = Entity.DEFAULT
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val blocksInvolved: List<Location> get() = GameValue.eventBlocksInvolved()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сущность решила взорваться
 *
 * Выполняет код, когда сущность решает взорваться.
 */
@Event("entity_explosion")
class EntityExplosionEvent {
    val entity: Entity get() = Entity.DEFAULT
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val blocksInvolved: List<Location> get() = GameValue.eventBlocksInvolved()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сущность звонит в колокол
 *
 * Выполняет код, когда сущность звонит в колокол.
 */
@Event("entity_bell_ring")
class EntityBellRingEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Падающий блок приземляется
 *
 * Выполняет код, когда падающий блок превращается в обычный блок.
 */
@Event("falling_block_land")
class FallingBlockLandEvent {
    val entity: Entity get() = Entity.DEFAULT
    val block: Text get() = GameValue.eventBlock()
    val location: Location get() = GameValue.eventNewLocation()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Предмет переместился в контейнер
 *
 * Выполняет код, когда предмет перемещается в контейнер.
 */
@Event("item_moved_into_container")
class ItemMovedIntoContainerEvent {
    val entity: Entity get() = Entity.DEFAULT
    val fromLocation: Location get() = GameValue.eventFromLocation()
    val location: Location get() = GameValue.eventNewLocation()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Пиглин торгуется
 *
 * Выполняет код, когда Пиглин торгуется.
 */
@Event("piglin_barter")
class PiglinBarterEvent {
    val entity: Entity get() = Entity.DEFAULT
    val items: List<Item> get() = GameValue.eventItems()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_items")
    external fun setItems(vararg items: Item)
}

/**
 * Запуск снаряда
 *
 * Выполняет код, когда запускается какой-либо снаряд.
 */
@Event("projectile_launch")
class ProjectileLaunchEvent {
    val shooter: Entity get() = Entity.SHOOTER
    val projectile: Entity get() = Entity.PROJECTILE

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сущность стреляет
 *
 * Выполняет код, когда сущность стреляет из лука или арбалета.
 */
@Event("entity_shot_bow")
class EntityShotBowEvent {
    val entity: Entity get() = Entity.DEFAULT
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()
    val item: Item get() = GameValue.eventItem()
    val power: Double get() = GameValue.eventPower()
    val projectileItem: Item get() = GameValue.eventProjectileItem()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сущность заряжает арбалет
 *
 * Выполняет код, когда сущность заряжает арбалет.
 */
@Event("entity_load_crossbow")
class EntityLoadCrossbowEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сущность заменяется другой сущностью
 *
 * Выполняет код, когда сущность заменяется другой сущностью.
 */
@Event("entity_transform")
class EntityTransformEvent {
    val entity: Entity get() = Entity.DEFAULT
    val transformReason: Text get() = GameValue.eventTransformReason()
    val transformedEntities: List<Text> get() = GameValue.eventTransformedEntities()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Древний страж проклял игрока
 *
 * Выполняет код, когда древний страж проклинает игрока.
 */
@Event("elder_guardian_appears_at_player")
class ElderGuardianAppearsAtPlayerEvent {
    val entity: Entity get() = Entity.DEFAULT
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Коза таранит сущность
 *
 * Выполняет код, когда Коза таранит сущность.
 */
@Event("goat_ram_entity")
class GoatRamEntityEvent {
    val goat: Entity get() = Entity.DEFAULT
    val target: Entity get() = Entity.VICTIM

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Предметы на земле объединяются
 *
 * Выполняет код, когда рядом лежащие предметы объединяются в единый стак.
 */
@Event("item_merge")
class ItemMergeEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сущность телепортируется
 *
 * Выполняет код, когда сущность телепортируется.
 */
@Event("entity_teleport")
class EntityTeleportEvent {
    val entity: Entity get() = Entity.DEFAULT
    val fromLocation: Location get() = GameValue.eventFromLocation()
    val location: Location get() = GameValue.eventNewLocation()
    val teleportCause: Text get() = GameValue.eventTeleportCause()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сущность отталкивается
 *
 * Выполняет код, когда сущность отталкивается.
 */
@Event("entity_knockback")
class EntityKnockbackEvent {
    val entity: Entity get() = Entity.DEFAULT
    val knockbackCause: Text get() = GameValue.eventKnockbackCause()
    val knockbackType: Text get() = GameValue.eventKnockbackEventType()
    val knockbackVector: Vector get() = GameValue.eventKnockbackVector()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_knockback_vector")
    external fun setKnockbackVector(knockback: Vector)
}

/**
 * Сущность начинает лететь на элитрах
 *
 * Выполняет код, когда сущность начинает лететь на элитрах.
 */
@Event("entity_start_gliding")
class EntityStartGlidingEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сущность перестаёт лететь на элитрах
 *
 * Выполняет код, когда сущность перестаёт лететь на элитрах.
 */
@Event("entity_stop_gliding")
class EntityStopGlidingEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сущность загорелась
 *
 * Выполняет код, когда сущность загорается.
 */
@Event("entity_combust")
class EntityCombustEvent {
    val entity: Entity get() = Entity.DEFAULT
    val combustDuration: Double get() = GameValue.eventCombustDuration()
    val combustReason: Text get() = GameValue.eventCombustReason()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_combust_duration")
    external fun setCombustDuration(duration: Double)
}

/**
 * Сущность меняет экипировку
 *
 * Выполняет код, когда экипировка сущности меняется.
 */
@Event("entity_equipment_changed")
class EntityEquipmentChangedEvent {
    val entity: Entity get() = Entity.DEFAULT
    val newEquipments: Map<Text, Item> get() = GameValue.eventNewEquipments()
    val oldEquipments: Map<Text, Item> get() = GameValue.eventOldEquipments()
}

/**
 * Поплавок удочки изменяет состояние
 *
 * Выполняет код, когда поплавок удочки изменяет своё состояние.
 */
@Event("fishing_hook_state_change")
class FishingHookStateChangeEvent {
    val entity: Entity get() = Entity.DEFAULT
    val experience: Double get() = GameValue.eventExperience()
    val fishState: Text get() = GameValue.eventFishState()
    val item: Item get() = GameValue.eventItem()
    val newFishingHookState: Text get() = GameValue.eventNewFishingHookState()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_experience")
    external fun setExperience(experience: Double)
}

/**
 * Сферы опыта объединяются
 *
 * Выполняет код, когда сфера опыта объединяется с другой сферой опыта.
 */
@Event("experience_orb_merge")
class ExperienceOrbMergeEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Обновление статуса поломки блока
 *
 * Выполняет код, когда сущность обновляет статус поломки блока.
 */
@Event("entity_block_break_progress_update")
class EntityBlockBreakProgressUpdateEvent {
    val entity: Entity get() = Entity.DEFAULT
    val breakProgress: Double get() = GameValue.eventBlockBreakProgress()
}

/**
 * Сущность отвязалась
 *
 * Выполняет код, когда сущность отвязывается от поводка.
 */
@Event("entity_unleash_event")
class EntityUnleashEvent {
    val entity: Entity get() = Entity.DEFAULT
    val unleashReason: Text get() = GameValue.eventEntityUnleashReason()
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_should_drop_leash")
    external fun setShouldDropLeash(shouldDropLeash: String)
}
