package justmc.event

import justmc.annotation.*
import justmc.entity.Entity
import justmc.value.*

/**
 * Запуск мира
 *
 * Выполняет код в момент запуска мира в режиме игры.
 */
@Event("world_start")
class WorldStartEvent 
/**
 * Остановка мира
 *
 * Выполняет код в момент остановки режима игры в мире.
 */
@Event("world_stop")
class WorldStopEvent 
/**
 * Пропуск времени
 *
 * Выполняет код, если произошёл пропуск времени.
 */
@Event("time_skip")
class TimeSkipEvent {
    val amount: Double get() = GameValue.eventTimeSkipAmount()
    val reason: Text get() = GameValue.eventTimeSkipReason()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Ответ от сервера
 *
 * Выполняет код, когда сервер, на который был отправлен веб-запрос, отвечает.
 */
@Event("world_web_response")
class WorldWebResponseEvent {
    val headers: Map<Text, Text> get() = GameValue.responseHeaders()
    val url: Text get() = GameValue.url()
    val response: Text get() = GameValue.urlResponse()
    val responseCode: Double get() = GameValue.urlResponseCode()
}

/**
 * Блок поджигается
 *
 * Выполняет код, когда блок поджигается.
 */
@Event("block_ignite")
class BlockIgniteEvent {
    val block: Text get() = GameValue.eventBlock()
    val blockLocation: Location get() = GameValue.eventBlockLocation()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сгорание блока
 *
 * Выполняет код в момент сгорания блока.
 */
@Event("block_burn")
class BlockBurnEvent {
    val block: Text get() = GameValue.eventBlock()
    val blockLocation: Location get() = GameValue.eventBlockLocation()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Исчезновение блока
 *
 * Выполняет код, когда блок исчезает, к примеру, когда тает лёд или снег, затухает огонь или засыхает коралл.
 */
@Event("block_fade")
class BlockFadeEvent {
    val block: Text get() = GameValue.eventBlock()
    val blockLocation: Location get() = GameValue.eventBlockLocation()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Поршень выдвигается
 *
 * Выполняет код, когда поршень выдвигает блок.
 */
@Event("block_piston_extend")
class BlockPistonExtendEvent {
    val blockFace: Text get() = GameValue.eventBlockFace()
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val blocksInvolved: List<Location> get() = GameValue.eventBlocksInvolved()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Поршень втягивается
 *
 * Выполняет код, когда поршень втягивает блок.
 */
@Event("block_piston_retract")
class BlockPistonRetractEvent {
    val blockFace: Text get() = GameValue.eventBlockFace()
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val blocksInvolved: List<Location> get() = GameValue.eventBlocksInvolved()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Подрыв динамита
 *
 * Выполняет код, когда блок динамита поджигается.
 */
@Event("tnt_prime")
class TntPrimeEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Опадание листьев
 *
 * Выполняет код, когда листья опадают.
 */
@Event("leaves_decay")
class LeavesDecayEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Дерево вырастает
 *
 * Выполняет код, когда дерево или гриб вырастает.
 */
@Event("structure_grow")
class StructureGrowEvent {
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val treeType: Text get() = GameValue.eventTreeType()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Рост блока
 *
 * Выполняет код, когда блок вырастает.
 */
@Event("block_grow")
class BlockGrowEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Перемещение блока
 *
 * Выполняет код, когда блок перемещается.
 */
@Event("block_flow")
class BlockFlowEvent {
    val block: Text get() = GameValue.eventBlock()
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val fromLocation: Location get() = GameValue.eventFromLocation()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Блок взрывается
 *
 * Выполняет код, когда блок создаёт взрыв.
 */
@Event("block_explode")
class BlockExplodeEvent {
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val blocksInvolved: List<Location> get() = GameValue.eventBlocksInvolved()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Удобрение блока
 *
 * Выполняет код, когда блок удобряется.
 */
@Event("block_fertilize")
class BlockFertilizeEvent {
    val block: Text get() = GameValue.eventBlock()
    val blockLocation: Location get() = GameValue.eventBlockLocation()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Блок активируется
 *
 * Выполняет код, когда блок активируется редстоуном.
 */
@Event("redstone_level_change")
class RedstoneLevelChangeEvent 
/**
 * Завершение зельеварения
 *
 * Выполняет код, когда зельеварение в блоке заканчивается.
 */
@Event("brew_complete")
class BrewCompleteEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Генерация блока
 *
 * Выполняет код, когда блок генерируется впоследствии взаимодействия блоков.
 */
@Event("block_form")
class BlockFormEvent {
    val block: Text get() = GameValue.eventBlock()
    val blockLocation: Location get() = GameValue.eventBlockLocation()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Распространение блока
 *
 * Выполняет код, когда блок распространяется.
 */
@Event("block_spread")
class BlockSpreadEvent {
    val block: Text get() = GameValue.eventBlock()
    val blockLocation: Location get() = GameValue.eventBlockLocation()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Генерация блока из-за сущности
 *
 * Выполняет код, когда блок генерируется впоследствии взаимодействия блоков и сущностей.
 */
@Event("block_form_by_entity")
class BlockFormByEntityEvent {
    val entity: Entity get() = Entity.DEFAULT

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Создание портала
 *
 * Выполняет код, когда в мире создаётся портал.
 */
@Event("portal_create")
class PortalCreateEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Звон колокола
 *
 * Выполняет код, когда в мире звонит колокол.
 */
@Event("bell_ring")
class BellRingEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Проигрывание звука нотным блоком
 *
 * Выполняет код, когда в мире нотный блок проигрывает звук.
 */
@Event("note_play")
class NotePlayEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Блок выбрасывает предмет
 *
 * Выполняет код, когда блок выбрасывает предмет.
 */
@Event("dispenser_dispense_item")
class DispenserDispenseItemEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Раздатчик надевает броню
 *
 * Выполняет код, когда раздатчик надевает броню на сущность.
 */
@Event("dispenser_equip_armor")
class DispenserEquipArmorEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Изменение уровня воды
 *
 * Выполняет код, когда изменяется уровень воды в блоке.
 */
@Event("fluid_level_change")
class FluidLevelChangeEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Губка впитывает воду
 *
 * Выполняет код, когда губка впитывает воду.
 */
@Event("sponge_absorb")
class SpongeAbsorbEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Воронка подбирает предмет
 *
 * Выполняет код, когда воронка подбирает предмет.
 */
@Event("hopper_pickup_item")
class HopperPickupItemEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Скалк цветёт
 *
 * Выполняет код, когда скалк цветёт.
 */
@Event("sculk_bloom")
class SculkBloomEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Печь начала плавку
 *
 * Выполняет код, когда печь начинает плавку.
 */
@Event("furnace_start_smelt")
class FurnaceStartSmeltEvent 
/**
 * Печь закончила плавку
 *
 * Выполняет код, когда печь заканчивает плавку.
 */
@Event("furnace_smelt")
class FurnaceSmeltEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Печь использует топливо
 *
 * Выполняет код, когда печь использует предмет как топливо.
 */
@Event("furnace_burn")
class FurnaceBurnEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Ошибка веб-запроса
 *
 * Выполняет код, если не удалось получить ответ на веб-запрос.
 */
@Event("world_web_exception")
class WorldWebExceptionEvent 
/**
 * Грядка меняет статус влажности
 *
 * Выполняет код, когда блок грядки становится мокрым или высыхает.
 */
@Event("moisture_change")
class MoistureChangeEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сокровищница показывает предмет
 *
 * Выполняет код, когда блок сокровищницы показывает предмет.
 */
@Event("vault_display_item")
class VaultDisplayItemEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сборщик создаёт предмет
 *
 * Выполняет код, когда сборщик создаёт предмет.
 */
@Event("crafter_craft")
class CrafterCraftEvent {
    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Сокровищница меняет состояние
 *
 * Выполняет код, когда сокровищница меняет своё состояние.
 */
@Event("vault_change_state")
class VaultChangeStateEvent {
    val newVaultState: Text get() = GameValue.eventNewVaultState()
    val oldVaultState: Text get() = GameValue.eventOldVaultState()

    @Action("game_cancel_event")
    external fun cancel()
}

/**
 * Блок выбрасывает лут
 *
 * Выполняет код, когда блок выбрасывает лут.
 */
@Event("block_dispense_loot")
class BlockDispenseLootEvent {
    val items: List<Item> get() = GameValue.eventItems()

    @Action("game_cancel_event")
    external fun cancel()

    @Action("game_set_event_items")
    external fun setItems(vararg items: Item)
}

/**
 * Маяк активирован
 *
 * Выполняет код, когда активируется маяк.
 */
@Event("beacon_activate")
class BeaconActivateEvent 
/**
 * Маяк деактивирован
 *
 * Выполняет код, когда деактивируется маяк.
 */
@Event("beacon_deactivate")
class BeaconDeactivateEvent 
/**
 * Блок ломает блок
 *
 * Выполняет код, когда блок (жидкость или поршень) ломает другой блок.
 */
@Event("block_break_block")
class BlockBreakBlockEvent {
    val block: Text get() = GameValue.eventBlock()
    val blockFace: Text get() = GameValue.eventBlockFace()
    val blockLocation: Location get() = GameValue.eventBlockLocation()
    val blocksInvolved: List<Location> get() = GameValue.eventBlocksInvolved()
    val items: List<Item> get() = GameValue.eventItems()

    @Action("game_set_event_items")
    external fun setItems(vararg items: Item)
}

/**
 * Блок не смог выбросить предмет
 *
 * Выполняет код, когда блок не может выбросить предмет.
 */
@Event("block_failed_dispense")
class BlockFailedDispenseEvent 
/**
 * Чанк загружен
 *
 * Выполняет код, когда чанк загружается.
 */
@Event("chunk_load")
class ChunkLoadEvent 
/**
 * Чанк выгружен
 *
 * Выполняет код, когда чанк выгружается.
 */
@Event("chunk_unload")
class ChunkUnloadEvent 
/**
 * Мир разморозился
 *
 * Выполняет код, когда мир размораживается после возникновения критической ошибки.
 */
@Event("world_reload")
class WorldReloadEvent 