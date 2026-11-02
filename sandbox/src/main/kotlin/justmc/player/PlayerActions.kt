package justmc.player

import justmc.annotation.*
import justmc.value.*
import kotlin.*

/**
 * Добавить строку меню
 * Добавляет строку с указанными предметами в инвентаре типа \"Сундук\".
 */
@Action("player_add_inventory_menu_row")
external fun Player.addInventoryMenuRow(
    vararg items: Item,
    position: PlayerPosition = PlayerPosition.HEADER
)

/**
 * Ускорить полёт на Элитрах
 * Ускоряет полёт игрока на Элитрах с силой указанного фейерверка.
 */
@Action("player_boost_elytra")
external fun Player.boostElytra(firework: Item)

/**
 * Прервать использование предмета
 * Прерывает использование текущего предмета.
 */
@Action("player_clear_active_item")
external fun Player.clearActiveItem()

/**
 * Очистить чат
 * Удаляет все сообщения из окна чата выбранных игроков.
 */
@Action("player_clear_chat")
external fun Player.clearChat()

/**
 * Удалить отладочные маркеры
 * Удаляет все отладочные маркеры для игрока.
 */
@Action("player_clear_debug_markers")
external fun Player.clearDebugMarkers()

/**
 * Очистить эффекты
 * Очищает все эффекты у игрока.
 */
@Action("player_clear_effects_action")
external fun Player.clearEffectsAction()

/**
 * Очистить содержимое Эндер-сундука
 * Очищает предметы в инвентаре Эндер-сундука игрока.
 */
@Action("player_clear_ender_chest_contents")
external fun Player.clearEnderChestContents()

/**
 * Очистить инвентарь
 * Очищает инвентарь игрока.
 */
@Action("player_clear_inventory")
external fun Player.clearInventory(
    clearMode: PlayerClearMode = PlayerClearMode.ENTIRE
)

/**
 * Очистить предметы
 * Удаляет все выбранные предметы из инвентаря игрока.
 */
@Action("player_clear_items")
external fun Player.clearItems(
    vararg items: Item
)

/**
 * Очистить эффекты
 * Очищает все эффекты у игрока.
 */
@Action("player_clear_potion_effects")
external fun Player.clearPotionEffects()

/**
 * Очистить очки
 * Очищает очки у данного скорборда.
 */
@Action("player_clear_scoreboard")
external fun Player.clearScoreboard()

/**
 * Закрыть диалоговое окно
 * Закрывает текущее диалоговое окно игроку.
 */
@Action("player_close_dialog_menu")
external fun Player.closeDialogMenu()

/**
 * Закрыть меню
 * Закрывает открытое инвентарное меню игрока.
 */
@Action("player_close_inventory")
external fun Player.closeInventory()

/**
 * Завершить использование предмета
 * Завершает использование текущего предмета в руке с результатом.
 */
@Action("player_complete_using_active_item")
external fun Player.completeUsingActiveItem()

/**
 * Отправить игрока на другой сервер
 * Отправляет игрока на сервер с указанным именем (например, "cr-0").
 */
@Action("player_connect_to_server")
external fun Player.connectToServer(
    serverName: Text = ""
)

/**
 * Нанести урон
 * Наносит урон игроку.
 */
@Action("player_damage")
external fun Player.damage(
    damage: Double = 0.0,
    source: Text = ""
)

/**
 * Замаскировать игрока под блок
 * Маскирует игрока под выбранный блок.
 */
@Action("player_disguise_as_block")
external fun Player.disguiseAsBlock(
    block: Item,
    visibleToSelf: Boolean = false
)

/**
 * Замаскировать игрока под сущность
 * Маскирует игрока под выбранную сущность.
 */
@Action("player_disguise_as_entity")
external fun Player.disguiseAsEntity(
    entityType: Item,
    visibleToSelf: Boolean = false
)

/**
 * Замаскировать игрока под предмет
 * Маскирует игрока под предмет.
 */
@Action("player_disguise_as_item")
external fun Player.disguiseAsItem(
    item: Item,
    visibleToSelf: Boolean = false
)

/**
 * Замаскировать игрока под моба
 * Маскирует игрока под выбранного моба.
 */
@Action("player_disguise_as_mob")
external fun Player.disguiseAsMob()

/**
 * Замаскировать под игрока
 * Маскирует игрока под другого игрока.
 */
@Action("player_disguise_as_player")
external fun Player.disguiseAsPlayer()

/**
 * Показать удар в колокол
 * Показывает игроку анимацию удара в колокол, не влияя на других игроков.
 */
@Action("player_display_bell_ring")
external fun Player.displayBellRing(
    location: Location,
    direction: PlayerDirection = PlayerDirection.DOWN
)

/**
 * Показать блок
 * Показать игроку блок, не влияя на других игроков.
 */
@Action("player_display_block")
external fun Player.displayBlock(
    block: Item? = null,
    location: Location? = null
)

/**
 * Показать анимацию луча Врат Энда
 * Показывает анимацию луча Врат Энда на определённом местоположении.
 */
@Action("player_display_end_gateway_beam")
external fun Player.displayEndGatewayBeam(
    location: Location,
    color: PlayerColor = PlayerColor.PINK
)

/**
 * Показать голограмму
 * Показывает игроку голограмму. Чтобы удалить голограмму на местоположении, оставьте текст пустым.
 */
@Action("player_display_hologram")
external fun Player.displayHologram(
    location: Location,
    text: Text
)

/**
 * Отобразить эффект молнии
 * Отобразить молнию игроку, не показывая её для других игроков и не поджигая местность.
 */
@Action("player_display_lightning")
external fun Player.displayLightning(location: Location)

/**
 * Отобразить эффект частицы
 * Отображает игроку эффект частицы на выбранном местоположении.
 */
@Action("player_display_particle")
external fun Player.displayParticle(
    particle: List<Particle> = emptyList(),
    location: List<Location> = emptyList()
)

/**
 * Отобразить окружность частиц
 * Отображает игроку окружность из эффекта частиц с указанными параметрами.
 */
@Action("player_display_particle_circle")
external fun Player.displayParticleCircle(
    particle: Particle,
    center: Location,
    radius: Double,
    points: Double = 20.0,
    startAngle: Double = 0.0,
    perpendicular: Vector? = null,
    angleUnit: PlayerAngleUnit = PlayerAngleUnit.DEGREES
)

/**
 * Отобразить куб частиц
 * Отображает игроку куб из эффекта частиц с указанными параметрами.
 */
@Action("player_display_particle_cube")
external fun Player.displayParticleCube(
    particle: Particle,
    firstCorner: Location,
    secondCorner: Location,
    spacing: Double = 0.5,
    type: PlayerType = PlayerType.SOLID
)

/**
 * Отобразить линию частиц
 * Отображает игроку линию эффекта частиц от начального местоположения до конечного с определённым расстоянием.
 */
@Action("player_display_particle_line")
external fun Player.displayParticleLine(
    particle: Particle,
    start: Location,
    end: Location,
    divider: Double? = null,
    unitOfMeasurement: PlayerUnitOfMeasurement = PlayerUnitOfMeasurement.POINTS
)

/**
 * Отобразить луч частиц
 * Отображает игроку луч эффекта частиц от начального местоположения по указанному вектору с определённым расстоянием.
 */
@Action("player_display_particle_ray")
external fun Player.displayParticleRay(
    particle: Particle,
    start: Location,
    ray: Vector,
    divider: Vector? = null,
    unitOfMeasurement: PlayerUnitOfMeasurement = PlayerUnitOfMeasurement.POINTS
)

/**
 * Отобразить сферу частиц
 * Отображает игроку сферу из эффекта частиц с указанными параметрами.
 */
@Action("player_display_particle_sphere")
external fun Player.displayParticleSphere(
    particle: Particle,
    center: Location,
    radius: Double,
    points: Double = 20.0
)

/**
 * Отобразить спираль частиц
 * Отображает игроку спираль из эффекта частиц с указанными параметрами.
 */
@Action("player_display_particle_spiral")
external fun Player.displayParticleSpiral(
    particle: Particle,
    center: Location,
    radius: Double,
    distance: Double = 5.0,
    points: Double = 20.0,
    rotations: Double = 1.0,
    startAngle: Double = 0.0,
    angleUnit: PlayerAngleUnit = PlayerAngleUnit.DEGREES
)

/**
 * Показать анимацию подбора предмета
 * Показывает игроку анимацию подбора предмета.
 */
@Action("player_display_pick_up_animation")
external fun Player.displayPickUpAnimation(
    collectedNameOrUuid: Text = "",
    collectorNameOrUuid: Text = "",
    amount: Double = 0.0
)

/**
 * Показать текст таблички
 * Показать игроку изменение текста таблички, не изменяя её текст для других игроков.
 */
@Action("player_display_sign_text")
external fun Player.displaySignText(
    location: Location,
    line1: Text = "",
    line2: Text = "",
    line3: Text = "",
    line4: Text = "",
    side: PlayerSide = PlayerSide.FRONT
)

/**
 * Отобразить частицу вибрации
 * Отображает игроку частицу вибрации движущуюся с одной точки на другую.
 */
@Action("player_display_vibration")
external fun Player.displayVibration(
    from: Location,
    to: Location,
    destinationTime: Double = 0.0
)

/**
 * Расширить меню
 * Расширяет открытое инвентарное меню игрока на выбранное количество строк и заполняет его указанными предметами.
 */
@Action("player_expand_inventory_menu")
external fun Player.expandInventoryMenu(
    vararg items: Item,
    size: Double = 0.0
)

/**
 * Повернуть к местоположению
 * Поворачивает игрока в сторону к местоположению.
 */
@Action("player_face_location")
external fun Player.faceLocation(location: Location)

/**
 * Получить значение атрибута игрока
 * Получает значение указанного атрибута игрока и присваивает результат к переменной.
 */
@Action("player_get_attribute", returns = ["variable"])
external fun Player.getAttribute(
    attributeType: PlayerAttributeType = PlayerAttributeType.MAX_HEALTH,
    returnValue: PlayerReturnValue = PlayerReturnValue.VALUE
): Any

/**
 * Получить NBT-теги игрока
 * Получает NBT-теги игрока по введённому пути и присваивает результат к переменной.
 */
@Action("player_get_nbt", returns = ["variable"])
external fun Player.getNbt(path: Text, valueType: PlayerValueType = PlayerValueType.ANY_VALUE) : Any

/**
 * Прибавить уровень
 * Прибавляет уровень игроку.
 */
@Action("player_give_experience")
external fun Player.giveExperience(
    experience: Double = 0.0,
    mode: PlayerMode = PlayerMode.SET
)

/**
 * Выдать предмет
 * Выдаёт игроку предметы из сундука.
 */
@Action("player_give_items")
external fun Player.giveItems(
    vararg items: Item,
    amount: Double = 0.0
)

/**
 * Выдать эффект
 * Выдаёт выбранные эффекты игроку.
 */
@Action("player_give_potion_effect")
external fun Player.givePotionEffect(
    vararg potions: Potion,
    showIcon: Boolean = false,
    overwrite: Boolean = false,
    particleMode: PlayerParticleMode = PlayerParticleMode.REGULAR
)

/**
 * Выдать случайный предмет
 * Выдаёт игроку случайный предмет или стак из предметов в сундуке.
 */
@Action("player_give_random_item")
external fun Player.giveRandomItem(vararg items: Item)

/**
 * Исцелить игрока
 * Исцеляет игрока.
 */
@Action("player_heal")
external fun Player.heal(heal: Double = 0.0)

/**
 * Скрыть кастомный рецепт
 * Скрывает игроку рецепт.
 */
@Action("player_hide_custom_recipe")
external fun Player.hideCustomRecipe(vararg names: Text, isVanillaRecipe: Boolean = false)

/**
 * Скрыть сущность игроку
 * Скрывает указанную сущность для игрока.
 */
@Action("player_hide_entity")
external fun Player.hideEntity(nameOrUuid: Text, hide: Boolean = false)

/**
 * Скрыть игрока
 * Отключает видимость указанного игрока для цели события.
 */
@Action("player_hide_player")
external fun Player.hidePlayer(nameOrUuid: Text, hide: Boolean = false)

/**
 * Скрыть скорборд
 * Скрывает текущий скорборд игрока.
 */
@Action("player_hide_scoreboard")
external fun Player.hideScoreboard()

/**
 * Выгнать игрока
 * Выгоняет игрока из мира.
 */
@Action("player_kick")
external fun Player.kick()

/**
 * Запустить вперёд
 * Запускает игрока вперёд или назад по направлению взгляда в зависимости от силы.
 */
@Action("player_launch_forward")
external fun Player.launchForward(
    increment: Boolean = false,
    launchAxis: PlayerLaunchAxis = PlayerLaunchAxis.YAW,
    power: Double = 0.0
)

/**
 * Запустить снаряд
 * Запустить снаряд из местоположения игрока.
 */
@Action("player_launch_projectile")
external fun Player.launchProjectile(
    projectile: Item,
    location: Location,
    name: Text = "",
    speed: Double = 1.0,
    inaccuracy: Double = 0.0,
    trail: Particle? = null
)

/**
 * Запустить к местоположению
 * Запускает игрока к выбранному местоположению.
 */
@Action("player_launch_to_location")
external fun Player.launchToLocation(
    location: Location,
    power: Double,
    increment: Boolean = false
)

/**
 * Подбросить вверх
 * Подбрасывает игрока вверх или вниз в зависимости от силы.
 */
@Action("player_launch_up")
external fun Player.launchUp(increment: Boolean = false, power: Double = 0.0)

/**
 * Высадить из транспорта
 * Высаживает игрока из транспорта или существа.
 */
@Action("player_leave_vehicle")
external fun Player.leaveVehicle()

/**
 * Загрузить сохранённый инвентарь
 * Загружает выбранный сохранённый инвентарь.
 */
@Action("player_load_inventory")
external fun Player.loadInventory()

/**
 * Замаскировать игрока под сущность из мира
 * Маскирует игрока под указанную сущность из мира.
 */
@Action("player_mimic_disguise_from_entity")
external fun Player.mimicDisguiseFromEntity(
    nameOrUuid: Text = "",
    includeDisguise: Boolean = false,
    disguise: PlayerDisguise = PlayerDisguise.ALL,
    removeOriginalEntity: Boolean = false
)

/**
 * Открыть книгу
 * Открывает книгу определённому игроку.
 */
@Action("player_open_book")
external fun Player.openBook(book: Item)

/**
 * Открыть меню блока
 * Открывает для игрока меню блока в указанном местоположении.
 */
@Action("player_open_container_inventory")
external fun Player.openContainerInventory(location: Location)

/**
 * Открыть Эндер-сундук
 * Открывает для игрока Эндер-сундук.
 */
@Action("player_open_ender_chest")
external fun Player.openEnderChest()

/**
 * Открыть функциональное меню
 * Открывает для игрока меню, имеющее функционал.
 */
@Action("player_open_working_menu")
external fun Player.openWorkingMenu(
    title: Text,
    menuType: PlayerMenuType = PlayerMenuType.CRAFTING
)

/**
 * Проиграть анимацию игроку
 * Проигрывает для игрока определённую анимацию.
 */
@Action("player_play_animation_action")
external fun Player.playAnimationAction(animation: PlayerAnimation = PlayerAnimation.DAMAGE)

/**
 * Проиграть анимацию получения урона
 * Проигрывает для игрока анимацию получения урона с определённым наклоном.
 */
@Action("player_play_hurt_animation")
external fun Player.playHurtAnimation(yaw: Double = 0.0)

/**
 * Отобразить частицы
 * Отображает эффект частиц для игрока.
 */
@Action("player_play_particle")
external fun Player.playParticle(
    particle: Particle,
    location: Location,
    count: Double = 1.0
)

/**
 * Проиграть звук
 * Проигрывает звук игроку.
 */
@Action("player_play_sound")
external fun Player.playSound(
    sound: Sound,
    location: Location,
    source: PlayerSource = PlayerSource.MASTER
)

/**
 * Проиграть звук от сущности
 * Проигрывает звук игроку от указанной сущности.
 */
@Action("player_play_sound_from_entity")
external fun Player.playSoundFromEntity(nameOrUuid: Text = "", vararg sounds: Sound)

/**
 * Проиграть последовательность звуков
 * Проигрывает игроку последовательность звуков с задержкой между каждым звуком.
 */
@Action("player_play_sound_sequence")
external fun Player.playSoundSequence(
    vararg sounds: Sound,
    delay: Double = 0.0,
    location: Location? = null,
    source: PlayerSource = PlayerSource.MASTER
)

/**
 * Случайная телепортация
 * Телепортирует игрока в случайное местоположение.
 */
@Action("player_randomized_teleport")
external fun Player.randomizedTeleport(
    vararg locations: Location,
    keepRotation: Boolean = false,
    keepVelocity: Boolean = false,
    ignorePassengers: Boolean = false,
    dismount: Boolean = false
)

/**
 * Переместить игрока в другой мир
 * Перемещает игрока в мир с указанным ID.
 */
@Action("player_redirect_world")
external fun Player.redirectWorld(worldId: Text)

/**
 * Удалить босс-бар
 * Удаляет имеющийся босс-бар у определённого игрока.
 */
@Action("player_remove_boss_bar")
external fun Player.removeBossBar(id: Text)

/**
 * Убрать маскировку
 * Убирает маскировку игроку.
 */
@Action("player_remove_disguise")
external fun Player.removeDisguise()

/**
 * Скрыть отображаемые блоки
 * Скрывает от игрока все отображаемые блоки в выбранном пространстве, не влияя на других игроков (максимальный размер пространства - 500 блоков).
 */
@Action("player_remove_display_blocks")
external fun Player.removeDisplayBlocks(pos1: Location? = null, pos2: Location? = null)

/**
 * Убрать строки меню
 * Убирает одну или несколько строк в инвентаре типа \"Сундук\".
 */
@Action("player_remove_inventory_menu_row")
external fun Player.removeInventoryMenuRow(size: Double = 0.0, position: PlayerPosition = PlayerPosition.HEADER)

/**
 * Удалить предметы
 * Удаляет указанные предметы из инвентаря игрока.
 */
@Action("player_remove_items")
external fun Player.removeItems(vararg items: Item)

/**
 * Сбросить позу игроку
 * Сбрасывает позу игроку.
 */
@Action("player_remove_pose")
external fun Player.removePose()

/**
 * Удалить эффект
 * Удаляет выбранные эффекты у игрока.
 */
@Action("player_remove_potion_effect")
external fun Player.removePotionEffect(vararg potions: Potion)

/**
 * Отнять очки у скорборда
 * Отнимает очки у данного скорборда.
 */
@Action("player_remove_scoreboard_score")
external fun Player.removeScoreboardScore()

/**
 * Убрать свою маскировку
 * Убирает маскировку игрока, которую видно только ему.
 */
@Action("player_remove_self_disguise")
external fun Player.removeSelfDisguise()

/**
 * Убрать скин
 * Возвращает обычный скин цели события.
 */
@Action("player_remove_skin")
external fun Player.removeSkin()

/**
 * Сбросить границу мира
 * Установить границу мира для игрока на значение по умолчанию.
 */
@Action("player_remove_world_border")
external fun Player.removeWorldBorder()

/**
 * Заменить предметы
 * Заменяет указанные предметы в инвентаре на определённый предмет.
 */
@Action("player_replace_items")
external fun Player.replaceItems(vararg items: Item, replace: Item, count: Double = 0.0)

/**
 * Сбросить цвет значка на локаторе
 * Устанавливает игроку цвет значка, отображаемого на локаторе, по умолчанию.
 */
@Action("player_reset_waypoint_color")
external fun Player.resetWaypointColor()

/**
 * Сбросить погоду
 * Сбрасывает погоду игроку.
 */
@Action("player_reset_weather")
external fun Player.resetWeather()

/**
 * Посадить на существо
 * Сажает игрока на существо или другого игрока.
 */
@Action("player_ride_entity")
external fun Player.rideEntity(nameOrUuid: Text)

/**
 * Сохранить текущий инвентарь
 * Сохраняет текущий инвентарь игрока. Его можно будет загрузить позже с помощью 'Загрузить сохранённый инвентарь'.
 */
@Action("player_save_inventory")
external fun Player.saveInventory()

/**
 * Замаскировать себя под блок
 * Маскирует игрока под блок, но эту маскировку видно только этому игроку.
 */
@Action("player_self_disguise_as_block")
external fun Player.selfDisguiseAsBlock(block: Item)

/**
 * Замаскировать себя под сущность
 * Маскирует игрока под сущность, но эту маскировку видно только этому игроку.
 */
@Action("player_self_disguise_as_entity")
external fun Player.selfDisguiseAsEntity(entityType: Item)

/**
 * Замаскировать себя под предмет
 * Маскирует игрока под предмет, но эту маскировку видно только этому игроку.
 */
@Action("player_self_disguise_as_item")
external fun Player.selfDisguiseAsItem(item: Item)

/**
 * Отправить экшн-бар
 * Высвечивает выбранному игроку экшн-бар.
 */
@Action("player_send_action_bar")
external fun Player.sendActionBar(vararg messages: Any?, merging: PlayerMerging = PlayerMerging.SPACES)

/**
 * Отправить достижение игроку
 * Высвечивает игроку пользовательское всплывающее достижение.
 */
@Action("player_send_advancement")
external fun Player.sendAdvancement(name: Text, icon: Item? = null, frame: PlayerFrame = PlayerFrame.TASK)

/**
 * Показать анимацию ломания блока
 * Показывает анимацию ломания блока (трещины) для игрока, не влияя на других игроков.
 */
@Action("player_send_break_animation")
external fun Player.sendBreakAnimation(vararg locations: Location, stage: Double = 0.0)

/**
 * Диалог
 * Отправляет несколько сообщений в чат выбранным игрокам с задержкой после каждого сообщения.
 */
@Action("player_send_dialogue")
external fun Player.sendDialogue(vararg messages: Any?, delay: Double = 0.0)

/**
 * Отправить сообщение с наведением
 * Отправляет сообщение выбранному игроку. Когда игрок 'наводит' на него курсор, появляется второе сообщение.
 */
@Action("player_send_hover")
external fun Player.sendHover(message: Text, hover: Text)

/**
 * Отправить сообщение
 * Отправляет сообщение в чат указанным игрокам.
 */
@Action("player_send_message")
external fun Player.sendMessage(vararg messages: Any?, merging: PlayerMerging = PlayerMerging.SPACES)

/**
 * Отправить сообщение формата MiniMessage
 * Отправляет игроку сообщение в чат в формате MiniMessage.
 */
@Action("player_send_minimessage")
external fun Player.sendMinimessage(minimessage: Any?)

/**
 * Отправить титул
 * Высвечивает выбранному игроку две надписи на экран - титул и подтитул.
 */
@Action("player_send_title")
external fun Player.sendTitle(
    title: Text = "",
    subtitle: Text = "",
    fadeIn: Double = 0.0,
    stay: Double = 0.0,
    fadeOut: Double = 0.0
)

/**
 * Установить дополнительное здоровье
 * Устанавливает дополнительное здоровье игрока.
 */
@Action("player_set_absorption_health")
external fun Player.setAbsorptionHealth(health: Double = 0.0)

/**
 * Установить оставшийся воздух
 * Устанавливает оставшийся воздух игроку.
 */
@Action("player_set_air_ticks")
external fun Player.setAirTicks(ticks: Double = 0.0)

/**
 * Установить разрешение полёта игрока
 * Устанавливает разрешение полёта для игрока.
 */
@Action("player_set_allow_flying")
external fun Player.setAllowFlying(allowFlying: Boolean = false)

/**
 * Установить броню
 * Устанавливает броню игрока.
 */
@Action("player_set_armor")
external fun Player.setArmor(helmet: Item? = null, chestplate: Item? = null, leggings: Item? = null, boots: Item? = null)

/**
 * Установить стрелы на игроке
 * Отображает определённое количество стрел на игроке.
 */
@Action("player_set_arrows_in_body")
external fun Player.setArrowsInBody(amount: Double = 0.0)

/**
 * Установить скорость атаки
 * Устанавливает скорость атаки игроку.
 */
@Action("player_set_attack_speed")
external fun Player.setAttackSpeed(speed: Double = 0.0)

/**
 * Установить атрибут
 * Устанавливает игроку указанное значение атрибута.
 */
@Action("player_set_attribute")
external fun Player.setAttribute(value: Double = 0.0, attributeType: PlayerAttributeType = PlayerAttributeType.MAX_HEALTH)

/**
 * Установить жало пчелы на игроке
 * Отображает определённое количество жал пчёл на игроке.
 */
@Action("player_set_bee_stingers_in_body")
external fun Player.setBeeStingersInBody(amount: Double = 0.0)

/**
 * Открыть/Закрыть блок
 * Отобразить игроку закрытие/открытие блока не меняя состояния блока для других игроков.
 */
@Action("player_set_block_opened_state")
external fun Player.setBlockOpenedState(
    location: Location,
    isOpened: Boolean = false
)

/**
 * Установить босс-бар
 * Устанавливает у определённого игрока пользовательский босс-бар.
 */
@Action("player_set_boss_bar")
external fun Player.setBossBar(
    id: Text,
    title: Text = "",
    progress: Double = 0.0,
    color: PlayerColor = PlayerColor.PINK,
    style: PlayerStyle = PlayerStyle.PROGRESS,
    skyEffect: PlayerSkyEffect = PlayerSkyEffect.NONE,
)

/**
 * Обновление подсказок в чате
 * Обновляет игроку подсказки, показываемые при вводе текста в чате.
 */
@Action("player_set_chat_completions")
external fun Player.setChatCompletions(
    vararg completions: Text,
    settingMode: PlayerSettingMode = PlayerSettingMode.ADD
)

/**
 * Установить режим столкновения
 * Устанавливает игроку режим столкновения с существами.
 */
@Action("player_set_collidable")
external fun Player.setCollidable(collidable: Boolean = false)

/**
 * Установить цель компаса
 * Установить цель компаса для игрока, в сторону которой будет крутиться стрелка компаса.
 */
@Action("player_set_compass_target")
external fun Player.setCompassTarget(location: Location)

/**
 * Установить предмет на курсор
 * Устанавливает предмет на курсор игрока.
 */
@Action("player_set_cursor_item")
external fun Player.setCursorItem(item: Item)

/**
 * Установить выпадение предметов
 * Устанавливает выпадение предметов из игрока при смерти.
 */
@Action("player_set_death_drops")
external fun Player.setDeathDrops(deathDrops: Boolean = false)

/**
 * Установить количество очков
 * Устанавливает количество очков, отображаемых игроку на экране смерти.
 */
@Action("player_set_death_screen_score")
external fun Player.setDeathScreenScore(score: Double = 0.0)

/**
 * Установить видимость
 * Устанавливает игроку видимость.
 */
@Action("player_set_default_visible")
external fun Player.setDefaultVisible(defaultVisible: Boolean = false)

/**
 * Установить маскировку от третьего лица
 * Будет ли игрок видеть на себе установленную маскировку.
 */
@Action("player_set_disguise_visible")
external fun Player.setDisguiseVisible()

/**
 * Установить сид зачарований
 * Устанавливает игроку сид зачарований, определяющий набор зачарований в чародейском столе.
 */
@Action("player_set_enchantment_seed")
external fun Player.setEnchantmentSeed(seed: Double = 0.0)

/**
 * Установить содержимое Эндер-сундука
 * Устанавливает предметы в инвентарь Эндер-сундука игрока.
 */
@Action("player_set_ender_chest_contents")
external fun Player.setEnderChestContents(vararg items: Item)

/**
 * Установить свечение сущности
 * Включает или выключает свечение сущности для данного игрока.
 */
@Action("player_set_entity_glowing")
external fun Player.setEntityGlowing(
    nameOrUuid: Text,
    glow: Boolean = false,
    color: PlayerColor = PlayerColor.PINK
)

/**
 * Установить экипировку
 * Устанавливает предметы в один из слотов экипировки (броня и предметы в руках) игрока.
 */
@Action("player_set_equipment")
external fun Player.setEquipment(item: Item, slot: PlayerSlot = PlayerSlot.HAND)

/**
 * Установить уровень истощения
 * Устанавливает уровень истощения игроку.
 */
@Action("player_set_exhaustion")
external fun Player.setExhaustion(exhaustion: Double = 0.0, mode: PlayerMode = PlayerMode.SET)

/**
 * Установить уровень
 * Устанавливает уровень игроку.
 */
@Action("player_set_experience")
external fun Player.setExperience(experience: Double = 0.0, mode: PlayerMode = PlayerMode.SET)

/**
 * Установить дистанцию падения
 * Устанавливает дистанцию, с которой падает игрок.
 */
@Action("player_set_fall_distance")
external fun Player.setFallDistance(distance: Double = 0.0)

/**
 * Поджечь игрока
 * Поджигает игрока на выбранное время.
 */
@Action("player_set_fire_ticks")
external fun Player.setFireTicks(ticks: Double = 0.0)

/**
 * Установить полёт
 * Устанавливает для игрока состояние полёта.
 */
@Action("player_set_flying")
external fun Player.setFlying(isFlying: Boolean = false)

/**
 * Установить дистанцию прорисовки
 * Устанавливает дистанцию прорисовки чанков для игрока. Значение \"-1\" сбрасывает до стандартной.
 */
@Action("player_set_fog_distance")
external fun Player.setFogDistance(distance: Double = 0.0)

/**
 * Установить голод
 * Устанавливает уровень голода игроку.
 */
@Action("player_set_food")
external fun Player.setFood(food: Double = 0.0, mode: PlayerMode = PlayerMode.SET)

/**
 * Установить время заморозки
 * Устанавливает игроку время заморозки (количество тиков, которое игрок провёл в рыхлом снегу).
 */
@Action("player_set_freeze_ticks")
external fun Player.setFreezeTicks(ticks: Double = 0.0, tickingLocked: Boolean = false)

/**
 * Установить режим игры
 * Устанавливает режим игры для игрока.
 */
@Action("player_set_gamemode")
external fun Player.setGamemode(
    flightMode: PlayerFlightMode = PlayerFlightMode.RESPECT_GAMEMODE,
    gamemode: PlayerGamemode = PlayerGamemode.CREATIVE
)

/**
 * Установить полёт на элитрах
 * Устанавливает для игрока состояние полёта на элитрах.
 */
@Action("player_set_gliding")
external fun Player.setGliding(
    isGliding: Boolean = false
)

/**
 * Установить здоровье игрока
 * Устанавливает здоровье игрока на выбранное количество.
 */
@Action("player_set_health")
external fun Player.setHealth(
    health: Double = 0.0
)

/**
 * Установить слот
 * Устанавливает выбранный слот игроку.
 */
@Action("player_set_hotbar_slot")
external fun Player.setHotbarSlot(
    slot: Double = 0.0
)

/**
 * Установить мгновенное возрождение
 * Устанавливает мгновенное возрождение игроку.
 */
@Action("player_set_instant_respawn")
external fun Player.setInstantRespawn(
    instantRespawn: Boolean = false
)

/**
 * Установить сохранение инвентаря
 * Устанавливает игроку сохранение инвентаря при смерти.
 */
@Action("player_set_inventory_kept")
external fun Player.setInventoryKept(
    kept: Boolean = false
)

/**
 * Установить кастомный ID открытого инвентаря
 * Устанавливает кастомный ID для открытого меню игрока.
 */
@Action("player_set_inventory_menu_custom_id")
external fun Player.setInventoryMenuCustomId(
    customId: Text = ""
)

/**
 * Установить предмет в слот
 * Устанавливает предмет в указанный слот открытого инвентарного меню игрока.
 */
@Action("player_set_inventory_menu_item")
external fun Player.setInventoryMenuItem(
    item: Item,
    slot: Double
)

/**
 * Установить название меню
 * Устанавливает новое название для открытого инвентарного меню игрока.
 */
@Action("player_set_inventory_menu_name")
external fun Player.setInventoryMenuName(
    text: Text = ""
)

/**
 * Установить длительность неуязвимости
 * Устанавливает длительность неуязвимости для игрока.
 */
@Action("player_set_invulnerability_ticks")
external fun Player.setInvulnerabilityTicks(
    ticks: Double = 0.0
)

/**
 * Установить задержку предмета
 * Применяет визуальный эффект шкалы задержки для всех предметов выбранного типа.
 */
@Action("player_set_item_cooldown")
external fun Player.setItemCooldown(
    item: Item,
    cooldown: Double,
    sound: Sound? = null
)

/**
 * Установить задержку для группы предметов
 * Применяет визуальный эффект шкалы задержки для всех предметов указанной группы.
 */
@Action("player_set_item_group_cooldown")
external fun Player.setItemGroupCooldown(
    key: Text,
    cooldown: Double
)

/**
 * Установить предметы
 * Устанавливает в инвентарь игрока соответственно предметы из сундука.
 */
@Action("player_set_items")
external fun Player.setItems(
    vararg items: Item
)

/**
 * Установить максимальное здоровье игрока
 * Устанавливает максимальное количество здоровья для игрока.
 */
@Action("player_set_max_health")
external fun Player.setMaxHealth(
    health: Double = 0.0,
    heal: Boolean = false
)

/**
 * Установить максимальную длительность неуязвимости
 * Устанавливает максимальную длительность неуязвимости для игрока.
 */
@Action("player_set_max_invulnerability_ticks")
external fun Player.setMaxInvulnerabilityTicks(
    ticks: Double = 0.0
)

/**
 * Установить скорость движения
 * Устанавливает скорость движения игрока.
 */
@Action("player_set_movement_speed")
external fun Player.setMovementSpeed(
    distance: Double = 0.0,
    movementType: PlayerMovementType = PlayerMovementType.WALK
)

/**
 * Отображение ника игрока
 * Отобразит или скроет ник над головой.
 */
@Action("player_set_nametag_visible")
external fun Player.setNametagVisible(
    visible: Boolean = false
)

/**
 * Установить текст в списке игроков
 * Устанавливает текст над или под списком игроков для игрока.
 */
@Action("player_set_player_list_info")
external fun Player.setPlayerListInfo(
    vararg text: Text,
    position: PlayerPosition = PlayerPosition.HEADER,
    merging: PlayerMerging = PlayerMerging.SPACES
)

/**
 * Установить позу игроку
 * Устанавливает определённую позу игроку.
 */
@Action("player_set_pose")
external fun Player.setPose(
    pose: PlayerPose = PlayerPose.STANDING,
    locked: Boolean = false
)

/**
 * Установить разрешение атаковать игроков
 * Устанавливает разрешение игроку атаковать других игроков и наносить им урон.
 */
@Action("player_set_pvp")
external fun Player.setPvp(
    pvp: Boolean = false
)

/**
 * Установить уровень дождя
 * Устанавливает уровень дождя игроку.
 */
@Action("player_set_rain_level")
external fun Player.setRainLevel(
    rainLevel: Double = 0.0
)

/**
 * Установить поворот
 * Устанавливает поворот игрока.
 */
@Action("player_set_rotation")
external fun Player.setRotation(
    yaw: Double = 0.0,
    pitch: Double = 0.0
)

/**
 * Установить поворот по вектору
 * Устанавливает поворот игрока по вектору.
 */
@Action("player_set_rotation_by_vector")
external fun Player.setRotationByVector(
    vector: Vector? = null
)

/**
 * Установить скорость регенерации с насыщением
 * Устанавливает игроку скорость регенерации с насыщением.
 */
@Action("player_set_saturated_regen_rate")
external fun Player.setSaturatedRegenRate(
    rate: Double = 0.0
)

/**
 * Установить насыщенность
 * Устанавливает второстепенный уровень голода (насыщенность) игроку.
 */
@Action("player_set_saturation")
external fun Player.setSaturation(
    saturation: Double = 0.0,
    mode: PlayerMode = PlayerMode.SET
)

/**
 * Установить скорборд
 * Устанавливает скорборд для игроков.
 */
@Action("player_set_scoreboard_name")
external fun Player.setScoreboardName()

/**
 * Установить очки
 * Устанавливает очки у данного скорборда.
 */
@Action("player_set_scoreboard_score")
external fun Player.setScoreboardScore()

/**
 * Установить видимость скорборда
 * Устанавливает видимость скорборда у игрока.
 */
@Action("player_set_scoreboard_visible")
external fun Player.setScoreboardVisible()

/**
 * Установить дистанцию симуляции
 * Устанавливает дистанцию симуляции чанков для игрока.
 */
@Action("player_set_simulation_distance")
external fun Player.setSimulationDistance(
    distance: Double = 0.0
)

/**
 * Установить скин
 * Устанавливает скин указанного игрока для цели события.
 */
@Action("player_set_skin")
external fun Player.setSkin(
    nameOrUuid: Text = "",
    serverType: PlayerServerType = PlayerServerType.MOJANG
)

/**
 * Установить предмет в слот
 * Устанавливает предмет в слот в инвентаре игрока.
 */
@Action("player_set_slot_item")
external fun Player.setSlotItem(
    item: Item,
    slot: Double
)

/**
 * Установить местоположение возрождения
 * Устанавливает игроку новое местоположение возрождения.
 */
@Action("player_set_spawn_point")
external fun Player.setSpawnPoint(spawnPoint: Location)

/**
 * Установить скорость голодания
 * Устанавливает игроку скорость голодания.
 */
@Action("player_set_starvation_rate")
external fun Player.setStarvationRate(
    rate: Double = 0.0
)

/**
 * Установить уровень грозы
 * Устанавливает уровень грозы игроку.
 */
@Action("player_set_thunder_level")
external fun Player.setThunderLevel(
    thunderLevel: Double = 0.0
)

/**
 * Установить тик-рейт
 * Устанавливает игроку тик-рейт, не влияя на других игроков.
 */
@Action("player_set_tick_rate")
external fun Player.setTickRate(
    tickRate: Double = 0.0
)

/**
 * Установить время игрока
 * Установить время игроку, не меняя его для остальных игроков.
 */
@Action("player_set_time")
external fun Player.setTime(
    time: Double = 0.0
)

/**
 * Установить скорость регенерации без насыщения
 * Устанавливает игроку скорость регенерации без насыщения.
 */
@Action("player_set_unsaturated_regen_rate")
external fun Player.setUnsaturatedRegenRate(
    rate: Double = 0.0
)

/**
 * Запустить по вектору
 * Запускает игрока по указанному вектору.
 */
@Action("player_set_velocity")
external fun Player.setVelocity(
    velocity: Vector,
    increment: Boolean = false
)

/**
 * Установить визуальный огонь
 * Устанавливает игроку эффект горения.
 */
@Action("player_set_visual_fire")
external fun Player.setVisualFire(
    visualFire: Boolean = false
)

/**
 * Установить цвет значка на локаторе
 * Устанавливает игроку цвет значка, отображаемого на локаторе.
 */
@Action("player_set_waypoint_color")
external fun Player.setWaypointColor(
    red: Double = 0.0,
    green: Double = 0.0,
    blue: Double = 0.0
)

/**
 * Установить стиль значка на локаторе
 * Устанавливает игроку стиль значка, отображаемого на локаторе.
 */
@Action("player_set_waypoint_style")
external fun Player.setWaypointStyle(
    style: Text = ""
)

/**
 * Установить погоду
 * Установить погоду для игрока, не влияя на других игроков.
 */
@Action("player_set_weather")
external fun Player.setWeather(
    weatherType: PlayerWeatherType = PlayerWeatherType.DOWNFALL
)

/**
 * Установить границу мира игроку
 * Установить границу мира для игрока, не меняя её для других игроков.
 */
@Action("player_set_world_border")
external fun Player.setWorldBorder(
    center: Location,
    size: Double,
    warning: Double = 0.0
)

/**
 * Передвинуть границу мира
 * Передвинуть границу мира для игрока, не меняя её для других игроков.
 */
@Action("player_shift_world_border")
external fun Player.shiftWorldBorder(
    oldSize: Double = 0.0,
    size: Double = 0.0,
    time: Double = 0.0
)

/**
 * Показать кастомный рецепт
 * Отображает игроку новый рецепт в книге рецептов.
 */
@Action("player_show_custom_recipe")
external fun Player.showCustomRecipe(
    vararg names: Text,
    isVanillaRecipe: Boolean = false
)

/**
 * Показать отладочный маркер
 * Показывает игроку отладочный маркер на местоположении на указанное время. Красный и синий цвет работают для игроков на версии 1.19.4 и выше.
 */
@Action("player_show_debug_marker")
external fun Player.showDebugMarker(
    location: Location? = null,
    name: Text = "",
    duration: Double = 0.0,
    red: Double = 0.0,
    green: Double = 0.0,
    blue: Double = 0.0,
    alpha: Double = 0.0
)

/**
 * Показать экран демо-режима
 * Показывает игроку экран демо-режима.
 */
@Action("player_show_demo_screen")
external fun Player.showDemoScreen()

/**
 * Показать диалоговое окно
 * Показывает игроку диалоговое окно из NBT-тегов.
 */
@Action("player_show_dialog_menu_from_nbt")
external fun Player.showDialogMenuFromNbt(
    dialogNbt: Text = ""
)

/**
 * Показать меню
 * Показывает игроку инвентарное меню с выбранными предметами и названием.
 */
@Action("player_show_inventory_menu")
external fun Player.showInventoryMenu(
    vararg items: Item,
    name: Text = "",
    inventoryType: PlayerInventoryType = PlayerInventoryType.CHEST,
    customId: Text = ""
)

/**
 * Показать скорборд
 * Отображает определённый скорборд игроку. Для отображения указанный скорборд должен иметь минимум одно значение.
 */
@Action("player_show_scoreboard")
external fun Player.showScoreboard(id: Text)

/**
 * Показать экран титров
 * Показывает игроку экран титров.
 */
@Action("player_show_win_screen")
external fun Player.showWinScreen()

/**
 * Следить за целью
 * Устанавливает цель слежения игрока в режиме наблюдателя.
 */
@Action("player_spectate_target")
external fun Player.spectateTarget(
    nameOrUuid: Text = ""
)

/**
 * Начать использование предмета
 * Начинает использование предмета в указанной руке.
 */
@Action("player_start_using_item")
external fun Player.startUsingItem(
    equipment: PlayerEquipment = PlayerEquipment.MAIN_HAND
)

/**
 * Остановить звук
 * Останавливает все или определённые звуки для игрока.
 */
@Action("player_stop_sound")
external fun Player.stopSound(
    vararg sounds: Sound
)

/**
 * Остановить звуки по источнику
 * Останавливает все звуки по определённому источнику.
 */
@Action("player_stop_sounds_by_source")
external fun Player.stopSoundsBySource(
    source: PlayerSource = PlayerSource.MASTER
)

/**
 * Проиграть анимацию взмаха руки
 * Проигрывает для игрока анимацию взмаха руки.
 */
@Action("player_swing_hand")
external fun Player.swingHand(
    handType: PlayerHandType = PlayerHandType.MAIN
)

/**
 * Телепортация
 * Телепортирует игрока в выбранное местоположение.
 */
@Action("player_teleport")
external fun Player.teleport(
    location: Location,
    keepRotation: Boolean = false,
    keepVelocity: Boolean = false,
    ignorePassengers: Boolean = false,
    dismount: Boolean = false
)

/**
 * Последовательность телепортаций
 * Телепортирует игрока между местоположениями с заданной задержкой.
 */
@Action("player_teleport_sequence")
external fun Player.teleportSequence(
    vararg locations: Location,
    delay: Double = 0.0
)

/**
 * Переместить на другой сервер
 * Перемещает игрока на указанный сервер.
 */
@Action("player_transfer_to_other_server")
external fun Player.transferToOtherServer(
    domain: Text = "",
    port: Double = 0.0
)
