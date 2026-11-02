package justmc.entity

import justmc.value.*
import kotlin.*

/**
 * Дополнительное здоровье
 * Получает количество единиц поглощательного (золотого) здоровья цели.
 */
inline var Entity.absorptionHealth: Double
    get() = gameValue("absorption_health", this)
    set(value) = setAbsorptionHealth(value)

/**
 * Время использования предмета
 * Получает текущее время использования предмета в руке.
 */
inline val Entity.activeItemUsedTime: Double get() = gameValue("active_item_used_time", this)

/**
 * Возраст цели
 * Получает возраст цели в тиках.
 */
inline val Entity.age: Double get() = gameValue("age", this)

/**
 * Предметы брони
 * Получает предметы в слотах брони цели.
 */
inline val Entity.armorItems: List<Item> get() = gameValue("armor_items", this)

/**
 * Очки защиты
 * Получает количество единиц брони цели, которое можно изменить предметами.
 */
inline val Entity.armorPoints: Double get() = gameValue("armor_points", this)

/**
 * Твёрдость брони
 * Получает количество единиц твёрдости брони цели, которое можно изменить предметами.
 */
inline val Entity.armorToughness: Double get() = gameValue("armor_toughness", this)

/**
 * Количество стрел в теле
 * Получает количество стрел в теле цели.
 */
inline val Entity.arrowsInBody: Double get() = gameValue("arrows_in_body", this)

/**
 * Привязанные сущности
 * Получает UUID сущностей, которые привязаны поводком к цели.
 */
inline val Entity.attachedLeads: List<Text> get() = gameValue("attached_leads", this)

/**
 * Кулдаун атаки
 * Получает текущий кулдаун атаки цели.
 */
inline val Entity.attackCooldownStrength: Double get() = gameValue("attack_cooldown_strength", this)

/**
 * Кулдаун атаки в тиках
 * Получает текущий кулдаун атаки цели в тиках.
 */
inline val Entity.attackCooldownTicks: Double get() = gameValue("attack_cooldown_ticks", this)

/**
 * Урон от атаки
 * Получает количество единиц урона от атак цели, которое можно изменить предметами.
 */
inline val Entity.attackDamage: Double get() = gameValue("attack_damage", this)

/**
 * Скорость атаки
 * Получает скорость атаки цели, которую можно изменить предметами.
 */
inline val Entity.attackSpeed: Double get() = gameValue("attack_speed", this)

/**
 * Местоположение блока под целью
 * Получает местоположение блока под целью.
 */
inline val Entity.blockBeneath: Location get() = gameValue("block_beneath", this)

/**
 * Блоки под целью
 * Получает местоположения всех блоков, находящихся под целью.
 */
inline val Entity.blocksBeneath: List<Text> get() = gameValue("blocks_beneath", this)

/**
 * Поворот тела
 * Получает поворот тела цели.
 */
inline val Entity.bodyYaw: Double get() = gameValue("body_yaw", this)

/**
 * Местоположение плаща
 * Получает местоположение плаща игрока.
 */
inline val Entity.capeLocation: Location get() = gameValue("cape_location", this)

/**
 * Кардинальное направление
 * Получает кардинальное направление (север, запад, юг, восток) цели.
 */
inline val Entity.cardinalDirection: Text get() = gameValue("cardinal_direction", this)

/**
 * Видимость чата
 * Получает статус видимости чата игрока.
 */
inline val Entity.chatVisibility: Text get() = gameValue("chat_visibility", this)

/**
 * Название клиента игрока
 * Получает название клиента игрока.
 */
inline val Entity.clientBrandName: Text get() = gameValue("client_brand_name", this)

/**
 * Дальность прорисовки игрока
 * Получает дальность прорисовки игрока, установленную в настройках игры.
 */
inline val Entity.clientViewDistance: Double get() = gameValue("client_view_distance", this)

/**
 * Язык клиента игрока
 * Получает язык клиента игрока.
 */
inline val Entity.clientsideLocale: Text get() = gameValue("clientside_locale", this)

/**
 * Количество изумрудов в транзакции
 * Получает количество потраченных изумрудов в транзакции.
 */
inline val Entity.currencyTransactionAmount: Text get() = gameValue("currency_transaction_amount", this)

/**
 * Причина запроса транзакции
 * Получает причину запроса транзакции в изумрудах.
 */
inline val Entity.currencyTransactionReason: Text get() = gameValue("currency_transaction_reason", this)

/**
 * Результат транзакции
 * Получает результат совершённой транзакции.
 */
inline val Entity.currencyTransactionResult: Text get() = gameValue("currency_transaction_result", this)

/**
 * Текущее здоровье
 * Получает оставшееся количество единиц здоровья цели.
 */
inline var Entity.currentHealth: Double
    get() = gameValue("current_health", this)
    set(value) = setCurrentHealth(value)

/**
 * Текущие нажатые клавиши передвижения
 * Получает нажатые в данный момент клавиши передвижения.
 */
inline val Entity.currentInputList: List<Text> get() = gameValue("current_input_list", this)

/**
 * Предмет на курсоре
 * Получает предмет на курсоре цели (используется при переносе предметов в инвентаре).
 */
inline val Entity.cursorItem: Item get() = gameValue("cursor_item", this)

/**
 * Список предметов в открытом инвентаре
 * Возвращает список, содержащий предметы, которые находятся в текущем открытом инвентарном меню.
 */
inline val Entity.customInventoryItems: List<Item> get() = gameValue("custom_inventory_items", this)

/**
 * Количество очков
 * Получает количество очков, отображаемых на экране смерти.
 */
inline val Entity.deathScreenScore: Double get() = gameValue("death_screen_score", this)

/**
 * Направление взгляда
 * Получает вектор направления взгляда цели.
 */
inline val Entity.directionOfView: Vector get() = gameValue("direction_of_view", this)

/**
 * Левый поворот визуализатора
 * Получает левый поворот визуализатора в виде вектора.
 */
inline val Entity.displayEntityLeftRotation: Vector get() = gameValue("display_entity_left_rotation", this)

/**
 * Правый поворот визуализатора
 * Получает правый поворот визуализатора в виде вектора.
 */
inline val Entity.displayEntityRightRotation: Vector get() = gameValue("display_entity_right_rotation", this)

/**
 * Масштаб визуализатора
 * Получает масштаб визуализатора в виде вектора.
 */
inline val Entity.displayEntityScale: Vector get() = gameValue("display_entity_scale", this)

/**
 * Смещение визуализатора
 * Получает смещение визуализатора в виде вектора.
 */
inline val Entity.displayEntityTranslation: Vector get() = gameValue("display_entity_translation", this)

/**
 * Отображаемое имя
 * Получает отображаемое имя цели.
 */
inline val Entity.displayName: Text get() = gameValue("display_name", this)

/**
 * Время до взрыва
 * Получает время до взрыва сущности.
 */
inline val Entity.entityFuseTicks: Double get() = gameValue("entity_fuse_ticks", this)

/**
 * Высота хитбокса
 * Получает размер хитбокса цели по оси Y.
 */
inline val Entity.entityHeight: Double get() = gameValue("entity_height", this)

/**
 * Предмет сущности
 * Получает предметную форму цели.
 */
inline val Entity.entityItem: Item get() = gameValue("entity_item", this)

/**
 * Индекс точки на пути
 * Получает текущий индекс точки пути моба, по которому он идет.
 */
inline val Entity.entityPathfinderPointIndex: Double get() = gameValue("entity_pathfinder_point_index", this)

/**
 * Текущий маршрут
 * Получает список всех точек, которые составляют текущий путь моба.
 */
inline val Entity.entityPathfinderPoints: List<Location> get() = gameValue("entity_pathfinder_points", this)

/**
 * Получаемый предмет сущности
 * Получает предмет, получаемый при нажатии колесиком (СКМ) по сущности.
 */
inline val Entity.entityPickItemStack: Item get() = gameValue("entity_pick_item_stack", this)

/**
 * Время жизни цели
 * Получает количество тиков существования цели.
 */
inline val Entity.entityTicksLived: Double get() = gameValue("entity_ticks_lived", this)

/**
 * Тип сущности
 * Получает тип сущности цели.
 */
inline val Entity.entityType: Text get() = gameValue("entity_type", this)

/**
 * Ширина хитбокса
 * Получает размер хитбокса цели по оси X.
 */
inline val Entity.entityWidthX: Double get() = gameValue("entity_width_x", this)

/**
 * Длина хитбокса
 * Получает размер хитбокса цели по оси Z.
 */
inline val Entity.entityWidthZ: Double get() = gameValue("entity_width_z", this)

/**
 * Уровень опыта
 * Получает количество уровней опыта цели.
 */
inline val Entity.experienceLevel: Double get() = gameValue("experience_level", this)

/**
 * Прогресс опыта
 * Получает процентный прогресс текущего уровня опыта цели.
 */
inline val Entity.experienceProgress: Double get() = gameValue("experience_progress", this)

/**
 * Местоположение глаз
 * Получает местоположение цели на высоте глаз.
 */
inline val Entity.eyeLocation: Location get() = gameValue("eye_location", this)

/**
 * Дистанция падения
 * Получает дистанцию падения цели в блоках.
 */
inline var Entity.fallDistance: Double
    get() = gameValue("fall_distance", this)
    set(value) = setFallDistance(value)

/**
 * Время горения
 * Получает оставшееся количество тиков горения цели.
 */
inline var Entity.fireTicks: Double
    get() = gameValue("fire_ticks", this)
    set(value) = setFireTicks(value)

/**
 * Скорость полёта
 * Получает текущую скорость полёта цели (атрибут).
 */
inline val Entity.flyingSpeed: Double get() = gameValue("flying_speed", this)

/**
 * Уровень истощения
 * Получает уровень истощения цели, который увеличивается от выполненных действий игрока.
 */
inline val Entity.foodExhaustion: Double get() = gameValue("food_exhaustion", this)

/**
 * Уровень голода
 * Получает оставшееся количество единиц еды цели.
 */
inline val Entity.foodLevel: Double get() = gameValue("food_level", this)

/**
 * Уровень насыщения
 * Получает количество единиц насыщения едой цели, которое зависит от видов съеденной еды.
 */
inline val Entity.foodSaturation: Double get() = gameValue("food_saturation", this)

/**
 * Время заморозки
 * Получает текущее время заморозки цели.
 */
inline var Entity.freezeTicks: Double
    get() = gameValue("freeze_ticks", this)
    set(value) = setFreezeTicks(value)

/**
 * Режим игры
 * Получает текущий режим игры игрока.
 */
inline val Entity.gamemode: Text get() = gameValue("gamemode", this)

/**
 * Выбранный слот в хот-баре
 * Получает выбранный слот хот-бара цели.
 */
inline val Entity.heldSlot: Double get() = gameValue("held_slot", this)

/**
 * Центр хитбокса
 * Получает местоположение центра хитбокса цели.
 */
inline val Entity.hitboxMidpointLocation: Location get() = gameValue("hitbox_midpoint_location", this)

/**
 * Предметы в хот-баре
 * Получает предметы в хот-баре цели.
 */
inline val Entity.hotbarItems: List<Item> get() = gameValue("hotbar_items", this)

/**
 * Длительность простоя
 * Получает текущую длительность простоя игрока.
 */
inline val Entity.idleDuration: Double get() = gameValue("idle_duration", this)

/**
 * Предметы в инвентаре
 * Получает предметы в инвентаре цели (включая хот-бар).
 */
inline val Entity.inventoryItems: List<Item> get() = gameValue("inventory_items", this)

/**
 * Время бессмертия
 * Получает оставшееся количество тиков неуязвимости цели.
 */
inline var Entity.invulnerabilityTicks: Double
    get() = gameValue("invulnerability_ticks", this)
    set(value) = setInvulnerabilityTicks(value)

/**
 * Прогресс использования предмета
 * Получает процентный прогресс использования целью предмета в руке, например еды.
 */
inline val Entity.itemUsageProgress: Double get() = gameValue("item_usage_progress", this)

/**
 * Последняя причина урона
 * Получает последнюю причину урона цели.
 */
inline val Entity.lastDamageCause: Text get() = gameValue("last_damage_cause", this)

/**
 * Местоположение последней смерти
 * Получает местоположение последней смерти игрока.
 */
inline val Entity.lastDeathLocation: Location get() = gameValue("last_death_location", this)

/**
 * Поводырь
 * Получает UUID сущности, которая ведёт цель на поводке.
 */
inline val Entity.leadHolder: Text get() = gameValue("lead_holder", this)

/**
 * Местоположение
 * Получает местоположение цели.
 */
inline val Entity.location: Location get() = gameValue("location", this)

/**
 * Ведущая рука
 * Получает ведущую руку игрока.
 */
inline val Entity.mainHand: Text get() = gameValue("main_hand", this)

/**
 * Предмет в ведущей руке
 * Получает предмет в ведущей руке цели.
 */
inline val Entity.mainHandItem: Item get() = gameValue("main_hand_item", this)

/**
 * Максимальное здоровье
 * Получает максимальное количество единиц здоровья цели.
 */
inline var Entity.maxHealth: Double
    get() = gameValue("max_health", this)
    set(value) = setMaxHealth(value)

/**
 * Общее время бессмертия
 * Получает количество тиков на которое выдана неуязвимость для цели.
 */
inline var Entity.maxInvulnerabilityTicks: Double
    get() = gameValue("max_invulnerability_ticks", this)
    set(value) = setMaxInvulnerabilityTicks(value)

/**
 * Количество торгов Жителя
 * Получает количество торгов Жителя.
 */
inline val Entity.merchantRecipeCount: Double get() = gameValue("merchant_recipe_count", this)

/**
 * Имя
 * Получает имя цели.
 */
inline val Entity.name: Text get() = gameValue("name", this)

/**
 * Предмет во второй руке
 * Получает предмет во второстепенной руке цели.
 */
inline val Entity.offHandItem: Item get() = gameValue("off_hand_item", this)

/**
 * Кастомный ID открытого инвентаря
 * Получает кастомный ID открытого инвентаря цели.
 */
inline val Entity.openInventoryCustomId: Text get() = gameValue("open_inventory_custom_id", this)

/**
 * Размер открытого инвентаря
 * Получает размер текущего открытого инвентаря.
 */
inline val Entity.openInventorySize: Double get() = gameValue("open_inventory_size", this)

/**
 * Заголовок открытого инвентаря
 * Получает заголовок открытого инвентаря цели.
 */
inline val Entity.openInventoryTitle: Text get() = gameValue("open_inventory_title", this)

/**
 * Тип открытого инвентаря
 * Получает тип открытого инвентаря цели.
 */
inline val Entity.openInventoryType: Text get() = gameValue("open_inventory_type", this)

/**
 * Местоположение первого появления
 * Получает местоположение первого появления цели.
 */
inline val Entity.origin: Location get() = gameValue("origin", this)

/**
 * Видимость частиц
 * Получает значение настроек видимости частиц игрока.
 */
inline val Entity.particleVisibility: Text get() = gameValue("particle_visibility", this)

/**
 * Пассажиры
 * Получает UUID сущностей, которые едут на цели.
 */
inline val Entity.passengers: List<Text> get() = gameValue("passengers", this)

/**
 * Пинг игрока
 * Получает задержку между игроком и сервером в миллисекундах.
 */
inline val Entity.ping: Double get() = gameValue("ping", this)

/**
 * Вертикальный поворот
 * Получает вертикальный (вверх/вниз) поворот (pitch) цели.
 */
inline val Entity.pitch: Double get() = gameValue("pitch", this)

/**
 * Список эндер-жемчугов
 * Получает список не приземлившихся эндер-жемчугов игрока.
 */
inline val Entity.playerEnderPearls: List<Text> get() = gameValue("player_ender_pearls", this)

/**
 * Предметы в эндер-сундуке
 * Получает предметы в эндер-сундуке цели.
 */
inline val Entity.playerEnderchestItems: List<Item> get() = gameValue("player_enderchest_items", this)

/**
 * Поза сущности
 * Получает позу сущности.
 */
inline val Entity.pose: Text get() = gameValue("pose", this)

/**
 * Эффекты зелий
 * Получает действующие эффекты зелий цели.
 */
inline val Entity.potionEffects: List<Potion> get() = gameValue("potion_effects", this)

/**
 * Вектор движения снаряда
 * Получает вектор движения снаряда.
 */
inline val Entity.projectilePower: Vector get() = gameValue("projectile_power", this)

/**
 * Версия протокола клиента
 * Получает версию протокола клиента игрока.
 */
inline val Entity.protocolVersion: Double get() = gameValue("protocol_version", this)

/**
 * Оставшийся воздух
 * Получает оставшееся количество тиков воздуха цели.
 */
inline val Entity.remainingAir: Double get() = gameValue("remaining_air", this)

/**
 * Предмет на седле
 * Получает седло или ковёр, надетые на цель.
 */
inline val Entity.saddleItem: Item get() = gameValue("saddle_item", this)

/**
 * Скорость регенерации от насыщения
 * Получает скорость регенерации игрока с насыщением.
 */
inline val Entity.saturatedRegenRate: Double get() = gameValue("saturated_regen_rate", this)

/**
 * Местоположение спавна мира
 * Получает местоположение точки спавна мира.
 */
inline val Entity.spawnLocation: Location get() = gameValue("spawn_location", this)

/**
 * Причина спавна
 * Получает причину спавна цели.
 */
inline val Entity.spawnReason: Text get() = gameValue("spawn_reason", this)

/**
 * Скорость голодания
 * Получает скорость голодания цели.
 */
inline val Entity.starvationRate: Double get() = gameValue("starvation_rate", this)

/**
 * Прямолинейное движение транспорта
 * Получает значение движения транспорта вперёд или назад.
 */
inline val Entity.steerForward: Double get() = gameValue("steer_forward", this)

/**
 * Движение транспорта в стороны
 * Получает значение движения транспорта влево или вправо.
 */
inline val Entity.steerSideways: Double get() = gameValue("steer_sideways", this)

/**
 * Сторона целевого блока
 * Получает направление стороны блока, на которую смотрит цель.
 */
inline val Entity.targetBlockFace: Text get() = gameValue("target_block_face", this)

/**
 * Местоположение целевого блока
 * Получает местоположение блока, на который смотрит цель.
 */
inline val Entity.targetBlockLocation: Location get() = gameValue("target_block_location", this)

/**
 * Местоположение целевой жидкости
 * Получает местоположение жидкости, на которую смотрит цель.
 */
inline val Entity.targetFluidLocation: Location get() = gameValue("target_fluid_location", this)

/**
 * Цель для атаки
 * Получает текущую цель для атаки мобом.
 */
inline val Entity.targetedEntity: Text get() = gameValue("targeted_entity", this)

/**
 * Скорость регенерации без насыщения
 * Получает скорость регенерации игрока без насыщения.
 */
inline val Entity.unsaturatedRegenRate: Double get() = gameValue("unsaturated_regen_rate", this)

/**
 * Серверный язык игрока
 * Получает текущий серверный язык игрока.
 */
inline val Entity.userLocale: Text get() = gameValue("user_locale", this)

/**
 * UUID
 * Получает универсальный уникальный идентификатор (UUID) цели.
 */
inline val Entity.uuid: Text get() = gameValue("uuid", this)

/**
 * Транспорт
 * Получает UUID сущности, которую оседлала цель.
 */
inline val Entity.vehicle: Text get() = gameValue("vehicle", this)

/**
 * Вектор скорости
 * Получает вектор скорости движения цели (не ходьбы, а внешних сил).
 */
inline val Entity.velocity: Vector get() = gameValue("velocity", this)

/**
 * Скорость ходьбы
 * Получает текущую скорость ходьбы цели (атрибут).
 */
inline val Entity.walkingSpeed: Double get() = gameValue("walking_speed", this)

/**
 * Координата X
 * Получает координату X местоположения цели.
 */
inline val Entity.xCoordinate: Double get() = gameValue("x_coordinate", this)

/**
 * Координата Y
 * Получает координату Y местоположения цели.
 */
inline val Entity.yCoordinate: Double get() = gameValue("y_coordinate", this)

/**
 * Горизонтальный поворот
 * Получает горизонтальный (влево/вправо) поворот (yaw) цели.
 */
inline val Entity.yaw: Double get() = gameValue("yaw", this)

/**
 * Координата Z
 * Получает координату Z местоположения цели.
 */
inline val Entity.zCoordinate: Double get() = gameValue("z_coordinate", this)

// --- Convenient Aliases & Operators ---
inline var Entity.health: Double
    get() = currentHealth
    set(value) = setCurrentHealth(value)

inline var Entity.maxHealthPoints: Double
    get() = maxHealth
    set(value) = setMaxHealth(value)

inline var Entity.customName: Text
    get() = name
    set(value) = setCustomName(value)

inline operator fun Entity.get(tagName: String): String = getCustomTag(tagName)
inline operator fun Entity.set(tagName: String, tagValue: String) = setCustomTag(tagName, tagValue)
inline operator fun Entity.contains(tagName: String): Boolean = hasCustomTag(tagName)