package justmc

import justmc.value.Location
import justmc.annotation.*

enum class DistanceCompareMode {
    NEAREST, FARTHEST
}

enum class EventTargetType {
    DEFAULT, KILLER, DAMAGER, VICTIM, SHOOTER, PROJECTILE
}

enum class FluidCollisionMode {
    NEVER, SOURCE_ONLY, ALWAYS
}

/**
 * Управление выборкой игроков и сущностей JustMC (селектор).
 */
object Select {

    // --- 1. Выбор по умолчанию ---
    @Action("select_default_player")
    external fun defaultPlayer()

    @Action("select_default_entity")
    external fun defaultEntity()

    // --- 2. Случайные цели ---
    @Action("select_random_player")
    external fun randomPlayer()

    @Action("select_random_mob")
    external fun randomMob()

    @Action("select_random_entity")
    external fun randomEntity()

    // --- 3. Все цели ---
    @Action("select_all_players")
    external fun allPlayers()

    @Action("select_all_mobs")
    external fun allMobs()

    @Action("select_all_entities")
    external fun allEntities()

    // --- 4. Выбор по условию ---
    @Action("select_player_by_conditional")
    external fun playerByCondition(condition: () -> Boolean)

    @Action("select_entity_by_conditional")
    external fun entityByCondition(condition: () -> Boolean)

    // --- 5. Последние появившиеся ---
    @Action("select_last_player")
    external fun lastPlayer()

    @Action("select_last_mob")
    external fun lastMob()

    @Action("select_last_entity")
    external fun lastEntity()

    // --- 6. Роли в событии ---
    @Action("select_killer")
    external fun killer()

    @Action("select_damager")
    external fun damager()

    @Action("select_shooter")
    external fun shooter()

    @Action("select_projectile")
    external fun projectile()

    @Action("select_victim")
    external fun victim()

    // --- 7. По имени / UUID ---
    @Action("select_player_by_name")
    external fun playerByName(nameOrUuid: String)

    @Action("select_mob_by_name")
    external fun mobByName(nameOrUuid: String)

    @Action("select_entity_by_name")
    external fun entityByName(nameOrUuid: String)

    // --- 8. Фильтрация текущей выборки ---
    @Action("select_filter_randomly")
    external fun filterRandomly(size: Double)
    inline fun filterRandomly(size: Int) = filterRandomly(size.toDouble())

    @Action("select_filter_by_conditional")
    external fun filterByCondition(condition: () -> Boolean)

    @Action("select_filter_by_distance")
    external fun filterByDistance(
        location: Location,
        selectionSize: Double,
        @Slot("ignore_y_axis") ignoreYAxis: Boolean = false,
        compareMode: DistanceCompareMode = DistanceCompareMode.NEAREST
    )
    inline fun filterByDistance(
        location: Location,
        selectionSize: Int,
        ignoreYAxis: Boolean = false,
        compareMode: DistanceCompareMode = DistanceCompareMode.NEAREST
    ) = filterByDistance(location, selectionSize.toDouble(), ignoreYAxis, compareMode)

    @Action("select_invert")
    external fun invert()

    @Action("select_filter_by_raycast", returns = ["variable"])
    external fun filterByRaycast(
        origin: Location,
        maxDistance: Double,
        raySize: Double = 0.1,
        selectionSize: Double = 1.0,
        considerBlocks: Boolean = true,
        ignorePassableBlocks: Boolean = false,
        fluidCollisionMode: FluidCollisionMode = FluidCollisionMode.NEVER
    ): Location

    @Action("select_reset")
    external fun reset()

    @Action("select_event_target")
    external fun eventTarget(selectionType: EventTargetType)

    // --- 9. Добавление к существующей выборке (Add) ---
    @Action("select_add_event_target")
    external fun addEventTarget(selectionType: EventTargetType)

    @Action("select_add_random_player")
    external fun addRandomPlayer()

    @Action("select_add_random_mob")
    external fun addRandomMob()

    @Action("select_add_random_entity")
    external fun addRandomEntity()

    @Action("select_add_last_mob")
    external fun addLastMob()

    @Action("select_add_last_entity")
    external fun addLastEntity()

    @Action("select_add_player_by_name")
    external fun addPlayerByName(nameOrUuid: String)
    inline fun addPlayersByName(nameOrUuid: String) = addPlayerByName(nameOrUuid)

    @Action("select_add_mob_by_name")
    external fun addMobByName(nameOrUuid: String)

    @Action("select_add_entity_by_name")
    external fun addEntityByName(nameOrUuid: String)

    @Action("select_add_all_players")
    external fun addAllPlayers()

    @Action("select_add_all_mobs")
    external fun addAllMobs()

    @Action("select_add_all_entities")
    external fun addAllEntities()

    @Action("select_add_player_by_conditional")
    external fun addPlayerByCondition(condition: () -> Boolean)

    @Action("select_add_entity_by_conditional")
    external fun addEntityByCondition(condition: () -> Boolean)
}
