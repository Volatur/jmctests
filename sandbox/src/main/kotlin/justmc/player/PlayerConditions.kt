package justmc.player

import justmc.annotation.*
import justmc.value.*
import kotlin.*

/**
 * Имеет цвета в чате
 * Проверяет, включена ли настройка "Цвета в чате" у игрока.
 */
@Action("if_player_chat_colors_enabled")
external fun Player.chatColorsEnabled(): Boolean

/**
 * Сообщение равно
 * Проверяет, равно ли сообщение игрока выбранному.
 */
@Action("if_player_chat_message_equals")
external fun Player.chatMessageEquals(vararg chatMessages: Text, ignoreCase: Boolean = false): Boolean

/**
 * Сталкивается на местоположении
 * Проверяет, сталкивается ли игрок с блоками, шалкерами, лодками и границей мира на указанном местоположении.
 */
@Action("if_player_collides_at_location")
external fun Player.collidesAtLocation(location: Location): Boolean

/**
 * Сталкивается используя кастомный хитбокс
 * Проверяет, сталкивается ли игрок с блоками, шалкерами, лодками и границей мира используя кастомный хитбокс.
 */
@Action("if_player_collides_using_hitbox")
external fun Player.collidesUsingHitbox(min: Location, max: Location): Boolean

/**
 * Сталкивается с сущностью
 * Проверяет, сталкивается ли хитбокс игрока с хитбоксом указанной сущности.
 */
@Action("if_player_collides_with_entity")
external fun Player.collidesWithEntity(
    nameOrUuid: Text,
    checkType: PlayerCheckType = PlayerCheckType.CONTAINS
): Boolean

/**
 * Предмет на курсоре равен
 * Проверяет, равен ли предмет, находящийся на курсоре игрока, выбранному предмету.
 */
@Action("if_player_cursor_item_equals")
external fun Player.cursorItemEquals(
    vararg items: Item,
    comparisonMode: PlayerComparisonMode = PlayerComparisonMode.IGNORE_STACK_SIZE
): Boolean

/**
 * Режим игры равен
 * Проверяет, равен ли режим игры игрока выбранному.
 */
@Action("if_player_gamemode_equals")
external fun Player.gamemodeEquals(gamemode: PlayerGamemode = PlayerGamemode.CREATIVE): Boolean

/**
 * Клавиша передвижения нажата
 * Проверяет, нажата ли выбранная кнопка передвижения у игрока.
 */
@Action("if_player_has_input")
external fun Player.hasInput(inputType: PlayerInputType = PlayerInputType.FORWARD): Boolean

/**
 * Имеет предмет
 * Проверяет, имеет ли игрок предмет в своём инвентаре.
 */
@Action("if_player_has_item")
external fun Player.hasItem(
    vararg items: Item,
    checkMode: PlayerCheckMode = PlayerCheckMode.ANY,
    comparisonMode: PlayerComparisonMode = PlayerComparisonMode.IGNORE_STACK_SIZE
): Boolean

/**
 * Имеет предмет в количестве
 * Проверяет, имеет ли игрок предмет в определённом количестве.
 */
@Action("if_player_has_item_at_least")
external fun Player.hasItemAtLeast(
    item: Item,
    count: Double,
    comparisonMode: PlayerComparisonMode = PlayerComparisonMode.IGNORE_STACK_SIZE
): Boolean

/**
 * Имеет предмет в слоте
 * Проверяет, имеет ли игрок предмет в определённом слоте инвентаря.
 */
@Action("if_player_has_item_in_slot")
external fun Player.hasItemInSlot(
    slots: List<Double> = emptyList(),
    items: List<Item> = emptyList(),
    comparisonMode: PlayerComparisonMode = PlayerComparisonMode.IGNORE_STACK_SIZE
): Boolean

/**
 * Имеет эффект от зелья
 * Проверяет, имеет ли игрок эффект от зелья.
 */
@Action("if_player_has_potion_effect")
external fun Player.hasPotionEffect(
    vararg potions: Potion,
    checkMode: PlayerCheckMode = PlayerCheckMode.ANY
): Boolean

/**
 * Имеет права
 * Проверяет, имеет ли игрок определённые права в мире.
 */
@Action("if_player_has_privilege")
external fun Player.hasPrivilege(
    privilege: PlayerPrivilege = PlayerPrivilege.BUILDER,
    exact: Boolean = false
): Boolean

/**
 * Имеет место для предметов
 * Проверяет, имеет ли игрок в своём инвентаре место для одного или нескольких предметов.
 */
@Action("if_player_has_room_for_item")
external fun Player.hasRoomForItem(
    vararg items: Item,
    checkMode: PlayerCheckMode = PlayerCheckMode.ANY,
    checkedSlots: PlayerCheckedSlots = PlayerCheckedSlots.ENTIRE_INVENTORY
): Boolean

/**
 * Имеет права в мире
 * Проверяет, имеет ли игрок определённый уровень доступа в этом мире.
 */
@Action("if_player_has_world_permission")
external fun Player.hasWorldPermission(permission: PlayerPermission = PlayerPermission.OWNER): Boolean

/**
 * Слот в хот-баре равен
 * Проверяет, совпадает ли текущий слот хот-бара игрока со слотом от 1 до 9 в сундуке.
 */
@Action("if_player_hotbar_slot_equals")
external fun Player.hotbarSlotEquals(slot: Double = 0.0): Boolean

/**
 * Внутри региона
 * Проверяет, находится ли игрок в определённом регионе.
 */
@Action("if_player_in_area")
external fun Player.inArea(
    location1: Location,
    location2: Location,
    ignoreYAxis: Boolean = false,
    intersectType: PlayerIntersectType = PlayerIntersectType.POINT,
    checkType: PlayerCheckType = PlayerCheckType.CONTAINS
): Boolean

/**
 * Слот в инвентаре содержит
 * Проверяет, содержит ли сейчас игрок с открытым инвентарём определённый предмет в слоте.
 */
@Action("if_player_inventory_menu_slot_equals")
external fun Player.inventoryMenuSlotEquals(
    slots: List<Double> = emptyList(),
    items: List<Item> = emptyList(),
    comparisonMode: PlayerComparisonMode = PlayerComparisonMode.IGNORE_STACK_SIZE
): Boolean

/**
 * Открыт инвентарь типа
 * Проверяет, открыт ли инвентарь определённого типа у игрока.
 */
@Action("if_player_inventory_type_open")
external fun Player.inventoryTypeOpen(
    inventoryType: PlayerInventoryType = PlayerInventoryType.CHEST
): Boolean

/**
 * Отображается в списке игроков сервера
 * Проверяет, включена ли настройка "Показывать в списках" у игрока.
 */
@Action("if_player_is_allow_server_listing")
external fun Player.isAllowServerListing(): Boolean

/**
 * Использует щит
 * Проверяет, использует ли игрок щит.
 */
@Action("if_player_is_blocking")
external fun Player.isBlocking(): Boolean

/**
 * Замаскирован для всех
 * Проверяет, замаскирован ли игрок для остальных игроков.
 */
@Action("if_player_is_disguised")
external fun Player.isDisguised(): Boolean

/**
 * Летит
 * Проверяет, летит ли игрок.
 */
@Action("if_player_is_flying")
external fun Player.isFlying(): Boolean

/**
 * Парит
 * Проверяет, парит ли игрок на элитрах.
 */
@Action("if_player_is_gliding")
external fun Player.isGliding(): Boolean

/**
 * Стоит на блоке
 * Проверяет, находится ли у игрока под ногами блок.
 */
@Action("if_player_is_grounded")
external fun Player.isGrounded(): Boolean

/**
 * Держит предмет
 * Проверяет, держит ли игрок предмет в своих руках.
 */
@Action("if_player_is_holding")
external fun Player.isHolding(
    vararg items: Item,
    handSlot: PlayerHandSlot = PlayerHandSlot.EITHER_HAND,
    comparisonMode: PlayerComparisonMode = PlayerComparisonMode.IGNORE_STACK_SIZE
): Boolean

/**
 * Смотрит на блок
 * Проверяет, смотрит ли игрок на определённый блок или местоположение.
 */
@Action("if_player_is_looking_at_block")
external fun Player.isLookingAtBlock(
    vararg blocks: Item,
    distance: Double = 0.0,
    fluidMode: PlayerFluidMode = PlayerFluidMode.NEVER
): Boolean

/**
 * Рядом с местоположением
 * Проверяет, находится ли игрок рядом с указанным местоположением (По умолчанию: 5 блоков).
 */
@Action("if_player_is_near")
external fun Player.isNear(
    location: Location,
    range: Double,
    ignoreYAxis: Boolean = false
): Boolean

/**
 * Стоит на земле
 * Проверяет, не находится ли игрок в воздухе.
 */
@Action("if_player_is_on_ground")
external fun Player.isOnGround(): Boolean

/**
 * Имеет лицензионный аккаунт
 * Проверяет, имеет ли игрок лицензионный аккаунт.
 */
@Action("if_player_is_online_mode")
external fun Player.isOnlineMode(): Boolean

/**
 * Оседлал существо
 * Проверяет, оседлал ли игрок существо (включая транспорт).
 */
@Action("if_player_is_riding_entity")
external fun Player.isRidingEntity(
    vararg entityIds: Text,
    compareMode: PlayerCompareMode = PlayerCompareMode.TYPE
): Boolean

/**
 * Замаскирован для себя
 * Проверяет, замаскирован ли игрок для себя.
 */
@Action("if_player_is_self_disguised")
external fun Player.isSelfDisguised(): Boolean

/**
 * Спит
 * Проверяет, спит ли игрок.
 */
@Action("if_player_is_sleeping")
external fun Player.isSleeping(): Boolean

/**
 * Крадется
 * Проверяет, крадется ли игрок.
 */
@Action("if_player_is_sneaking")
external fun Player.isSneaking(): Boolean

/**
 * Бежит
 * Проверяет, бежит ли игрок или использует клавишу бега при плавании.
 */
@Action("if_player_is_sprinting")
external fun Player.isSprinting(): Boolean

/**
 * Стоит на блоке
 * Проверяет, стоит ли игрок на определённом блоке или местоположении.
 */
@Action("if_player_is_standing_on_block")
external fun Player.isStandingOnBlock(
    vararg blocks: Item,
    onlySolid: Boolean = false
): Boolean

/**
 * Плавает
 * Проверяет, плавает ли игрок в воде или лаве.
 */
@Action("if_player_is_swimming")
external fun Player.isSwimming(): Boolean

/**
 * Игрок перемещен на сервер
 * Проверяет, перемещен ли игрок с другого сервера.
 */
@Action("if_player_is_transferred")
external fun Player.isTransferred(): Boolean

/**
 * Использует предмет
 * Проверяет, использует ли игрок лук, щит или любой другой предмет, который возможно использовать.
 */
@Action("if_player_is_using_item")
external fun Player.isUsingItem(
    vararg items: Item,
    comparisonMode: PlayerComparisonMode = PlayerComparisonMode.IGNORE_STACK_SIZE
): Boolean

/**
 * Одет в предмет
 * Проверяет, одет ли игрок в предмет.
 */
@Action("if_player_is_wearing_item")
external fun Player.isWearingItem(
    vararg items: Item,
    checkMode: PlayerCheckMode = PlayerCheckMode.ANY,
    comparisonMode: PlayerComparisonMode = PlayerComparisonMode.IGNORE_STACK_SIZE
): Boolean

/**
 * Группа предметов не имеет задержку
 * Проверяет, не имеет ли группа предметов у игрока задержку, применимую к определённому типу предметов.
 */
@Action("if_player_item_group_is_not_on_cooldown")
external fun Player.itemGroupIsNotOnCooldown(
    vararg itemKeys: Item,
    checkMode: PlayerCheckMode = PlayerCheckMode.ANY
): Boolean

/**
 * Предмет не имеет задержку
 * Проверяет, не имеет ли предмет у игрока задержку, применимую к определённому типу предметов.
 */
@Action("if_player_item_is_not_on_cooldown")
external fun Player.itemIsNotOnCooldown(
    vararg items: Item,
    checkMode: PlayerCheckMode = PlayerCheckMode.ANY
): Boolean

/**
 * Имя равно
 * Проверяет, равно ли имя игрока имени в сундуке.
 */
@Action("if_player_name_equals")
external fun Player.nameEquals(vararg namesOrUuids: Text): Boolean

/**
 * Имеет фильтр слов
 * Проверяет, включен ли фильтр слов от Mojang у игрока.
 */
@Action("if_player_text_filtering_enabled")
external fun Player.textFilteringEnabled(): Boolean
