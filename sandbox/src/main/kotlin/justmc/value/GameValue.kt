package justmc.value

import justmc.annotation.*
import kotlin.*

object GameValue {
    /**
     * Текущее здоровье
     *
     * Получает оставшееся количество единиц здоровья цели.
     */
    @Inline
    fun currentHealth(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("current_health", selection)

    /**
     * Максимальное здоровье
     *
     * Получает максимальное количество единиц здоровья цели.
     */
    @Inline
    fun maxHealth(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("max_health", selection)

    /**
     * Дополнительное здоровье
     *
     * Получает количество единиц поглощательного (золотого) здоровья цели.
     */
    @Inline
    fun absorptionHealth(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("absorption_health", selection)

    /**
     * Уровень голода
     *
     * Получает оставшееся количество единиц еды цели.
     */
    @Inline
    fun foodLevel(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("food_level", selection)

    /**
     * Уровень насыщения
     *
     * Получает количество единиц насыщения едой цели, которое зависит от видов съеденной еды.
     */
    @Inline
    fun foodSaturation(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("food_saturation", selection)

    /**
     * Уровень истощения
     *
     * Получает уровень истощения цели, который увеличивается от выполненных действий игрока.
     */
    @Inline
    fun foodExhaustion(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("food_exhaustion", selection)

    /**
     * Урон от атаки
     *
     * Получает количество единиц урона от атак цели, которое можно изменить предметами.
     */
    @Inline
    fun attackDamage(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("attack_damage", selection)

    /**
     * Скорость атаки
     *
     * Получает скорость атаки цели, которую можно изменить предметами.
     */
    @Inline
    fun attackSpeed(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("attack_speed", selection)

    /**
     * Очки защиты
     *
     * Получает количество единиц брони цели, которое можно изменить предметами.
     */
    @Inline
    fun armorPoints(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("armor_points", selection)

    /**
     * Твёрдость брони
     *
     * Получает количество единиц твёрдости брони цели, которое можно изменить предметами.
     */
    @Inline
    fun armorToughness(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("armor_toughness", selection)

    /**
     * Время бессмертия
     *
     * Получает оставшееся количество тиков неуязвимости цели.
     */
    @Inline
    fun invulnerabilityTicks(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("invulnerability_ticks", selection)

    /**
     * Уровень опыта
     *
     * Получает количество уровней опыта цели.
     */
    @Inline
    fun experienceLevel(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("experience_level", selection)

    /**
     * Прогресс опыта
     *
     * Получает процентный прогресс текущего уровня опыта цели.
     */
    @Inline
    fun experienceProgress(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("experience_progress", selection)

    /**
     * Время горения
     *
     * Получает оставшееся количество тиков горения цели.
     */
    @Inline
    fun fireTicks(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("fire_ticks", selection)

    /**
     * Время заморозки
     *
     * Получает текущее время заморозки цели.
     */
    @Inline
    fun freezeTicks(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("freeze_ticks", selection)

    /**
     * Оставшийся воздух
     *
     * Получает оставшееся количество тиков воздуха цели.
     */
    @Inline
    fun remainingAir(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("remaining_air", selection)

    /**
     * Дистанция падения
     *
     * Получает дистанцию падения цели в блоках.
     */
    @Inline
    fun fallDistance(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("fall_distance", selection)

    /**
     * Выбранный слот в хот-баре
     *
     * Получает выбранный слот хот-бара цели.
     */
    @Inline
    fun heldSlot(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("held_slot", selection)

    /**
     * Скорость ходьбы
     *
     * Получает текущую скорость ходьбы цели (атрибут).
     */
    @Inline
    fun walkingSpeed(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("walking_speed", selection)

    /**
     * Скорость полёта
     *
     * Получает текущую скорость полёта цели (атрибут).
     */
    @Inline
    fun flyingSpeed(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("flying_speed", selection)

    /**
     * Пинг игрока
     *
     * Получает задержку между игроком и сервером в миллисекундах.
     */
    @Inline
    fun ping(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("ping", selection)

    /**
     * Версия протокола клиента
     *
     * Получает версию протокола клиента игрока.
     */
    @Inline
    fun protocolVersion(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("protocol_version", selection)

    /**
     * Прогресс использования предмета
     *
     * Получает процентный прогресс использования целью предмета в руке, например еды.
     */
    @Inline
    fun itemUsageProgress(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("item_usage_progress", selection)

    /**
     * Время жизни цели
     *
     * Получает количество тиков существования цели.
     */
    @Inline
    fun entityTicksLived(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("entity_ticks_lived", selection)

    /**
     * Количество стрел в теле
     *
     * Получает количество стрел в теле цели.
     */
    @Inline
    fun arrowsInBody(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("arrows_in_body", selection)

    /**
     * Возраст цели
     *
     * Получает возраст цели в тиках.
     */
    @Inline
    fun age(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("age", selection)

    /**
     * Прямолинейное движение транспорта
     *
     * Получает значение движения транспорта вперёд или назад.
     */
    @Inline
    fun steerForward(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("steer_forward", selection)

    /**
     * Движение транспорта в стороны
     *
     * Получает значение движения транспорта влево или вправо.
     */
    @Inline
    fun steerSideways(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("steer_sideways", selection)

    /**
     * Количество торгов Жителя
     *
     * Получает количество торгов Жителя.
     */
    @Inline
    fun merchantRecipeCount(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("merchant_recipe_count", selection)

    /**
     * Размер открытого инвентаря
     *
     * Получает размер текущего открытого инвентаря.
     */
    @Inline
    fun openInventorySize(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("open_inventory_size", selection)

    /**
     * Ширина хитбокса
     *
     * Получает размер хитбокса цели по оси X.
     */
    @Inline
    fun entityWidthX(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("entity_width_x", selection)

    /**
     * Длина хитбокса
     *
     * Получает размер хитбокса цели по оси Z.
     */
    @Inline
    fun entityWidthZ(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("entity_width_z", selection)

    /**
     * Высота хитбокса
     *
     * Получает размер хитбокса цели по оси Y.
     */
    @Inline
    fun entityHeight(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("entity_height", selection)

    /**
     * Время до взрыва
     *
     * Получает время до взрыва сущности.
     */
    @Inline
    fun entityFuseTicks(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("entity_fuse_ticks", selection)

    /**
     * Местоположение
     *
     * Получает местоположение цели.
     */
    @Inline
    fun location(selection: GameValueSelection = GameValueSelection.DEFAULT): Location =
        gameValue("location", selection)

    /**
     * Местоположение целевого блока
     *
     * Получает местоположение блока, на который смотрит цель.
     */
    @Inline
    fun targetBlockLocation(selection: GameValueSelection = GameValueSelection.DEFAULT): Location =
        gameValue("target_block_location", selection)

    /**
     * Местоположение целевой жидкости
     *
     * Получает местоположение жидкости, на которую смотрит цель.
     */
    @Inline
    fun targetFluidLocation(selection: GameValueSelection = GameValueSelection.DEFAULT): Location =
        gameValue("target_fluid_location", selection)

    /**
     * Сторона целевого блока
     *
     * Получает направление стороны блока, на которую смотрит цель.
     */
    @Inline
    fun targetBlockFace(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("target_block_face", selection)

    /**
     * Местоположение глаз
     *
     * Получает местоположение цели на высоте глаз.
     */
    @Inline
    fun eyeLocation(selection: GameValueSelection = GameValueSelection.DEFAULT): Location =
        gameValue("eye_location", selection)

    /**
     * Координата X
     *
     * Получает координату X местоположения цели.
     */
    @Inline
    fun xCoordinate(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("x_coordinate", selection)

    /**
     * Координата Y
     *
     * Получает координату Y местоположения цели.
     */
    @Inline
    fun yCoordinate(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("y_coordinate", selection)

    /**
     * Координата Z
     *
     * Получает координату Z местоположения цели.
     */
    @Inline
    fun zCoordinate(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("z_coordinate", selection)

    /**
     * Вертикальный поворот
     *
     * Получает вертикальный (вверх/вниз) поворот (pitch) цели.
     */
    @Inline
    fun pitch(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("pitch", selection)

    /**
     * Горизонтальный поворот
     *
     * Получает горизонтальный (влево/вправо) поворот (yaw) цели.
     */
    @Inline
    fun yaw(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("yaw", selection)

    /**
     * Направление взгляда
     *
     * Получает вектор направления взгляда цели.
     */
    @Inline
    fun directionOfView(selection: GameValueSelection = GameValueSelection.DEFAULT): Vector =
        gameValue("direction_of_view", selection)

    /**
     * Кардинальное направление
     *
     * Получает кардинальное направление (север, запад, юг, восток) цели.
     */
    @Inline
    fun cardinalDirection(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("cardinal_direction", selection)

    /**
     * Центр хитбокса
     *
     * Получает местоположение центра хитбокса цели.
     */
    @Inline
    fun hitboxMidpointLocation(selection: GameValueSelection = GameValueSelection.DEFAULT): Location =
        gameValue("hitbox_midpoint_location", selection)

    /**
     * Местоположение спавна мира
     *
     * Получает местоположение точки спавна мира.
     */
    @Inline
    fun spawnLocation(selection: GameValueSelection = GameValueSelection.DEFAULT): Location =
        gameValue("spawn_location", selection)

    /**
     * Местоположение первого появления
     *
     * Получает местоположение первого появления цели.
     */
    @Inline
    fun origin(selection: GameValueSelection = GameValueSelection.DEFAULT): Location =
        gameValue("origin", selection)

    /**
     * Причина спавна
     *
     * Получает причину спавна цели.
     */
    @Inline
    fun spawnReason(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("spawn_reason", selection)

    /**
     * Поворот тела
     *
     * Получает поворот тела цели.
     */
    @Inline
    fun bodyYaw(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("body_yaw", selection)

    /**
     * Предмет в ведущей руке
     *
     * Получает предмет в ведущей руке цели.
     */
    @Inline
    fun mainHandItem(selection: GameValueSelection = GameValueSelection.DEFAULT): Item =
        gameValue("main_hand_item", selection)

    /**
     * Предмет во второй руке
     *
     * Получает предмет во второстепенной руке цели.
     */
    @Inline
    fun offHandItem(selection: GameValueSelection = GameValueSelection.DEFAULT): Item =
        gameValue("off_hand_item", selection)

    /**
     * Ведущая рука
     *
     * Получает ведущую руку игрока.
     */
    @Inline
    fun mainHand(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("main_hand", selection)

    /**
     * Отображаемое имя
     *
     * Получает отображаемое имя цели.
     */
    @Inline
    fun displayName(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("display_name", selection)

    /**
     * Предметы брони
     *
     * Получает предметы в слотах брони цели.
     */
    @Inline
    fun armorItems(selection: GameValueSelection = GameValueSelection.DEFAULT): List<Item> =
        gameValue("armor_items", selection)

    /**
     * Предметы в хот-баре
     *
     * Получает предметы в хот-баре цели.
     */
    @Inline
    fun hotbarItems(selection: GameValueSelection = GameValueSelection.DEFAULT): List<Item> =
        gameValue("hotbar_items", selection)

    /**
     * Предметы в инвентаре
     *
     * Получает предметы в инвентаре цели (включая хот-бар).
     */
    @Inline
    fun inventoryItems(selection: GameValueSelection = GameValueSelection.DEFAULT): List<Item> =
        gameValue("inventory_items", selection)

    /**
     * Список предметов в открытом инвентаре
     *
     * Возвращает список, содержащий предметы, которые находятся в текущем открытом инвентарном меню.
     */
    @Inline
    fun customInventoryItems(selection: GameValueSelection = GameValueSelection.DEFAULT): List<Item> =
        gameValue("custom_inventory_items", selection)

    /**
     * Предмет на курсоре
     *
     * Получает предмет на курсоре цели (используется при переносе предметов в инвентаре).
     */
    @Inline
    fun cursorItem(selection: GameValueSelection = GameValueSelection.DEFAULT): Item =
        gameValue("cursor_item", selection)

    /**
     * Предмет на седле
     *
     * Получает седло или ковёр, надетые на цель.
     */
    @Inline
    fun saddleItem(selection: GameValueSelection = GameValueSelection.DEFAULT): Item =
        gameValue("saddle_item", selection)

    /**
     * Предмет сущности
     *
     * Получает предметную форму цели.
     */
    @Inline
    fun entityItem(selection: GameValueSelection = GameValueSelection.DEFAULT): Item =
        gameValue("entity_item", selection)

    /**
     * Имя
     *
     * Получает имя цели.
     */
    @Inline
    fun name(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("name", selection)

    /**
     * UUID
     *
     * Получает универсальный уникальный идентификатор (UUID) цели.
     */
    @Inline
    fun uuid(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("uuid", selection)

    /**
     * Тип сущности
     *
     * Получает тип сущности цели.
     */
    @Inline
    fun entityType(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("entity_type", selection)

    /**
     * Название клиента игрока
     *
     * Получает название клиента игрока.
     */
    @Inline
    fun clientBrandName(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("client_brand_name", selection)

    /**
     * Серверный язык игрока
     *
     * Получает текущий серверный язык игрока.
     */
    @Inline
    fun userLocale(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("user_locale", selection)

    /**
     * Заголовок открытого инвентаря
     *
     * Получает заголовок открытого инвентаря цели.
     */
    @Inline
    fun openInventoryTitle(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("open_inventory_title", selection)

    /**
     * Тип открытого инвентаря
     *
     * Получает тип открытого инвентаря цели.
     */
    @Inline
    fun openInventoryType(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("open_inventory_type", selection)

    /**
     * Режим игры
     *
     * Получает текущий режим игры игрока.
     */
    @Inline
    fun gamemode(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("gamemode", selection)

    /**
     * Последняя причина урона
     *
     * Получает последнюю причину урона цели.
     */
    @Inline
    fun lastDamageCause(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("last_damage_cause", selection)

    /**
     * Эффекты зелий
     *
     * Получает действующие эффекты зелий цели.
     */
    @Inline
    fun potionEffects(selection: GameValueSelection = GameValueSelection.DEFAULT): List<Potion> =
        gameValue("potion_effects", selection)

    /**
     * Вектор скорости
     *
     * Получает вектор скорости движения цели (не ходьбы, а внешних сил).
     */
    @Inline
    fun velocity(selection: GameValueSelection = GameValueSelection.DEFAULT): Vector =
        gameValue("velocity", selection)

    /**
     * Местоположение блока события
     *
     * Получает местоположение блока в событии.
     */
    @Inline
    fun eventBlockLocation(): Location =
        gameValue("event_block_location")

    /**
     * Сторона блока события
     *
     * Получает как направления сторону блока, задетую в событии.
     */
    @Inline
    fun eventBlockFace(): Text =
        gameValue("event_block_face")

    /**
     * Задействованные блоки события
     *
     * Получает список местоположений всех задействованных блоков в событии.
     */
    @Inline
    fun eventBlocksInvolved(): List<Location> =
        gameValue("event_blocks_involved")

    /**
     * Тип взаимодействия события
     *
     * Получает тип взаимодействия цели в событии.
     */
    @Inline
    fun eventInteraction(): Text =
        gameValue("event_interaction")

    /**
     * Новое местоположение игрока
     *
     * Получает новое местоположение игрока.
     */
    @Inline
    fun eventNewLocation(): Location =
        gameValue("event_new_location")

    /**
     * Нанесённый урон
     *
     * Получает количество единиц нанесённого урона в событии.
     */
    @Inline
    fun eventDamage(): Double =
        gameValue("event_damage")

    /**
     * Причина полученного урона
     *
     * Получает причину или тип полученного урона в событии.
     */
    @Inline
    fun eventDamageCause(): Text =
        gameValue("event_damage_cause")

    /**
     * Количество восстановленного здоровья
     *
     * Получает количество единиц восстановленного здоровья в событии.
     */
    @Inline
    fun eventHealAmount(): Double =
        gameValue("event_heal_amount")

    /**
     * Причина исцеления
     *
     * Получает причину восстановления здоровья в событии.
     */
    @Inline
    fun eventHealCause(): Text =
        gameValue("event_heal_cause")

    /**
     * Новый эффект
     *
     * Получает новый эффект события.
     */
    @Inline
    fun eventNewPotionEffect(): Potion =
        gameValue("event_new_potion_effect")

    /**
     * Процент силы выполнения
     *
     * Получает процент силы выполнения (натяжения лука, прыжка на коне) события.
     */
    @Inline
    fun eventPower(): Double =
        gameValue("event_power")

    /**
     * Предмет события
     *
     * Получает предмет в событии.
     */
    @Inline
    fun eventItem(): Item =
        gameValue("event_item")

    /**
     * Слот события
     *
     * Выдаёт номер слота в событии.
     */
    @Inline
    fun eventSlot(): Double =
        gameValue("event_slot")

    /**
     * Причина закрытия инвентаря
     *
     * Получает причину закрытия открытого инвентаря цели в событии.
     */
    @Inline
    fun eventCloseInventoryCause(): Text =
        gameValue("event_close_inventory_cause")

    /**
     * Тип клика по инвентарю
     *
     * Получает тип клика по открытому инвентарю цели в событии.
     */
    @Inline
    fun eventInventoryClickType(): Text =
        gameValue("event_inventory_click_type")

    /**
     * Тип перетягивания по инвентарю
     *
     * Получает тип перетягивания предметов по открытому инвентарю цели в событии.
     */
    @Inline
    fun eventDragType(): Text =
        gameValue("event_drag_type")

    /**
     * Задействованные слоты
     *
     * Получает список всех задействованных слотов открытого инвентаря цели в событии.
     */
    @Inline
    fun eventSlotsInvolved(): List<Double> =
        gameValue("event_slots_involved")

    /**
     * Распределённые предметы
     *
     * Выдаёт словарь распределённых по слотам предметов с помощью ЛКМ/ПКМ или дублирования с помощью колёсика мыши.
     */
    @Inline
    fun eventAddedItems(): Map<Double, Item> =
        gameValue("event_added_items")

    /**
     * Тип задействованного слота
     *
     * Получает тип задействованного слота цели в событии.
     */
    @Inline
    fun eventEquipmentSlot(): Text =
        gameValue("event_equipment_slot")

    /**
     * Причина события рыбалки
     *
     * Получает причину события рыбалки.
     */
    @Inline
    fun eventFishState(): Text =
        gameValue("event_fish_state")

    /**
     * Тип дерева
     *
     * Получает тип дерева в событии.
     */
    @Inline
    fun eventTreeType(): Text =
        gameValue("event_tree_type")

    /**
     * Количество опыта события
     *
     * Получает количество единиц опыта в событии.
     */
    @Inline
    fun eventExperience(): Double =
        gameValue("event_experience")

    /**
     * Причина удаления висящей сущности
     *
     * Получает причину удаления висящей сущности (картины, рамки).
     */
    @Inline
    fun eventHangingBreakCause(): Text =
        gameValue("event_hanging_break_cause")

    /**
     * Причина пропуска времени
     *
     * Получает причину пропуска времени в мире.
     */
    @Inline
    fun eventTimeSkipReason(): Text =
        gameValue("event_time_skip_reason")

    /**
     * Количество тиков пропуска времени
     *
     * Получает количество тиков пропуска времени в мире.
     */
    @Inline
    fun eventTimeSkipAmount(): Double =
        gameValue("event_time_skip_amount")

    /**
     * Восполненный голод события
     *
     * Получает количество единиц восполненного голода.
     */
    @Inline
    fun eventFoodLevel(): Double =
        gameValue("event_food_level")

    /**
     * Предмет снаряда события
     *
     * Получает предмет снаряда события.
     */
    @Inline
    fun eventProjectileItem(): Item =
        gameValue("event_projectile_item")

    /**
     * Причина телепортации
     *
     * Получает причину телепортации в событии.
     */
    @Inline
    fun eventTeleportCause(): Text =
        gameValue("event_teleport_cause")

    /**
     * Количество тиков использования предмета
     *
     * Получает количество тиков использования предмета.
     */
    @Inline
    fun eventTicksHeldFor(): Double =
        gameValue("event_ticks_held_for")

    /**
     * Отладочная информация
     *
     * Получает отладочную информацию целевого блока или сущности.
     */
    @Inline
    fun eventQueryInfo(): Text =
        gameValue("event_query_info")

    /**
     * Причина неудачного перемещения
     *
     * Получает причину неудачного перемещения.
     */
    @Inline
    fun eventFailMoveReason(): Text =
        gameValue("event_fail_move_reason")

    /**
     * Количество игроков в мире
     *
     * Получает количество игроков, находящихся в мире.
     */
    @Inline
    fun playerCount(): Double =
        gameValue("player_count")

    /**
     * Процент использования процессора
     *
     * Получает процент нагрузки миром процессора сервера.
     */
    @Inline
    fun cpuUsage(): Double =
        gameValue("cpu_usage")

    /**
     * TPS сервера
     *
     * Получает количество Тиков За Секунду (TPS), которое может обработать сервер.
     */
    @Inline
    fun serverTps(): Double =
        gameValue("server_tps")

    /**
     * UNIX-время
     *
     * Получает текущее время как одно число в миллисекундах.
     */
    @Inline
    fun timestamp(): Double =
        gameValue("timestamp")

    /**
     * Текущее время сервера
     *
     * Получает текущее время сервера в тиках.
     */
    @Inline
    fun serverCurrentTick(): Double =
        gameValue("server_current_tick")

    /**
     * Количество выбранных целей
     *
     * Получает количество целей в выборке.
     */
    @Inline
    fun selectionSize(): Double =
        gameValue("selection_size")

    /**
     * Имена выбранных целей
     *
     * Получает имя каждой цели в выборке.
     */
    @Inline
    fun selectionTargetNames(): List<Text> =
        gameValue("selection_target_names")

    /**
     * UUID выбранных целей
     *
     * Получает UUID каждой цели в выборке.
     */
    @Inline
    fun selectionTargetUuids(): List<Text> =
        gameValue("selection_target_uuids")

    /**
     * Ответ на веб-запрос
     *
     * Получает ответ на отправленный веб-запрос.
     */
    @Inline
    fun urlResponse(): Text =
        gameValue("url_response")

    /**
     * Код ответа на веб-запрос
     *
     * Получает код ответа на отправленный веб-запрос.
     */
    @Inline
    fun urlResponseCode(): Double =
        gameValue("url_response_code")

    /**
     * Время остановки сервера
     *
     * Получает время остановки сервера в миллисекундах.
     */
    @Inline
    fun serverStoppedTime(): Double =
        gameValue("server_stopped_time")

    /**
     * Количество действий за тик
     *
     * Получает количество действий в мире за тик.
     */
    @Inline
    fun actionCountPerTick(): Double =
        gameValue("action_count_per_tick")

    /**
     * UUID владельца мира
     *
     * Получает UUID владельца мира.
     */
    @Inline
    fun ownerUuid(): Text =
        gameValue("owner_uuid")

    /**
     * Размер мира
     *
     * Получает текущий размер мира в чанках.
     */
    @Inline
    fun worldSize(): Double =
        gameValue("world_size")

    /**
     * ID мира
     *
     * Получает идентификатор мира.
     */
    @Inline
    fun worldId(): Text =
        gameValue("world_id")

    /**
     * Транспорт
     *
     * Получает UUID сущности, которую оседлала цель.
     */
    @Inline
    fun vehicle(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("vehicle", selection)

    /**
     * Пассажиры
     *
     * Получает UUID сущностей, которые едут на цели.
     */
    @Inline
    fun passengers(selection: GameValueSelection = GameValueSelection.DEFAULT): List<Text> =
        gameValue("passengers", selection)

    /**
     * Поводырь
     *
     * Получает UUID сущности, которая ведёт цель на поводке.
     */
    @Inline
    fun leadHolder(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("lead_holder", selection)

    /**
     * Привязанные сущности
     *
     * Получает UUID сущностей, которые привязаны поводком к цели.
     */
    @Inline
    fun attachedLeads(selection: GameValueSelection = GameValueSelection.DEFAULT): List<Text> =
        gameValue("attached_leads", selection)

    /**
     * Цель для атаки
     *
     * Получает текущую цель для атаки мобом.
     */
    @Inline
    fun targetedEntity(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("targeted_entity", selection)

    /**
     * Сообщение чата
     *
     * Получает сообщение, отправленное целью в событии.
     */
    @Inline
    fun eventChatMessage(): Text =
        gameValue("event_chat_message")

    /**
     * Слот хот-бара в событии
     *
     * Получает текущий номер слота хот-бара в событии.
     */
    @Inline
    fun eventHotbarSlot(): Double =
        gameValue("event_hotbar_slot")

    /**
     * Тип слота при клике
     *
     * Получает текущий тип слота инвентарного меню при клике по нему.
     */
    @Inline
    fun eventSlotType(): Text =
        gameValue("event_slot_type")

    /**
     * Действие в инвентаре при клике
     *
     * Получает текущее действие в инвентарном меню при клике по нему.
     */
    @Inline
    fun eventInventoryAction(): Text =
        gameValue("event_inventory_action")

    /**
     * Сообщение события
     *
     * Получает системное сообщение, отправленное в событии.
     */
    @Inline
    fun eventMessage(): Text =
        gameValue("event_message")

    /**
     * Ссылка веб-запроса
     *
     * Получает ссылку веб-запроса.
     */
    @Inline
    fun url(): Text =
        gameValue("url")

    /**
     * Текущее время мира
     *
     * Получает текущее время мира в тиках.
     */
    @Inline
    fun worldTime(): Double =
        gameValue("world_time")

    /**
     * Время существования мира
     *
     * Получает время существования мира в тиках.
     */
    @Inline
    fun worldGameTime(): Double =
        gameValue("world_game_time")

    /**
     * Текущая погода мира
     *
     * Получает тип текущей погоды мира.
     */
    @Inline
    fun worldWeather(): Text =
        gameValue("world_weather")

    /**
     * Местоположение блока под целью
     *
     * Получает местоположение блока под целью.
     */
    @Inline
    fun blockBeneath(selection: GameValueSelection = GameValueSelection.DEFAULT): Location =
        gameValue("block_beneath", selection)

    /**
     * Блоки под целью
     *
     * Получает местоположения всех блоков, находящихся под целью.
     */
    @Inline
    fun blocksBeneath(selection: GameValueSelection = GameValueSelection.DEFAULT): List<Location> =
        gameValue("blocks_beneath", selection)

    /**
     * Предметы события
     *
     * Получает все предметы в событии.
     */
    @Inline
    fun eventItems(): List<Item> =
        gameValue("event_items")

    /**
     * Заменённые сущности события
     *
     * Получает заменённых сущностей события.
     */
    @Inline
    fun eventTransformedEntities(): List<Text> =
        gameValue("event_transformed_entities")

    /**
     * Причина замены сущности
     *
     * Получает причину замены сущности события.
     */
    @Inline
    fun eventTransformReason(): Text =
        gameValue("event_transform_reason")

    /**
     * Заменённый блок
     *
     * Получает ID заменённого блока события.
     */
    @Inline
    fun eventReplacedBlock(): Text =
        gameValue("event_replaced_block")

    /**
     * Кулдаун атаки в тиках
     *
     * Получает текущий кулдаун атаки цели в тиках.
     */
    @Inline
    fun attackCooldownTicks(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("attack_cooldown_ticks", selection)

    /**
     * Кулдаун атаки
     *
     * Получает текущий кулдаун атаки цели.
     */
    @Inline
    fun attackCooldownStrength(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("attack_cooldown_strength", selection)

    /**
     * Истощение события
     *
     * Получает количество полученного истощения.
     */
    @Inline
    fun eventExhaustionAmount(): Double =
        gameValue("event_exhaustion_amount")

    /**
     * Причина истощения
     *
     * Получает причину истощения.
     */
    @Inline
    fun eventExhaustionReason(): Text =
        gameValue("event_exhaustion_reason")

    /**
     * Вектор движения снаряда
     *
     * Получает вектор движения снаряда.
     */
    @Inline
    fun projectilePower(selection: GameValueSelection = GameValueSelection.DEFAULT): Vector =
        gameValue("projectile_power", selection)

    /**
     * Дальность прорисовки игрока
     *
     * Получает дальность прорисовки игрока, установленную в настройках игры.
     */
    @Inline
    fun clientViewDistance(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("client_view_distance", selection)

    /**
     * Общее время бессмертия
     *
     * Получает количество тиков на которое выдана неуязвимость для цели.
     */
    @Inline
    fun maxInvulnerabilityTicks(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("max_invulnerability_ticks", selection)

    /**
     * Местоположение плаща
     *
     * Получает местоположение плаща игрока.
     */
    @Inline
    fun capeLocation(selection: GameValueSelection = GameValueSelection.DEFAULT): Location =
        gameValue("cape_location", selection)

    /**
     * Видимость чата
     *
     * Получает статус видимости чата игрока.
     */
    @Inline
    fun chatVisibility(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("chat_visibility", selection)

    /**
     * Имя вкладки достижений
     *
     * Получает имя текущей вкладки достижений события.
     */
    @Inline
    fun eventAdvancementTabName(): Text =
        gameValue("event_advancement_tab_name")

    /**
     * UUID владельца снаряда
     *
     * Получает UUID владельца снаряда.
     */
    @Inline
    fun projectileOwnerUuid(): Text =
        gameValue("projectile_owner_uuid")

    /**
     * Смещение визуализатора
     *
     * Получает смещение визуализатора в виде вектора.
     */
    @Inline
    fun displayEntityTranslation(selection: GameValueSelection = GameValueSelection.DEFAULT): Vector =
        gameValue("display_entity_translation", selection)

    /**
     * Масштаб визуализатора
     *
     * Получает масштаб визуализатора в виде вектора.
     */
    @Inline
    fun displayEntityScale(selection: GameValueSelection = GameValueSelection.DEFAULT): Vector =
        gameValue("display_entity_scale", selection)

    /**
     * Старое местоположение игрока
     *
     * Получает старое местоположение игрока.
     */
    @Inline
    fun eventFromLocation(): Location =
        gameValue("event_from_location")

    /**
     * Строки таблички
     *
     * Получает строки таблички в виде списка.
     */
    @Inline
    fun eventSignLines(): List<Text> =
        gameValue("event_sign_lines")

    /**
     * Сторона таблички
     *
     * Получает сторону таблички в виде текста.
     */
    @Inline
    fun eventSignSide(): Text =
        gameValue("event_sign_side")

    /**
     * Новое имя предмета
     *
     * Получает новое имя предмета в наковальне.
     */
    @Inline
    fun eventAnvilRenameInput(): Text =
        gameValue("event_anvil_rename_input")

    /**
     * Процент использования процессора частицами
     *
     * Получает процент нагрузки процессора сервера созданием частиц.
     */
    @Inline
    fun particleCpuUsage(): Double =
        gameValue("particle_cpu_usage")

    /**
     * Тип отталкивания
     *
     * Получает тип отталкивания в событии.
     */
    @Inline
    fun eventKnockbackEventType(): Text =
        gameValue("event_knockback_event_type")

    /**
     * Причина отталкивания
     *
     * Получает причину отталкивания в событии.
     */
    @Inline
    fun eventKnockbackCause(): Text =
        gameValue("event_knockback_cause")

    /**
     * Вектор отталкивания
     *
     * Получает вектор отталкивания в событии.
     */
    @Inline
    fun eventKnockbackVector(): Vector =
        gameValue("event_knockback_vector")

    /**
     * Вектор скорости
     *
     * Получает вектор скорости в событии.
     */
    @Inline
    fun eventVelocity(): Vector =
        gameValue("event_velocity")

    /**
     * Поза сущности
     *
     * Получает позу сущности.
     */
    @Inline
    fun pose(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("pose", selection)

    /**
     * Конечный урон
     *
     * Получает конечное количество единиц нанесённого урона в событии.
     */
    @Inline
    fun eventFinalDamage(): Double =
        gameValue("event_final_damage")

    /**
     * Левый поворот визуализатора
     *
     * Получает левый поворот визуализатора в виде вектора.
     */
    @Inline
    fun displayEntityLeftRotation(selection: GameValueSelection = GameValueSelection.DEFAULT): Vector =
        gameValue("display_entity_left_rotation", selection)

    /**
     * Правый поворот визуализатора
     *
     * Получает правый поворот визуализатора в виде вектора.
     */
    @Inline
    fun displayEntityRightRotation(selection: GameValueSelection = GameValueSelection.DEFAULT): Vector =
        gameValue("display_entity_right_rotation", selection)

    /**
     * Длительность ясной погоды в мире
     *
     * Получает текущую длительность ясной погоды в мире.
     */
    @Inline
    fun worldClearWeatherDuration(): Double =
        gameValue("world_clear_weather_duration")

    /**
     * Длительность текущей погоды мира
     *
     * Получает длительность текущей погоды мира.
     */
    @Inline
    fun worldWeatherDuration(): Double =
        gameValue("world_weather_duration")

    /**
     * Длительность дождя в мире
     *
     * Получает текущую длительность дождя в мире.
     */
    @Inline
    fun worldThunderDuration(): Double =
        gameValue("world_thunder_duration")

    /**
     * Текущая фаза луны
     *
     * Получает текущую фазу луны в мире.
     */
    @Inline
    fun worldMoonPhase(): Text =
        gameValue("world_moon_phase")

    /**
     * Язык клиента игрока
     *
     * Получает язык клиента игрока.
     */
    @Inline
    fun clientsideLocale(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("clientside_locale", selection)

    /**
     * Предложенное зачарование
     *
     * Получает название предложенного зачарования в столе зачарований.
     */
    @Inline
    fun eventEnchantmentHint(): Text =
        gameValue("event_enchantment_hint")

    /**
     * Полученные зачарования
     *
     * Получает словарь полученных зачарований предмета.
     */
    @Inline
    fun eventEnchantmentsToAdd(): Map<Text, Double> =
        gameValue("event_enchantments_to_add")

    /**
     * Требуемый уровень опыта зачарования
     *
     * Получает требуемый уровень опыта для выбранного зачарования.
     */
    @Inline
    fun eventEnchantmentLevelHint(): Double =
        gameValue("event_enchantment_level_hint")

    /**
     * Заголовки ответа на веб-запрос
     *
     * Получает заголовки ответа на отправленный веб-запрос.
     */
    @Inline
    fun responseHeaders(): Map<Text, Text> =
        gameValue("response_headers")

    /**
     * Экипировка
     *
     * Получает экипировку из события.
     */
    @Inline
    fun eventNewEquipments(): Map<Text, Item> =
        gameValue("event_new_equipments")

    /**
     * Прошлая экипировка события
     *
     * Получает прошлую экипировку события.
     */
    @Inline
    fun eventOldEquipments(): Map<Text, Item> =
        gameValue("event_old_equipments")

    /**
     * Список нажатых клавиш передвижения
     *
     * Получает список нажатых клавиш передвижения события.
     */
    @Inline
    fun eventInputList(): List<Text> =
        gameValue("event_input_list")

    /**
     * Новое состояние сокровищницы
     *
     * Получает новое состояние сокровищницы.
     */
    @Inline
    fun eventNewVaultState(): Text =
        gameValue("event_new_vault_state")

    /**
     * Прошлое состояние сокровищницы
     *
     * Получает прошлое состояние сокровищницы.
     */
    @Inline
    fun eventOldVaultState(): Text =
        gameValue("event_old_vault_state")

    /**
     * Причина сгорания сущности
     *
     * Получает причину сгорания сущности из события.
     */
    @Inline
    fun eventCombustReason(): Text =
        gameValue("event_combust_reason")

    /**
     * Длительность сгорания сущности
     *
     * Получает длительность сгорания сущности из события.
     */
    @Inline
    fun eventCombustDuration(): Double =
        gameValue("event_combust_duration")

    /**
     * Группа предмета с задержкой
     *
     * Получает группу предмета, на который распостраняется задержка из события.
     */
    @Inline
    fun eventItemCooldownGroup(): Text =
        gameValue("event_item_cooldown_group")

    /**
     * Задержка предмета события
     *
     * Получает задержку предметы события.
     */
    @Inline
    fun eventItemCooldown(): Double =
        gameValue("event_item_cooldown")

    /**
     * Новое состояние поплавка
     *
     * Получает новое состояние поплавка.
     */
    @Inline
    fun eventNewFishingHookState(): Text =
        gameValue("event_new_fishing_hook_state")

    /**
     * Количество очков
     *
     * Получает количество очков, отображаемых на экране смерти.
     */
    @Inline
    fun deathScreenScore(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("death_screen_score", selection)

    /**
     * Сообщение при смерти
     *
     * Получает сообщение, отображаемое на экране смерти.
     */
    @Inline
    fun eventDeathScreenMessage(): Text =
        gameValue("event_death_screen_message")

    /**
     * Текущие нажатые клавиши передвижения
     *
     * Получает нажатые в данный момент клавиши передвижения.
     */
    @Inline
    fun currentInputList(selection: GameValueSelection = GameValueSelection.DEFAULT): List<Text> =
        gameValue("current_input_list", selection)

    /**
     * Видимость частиц
     *
     * Получает значение настроек видимости частиц игрока.
     */
    @Inline
    fun particleVisibility(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("particle_visibility", selection)

    /**
     * Получаемый предмет сущности
     *
     * Получает предмет, получаемый при нажатии колесиком (СКМ) по сущности.
     */
    @Inline
    fun entityPickItemStack(selection: GameValueSelection = GameValueSelection.DEFAULT): Item =
        gameValue("entity_pick_item_stack", selection)

    /**
     * Текущий маршрут
     *
     * Получает список всех точек, которые составляют текущий путь моба.
     */
    @Inline
    fun entityPathfinderPoints(selection: GameValueSelection = GameValueSelection.DEFAULT): List<Location> =
        gameValue("entity_pathfinder_points", selection)

    /**
     * ID кастомного клика
     *
     * Получает идентификатор кастомного клика в диалоговом окне или чате.
     */
    @Inline
    fun eventCustomClickKey(): Text =
        gameValue("event_custom_click_key")

    /**
     * Данные диалогового окна
     *
     * Получает данные, введённые игроком в диалоговое окно.
     */
    @Inline
    fun eventCustomClickDialogViewData(): Any =
        gameValue("event_custom_click_dialog_view_data")

    /**
     * Режим игры события
     *
     * Получает режим игры, связанный с событием.
     */
    @Inline
    fun eventGamemode(): Text =
        gameValue("event_gamemode")

    /**
     * Кастомный ID открытого инвентаря
     *
     * Получает кастомный ID открытого инвентаря цели.
     */
    @Inline
    fun openInventoryCustomId(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("open_inventory_custom_id", selection)

    /**
     * Блок события
     *
     * Получает ID блока, связанного с событием.
     */
    @Inline
    fun eventBlock(): Text =
        gameValue("event_block")

    /**
     * Предлагаемые зачарования события
     *
     * Получает список предлагаемых игроку зачарований, связанных с событием.
     */
    @Inline
    fun eventEnchantmentOffers(): List<Any> =
        gameValue("event_enchantment_offers")

    /**
     * Количество книжных полок
     *
     * Получает количество книжных полок, связанных с событием.
     */
    @Inline
    fun eventEnchantmentBonus(): Double =
        gameValue("event_enchantment_bonus")

    /**
     * Старый предмет события
     *
     * Получает старый предмет в событии.
     */
    @Inline
    fun eventOldItem(): Item =
        gameValue("event_old_item")

    /**
     * Предметы в эндер-сундуке
     *
     * Получает предметы в эндер-сундуке цели.
     */
    @Inline
    fun playerEnderchestItems(selection: GameValueSelection = GameValueSelection.DEFAULT): List<Item> =
        gameValue("player_enderchest_items", selection)

    /**
     * Причина запроса транзакции
     *
     * Получает причину запроса транзакции в изумрудах.
     */
    @Inline
    fun currencyTransactionReason(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("currency_transaction_reason", selection)

    /**
     * Количество изумрудов в транзакции
     *
     * Получает количество потраченных изумрудов в транзакции.
     */
    @Inline
    fun currencyTransactionAmount(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("currency_transaction_amount", selection)

    /**
     * Результат транзакции
     *
     * Получает результат совершённой транзакции.
     */
    @Inline
    fun currencyTransactionResult(selection: GameValueSelection = GameValueSelection.DEFAULT): Text =
        gameValue("currency_transaction_result", selection)

    /**
     * Проверка античита
     *
     * Получает название проверки античита, на которой засекли игрока.
     */
    @Inline
    fun anticheatCheck(): Text =
        gameValue("anticheat_check")

    /**
     * Срабатываний античита
     *
     * Получает количество срабатываний проверки античита у игрока.
     */
    @Inline
    fun anticheatViolations(): Double =
        gameValue("anticheat_violations")

    /**
     * Новое состояние поломки наковальни
     *
     * Получает новое состояние поломки наковальни.
     */
    @Inline
    fun eventAnvilDamageState(): Text =
        gameValue("event_anvil_damage_state")

    /**
     * Скорость голодания
     *
     * Получает скорость голодания цели.
     */
    @Inline
    fun starvationRate(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("starvation_rate", selection)

    /**
     * Причина отвязывания сущности
     *
     * Получает причину по которой сущность была отвязана.
     */
    @Inline
    fun eventEntityUnleashReason(): Text =
        gameValue("event_entity_unleash_reason")

    /**
     * Прогресс поломки блока
     *
     * Получает прогресс поломки блока, связанного с событием.
     */
    @Inline
    fun eventBlockBreakProgress(): Double =
        gameValue("event_block_break_progress")

    /**
     * Список эндер-жемчугов
     *
     * Получает список не приземлившихся эндер-жемчугов игрока.
     */
    @Inline
    fun playerEnderPearls(selection: GameValueSelection = GameValueSelection.DEFAULT): List<Any> =
        gameValue("player_ender_pearls", selection)

    /**
     * Местоположение последней смерти
     *
     * Получает местоположение последней смерти игрока.
     */
    @Inline
    fun lastDeathLocation(selection: GameValueSelection = GameValueSelection.DEFAULT): Location =
        gameValue("last_death_location", selection)

    /**
     * Скорость регенерации от насыщения
     *
     * Получает скорость регенерации игрока с насыщением.
     */
    @Inline
    fun saturatedRegenRate(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("saturated_regen_rate", selection)

    /**
     * Скорость регенерации без насыщения
     *
     * Получает скорость регенерации игрока без насыщения.
     */
    @Inline
    fun unsaturatedRegenRate(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("unsaturated_regen_rate", selection)

    /**
     * Длительность простоя
     *
     * Получает текущую длительность простоя игрока.
     */
    @Inline
    fun idleDuration(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("idle_duration", selection)

    /**
     * Индекс точки на пути
     *
     * Получает текущий индекс точки пути моба, по которому он идет.
     */
    @Inline
    fun entityPathfinderPointIndex(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("entity_pathfinder_point_index", selection)

    /**
     * Текущий сид зачарований
     *
     * Получает текущий сид зачарований игрока.
     */
    @Inline
    fun enchantmentSeed(): Double =
        gameValue("enchantment_seed")

    /**
     * Нанесённый урон предмету
     *
     * Получает количество единиц нанесённого урона предмету.
     */
    @Inline
    fun eventItemDamage(): Double =
        gameValue("event_item_damage")

    /**
     * Имена всех игроков
     *
     * Получает имена всех игроков, находящихся в мире.
     */
    @Inline
    fun allPlayersNames(): List<Text> =
        gameValue("all_players_names")

    /**
     * UUID всех игроков
     *
     * Получает UUID всех игроков, находящихся в мире.
     */
    @Inline
    fun allPlayersUuids(): List<Text> =
        gameValue("all_players_uuids")

    /**
     * Имена всех сущностей
     *
     * Получает имена всех сущностей, находящихся в мире.
     */
    @Inline
    fun allEntitiesNames(): List<Text> =
        gameValue("all_entities_names")

    /**
     * UUID всех сущностей
     *
     * Получает UUID всех сущностей, находящихся в мире.
     */
    @Inline
    fun allEntitiesUuids(): List<Text> =
        gameValue("all_entities_uuids")

    /**
     * Время использования предмета
     *
     * Получает текущее время использования предмета в руке.
     */
    @Inline
    fun activeItemUsedTime(selection: GameValueSelection = GameValueSelection.DEFAULT): Double =
        gameValue("active_item_used_time", selection)

    /**
     * Время начала заморозки мира
     *
     * Получает время начала заморозки мира в тиках.
     */
    @Inline
    fun startReloadTick(): Double =
        gameValue("start_reload_tick")

    /**
     * Текущее время заморозки мира
     *
     * Получает текущее время, которое мир заморожен.
     */
    @Inline
    fun delayReloadCount(): Double =
        gameValue("delay_reload_count")
}