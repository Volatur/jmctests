package justmc.event

import justmc.annotation.*
import justmc.player.Player
import justmc.entity.Entity
import justmc.value.*

/**
 * Игрок зашёл в мир
 *
 * Выполняет код, когда игрок заходит в мир.
 */
@Event("player_join")
class PlayerJoinEvent {
    val player: Player get() = Player.DEFAULT
    val message: Text get() = GameValue.eventMessage()

    @Action("game_hide_event_message")
    external fun hideMessage()
}

/**
 * Игрок вышел из мира
 *
 * Выполняет код, когда игрок выходит из мира.
 */
@Event("player_quit")
class PlayerQuitEvent {
    val player: Player get() = Player.DEFAULT
    val message: Text get() = GameValue.eventMessage()

    @Action("game_hide_event_message")
    external fun hideMessage()
}

/**
 * Игрок перезашёл в мир
 *
 * Выполняет код, когда игрок перезаходит в мир с помощью команды /play.
 */
@Event("player_rejoin")
class PlayerRejoinEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок взаимодействует с миром
 *
 * Выполняет код, когда игрок взаимодействует с миром.
 */
@Event("player_interact")
class PlayerInteractEvent {
    val player: Player get() = Player.DEFAULT
    val block: Text get() = GameValue.eventBlock()
    val blockFace: Text get() = GameValue.eventBlockFace()
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()
    val interaction: Text get() = GameValue.eventInteraction()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок кликает правой кнопкой
 *
 * Выполняет код, когда игрок кликает правой кнопкой мыши.
 */
@Event("player_right_click")
class PlayerRightClickEvent {
    val player: Player get() = Player.DEFAULT
    val block: Text get() = GameValue.eventBlock()
    val blockFace: Text get() = GameValue.eventBlockFace()
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()
    val interaction: Text get() = GameValue.eventInteraction()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок кликает левой кнопкой
 *
 * Выполняет код, когда игрок кликает левой кнопкой мыши.
 */
@Event("player_left_click")
class PlayerLeftClickEvent {
    val player: Player get() = Player.DEFAULT
    val block: Text get() = GameValue.eventBlock()
    val blockFace: Text get() = GameValue.eventBlockFace()
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()
    val interaction: Text get() = GameValue.eventInteraction()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок кликает правой кнопкой по существу
 *
 * Выполняет код, когда игрок кликает правой кнопкой по существу.
 */
@Event("player_right_click_entity")
class PlayerRightClickEntityEvent {
    val player: Player get() = Player.DEFAULT
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
 * Игрок кликает правой кнопкой по игроку
 *
 * Выполняет код, когда игрок кликает правой кнопкой по другому игроку.
 */
@Event("player_right_click_player")
class PlayerRightClickPlayerEvent {
    val player: Player get() = Player.DEFAULT
    val target: Player get() = Player.VICTIM
    val block: Text get() = GameValue.eventBlock()
    val blockFace: Text get() = GameValue.eventBlockFace()
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()
    val interaction: Text get() = GameValue.eventInteraction()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок ставит блок
 *
 * Выполняет код, когда игрок ставит блок.
 */
@Event("player_place_block")
class PlayerPlaceBlockEvent {
    val player: Player get() = Player.DEFAULT
    val block: Text get() = GameValue.eventBlock()
    val blockFace: Text get() = GameValue.eventBlockFace()
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()
    val replacedBlock: Text get() = GameValue.eventReplacedBlock()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок сломал блок
 *
 * Выполняет код, когда игрок сломал блок.
 */
@Event("player_break_block")
class PlayerBreakBlockEvent {
    val player: Player get() = Player.DEFAULT
    val block: Text get() = GameValue.eventBlock()
    val blockFace: Text get() = GameValue.eventBlockFace()
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val blocksInvolved: List<Location> get() = GameValue.eventBlocksInvolved()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок выращивает дерево
 *
 * Выполняет код, когда игрок выращивает дерево или гриб.
 */
@Event("player_structure_grow")
class PlayerStructureGrowEvent {
    val player: Player get() = Player.DEFAULT
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val treeType: Text get() = GameValue.eventTreeType()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок получает информацию о блоке
 *
 * Выполняет код, когда игрок получает отладочную информацию о целевом блоке (F3 + I).
 */
@Event("player_query_block_info")
class PlayerQueryBlockInfoEvent {
    val player: Player get() = Player.DEFAULT
    val block: Text get() = GameValue.eventBlock()
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val queryInfo: Text get() = GameValue.eventQueryInfo()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_uery_info")
    external fun setQueryInfo(information: Text)
}

/**
 * Игрок машет рукой
 *
 * Выполняет код, когда игрок машет правой или левой рукой.
 */
@Event("player_arm_swing")
class PlayerArmSwingEvent {
    val player: Player get() = Player.DEFAULT
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок меняет руку
 *
 * Выполняет код, когда игрок перекладывает предмет из главной руки во второстепенную.
 */
@Event("player_swap_hands")
class PlayerSwapHandsEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок меняет слот
 *
 * Выполняет код, когда игрок меняет слот.
 */
@Event("player_change_slot")
class PlayerChangeSlotEvent {
    val player: Player get() = Player.DEFAULT
    val hotbarSlot: Double get() = GameValue.eventHotbarSlot()
    val oldItem: Item get() = GameValue.eventOldItem()
    val slot: Double get() = GameValue.eventSlot()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок передвигается
 *
 * Выполняет код, когда игрок передвигается с блока на блок.
 */
@Event("player_move")
class PlayerMoveEvent {
    val player: Player get() = Player.DEFAULT
    val fromLocation: Location get() = GameValue.eventFromLocation()
    val location: Location get() = GameValue.eventNewLocation()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_move_allowed")
    external fun setMoveAllowed(allowed: String)
}

/**
 * Игрок прыгает
 *
 * Выполняет код, когда игрок прыгает.
 */
@Event("player_jump")
class PlayerJumpEvent {
    val player: Player get() = Player.DEFAULT
    val fromLocation: Location get() = GameValue.eventFromLocation()
    val location: Location get() = GameValue.eventNewLocation()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_move_allowed")
    external fun setMoveAllowed(allowed: String)
}

/**
 * Игрок начинает красться
 *
 * Выполняет код, когда игрок начинает красться.
 */
@Event("player_sneak")
class PlayerSneakEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок перестал красться
 *
 * Выполняет код, когда игрок перестаёт красться.
 */
@Event("player_unsneak")
class PlayerUnsneakEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок телепортировался
 *
 * Выполняет код, когда игрок совершает телепортацию.
 */
@Event("player_teleport")
class PlayerTeleportEvent {
    val player: Player get() = Player.DEFAULT
    val fromLocation: Location get() = GameValue.eventFromLocation()
    val location: Location get() = GameValue.eventNewLocation()
    val teleportCause: Text get() = GameValue.eventTeleportCause()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок начал бежать
 *
 * Выполняет код, когда игрок начинает бежать.
 */
@Event("player_start_sprint")
class PlayerStartSprintEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок перестаёт бежать
 *
 * Выполняет код, когда игрок перестаёт бежать.
 */
@Event("player_stop_sprint")
class PlayerStopSprintEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок начинает лететь
 *
 * Выполняет код, когда игрок начинает лететь.
 */
@Event("player_start_flight")
class PlayerStartFlightEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок перестаёт лететь
 *
 * Выполняет код, когда игрок перестаёт лететь.
 */
@Event("player_stop_flight")
class PlayerStopFlightEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок использует 'Тягун'
 *
 * Выполняет код, когда игрок использует трезубец с зачарованием 'Тягун'.
 */
@Event("player_riptide")
class PlayerRiptideEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок спешился
 *
 * Выполняет код, когда игрок спешился с лодки, лошади или других существ.
 */
@Event("player_dismount")
class PlayerDismountEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок прыгает на лошади
 *
 * Выполняет код, когда игрок выполняет прыжок на лошади, осле или муле.
 */
@Event("player_horse_jump")
class PlayerHorseJumpEvent {
    val player: Player get() = Player.DEFAULT
    val fromLocation: Location get() = GameValue.eventFromLocation()
    val location: Location get() = GameValue.eventNewLocation()
    val power: Double get() = GameValue.eventPower()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок передвигается на транспорте
 *
 * Выполняет код, когда игрок нажимает на кнопки движения, сидя на транспорте.
 */
@Event("player_vehicle_move")
class PlayerVehicleMoveEvent {
    val player: Player get() = Player.DEFAULT
    val fromLocation: Location get() = GameValue.eventFromLocation()
    val inputList: List<Text> get() = GameValue.eventInputList()
    val location: Location get() = GameValue.eventNewLocation()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок прыгает на транспорте
 *
 * Выполняет код, когда игрок нажимает на кнопку прыжка, сидя на транспорте.
 */
@Event("player_vehicle_jump")
class PlayerVehicleJumpEvent {
    val player: Player get() = Player.DEFAULT
    val fromLocation: Location get() = GameValue.eventFromLocation()
    val inputList: List<Text> get() = GameValue.eventInputList()
    val location: Location get() = GameValue.eventNewLocation()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игроку не удалось передвинуться
 *
 * Выполняет код, когда игроку не удаётся передвинуться с места.
 */
@Event("player_fail_move")
class PlayerFailMoveEvent {
    val player: Player get() = Player.DEFAULT
    val failReason: Text get() = GameValue.eventFailMoveReason()
    val fromLocation: Location get() = GameValue.eventFromLocation()
    val location: Location get() = GameValue.eventNewLocation()

    @Action("game_set_event_move_allowed")
    external fun setMoveAllowed(allowed: String)
}

/**
 * Игрок открыл инвентарь
 *
 * Выполняет код, когда игроку открывается инвентарное меню.
 */
@Event("player_open_inventory")
class PlayerOpenInventoryEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок кликает в инвентаре
 *
 * Выполняет код, когда игрок кликает в инвентаре.
 */
@Event("player_click_inventory")
class PlayerClickInventoryEvent {
    val player: Player get() = Player.DEFAULT
    val hotbarSlot: Double get() = GameValue.eventHotbarSlot()
    val inventoryAction: Text get() = GameValue.eventInventoryAction()
    val clickType: Text get() = GameValue.eventInventoryClickType()
    val slot: Double get() = GameValue.eventSlot()
    val slotType: Text get() = GameValue.eventSlotType()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_target_slot")
    external fun setTargetSlot(target: Double)

    @Action("game_set_event_source_slot")
    external fun setSourceSlot(sourceSlot: Double)
}

/**
 * Игрок перетягивает предмет в инвентаре
 *
 * Выполняет код, когда игрок перетягивает предмет в инвентаре.
 */
@Event("player_drag_inventory")
class PlayerDragInventoryEvent {
    val player: Player get() = Player.DEFAULT
    val addedItems: Map<Double, Item> get() = GameValue.eventAddedItems()
    val dragType: Text get() = GameValue.eventDragType()
    val slotsInvolved: List<Double> get() = GameValue.eventSlotsInvolved()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок кликает в своём инвентаре
 *
 * Выполняет код, когда игрок кликает в своём инвентаре.
 */
@Event("player_click_own_inventory")
class PlayerClickOwnInventoryEvent {
    val player: Player get() = Player.DEFAULT
    val hotbarSlot: Double get() = GameValue.eventHotbarSlot()
    val inventoryAction: Text get() = GameValue.eventInventoryAction()
    val clickType: Text get() = GameValue.eventInventoryClickType()
    val slot: Double get() = GameValue.eventSlot()
    val slotType: Text get() = GameValue.eventSlotType()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_target_slot")
    external fun setTargetSlot(target: Double)

    @Action("game_set_event_source_slot")
    external fun setSourceSlot(sourceSlot: Double)
}

/**
 * Игрок крафтит предмет
 *
 * Выполняет код, когда игрок крафтит предмет.
 */
@Event("player_craft_item")
class PlayerCraftItemEvent {
    val player: Player get() = Player.DEFAULT
    val item: Item get() = GameValue.eventItem()
    val slot: Double get() = GameValue.eventSlot()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_item")
    external fun setItem(item: Item)
}

/**
 * Игрок поднял предмет
 *
 * Выполняет код, когда игрок поднимает предмет.
 */
@Event("player_pickup_item")
class PlayerPickupItemEvent {
    val player: Player get() = Player.DEFAULT
    val item: Item get() = GameValue.eventItem()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_item")
    external fun setItem(item: Item)
}

/**
 * Игрок поднял снаряд
 *
 * Выполняет код, когда игрок поднимает снаряд.
 */
@Event("player_pickup_projectile")
class PlayerPickupProjectileEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок поднял сферу опыта
 *
 * Выполняет код, когда игрок поднимает сферу опыта.
 */
@Event("player_pickup_experience")
class PlayerPickupExperienceEvent {
    val player: Player get() = Player.DEFAULT
    val experience: Double get() = GameValue.eventExperience()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_experience")
    external fun setExperience(experience: Double)
}

/**
 * Игрок приручает существо
 *
 * Выполняет код, когда игрок приручает существо.
 */
@Event("player_tame_entity")
class PlayerTameEntityEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок привязывает существо
 *
 * Выполняет код, когда игрок привязывает существо.
 */
@Event("player_leash_entity")
class PlayerLeashEntityEvent {
    val player: Player get() = Player.DEFAULT
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок начал следить за существом
 *
 * Выполняет код, когда игрок начал следить за существом в режиме наблюдателя.
 */
@Event("player_start_spectating_entity")
class PlayerStartSpectatingEntityEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок перестал следить за существом
 *
 * Выполняет код, когда игрок перестаёт следить за существом в режиме наблюдателя.
 */
@Event("player_stop_spectating_entity")
class PlayerStopSpectatingEntityEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок останавливает рост существа
 *
 * Выполняет код, когда игрок блокирует рост существа с помощью золотого одуванчика.
 */
@Event("player_toggle_entity_age_lock")
class PlayerToggleEntityAgeLockEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок кормит серного слайма предметом
 *
 * Выполняет код, когда игрок кормит серного слайма предметом.
 */
@Event("player_feed_sulfur_cube_item")
class PlayerFeedSulfurCubeItemEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок получает информацию о сущности
 *
 * Выполняет код, когда игрок получает отладочную информацию о целевой сущности (F3 + I).
 */
@Event("player_query_entity_info")
class PlayerQueryEntityInfoEvent {
    val player: Player get() = Player.DEFAULT
    val queryInfo: Text get() = GameValue.eventQueryInfo()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_uery_info")
    external fun setQueryInfo(information: Text)
}

/**
 * Игрок выбрасывает предмет
 *
 * Выполняет код, когда игрок выбрасывает предмет.
 */
@Event("player_drop_item")
class PlayerDropItemEvent {
    val player: Player get() = Player.DEFAULT
    val item: Item get() = GameValue.eventItem()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_item")
    external fun setItem(item: Item)
}

/**
 * Игрок употребляет предмет
 *
 * Выполняет код, когда игрок съедает или выпивает предмет.
 */
@Event("player_consume_item")
class PlayerConsumeItemEvent {
    val player: Player get() = Player.DEFAULT
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()
    val item: Item get() = GameValue.eventItem()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок ломает предмет
 *
 * Выполняет код, когда игрок ломает предмет.
 */
@Event("player_break_item")
class PlayerBreakItemEvent {
    val player: Player get() = Player.DEFAULT
}

/**
 * Игрок изменяет книгу
 *
 * Выполняет код, когда игрок редактирует текст или подписывает Книгу с пером.
 */
@Event("player_edit_book")
class PlayerEditBookEvent {
    val player: Player get() = Player.DEFAULT
    val item: Item get() = GameValue.eventItem()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок рыбачит
 *
 * Выполняет код, когда игрок рыбачит.
 */
@Event("player_fish")
class PlayerFishEvent {
    val player: Player get() = Player.DEFAULT
    val hookedEntity: Entity get() = Entity.DEFAULT
    val experience: Double get() = GameValue.eventExperience()
    val fishState: Text get() = GameValue.eventFishState()
    val item: Item get() = GameValue.eventItem()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_experience")
    external fun setExperience(experience: Double)
}

/**
 * Игрок перестаёт использовать предмет
 *
 * Выполняет код, когда игрок перестаёт использовать предмет.
 */
@Event("player_stop_using_item")
class PlayerStopUsingItemEvent {
    val player: Player get() = Player.DEFAULT
    val item: Item get() = GameValue.eventItem()
    val ticksHeldFor: Double get() = GameValue.eventTicksHeldFor()
}

/**
 * Игрок закрывает инвентарь
 *
 * Выполняет код, когда игрок закрывает инвентарь.
 */
@Event("player_close_inventory")
class PlayerCloseInventoryEvent {
    val player: Player get() = Player.DEFAULT
    val closeCause: Text get() = GameValue.eventCloseInventoryCause()
}

/**
 * Игрок получает урон
 *
 * Выполняет код, когда игрок получает урон.
 */
@Event("player_take_damage")
class PlayerTakeDamageEvent {
    val player: Player get() = Player.DEFAULT
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
 * Игрок ранит игрока
 *
 * Выполняет код, когда игрок ранит другого игрока.
 */
@Event("player_damage_player")
class PlayerDamagePlayerEvent {
    val player: Player get() = Player.DEFAULT
    val damage: Double get() = GameValue.eventDamage()
    val cause: Text get() = GameValue.eventDamageCause()
    val finalDamage: Double get() = GameValue.eventFinalDamage()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_damage")
    external fun setDamage(damage: Double)
}

/**
 * Игрок ранит существо
 *
 * Выполняет код, когда игрок ранит существо.
 */
@Event("player_damage_entity")
class PlayerDamageEntityEvent {
    val player: Player get() = Player.DEFAULT
    val victim: Entity get() = Entity.VICTIM
    val damager: Player get() = Player.DEFAULT
    val damage: Double get() = GameValue.eventDamage()
    val cause: Text get() = GameValue.eventDamageCause()
    val finalDamage: Double get() = GameValue.eventFinalDamage()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_damage")
    external fun setDamage(damage: Double)
}

/**
 * Игрок восстанавливает здоровье
 *
 * Выполняет код, когда игрок восстанавливает здоровье любым способом.
 */
@Event("player_heal")
class PlayerHealEvent {
    val player: Player get() = Player.DEFAULT
    val healAmount: Double get() = GameValue.eventHealAmount()
    val healCause: Text get() = GameValue.eventHealCause()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_heal")
    external fun setHeal(heal: Double)
}

/**
 * Игрок возрождается от тотема
 *
 * Выполняет код, когда игрок возрождается от Тотема бессмертия.
 */
@Event("player_resurrect")
class PlayerResurrectEvent {
    val player: Player get() = Player.DEFAULT
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Изменение уровня голода игрока
 *
 * Выполняет код, когда уровень голода игрока изменяется.
 */
@Event("player_food_level_change")
class PlayerFoodLevelChangeEvent {
    val player: Player get() = Player.DEFAULT
    val foodLevel: Double get() = GameValue.eventFoodLevel()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок стреляет
 *
 * Выполняет код, когда игрок стреляет из лука, арбалета.
 */
@Event("player_shot_bow")
class PlayerShotBowEvent {
    val player: Player get() = Player.DEFAULT
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()
    val item: Item get() = GameValue.eventItem()
    val power: Double get() = GameValue.eventPower()
    val projectileItem: Item get() = GameValue.eventProjectileItem()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок запускает снаряд
 *
 * Выполняет код, когда игрок запускает снаряд.
 */
@Event("player_launch_projectile")
class PlayerLaunchProjectileEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Попадание снаряда игрока
 *
 * Выполняет код, когда снаряд, запущенный игроком, попадает в блок, существо или другого игрока.
 */
@Event("player_projectile_hit")
class PlayerProjectileHitEvent {
    val player: Player get() = Player.DEFAULT
    val shooter: Player get() = Player.SHOOTER
    val projectile: Entity get() = Entity.PROJECTILE
    val block: Text get() = GameValue.eventBlock()
    val blockFace: Text get() = GameValue.eventBlockFace()
    val blockLocation: Location get() = GameValue.eventBlockLocation()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок собирается нанести урон сущности
 *
 * Выполняет код, когда игрок собирается нанести урон по сущности. Отмена события так же отменяет звуки удара.
 */
@Event("player_pre_attack_entity")
class PlayerPreAttackEntityEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок получает эффект от туманного зелья
 *
 * Выполняет код, когда игрок получает эффект от туманного зелья.
 */
@Event("player_imbue_potion_cloud")
class PlayerImbuePotionCloudEvent {
    val player: Player get() = Player.DEFAULT
    val newPotionEffect: Potion get() = GameValue.eventNewPotionEffect()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок умирает
 *
 * Выполняет код, когда игрок умирает не в результате ранения от другого игрока или сущности.
 */
@Event("player_death")
class PlayerDeathEvent {
    val player: Player get() = Player.DEFAULT
    val killer: Entity get() = Entity.KILLER
    val deathScreenMessage: Text get() = GameValue.eventDeathScreenMessage()
    val experience: Double get() = GameValue.eventExperience()
    val message: Text get() = GameValue.eventMessage()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_experience")
    external fun setExperience(experience: Double)
    @Action("game_hide_event_message")
    external fun hideMessage()
    @Action("game_set_event_death_screen_message")
    external fun setDeathScreenMessage(message: Text)
}

/**
 * Игрок убивает игрока
 *
 * Выполняет код, кода игрок убивает другого игрока.
 */
@Event("player_kill_player")
class PlayerKillPlayerEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок убивает моба
 *
 * Выполняет код, когда игрок убивает моба.
 */
@Event("player_kill_mob")
class PlayerKillMobEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок возрождается
 *
 * Выполняет код, когда игрок возрождается.
 */
@Event("player_respawn")
class PlayerRespawnEvent {
    val player: Player get() = Player.DEFAULT
}

/**
 * Игрок пишет сообщение в чат
 *
 * Выполняет код, когда игрок пишет сообщение в чат.
 */
@Event("player_chat")
class PlayerChatEvent {
    val player: Player get() = Player.DEFAULT
    val message: Text get() = GameValue.eventChatMessage()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок начинает ломать блок
 *
 * Выполняет код, когда игрок начинает ломать блок.
 */
@Event("block_damage")
class BlockDamageEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_damage")
    external fun setDamage(damage: Double)
}

/**
 * Игрок перестаёт ломать блок
 *
 * Выполняет код, когда игрок перестаёт ломать блок.
 */
@Event("block_damage_abort")
class BlockDamageAbortEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_set_event_damage")
    external fun setDamage(damage: Double)
}

/**
 * Игрок находит предмет в инвентаре
 *
 * Выполняет код, когда игрок находит предмет в инвентаре при помощи средней кнопки мыши.
 */
@Event("player_pick_item")
class PlayerPickItemEvent {
    val player: Player get() = Player.DEFAULT
    val hotbarSlot: Double get() = GameValue.eventHotbarSlot()
    val items: List<Item> get() = GameValue.eventItems()
    val slot: Double get() = GameValue.eventSlot()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_items")
    external fun setItems(vararg items: Item)
}

/**
 * Игрок заряжает арбалет
 *
 * Выполняет код, когда игрок заряжает арбалет.
 */
@Event("player_load_crossbow")
class PlayerLoadCrossbowEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок забирает предмет из печи
 *
 * Выполняет код, когда игрок забирает предмет из печи.
 */
@Event("player_furnace_extract")
class PlayerFurnaceExtractEvent {
    val player: Player get() = Player.DEFAULT
}

/**
 * Игрок истощается
 *
 * Выполняет код, когда игрок получает истощение.
 */
@Event("player_exhaustion")
class PlayerExhaustionEvent {
    val player: Player get() = Player.DEFAULT
    val exhaustionAmount: Double get() = GameValue.eventExhaustionAmount()
    val exhaustionReason: Text get() = GameValue.eventExhaustionReason()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок сменил вкладку в меню достижений
 *
 * Выполняет код, когда игрок переключается на другую вкладку в меню достижений или открывает меню достижений.
 */
@Event("player_open_advancements_tab")
class PlayerOpenAdvancementsTabEvent {
    val player: Player get() = Player.DEFAULT
    val advancementTabName: Text get() = GameValue.eventAdvancementTabName()
}

/**
 * Игрок закрыл меню достижений
 *
 * Выполняет код, когда игрок закрывает меню достижений.
 */
@Event("player_close_advancements_menu")
class PlayerCloseAdvancementsMenuEvent {
    val player: Player get() = Player.DEFAULT
}

/**
 * Игрок изменяет табличку
 *
 * Выполняет код, когда игрок изменяет текст таблички.
 */
@Event("player_sign_change")
class PlayerSignChangeEvent {
    val player: Player get() = Player.DEFAULT
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val signLines: List<Text> get() = GameValue.eventSignLines()
    val signSide: Text get() = GameValue.eventSignSide()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок чинит предмет
 *
 * Выполняет код, когда игрок чинит предмет с помощью зачарования "Починка".
 */
@Event("player_item_mend")
class PlayerItemMendEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок переименовывает предмет
 *
 * Выполняет код, когда игрок переименовывает предмет с помощью наковальни.
 */
@Event("player_anvil_rename_input")
class PlayerAnvilRenameInputEvent {
    val player: Player get() = Player.DEFAULT
    val renameInput: Text get() = GameValue.eventAnvilRenameInput()
    val inputList: List<Text> get() = GameValue.eventInputList()
}

/**
 * Игрок меняет местоположение
 *
 * Выполняет код, когда игрок меняет свое местоположение (в том числе, оставаясь на том же блоке).
 */
@Event("player_location_change")
class PlayerLocationChangeEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок поворачивается
 *
 * Выполняет код, когда игрок поворачивается (изменяет положение yaw или pitch)
 */
@Event("player_rotate")
class PlayerRotateEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок изменил вектор скорости
 *
 * Выполняет код, когда вектор скорости игрока изменяется.
 */
@Event("player_velocity")
class PlayerVelocityEvent {
    val player: Player get() = Player.DEFAULT
    val velocity: Vector get() = GameValue.eventVelocity()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_velocity")
    external fun setVelocity(velocity: Vector)
}

/**
 * Игрок отталкивается
 *
 * Выполняет код, когда игрок отталкивается.
 */
@Event("player_knockback")
class PlayerKnockbackEvent {
    val player: Player get() = Player.DEFAULT
    val knockbackCause: Text get() = GameValue.eventKnockbackCause()
    val knockbackType: Text get() = GameValue.eventKnockbackEventType()
    val knockbackVector: Vector get() = GameValue.eventKnockbackVector()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_knockback_vector")
    external fun setKnockbackVector(knockback: Vector)
}

/**
 * Игрок зачаровывает предмет
 *
 * Выполняет код, когда игрок зачаровывает предмет.
 */
@Event("player_enchant_item")
class PlayerEnchantItemEvent {
    val player: Player get() = Player.DEFAULT
    val enchantmentHint: Text get() = GameValue.eventEnchantmentHint()
    val enchantmentLevelHint: Double get() = GameValue.eventEnchantmentLevelHint()
    val enchantmentsToAdd: Map<Text, Double> get() = GameValue.eventEnchantmentsToAdd()
    val experience: Double get() = GameValue.eventExperience()
    val slot: Double get() = GameValue.eventSlot()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_experience")
    external fun setExperience(experience: Double)
}

/**
 * Игрок загорелся
 *
 * Выполняет код, когда игрок загорается.
 */
@Event("player_combust")
class PlayerCombustEvent {
    val player: Player get() = Player.DEFAULT
    val combustDuration: Double get() = GameValue.eventCombustDuration()
    val combustReason: Text get() = GameValue.eventCombustReason()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_combust_duration")
    external fun setCombustDuration(duration: Double)
}

/**
 * Игрок использует выбор предмета на блоке
 *
 * Выполняет код, когда игрок использует выбор предмета на блоке.
 */
@Event("player_pick_block")
class PlayerPickBlockEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок меняет состояние сокровищницы
 *
 * Выполняет код, когда игрок меняет состояние сокровищницы.
 */
@Event("player_vault_change_state")
class PlayerVaultChangeStateEvent {
    val player: Player get() = Player.DEFAULT
    val newVaultState: Text get() = GameValue.eventNewVaultState()
    val oldVaultState: Text get() = GameValue.eventOldVaultState()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок использует выбор предмета на сущности
 *
 * Выполняет код, когда игрок использует выбор предмета на сущности.
 */
@Event("player_pick_entity")
class PlayerPickEntityEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок меняет экипировку
 *
 * Выполняет код, когда экипировка игрока меняется.
 */
@Event("player_equipment_changed")
class PlayerEquipmentChangedEvent {
    val player: Player get() = Player.DEFAULT
    val newEquipments: Map<Text, Item> get() = GameValue.eventNewEquipments()
    val oldEquipments: Map<Text, Item> get() = GameValue.eventOldEquipments()
}

/**
 * Игрок использует предмет с задержкой
 *
 * Выполняет код, когда игрок использует предмет, который имеет задержку между использованиями.
 */
@Event("player_item_cooldown")
class PlayerItemCooldownEvent {
    val player: Player get() = Player.DEFAULT
    val itemCooldown: Double get() = GameValue.eventItemCooldown()
    val itemCooldownGroup: Text get() = GameValue.eventItemCooldownGroup()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_item_cooldown")
    external fun setItemCooldown(cooldown: Double)
}

/**
 * Игрок получает задержку для группы предметов
 *
 * Выполняет код, когда игрок получает задержку для группы предметов.
 */
@Event("player_item_group_cooldown")
class PlayerItemGroupCooldownEvent {
    val player: Player get() = Player.DEFAULT
    val itemCooldown: Double get() = GameValue.eventItemCooldown()
    val itemCooldownGroup: Text get() = GameValue.eventItemCooldownGroup()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_item_cooldown")
    external fun setItemCooldown(cooldown: Double)
}

/**
 * Игрок меняет нажатые клавиши передвижения
 *
 * Выполняет код, когда игрок меняет нажатые клавиши передвижения.
 */
@Event("player_input_event")
class PlayerInputEvent {
    val player: Player get() = Player.DEFAULT
    val inputList: List<Text> get() = GameValue.eventInputList()
}

/**
 * Игрок начинает лететь на элитрах
 *
 * Выполняет код, когда игрок начинает лететь на элитрах.
 */
@Event("player_start_gliding")
class PlayerStartGlidingEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок перестаёт лететь на элитрах
 *
 * Выполняет код, когда игрок перестаёт лететь на элитрах.
 */
@Event("player_stop_gliding")
class PlayerStopGlidingEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок вызывает кастомный клик
 *
 * Выполняет код, когда игрок вызывает кастомный клик в диалоговом окне или чате.
 */
@Event("player_custom_click")
class PlayerCustomClickEvent {
    val player: Player get() = Player.DEFAULT
    val eventCustomClickDialogViewData: Any get() = GameValue.eventCustomClickDialogViewData()
    val eventCustomClickKey: Text get() = GameValue.eventCustomClickKey()
}

/**
 * Игрок запросил меню смены режима игры
 *
 * Выполняет код, когда игрок запрашивает меню смены режима игры.
 */
@Event("player_ask_gamemode_change")
class PlayerAskGamemodeChangeEvent {
    val player: Player get() = Player.DEFAULT
    val gamemode: Text get() = GameValue.eventGamemode()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_gamemode")
    external fun setGamemode(gamemode: String)
}

/**
 * Игрок получает результат
 *
 * Выполняет код, когда игрок получает результат в инвентаре.
 */
@Event("player_prepare_result")
class PlayerPrepareResultEvent {
    val player: Player get() = Player.DEFAULT
}

/**
 * Игрок выбирает зачарование
 *
 * Выполняет код, когда игрок получает результат в чародейском столе, получая возможность выбора зачарования.
 */
@Event("player_prepare_item_enchant")
class PlayerPrepareItemEnchantEvent {
    val player: Player get() = Player.DEFAULT
    val enchantmentBonus: Double get() = GameValue.eventEnchantmentBonus()
    val enchantmentOffers: List<Any> get() = GameValue.eventEnchantmentOffers()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок выложил крафт
 *
 * Выполняет код, когда игрок выкладывает крафт какого-нибудь предмета.
 */
@Event("player_prepare_item_craft")
class PlayerPrepareItemCraftEvent {
    val player: Player get() = Player.DEFAULT
    val items: List<Item> get() = GameValue.eventItems()

    @Action("game_set_event_items")
    external fun setItems(vararg items: Item)
}

/**
 * Игрок совершает транзакцию
 *
 * Выполняет код, когда игрок совершает транзакцию в изумрудах.
 */
@Event("player_currency_transaction")
class PlayerCurrencyTransactionEvent {
    val player: Player get() = Player.DEFAULT
    val transactionAmount: Text get() = GameValue.currencyTransactionAmount()
    val transactionReason: Text get() = GameValue.currencyTransactionReason()
    val transactionResult: Text get() = GameValue.currencyTransactionResult()
}

/**
 * Античит засёк игрока
 *
 * Выполняет код, когда античит засёк игрока на читах. Срабатывает только в рекомендованных мирах.
 */
@Event("player_anticheat_flag")
class PlayerAnticheatFlagEvent {
    val player: Player get() = Player.DEFAULT
    val check: Text get() = GameValue.anticheatCheck()
    val violations: Double get() = GameValue.anticheatViolations()
}

/**
 * Скин игрока изменился
 *
 * Выполняет код, когда скин игрока меняется.
 */
@Event("player_skin_change")
class PlayerSkinChangeEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок заставляет блок выбросить лут
 *
 * Выполняет код, когда игрок заставляет блок выбросить лут.
 */
@Event("player_block_dispense_loot")
class PlayerBlockDispenseLootEvent {
    val player: Player get() = Player.DEFAULT
    val items: List<Item> get() = GameValue.eventItems()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_items")
    external fun setItems(vararg items: Item)
}

/**
 * Игрок взаимодействует с цветочным горшком
 *
 * Выполняет код, когда игрок взаимодействует с цветочным горшком.
 */
@Event("player_flowerpot_manipulate")
class PlayerFlowerpotManipulateEvent {
    val player: Player get() = Player.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Игрок повреждает наковальню
 *
 * Выполняет код, когда игрок повреждает наковальню.
 */
@Event("player_anvil_damaged")
class PlayerAnvilDamagedEvent {
    val player: Player get() = Player.DEFAULT
    val anvilDamageState: Text get() = GameValue.eventAnvilDamageState()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_damage")
    external fun setDamage(damage: Double)

    @Action("game_set_event_anvil_damage_state")
    external fun setAnvilDamageState(damageState: String)
}

/**
 * Игрок запросил статистику
 *
 * Выполняет код, когда игрок открывает меню "Статистика".
 */
@Event("player_request_stats")
class PlayerRequestStatsEvent {
    val player: Player get() = Player.DEFAULT
}

/**
 * Обновление статуса поломки блока
 *
 * Выполняет код, когда игрок обновляет статус поломки блока.
 */
@Event("player_block_break_progress_update")
class PlayerBlockBreakProgressUpdateEvent {
    val player: Player get() = Player.DEFAULT
    val breakProgress: Double get() = GameValue.eventBlockBreakProgress()
}

/**
 * Игрок вырезает блок
 *
 * Выполняет код, когда игрок вырезает блок ножницами.
 */
@Event("player_shear_block")
class PlayerShearBlockEvent {
    val player: Player get() = Player.DEFAULT
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()
    val items: List<Item> get() = GameValue.eventItems()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_items")
    external fun setItems(vararg items: Item)
}

/**
 * Игрок собирает урожай
 *
 * Выполняет код, когда игрок собирает урожай не ломая блок.
 */
@Event("player_harvest_block")
class PlayerHarvestBlockEvent {
    val player: Player get() = Player.DEFAULT
    val items: List<Item> get() = GameValue.eventItems()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_items")
    external fun setItems(vararg items: Item)
}

/**
 * Игрок отвязал сущность
 *
 * Выполняет код, когда игрок отвязывает сущность от поводка.
 */
@Event("player_unleash_entity")
class PlayerUnleashEntityEvent {
    val player: Player get() = Player.DEFAULT
    val entity: Entity get() = Entity.DEFAULT
    val unleashReason: Text get() = GameValue.eventEntityUnleashReason()
    val equipmentSlot: Text get() = GameValue.eventEquipmentSlot()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_should_drop_leash")
    external fun setShouldDropLeash(shouldDropLeash: String)
}

/**
 * Игрок повреждает предмет
 *
 * Выполняет код, когда предмет в инвентаре игрока ломается.
 */
@Event("player_damage_item")
class PlayerDamageItemEvent {
    val player: Player get() = Player.DEFAULT
    val item: Item get() = GameValue.eventItem()
    val itemDamage: Double get() = GameValue.eventItemDamage()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_damage")
    external fun setDamage(damage: Double)

    @Action("game_set_event_item")
    external fun setItem(item: Item)
}

/**
 * Слот инвентаря игрока обновляется
 *
 * Выполняет код, когда обновляется предмет в слоте инвентаря игрока.
 */
@Event("player_inventory_slot_change")
class PlayerInventorySlotChangeEvent {
    val player: Player get() = Player.DEFAULT
    val oldItem: Item get() = GameValue.eventOldItem()
}
