package justmc.event

import justmc.annotation.Action
import justmc.annotation.Slot
import justmc.value.*

enum class AnvilRepairCostType {
    REPAIR_COST,
    REPAIR_ITEM_COUNT_COST,
    MAXIMUM_REPAIR_COST
}

enum class AnvilDamageState {
    FULL,
    CHIPPED,
    DAMAGED,
    BROKEN
}

enum class DamageCause {
    KILL,
    WORLD_BORDER,
    CONTACT,
    ENTITY_ATTACK,
    ENTITY_SWEEP_ATTACK,
    PROJECTILE,
    SUFFOCATION,
    FALL,
    FIRE,
    FIRE_TICK,
    MELTING,
    LAVA,
    DROWNING,
    BLOCK_EXPLOSION,
    ENTITY_EXPLOSION,
    VOID,
    LIGHTNING,
    SUICIDE,
    STARVATION,
    POISON,
    MAGIC,
    WITHER,
    FALLING_BLOCK,
    THORNS,
    DRAGON_BREATH,
    CUSTOM,
    FLY_INTO_WALL,
    HOT_FLOOR,
    CAMPFIRE,
    CRAMMING,
    DRYOUT,
    FREEZE,
    SONIC_BOOM
}

enum class HealCause {
    REGEN,
    SATIATED,
    EATING,
    ENDER_CRYSTAL,
    MAGIC,
    MAGIC_REGEN,
    WITHER_SPAWN,
    WITHER,
    CUSTOM
}

enum class IgniteCause {
    LAVA,
    FLINT_AND_STEEL,
    SPREAD,
    LIGHTNING,
    SUFFOCATION,
    FALL,
    FIREBALL,
    ENDER_CRYSTAL,
    EXPLOSION,
    ARROW
}

enum class Instrument {
    PIANO,
    BASS_DRUM,
    SNARE_DRUM,
    STICKS,
    BASS_GUITAR,
    FLUTE,
    BELL,
    GUITAR,
    CHIME,
    XYLOPHONE,
    IRON_XYLOPHONE,
    COW_BELL,
    DIDGERIDOO,
    BIT,
    BANJO,
    PLING,
    ZOMBIE,
    SKELETON,
    CREEPER,
    DRAGON,
    WITHER_SKELETON,
    PIGLIN,
    CUSTOM_HEAD,
    TRUMPET,
    TRUMPET_EXPOSED,
    TRUMPET_OXIDIZED,
    TRUMPET_WEATHERED
}

enum class EventInputType {
    FORWARD,
    BACKWARDS,
    LEFT,
    RIGHT,
    JUMP,
    SNEAK,
    SPRINT
}

enum class Gamemode {
    CREATIVE,
    SURVIVAL,
    ADVENTURE,
    SPECTATOR
}

enum class ComparisonMode {
    IGNORE_STACK_SIZE,
    IGNORE_DURABILITY_AND_STACK_SIZE,
    EXACTLY,
    TYPE_ONLY
}

/**
 * Действия над текущим событием (game_set_event_..., game_cancel_event и т.д.).
 */
object EventActions {

    /** Отмена события */
    @Action("game_cancel_event")
    external fun cancel()

    /** Возврат события */
    @Action("game_uncancel_event")
    external fun uncancel()

    /** Убрать сообщение события */
    @Action("game_hide_event_message")
    external fun hideMessage(hide: Boolean = true)

    /** Установить урон события */
    @Action("game_set_event_damage")
    external fun setDamage(damage: Double)

    /** Установить лечение события */
    @Action("game_set_event_heal")
    external fun setHeal(heal: Double)

    /** Установить опыт события */
    @Action("game_set_event_experience")
    external fun setExperience(experience: Double)

    /** Установить снаряд события */
    @Action("game_set_event_projectile")
    external fun setProjectile(projectile: Item, name: Text? = null, particle: Particle? = null)

    /** Установить звук события */
    @Action("game_set_event_sound")
    external fun setSound(sound: Sound)

    /** Установить предмет события */
    @Action("game_set_event_item")
    external fun setItem(item: Item)

    /** Установить предметы события */
    @Action("game_set_event_items")
    external fun setItems(vararg items: Item)

    /** Установить теги в полученную информацию */
    @Action("game_set_event_uery_info")
    external fun setQueryInfo(information: Text)

    /** Разрешить передвижение */
    @Action("game_set_event_move_allowed")
    external fun setMoveAllowed(allowed: Boolean = true)

    /** Установить конечный слот события */
    @Action("game_set_event_target_slot")
    external fun setTargetSlot(target: Double)

    /** Установить начальный слот события */
    @Action("game_set_event_source_slot")
    external fun setSourceSlot(sourceSlot: Double)

    /** Установить истощение события */
    @Action("game_set_event_exhaustion")
    external fun setExhaustion(exhaustion: Double)

    /** Установить вектор отталкивания события */
    @Action("game_set_event_knockback_vector")
    external fun setKnockback(@Slot("knockback") vector: Vector)

    /** Установить вектор скорости события */
    @Action("game_set_event_velocity")
    external fun setVelocity(velocity: Vector)

    /** Установить время горения события */
    @Action("game_set_event_combust_duration")
    external fun setCombustDuration(duration: Double)

    /** Установить задержку предмета события */
    @Action("game_set_event_item_cooldown")
    external fun setItemCooldown(cooldown: Double)

    /** Установить сообщение при смерти */
    @Action("game_set_event_death_screen_message")
    external fun setDeathScreenMessage(message: Text)

    /** Установить режим игры события */
    @Action("game_set_event_gamemode")
    external fun setGamemode(gamemode: Gamemode)

    /** Установить стоимость действия наковальни */
    @Action("game_set_event_anvil_repair_cost")
    external fun setAnvilRepairCost(
        repairCost: Double,
        repairCostType: AnvilRepairCostType = AnvilRepairCostType.REPAIR_COST,
        bypassCost: Boolean = false
    )

    /** Установить состояние поломки наковальни */
    @Action("game_set_event_anvil_damage_state")
    external fun setAnvilDamageState(damageState: AnvilDamageState)

    /** Установить предлагаемые зачарования события */
    @Action("game_set_event_enchantment_offers")
    external fun setEnchantmentOffers(
        enchantments: Map<Item, Double>,
        levels: List<Double>,
        costs: List<Double>
    )

    /** Установить создание частиц события */
    @Action("game_set_event_should_play_effect")
    external fun setShouldPlayEffect(shouldPlayEffect: Boolean = true)

    /** Установить выпадение поводка */
    @Action("game_set_event_should_drop_leash")
    external fun setShouldDropLeash(shouldDropLeash: Boolean = true)

    // --- Условия событий ---

    /** Событие отменено */
    @Action("if_game_event_is_canceled")
    external fun isCanceled(): Boolean

    /** Атака была критической */
    @Action("if_game_event_attack_is_critical")
    external fun isCriticalAttack(): Boolean

    /** Блок события равен */
    @Action("if_game_event_block_equals")
    external fun blockEquals(vararg blocks: Item, locations: List<Location> = emptyList()): Boolean

    /** Предмет события равен */
    @Action("if_game_event_item_equals")
    external fun itemEquals(
        vararg items: Item,
        comparisonMode: ComparisonMode = ComparisonMode.EXACTLY
    ): Boolean

    /** Источник урона события равен */
    @Action("if_game_damage_cause_equals")
    external fun damageCauseEquals(cause: DamageCause): Boolean

    /** Источник исцеления равен */
    @Action("if_game_heal_cause_equals")
    external fun healCauseEquals(healCause: HealCause): Boolean

    /** Источник огня равен */
    @Action("if_game_ignite_cause_equals")
    external fun igniteCauseEquals(cause: IgniteCause): Boolean

    /** Инструмент равен */
    @Action("if_game_instrument_equals")
    external fun instrumentEquals(instrument: Instrument): Boolean

    /** Клавиша передвижения равна */
    @Action("if_game_event_has_input")
    external fun hasInput(inputType: EventInputType): Boolean

    /** Рост остановлен */
    @Action("if_game_event_is_age_locked")
    external fun isAgeLocked(): Boolean
}

typealias EventAction = EventActions