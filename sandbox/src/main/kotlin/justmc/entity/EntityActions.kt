package justmc.entity

import justmc.value.*
import kotlin.*
import justmc.annotation.*

/**
 * Привязать на поводок
 * Привязывает существо на поводок к забору или существу.
 */
@Action("entity_attach_lead")
external fun Entity.attachLead(
    nameOrUuid: Text = "",
    location: Location? = null
)

/**
 * Очистить эффекты
 * Очищает все эффекты у существа.
 */
@Action("entity_celar_potion_effects")
external fun Entity.celarPotionEffects()

/**
 * Очистить торги Жителю
 * Очищает все торги Жителю.
 */
@Action("entity_clear_merchant_recipes")
external fun Entity.clearMerchantRecipes()

/**
 * Очистить эффекты
 * Очищает все эффекты у существа.
 */
@Action("entity_clear_potion_effects")
external fun Entity.clearPotionEffects()

/**
 * Завершить использование предмета
 * Завершает использование текущего предмета в руке с результатом.
 */
@Action("entity_complete_using_active_item")
external fun Entity.completeUsingActiveItem()

/**
 * Нанести урон
 * Наносит урон существу.
 */
@Action("entity_damage")
external fun Entity.damage(
    damage: Double = 0.0,
    source: Text = ""
)

/**
 * Замаскировать сущность под блок
 * Маскирует сущность под блок.
 */
@Action("entity_disguise_as_block")
external fun Entity.disguiseAsBlock(block: Item)

/**
 * Замаскировать под сущность
 * Замаскировать сущность под сущность.
 */
@Action("entity_disguise_as_entity")
external fun Entity.disguiseAsEntity(entityType: Item)

/**
 * Замаскировать сущность под предмет
 * Маскирует сущность под предмет.
 */
@Action("entity_disguise_as_item")
external fun Entity.disguiseAsItem(item: Item)

/**
 * Замаскировать сущность под моба
 * Маскирует сущность под моба.
 */
@Action("entity_disguise_as_mob")
external fun Entity.disguiseAsMob()

/**
 * Замаскировать сущность под игрока
 * Маскирует сущность под игрока.
 */
@Action("entity_disguise_as_player")
external fun Entity.disguiseAsPlayer(
    nameOrUuid: Text = "",
    displayName: Text = "",
    serverType: EntityServerType = EntityServerType.MOJANG
)

/**
 * Есть траву
 * Заставляет овцу есть траву.
 */
@Action("entity_eat_grass")
external fun Entity.eatGrass()

/**
 * Установить цель поедания
 * Устанавливает существу цель для поедания.
 */
@Action("entity_eat_target")
external fun Entity.eatTarget(
    nameOrUuid: Text = ""
)

/**
 * Взорваться
 * Заставляет существо взорваться.
 */
@Action("entity_explode")
external fun Entity.explode()

/**
 * Повернуть к местоположению
 * Поворачивает существо в сторону к местоположению.
 */
@Action("entity_face_location")
external fun Entity.faceLocation(location: Location)

/**
 * Получить значение атрибута сущности
 * Получает значение указанного атрибута сущности и присваивает результат к переменной.
 */
@Action("entity_get_attribute", returns = ["variable"])
external fun Entity.getAttribute(
    attributeType: EntityAttributeType = EntityAttributeType.MAX_HEALTH,
    returnValue: EntityReturnValue = EntityReturnValue.VALUE
): Any

/**
 * Получить кастомный тег
 * Получает кастомный нбт-тег существа.
 */
@Action("entity_get_custom_tag", returns = ["variable"])
external fun Entity.getCustomTag(name: Text, default: Any? = null): String

/**
 * Получить кастомные теги
 * Получает кастомные теги существа и присваивает результат к переменной.
 */
@Action("entity_get_custom_tags", returns = ["variable"])
external fun Entity.getCustomTags(): Map<String, String>

/**
 * Получить снаряжение сущности
 * Получает снаряжение сущности из указанного слота, и присваивает результат к переменной.
 */
@Action("entity_get_equipment_item", returns = ["variable"])
external fun Entity.getEquipmentItem(slot: EntityEquipmentSlot = EntityEquipmentSlot.HAND): Any

/**
 * Получить NBT-теги сущности
 * Получает NBT-теги сущности по введённому пути и присваивает результат к переменной.
 */
@Action("entity_get_nbt", returns = ["variable"])
external fun Entity.getNbt(
    path: Text = "",
    valueType: EntityValueType = EntityValueType.ANY_VALUE
): Any

/**
 * Выдать эффекты
 * Выдаёт выбранные эффекты существу.
 */
@Action("entity_give_potion_effects")
external fun Entity.givePotionEffects(
    vararg potions: Potion,
    showIcon: Boolean = false,
    overwrite: Boolean = false,
    particleMode: EntityParticleMode = EntityParticleMode.REGULAR
)

/**
 * Исцелить существо
 * Исцеляет существо.
 */
@Action("entity_heal")
external fun Entity.heal(
    heal: Double = 0.0
)

/**
 * Зажечь крипера
 * Поджигает крипера, заставляя его взорваться после определённого периода.
 */
@Action("entity_ignite_creeper")
external fun Entity.igniteCreeper()

/**
 * Прыгнуть
 * Заставляет существо прыгнуть.
 */
@Action("entity_jump")
external fun Entity.jump()

/**
 * Запустить вперёд
 * Запускает существо вперёд или назад по направлению взгляда в зависимости от силы.
 */
@Action("entity_launch_forward")
external fun Entity.launchForward(
    increment: Boolean = false,
    launchAxis: EntityLaunchAxis = EntityLaunchAxis.YAW,
    power: Double = 0.0
)

/**
 * Запустить снаряд
 * Запустить снаряд из местоположения существа.
 */
@Action("entity_launch_projectile")
external fun Entity.launchProjectile(
    projectile: Item,
    location: Location,
    name: Text = "",
    speed: Double = 1.0,
    inaccuracy: Double = 0.0,
    trail: Particle? = null
)

/**
 * Запустить к местоположению
 * Запускает существа к выбранному местоположению.
 */
@Action("entity_launch_to_location")
external fun Entity.launchToLocation(
    location: Location,
    power: Double,
    increment: Boolean = false
)

/**
 * Подбросить вверх
 * Подбрасывает существо вверх или вниз в зависимости от силы.
 */
@Action("entity_launch_up")
external fun Entity.launchUp(
    increment: Boolean = false,
    power: Double = 0.0
)

/**
 * Высадить из транспорта
 * Высаживает существо из транспорта или существа.
 */
@Action("entity_leave_vehicle")
external fun Entity.leaveVehicle()

/**
 * Замаскировать сущность под сущность из мира
 * Маскирует сущность под указанную сущность из мира.
 */
@Action("entity_mimic_disguise_from_entity")
external fun Entity.mimicDisguiseFromEntity(
    nameOrUuid: Text = "",
    includeDisguise: Boolean = false,
    removeOriginalEntity: Boolean = false
)

/**
 * Изменить торги пиглина
 * Изменяет предметы, которые может дать пиглин при обмене.
 */
@Action("entity_modify_piglin_barter_materials")
external fun Entity.modifyPiglinBarterMaterials(
    vararg materials: Item,
    modificationMode: EntityModificationMode = EntityModificationMode.ADD
)

/**
 * Изменить предметы для торга с пиглином
 * Изменяет предметы, требуемые для обмена с пиглином.
 */
@Action("entity_modify_piglin_interested_materials")
external fun Entity.modifyPiglinInterestedMaterials(
    vararg materials: Item,
    modificationMode: EntityModificationMode = EntityModificationMode.ADD
)

/**
 * Установить движение к местоположению
 * Инструктирует ИИ существа всегда находить путь к определённому местоположению с определённой скоростью.
 */
@Action("entity_move_to_location")
external fun Entity.moveToLocation(
    location: Location,
    speed: Double = 1.0
)

/**
 * Остановить движение к местоположению
 * Останавливает сущность, идущую к местоположению.
 */
@Action("entity_move_to_location_stop")
external fun Entity.moveToLocationStop()

/**
 * Отобразить анимацию урона
 * Отображает анимацию урона существу.
 */
@Action("entity_play_damage_animation")
external fun Entity.playDamageAnimation(
    damageType: EntityDamageType = EntityDamageType.DAMAGE
)

/**
 * Отобразить анимацию получения урона
 * Отображает существу анимацию получения урона с определённым наклоном.
 */
@Action("entity_play_hurt_animation")
external fun Entity.playHurtAnimation(
    yaw: Double = 0.0
)

/**
 * Таранить сущность
 * Заставляет козлов таранить указанную сущность.
 */
@Action("entity_ram_target")
external fun Entity.ramTarget(
    nameOrUuid: Text = ""
)

/**
 * Удалить сущность
 * Удаляет сущность из мира.
 */
@Action("entity_remove")
external fun Entity.remove()

/**
 * Удалить кастомный тег
 * Удаляет кастомный нбт-тег у существа.
 */
@Action("entity_remove_custom_tag")
external fun Entity.removeCustomTag(name: Text)

/**
 * Удалить кастомные теги
 * Удаляет все кастомные теги сущности.
 */
@Action("entity_remove_custom_tags")
external fun Entity.removeCustomTags()

/**
 * Убрать маскировку
 * Убирает маскировку у сущности.
 */
@Action("entity_remove_disguise")
external fun Entity.removeDisguise()

/**
 * Удалить товар Жителю
 * Удаляет товар Жителю по указанному индексу.
 */
@Action("entity_remove_merchant_recipe")
external fun Entity.removeMerchantRecipe(
    recipeIndex: Double = 0.0
)

/**
 * Удалить эффект
 * Удаляет выбранные эффекты у существа.
 */
@Action("entity_remove_potion_effect")
external fun Entity.removePotionEffect(
    vararg effects: Potion
)

/**
 * Сбросить яркость
 * Сбросить яркость сущности-визуализатору.
 */
@Action("entity_reset_display_brightness")
external fun Entity.resetDisplayBrightness()

/**
 * Сбросить цвет свечения
 * Сбросить цвет свечения сущности-визуализатору.
 */
@Action("entity_reset_display_glow_color")
external fun Entity.resetDisplayGlowColor()

/**
 * Очистить описание манекена
 * Очищает описание манекена.
 */
@Action("entity_reset_mannequin_description")
external fun Entity.resetMannequinDescription()

/**
 * Сбросить цвет фона
 * Сбросить цвет и прозрачность фона визуализатору текста.
 */
@Action("entity_reset_text_display_background")
external fun Entity.resetTextDisplayBackground()

/**
 * Сбросить цвет значка на локаторе
 * Устанавливает сущности цвет значка, отображаемого на локаторе, по умолчанию.
 */
@Action("entity_reset_waypoint_color")
external fun Entity.resetWaypointColor()

/**
 * Вернуть поплавок
 * Возвращает закинутый поплавок удочки, находящейся в указанной руке сущности.
 */
@Action("entity_retrieve_fishing_hook")
external fun Entity.retrieveFishingHook(
    slot: EntityHookSlot = EntityHookSlot.MAIN_HAND
)

/**
 * Посадить на существо
 * Сажает существо на другое существо или игрока.
 */
@Action("entity_ride_entity")
external fun Entity.rideEntity(
    nameOrUuid: Text = ""
)

/**
 * Установить Броненосцу состояние защиты
 * Устанавливает броненосцу состояние защиты (свернут ли броненосец).
 */
@Action("entity_roll_armadillo")
external fun Entity.rollArmadillo(
    roll: EntityRoll = EntityRoll.ROLL_OUT
)

/**
 * Установить дополнительное здоровье
 * Устанавливает дополнительное здоровье существа.
 */
@Action("entity_set_absorption_health")
external fun Entity.setAbsorptionHealth(
    health: Double = 0.0
)

/**
 * Установить блокировку роста
 * Устанавливает блокировку роста существу.
 */
@Action("entity_set_age_lock")
external fun Entity.setAgeLock(
    ageLock: Boolean = false
)

/**
 * Установить интеллект сущности
 * Устанавливает интеллект сущности.
 */
@Action("entity_set_ai")
external fun Entity.setAi(
    ai: Boolean = false
)

/**
 * Сделать Тихоню танцующим
 * Заставляет Тихоню отображать анимацию танца.
 */
@Action("entity_set_allay_dancing")
external fun Entity.setAllayDancing(
    dance: Boolean = false
)

/**
 * Установить режим гнева
 * Устанавливает существу режим гнева на определённую цель.
 */
@Action("entity_set_angry")
external fun Entity.setAngry(
    angry: Boolean = false,
    target: Text = ""
)

/**
 * Установить возраст животному
 * Устанавливает возраст животному.
 */
@Action("entity_set_animal_age")
external fun Entity.setAnimalAge(
    age: Double = 0.0,
    lock: EntityAgeLock = EntityAgeLock.ENABLE
)

/**
 * Установить броню
 * Устанавливает броню сущности.
 */
@Action("entity_set_armor_items")
external fun Entity.setArmorItems(
    silent: Boolean = false,
    helmet: Item? = null,
    chestplate: Item? = null,
    leggings: Item? = null,
    boots: Item? = null
)

/**
 * Установить детали стойки для брони
 * Установить детали стойки для брони.
 */
@Action("entity_set_armor_stand_parts")
external fun Entity.setArmorStandParts(
    arms: EntityArmorStandArms = EntityArmorStandArms.ENABLE,
    basePlate: EntityArmorStandBasePlate = EntityArmorStandBasePlate.ENABLE
)

/**
 * Установить позу стойки для брони
 * Устанавливает позу стойки для брони.
 */
@Action("entity_set_armor_stand_pose")
external fun Entity.setArmorStandPose(
    xRotation: Double = 0.0,
    yRotation: Double = 0.0,
    zRotation: Double = 0.0,
    bodyPart: EntityBodyPart = EntityBodyPart.HEAD
)

/**
 * Установить звук попадания снаряда
 * Устанавливает снаряду звук, издаваемый при попадании в сущность.
 */
@Action("entity_set_arrow_hit_sound")
external fun Entity.setArrowHitSound(
    sound: Sound? = null
)

/**
 * Установить стреле количество пронзаний
 * Устанавливает стреле количество раз, которые она может пронзить сущность (от 0 до 127).
 */
@Action("entity_set_arrow_pierce")
external fun Entity.setArrowPierce(
    pierce: Double = 0.0
)

/**
 * Установить атрибут
 * Устанавливает указанный атрибут на указанное значение существу.
 */
@Action("entity_set_attribute")
external fun Entity.setAttribute(
    value: Double = 0.0,
    attributeType: EntityAttributeType = EntityAttributeType.MAX_HEALTH
)

/**
 * Установить осведомлённость моба
 * В выключенном состоянии отключает ИИ моба, но оставляет взаимодействие с гравитацией, толканием и т.д.
 */
@Action("entity_set_aware")
external fun Entity.setAware(
    aware: Boolean = false
)

/**
 * Установить тип аксолотля
 * Устанавливает тип аксолотля.
 */
@Action("entity_set_axolotl_type")
external fun Entity.setAxolotlType(
    axolotlType: EntityAxolotlType = EntityAxolotlType.LUCY
)

/**
 * Установить режим ребёнка
 * Устанавливает существу режим ребёнка.
 */
@Action("entity_set_baby")
external fun Entity.setBaby(
    baby: Boolean = false
)

/**
 * Установить первичный урон снаряду
 * Устанавливает снаряду первичный урон, который будет использован в формуле урона снаряда при попадании.
 */
@Action("entity_set_base_arrow_damage")
external fun Entity.setBaseArrowDamage(
    damage: Double = 0.0
)

/**
 * Установить Пчеле жало
 * Устанавливает состояние жала пчеле.
 */
@Action("entity_set_bee_has_stinger")
external fun Entity.setBeeHasStinger(
    stinger: Boolean = false
)

/**
 * Установить пыльцу пчеле
 * Устанавливает видимость пыльцы пчеле.
 */
@Action("entity_set_bee_nectar")
external fun Entity.setBeeNectar(
    nectar: Boolean = false
)

/**
 * Установить отображаемый блок
 * Устанавливает отображаемый блок визуализатору блока.
 */
@Action("entity_set_block_display_block")
external fun Entity.setBlockDisplayBlock(displayedBlock: Item)

/**
 * Установить анимацию рывка верблюду
 * Устанавливает анимацию рывка верблюду.
 */
@Action("entity_set_camel_dashing")
external fun Entity.setCamelDashing(
    dashing: Boolean = false
)

/**
 * Установить видимость сундука
 * Устанавливает видимость сундука на сущности.
 */
@Action("entity_set_carrying_chest")
external fun Entity.setCarryingChest(
    carrying: Boolean = false
)

/**
 * Установить режим лежания кошке
 * Устанавливает режим лежания кошке.
 */
@Action("entity_set_cat_lying_down")
external fun Entity.setCatLyingDown(
    lyingDown: Boolean = false
)

/**
 * Установить тип кошки
 * Устанавливает тип кошки.
 */
@Action("entity_set_cat_type")
external fun Entity.setCatType(
    catType: EntityCatType = EntityCatType.TABBY
)

/**
 * Установить режим празднования
 * Устанавливает режим празднования существу.
 */
@Action("entity_set_celebrating")
external fun Entity.setCelebrating(
    celebrating: Boolean = false
)

/**
 * Установить тип Курицы
 * Устанавливает курице тип окраски.
 */
@Action("entity_set_chicken_type")
external fun Entity.setChickenType(
    variant: EntityAnimalVariant = EntityAnimalVariant.COLD
)

/**
 * Установить режим столкновения
 * Устанавливает существу режим столкновения с другими существами.
 */
@Action("entity_set_collidable")
external fun Entity.setCollidable(
    collidable: Boolean = false
)

/**
 * Установить вощённость медного голема
 * Устанавливает вощённость медного голема.
 */
@Action("entity_set_copper_golem_oxidizing")
external fun Entity.setCopperGolemOxidizing(
    oxidizingState: EntityOxidizingState = EntityOxidizingState.WAXED
)

/**
 * Установить время окисления медного голема
 * Устанавливает время, за которое медный голем повышает уровень окисления под дождём.
 */
@Action("entity_set_copper_golem_oxidizing_at_time")
external fun Entity.setCopperGolemOxidizingAtTime(
    time: Double = 0.0
)

/**
 * Установить окисление медного голема
 * Устанавливает степень окисления медного голема.
 */
@Action("entity_set_copper_golem_weathering")
external fun Entity.setCopperGolemWeathering(
    weatheringState: EntityWeatheringState = EntityWeatheringState.UNAFFECTED
)

/**
 * Установить тип Коровы
 * Устанавливает корове тип окраски.
 */
@Action("entity_set_cow_type")
external fun Entity.setCowType(
    variant: EntityAnimalVariant = EntityAnimalVariant.COLD
)

/**
 * Установить заряженность криперу
 * Устанавливает, будет ли крипер заряженным.
 */
@Action("entity_set_creeper_charge")
external fun Entity.setCreeperCharge(
    charged: Boolean = false
)

/**
 * Установить криперу силу взрыва
 * Устанавливает силу взрыва криперу.
 */
@Action("entity_set_creeper_explosion_power")
external fun Entity.setCreeperExplosionPower(
    power: Double = 0.0
)

/**
 * Установить максимальное время взрыва криперу
 * Устанавливает максимальное время взрыва криперу.
 */
@Action("entity_set_creeper_fuse")
external fun Entity.setCreeperFuse(
    fuseTicks: Double = 0.0
)

/**
 * Установить силу взрыва крипера
 * Устанавливает криперу силу взрыва.
 */
@Action("entity_set_creeper_power")
external fun Entity.setCreeperPower()

/**
 * Установить здоровье существа
 * Устанавливает здоровье существа на выбранное количество.
 */
@Action("entity_set_current_health")
external fun Entity.setCurrentHealth(
    health: Double = 0.0
)

/**
 * Установить имя
 * Устанавливает имя для существа.
 */
@Action("entity_set_custom_name")
external fun Entity.setCustomName(
    customName: Text = ""
)

/**
 * Установить видимость имени
 * Устанавливает видимость имени существа.
 */
@Action("entity_set_custom_name_visibility")
external fun Entity.setCustomNameVisibility(
    visibility: Boolean = false
)

/**
 * Установить кастомный тег
 * Устанавливает кастомный нбт-тег существу.
 */
@Action("entity_set_custom_tag")
external fun Entity.setCustomTag(
    name: Text,
    value: Text = ""
)

/**
 * Установить выпадение предметов
 * Устанавливает, будет ли выпадать лут с существа.
 */
@Action("entity_set_death_drops")
external fun Entity.setDeathDrops(
    drops: Boolean = false
)

/**
 * Установить длительность смерти
 * Устанавливает длительность смерти для существа.
 */
@Action("entity_set_death_time")
external fun Entity.setDeathTime(
    deathTime: Double = 0.0
)

/**
 * Установить видимость
 * Устанавливает сущности видимость.
 */
@Action("entity_set_default_visible")
external fun Entity.setDefaultVisible(
    defaultVisible: Boolean = false
)

/**
 * Установить пропадание существа
 * Устанавливает, будет ли пропадать существо.
 */
@Action("entity_set_despawning")
external fun Entity.setDespawning(
    despawning: Boolean = false
)

/**
 * Установить режим отображения
 * Устанавливает режим отображения сущности-визуализатору.
 */
@Action("entity_set_display_billboard")
external fun Entity.setDisplayBillboard(
    billboardType: EntityBillboardType = EntityBillboardType.FIXED
)

/**
 * Установить яркость
 * Устанавливает яркость сущности-визуализатору.
 */
@Action("entity_set_display_brightness")
external fun Entity.setDisplayBrightness(
    blockLightLevel: Double = 0.0,
    skyLightLevel: Double = 0.0
)

/**
 * Установить матрицу преобразования
 * Устанавливает матрицу преобразования сущности-визуализатору.
 */
@Action("entity_set_display_correct_transformation_matrix")
external fun Entity.setDisplayCorrectTransformationMatrix(
    matrix: List<Double> = emptyList()
)

/**
 * Установить размер области видимости
 * Устанавливает размер области видимости модели сущности-визуализатору.
 */
@Action("entity_set_display_culling_suze")
external fun Entity.setDisplayCullingSuze(
    width: Double = 0.0,
    height: Double = 0.0
)

/**
 * Установить цвет свечения
 * Устанавливает цвет свечения сущности-визуализатору.
 */
@Action("entity_set_display_glow_color")
external fun Entity.setDisplayGlowColor(
    colorHexadecimal: Text = ""
)

/**
 * Установить интерполяцию
 * Устанавливает длительность интерполяции сущности-визуализатору.
 */
@Action("entity_set_display_interpolation")
external fun Entity.setDisplayInterpolation(
    interpolationDuration: Double = 0.0,
    interpolationDelay: Double = 0.0
)

/**
 * Установить поворот по осевому вектору
 * Устанавливает левый или правый поворот по осевому вектору и углу сущности-визуализатору.
 */
@Action("entity_set_display_rotation_from_axis_angle")
external fun Entity.setDisplayRotationFromAxisAngle(
    axisVector: Vector? = null,
    angle: Double = 0.0,
    mode: EntityRotationMode = EntityRotationMode.SET,
    rotation: EntityDisplayRotation = EntityDisplayRotation.LEFT_ROTATION,
    input: EntityAngleUnit = EntityAngleUnit.DEGREES
)

/**
 * Установить поворот по углам Эйлера
 * Устанавливает левый или правый поворот по углам Эйлера сущности-визуализатору.
 */
@Action("entity_set_display_rotation_from_euler_angles")
external fun Entity.setDisplayRotationFromEulerAngles(
    pitch: Double = 0.0,
    yaw: Double = 0.0,
    roll: Double = 0.0,
    mode: EntityRotationMode = EntityRotationMode.SET,
    rotation: EntityDisplayRotation = EntityDisplayRotation.LEFT_ROTATION,
    input: EntityAngleUnit = EntityAngleUnit.DEGREES
)

/**
 * Установить поворот по вектору
 * Устанавливает визуализатору поворот по заданному вектору направления и вектору "Вверх".
 */
@Action("entity_set_display_rotation_from_vector")
external fun Entity.setDisplayRotationFromVector(
    direction: Vector? = null,
    up: Double = 0.0,
    rotation: EntityDisplayRotation = EntityDisplayRotation.LEFT_ROTATION
)

/**
 * Установить размер
 * Устанавливает размер сущности-визуализатору.
 */
@Action("entity_set_display_scale")
external fun Entity.setDisplayScale(
    scaleVector: Vector? = null,
    mode: EntityTransformMode = EntityTransformMode.SET
)

/**
 * Установить настройки тени
 * Устанавливает размер и прозрачность тени сущности-визуализатору.
 */
@Action("entity_set_display_shadow")
external fun Entity.setDisplayShadow(
    shadowRadius: Double = 0.0,
    shadowOpacityPercentage: Double = 0.0
)

/**
 * Установить длительность телепорта визуализатора
 * Устанавливает длительность телепорта визуализатора.
 */
@Action("entity_set_display_teleport_duration")
external fun Entity.setDisplayTeleportDuration(
    duration: Double = 0.0
)

/**
 * Установить матрицу преобразования
 * Устанавливает матрицу преобразования (ряд-столбец) сущности-визуализатору.
 */
@Action("entity_set_display_transformation_matrix")
external fun Entity.setDisplayTransformationMatrix(
    rowMajorMatrix: List<Double> = emptyList()
)

/**
 * Установить смещение
 * Устанавливает смещение сущности-визуализатору.
 */
@Action("entity_set_display_translation")
external fun Entity.setDisplayTranslation(
    translationVector: Vector? = null,
    mode: EntityTransformMode = EntityTransformMode.SET
)

/**
 * Установить дальность видимости
 * Устанавливает дальность видимости сущности-визуализатору.
 */
@Action("entity_set_display_view_range")
external fun Entity.setDisplayViewRange(
    viewRange: Double = 0.0
)

/**
 * Установить фазу Эндер-дракона
 * Устанавливает определённую фазу Эндер-дракону.
 */
@Action("entity_set_dragon_phase")
external fun Entity.setDragonPhase(
    phase: EntityPhase = EntityPhase.CIRCLING
)

/**
 * Установить цвет сущности
 * Устанавливает определённый цвет существу.
 */
@Action("entity_set_dye_color")
external fun Entity.setDyeColor(
    color: EntityDyeColor = EntityDyeColor.WHITE
)

/**
 * Указать луч кристалла Энда
 * Указывает луч кристалла Энда на определённое местоположение.
 */
@Action("entity_set_end_crystal_beam")
external fun Entity.setEndCrystalBeam(beam: Location)

/**
 * Установить блок Эндермену
 * Устанавливает отображаемый блок Эндермену.
 */
@Action("entity_set_enderman_block")
external fun Entity.setEndermanBlock(block: Item)

/**
 * Установить экипировку
 * Устанавливает предметы в один из слотов экипировки (броня и предметы в руках) сущности.
 */
@Action("entity_set_equipment_item")
external fun Entity.setEquipmentItem(
    item: Item,
    slot: EntityEquipmentSlot = EntityEquipmentSlot.HAND
)

/**
 * Установить силу взрыва
 * Устанавливает силу взрыва сущности.
 */
@Action("entity_set_explosive_power")
external fun Entity.setExplosivePower(
    power: Double = 0.0
)

/**
 * Установить дистанцию падения
 * Устанавливает дистанцию, с которой падает существо.
 */
@Action("entity_set_fall_distance")
external fun Entity.setFallDistance(
    fallDistance: Double = 0.0
)

/**
 * Установить тип существу Падающий блок
 * Устанавливает новый тип блока существу Падающий блок.
 */
@Action("entity_set_falling_block_type")
external fun Entity.setFallingBlockType(block: Item)

/**
 * Поджечь существо
 * Поджигает существо на выбранное время.
 */
@Action("entity_set_fire_ticks")
external fun Entity.setFireTicks(
    ticks: Double = 0.0
)

/**
 * Установить задержку рыбалки
 * Устанавливает задержку рыбалки существу в тиках.
 */
@Action("entity_set_fishing_wait")
external fun Entity.setFishingWait(
    waitType: EntityWaitType = EntityWaitType.MIN_MAX_WAIT,
    time: Double = 0.0
)

/**
 * Установить анимацию прыжка лисе
 * Устанавливает анимацию прыжка лисе.
 */
@Action("entity_set_fox_leaping")
external fun Entity.setFoxLeaping(
    leaping: Boolean = false
)

/**
 * Установить тип лисы
 * Устанавливает тип лисы.
 */
@Action("entity_set_fox_type")
external fun Entity.setFoxType(
    foxType: EntityFoxType = EntityFoxType.RED
)

/**
 * Установить время заморозки
 * Устанавливает существу время заморозки (количество тиков, которое сущность провела в рыхлом снегу).
 */
@Action("entity_set_freeze_ticks")
external fun Entity.setFreezeTicks(
    ticks: Double = 0.0,
    tickingLocked: Boolean = false
)

/**
 * Установить трение
 * Устанавливает, будет ли сущность испытывать трение.
 */
@Action("entity_set_friction")
external fun Entity.setFriction(
    friction: EntityTriState = EntityTriState.NOT_SET
)

/**
 * Установить тип жабы
 * Устанавливает окрас жабы.
 */
@Action("entity_set_frog_type")
external fun Entity.setFrogType(
    frogVariant: EntityFrogVariant = EntityFrogVariant.TEMPERATE
)

/**
 * Установить время до взрыва
 * Устанавливает время до взрыва сущности.
 */
@Action("entity_set_fuse_ticks")
external fun Entity.setFuseTicks(
    fuseTicks: Double = 0.0
)

/**
 * Установить полёт на элитрах
 * Устанавливает для существа состояние полёта на элитрах.
 */
@Action("entity_set_gliding")
external fun Entity.setGliding(
    isGliding: Boolean = false
)

/**
 * Установить время тьмы спруту
 * Устанавливает время тьмы в тиках светящемуся спруту.
 */
@Action("entity_set_glow_squid_dark")
external fun Entity.setGlowSquidDark(
    darkTicks: Double = 0.0
)

/**
 * Установить свечение сущности
 * Устанавливает существу эффект свечения.
 */
@Action("entity_set_glowing")
external fun Entity.setGlowing(
    glowing: Boolean = false
)

/**
 * Установить козла кричащим
 * Устанавливает тег \"кричащий\" козлу.
 */
@Action("entity_set_goat_screaming")
external fun Entity.setGoatScreaming(
    screams: Boolean = false
)

/**
 * Установить гравитацию
 * Устанавливает, будет ли сущность подчиняться гравитации.
 */
@Action("entity_set_gravity")
external fun Entity.setGravity(
    gravity: Boolean = false
)

/**
 * Установить сторону блока для висящей сущности
 * Устанавливает висящей сущности сторону блока, на которой она находится.
 */
@Action("entity_set_hanging_facing_location")
external fun Entity.setHangingFacingLocation(
    facing: EntityFacing = EntityFacing.NORTH,
    force: Boolean = false
)

/**
 * Установить лошади силу прыжка
 * Устанавливает лошади силу прыжка.
 */
@Action("entity_set_horse_jump")
external fun Entity.setHorseJump(
    power: Double = 0.0
)

/**
 * Установить узор лошади
 * Устанавливает окрас и узор лошади.
 */
@Action("entity_set_horse_pattern")
external fun Entity.setHorsePattern(
    horseColor: EntityHorseColor = EntityHorseColor.WHITE,
    horseStyle: EntityHorseStyle = EntityHorseStyle.NONE
)

/**
 * Установить иммунитет к зомбифицированию
 * Устанавливает существу иммунитет к зомбифицированию.
 */
@Action("entity_set_immune_to_zombification")
external fun Entity.setImmuneToZombification(
    isImmune: Boolean = false
)

/**
 * Установить отзывчивость сущности взаимодействия
 * Устанавливает, будет ли сущность взаимодействия отзываться на взаимодействия.
 */
@Action("entity_set_interaction_responsive")
external fun Entity.setInteractionResponsive(
    responsive: Boolean = false
)

/**
 * Установить размер сущности взаимодействия
 * Устанавливает горизонтальный и вертикальный размеры сущности взаимодействия.
 */
@Action("entity_set_interaction_size")
external fun Entity.setInteractionSize(
    width: Double = 0.0,
    height: Double = 0.0
)

/**
 * Установить режим невидимости
 * Устанавливает существу режим невидимости.
 */
@Action("entity_set_invisible")
external fun Entity.setInvisible(
    invisible: Boolean = false
)

/**
 * Установить длительность неуязвимости
 * Устанавливает длительность неуязвимости для существа.
 */
@Action("entity_set_invulnerability_ticks")
external fun Entity.setInvulnerabilityTicks(
    ticks: Double = 0.0
)

/**
 * Установить неуязвимость сущности
 * Устанавливает неуязвимости сущности, но в режиме креатива можно нанести урон.
 */
@Action("entity_set_invulnerable")
external fun Entity.setInvulnerable(
    invulnerable: Boolean = false
)

/**
 * Установить тип существу Предмет
 * Устанавливает определённый тип (ID) существу Предмет.
 */
@Action("entity_set_item")
external fun Entity.setItem(item: Item)

/**
 * Установить отображаемый предмет
 * Устанавливает отображаемый предмет визуализатору предмета.
 */
@Action("entity_set_item_display_item")
external fun Entity.setItemDisplayItem(displayedItem: Item)

/**
 * Установить тип модели предмета
 * Устанавливает тип отображаемой модели предмета визуализатору предмета.
 */
@Action("entity_set_item_display_model_type")
external fun Entity.setItemDisplayModelType(
    displayModelType: EntityDisplayModelType = EntityDisplayModelType.NONE
)

/**
 * Установить шанс выпадения предмета из рамки
 * Устанавливает шанс выпадения предмета из рамки при разрушении.
 */
@Action("entity_set_item_frame_item_drop_chance")
external fun Entity.setItemFrameItemDropChance(
    dropChance: Text = ""
)

/**
 * Установить предмет в рамку
 * Устанавливает указанный предмет в рамку.
 */
@Action("entity_set_item_in_frame")
external fun Entity.setItemInFrame(
    item: Item,
    playSound: Boolean = false
)

/**
 * Установить владельца предмета
 * Устанавливает сущности предмета владельца.
 */
@Action("entity_set_item_owner")
external fun Entity.setItemOwner(
    nameOrUuid: Text = ""
)

/**
 * Установить цвет ламы
 * Устанавливает цвет ламы.
 */
@Action("entity_set_llama_type")
external fun Entity.setLlamaType(
    type: EntityLlamaType = EntityLlamaType.CREAMY
)

/**
 * Запустить по вектору
 * Запускает существо по указанному вектору.
 */
@Action("entity_set_location")
external fun Entity.setLocation(
    velocity: Vector? = null,
    increment: Boolean = false
)

/**
 * Установить описание манекена
 * Устанавливает описание манекена.
 */
@Action("entity_set_mannequin_description")
external fun Entity.setMannequinDescription(
    description: Text = ""
)

/**
 * Установить передвижение манекена
 * Устанавливает возможность передвижения для манекена.
 */
@Action("entity_set_mannequin_immovable")
external fun Entity.setMannequinImmovable(
    immovable: Boolean = false
)

/**
 * Установить ведущую руку манекена
 * Устанавливает ведущую руку манекена.
 */
@Action("entity_set_mannequin_main_hand")
external fun Entity.setMannequinMainHand(
    hand: EntityMannequinHand = EntityMannequinHand.RIGHT
)

/**
 * Установить скин манекена
 * Устанавливает скин манекена.
 */
@Action("entity_set_mannequin_skin")
external fun Entity.setMannequinSkin(
    nameOrUuid: Text = "",
    serverType: EntityServerType = EntityServerType.MOJANG
)

/**
 * Установить тип модели манекена
 * Устанавливает тип модели скина манекена
 */
@Action("entity_set_mannequin_skin_model")
external fun Entity.setMannequinSkinModel(
    model: EntityMannequinModel = EntityMannequinModel.CLASSIC
)

/**
 * Установить слои скина манекена
 * Устанавливает отображение слоев скина манекена.
 */
@Action("entity_set_mannequin_skin_parts")
external fun Entity.setMannequinSkinParts(
    hat: EntityTriState = EntityTriState.NOT_SET,
    jacket: EntityTriState = EntityTriState.NOT_SET,
    leftSleeve: EntityTriState = EntityTriState.NOT_SET,
    rightSleeve: EntityTriState = EntityTriState.NOT_SET,
    leftPants: EntityTriState = EntityTriState.NOT_SET,
    rightPants: EntityTriState = EntityTriState.NOT_SET,
    cape: EntityTriState = EntityTriState.NOT_SET
)

/**
 * Установить текстуру части манекена
 * Устанавливает текстуру для указанной части манекена.
 */
@Action("entity_set_mannequin_skin_patch")
external fun Entity.setMannequinSkinPatch(
    textureKey: Text = "",
    patchTarget: EntityPatchTarget = EntityPatchTarget.BODY
)

/**
 * Установить режим маркера
 * Устанавливает режим маркера стойке для брони.
 */
@Action("entity_set_marker")
external fun Entity.setMarker(
    marker: Boolean = false
)

/**
 * Установить максимальное здоровье существа
 * Устанавливает максимальное количество здоровья для существа.
 */
@Action("entity_set_max_health")
external fun Entity.setMaxHealth(
    maxHealth: Double = 0.0,
    healToMax: Boolean = false
)

/**
 * Установить максимальную длительность неуязвимости
 * Устанавливает максимальную длительность неуязвимости для существа.
 */
@Action("entity_set_max_invulnerability_ticks")
external fun Entity.setMaxInvulnerabilityTicks(
    ticks: Double = 0.0
)

/**
 * Установить товар Жителю
 * Устанавливает товар Жителю за определённые предметы по указанному индексу.
 */
@Action("entity_set_merchant_recipe")
external fun Entity.setMerchantRecipe(
    result: Item? = null,
    ingredientOne: Item? = null,
    ingredientTwo: Item? = null,
    index: Double = 0.0,
    mode: EntityMerchantRecipeMode = EntityMerchantRecipeMode.MERGE,
    uses: Double = 0.0,
    maxUses: Double = 0.0,
    villagerExperience: Double = 0.0,
    priceMultiplifier: Double = 0.0,
    demand: Double = 0.0,
    specialPrice: Double = 0.0,
    ignoreDiscounts: Boolean = false,
    experienceReward: Boolean = false
)

/**
 * Установить блок в вагонетку
 * Устанавливает указанный блок в вагонетку.
 */
@Action("entity_set_minecart_block")
external fun Entity.setMinecartBlock(
    block: Item,
    blockOffset: Double = 0.0
)

/**
 * Установить агрессивность
 * Устанавливает агрессивность сущности.
 */
@Action("entity_set_mob_aggressive")
external fun Entity.setMobAggressive(
    aggressive: Boolean = false
)

/**
 * Установить тип грибной коровы
 * Устанавливает тип грибной коровы.
 */
@Action("entity_set_mushroom_cow_type")
external fun Entity.setMushroomCowType(
    cowType: EntityCowType = EntityCowType.RED
)

/**
 * Установить физику для сущности
 * Устанавливает существу физику.
 */
@Action("entity_set_no_physics")
external fun Entity.setNoPhysics(
    noPhysics: Boolean = false
)

/**
 * Установить рисунок картины
 * Устанавливает рисунок для картины.
 */
@Action("entity_set_painting_art")
external fun Entity.setPaintingArt(
    art: Text = "",
    force: Boolean = false
)

/**
 * Установить ген панды
 * Устанавливает ген панды. Это влияет на их поведение и внешний вид.
 */
@Action("entity_set_panda_gene")
external fun Entity.setPandaGene(
    gene: EntityGene = EntityGene.MAIN,
    geneType: EntityGeneType = EntityGeneType.NORMAL
)

/**
 * Посадить панду
 * Устанавливает Панде состояние сидения.
 */
@Action("entity_set_panda_on_back")
external fun Entity.setPandaOnBack(
    onBack: Boolean = false
)

/**
 * Установить Панде состояние переката
 * Устанавливает Панде состояние переката.
 */
@Action("entity_set_panda_rolling")
external fun Entity.setPandaRolling(
    rolling: Boolean = false
)

/**
 * Установить время грусти Панды
 * Устанавливает время грусти Панды в тиках.
 */
@Action("entity_set_panda_sad_ticks")
external fun Entity.setPandaSadTicks(
    sadTicks: Double = 0.0
)

/**
 * Установить тип попугая
 * Устанавливает тип попугая.
 */
@Action("entity_set_parrot_type")
external fun Entity.setParrotType(
    parrotType: EntityParrotType = EntityParrotType.RED
)

/**
 * Настроить поиск пути
 * Устанавливает параметры и ограничения для поиска пути сущности
 */
@Action("entity_set_pathfinder_settings")
external fun Entity.setPathfinderSettings(
    canFloat: EntityTriState = EntityTriState.NOT_SET,
    canOpenDoor: EntityTriState = EntityTriState.NOT_SET,
    canPassDoor: EntityTriState = EntityTriState.NOT_SET
)

/**
 * Установить исчезание существа
 * Устанавливает, будет ли предмет или падающий блок исчезать.
 */
@Action("entity_set_persistence")
external fun Entity.setPersistence(
    persistence: Boolean = false
)

/**
 * Установить сущности сохранение
 * Устанавливает сущности состояние, будет ли она сохранена после отгрузки мира.
 */
@Action("entity_set_persistent")
external fun Entity.setPersistent(
    persistent: Boolean = false
)

/**
 * Установить возможность подбора
 * Устанавливает сущности возможность подбора.
 */
@Action("entity_set_pickup")
external fun Entity.setPickup(
    canMobPickup: Boolean = false,
    canPlayerPickup: Boolean = false
)

/**
 * Установить задержку для поднятия
 * Устанавливает количество тиков, за которое предмет не может быть поднят.
 */
@Action("entity_set_pickup_delay")
external fun Entity.setPickupDelay(
    delay: Double = 0.0
)

/**
 * Установить тип Свиньи
 * Устанавливает свинье тип окраски.
 */
@Action("entity_set_pig_type")
external fun Entity.setPigType(
    variant: EntityAnimalVariant = EntityAnimalVariant.COLD
)

/**
 * Установить состояние охоты
 * Устанавливает пиглину состояние охоты на хоглинов.
 */
@Action("entity_set_piglin_able_to_hunt")
external fun Entity.setPiglinAbleToHunt(
    able: Boolean = false
)

/**
 * Установить состояние зарядки арбалета
 * Устанавливает пиглину состояние зарядки арбалета.
 */
@Action("entity_set_piglin_charging_crossbow")
external fun Entity.setPiglinChargingCrossbow(
    charging: Boolean = false
)

/**
 * Установить стадию танца
 * Устанавливает пиглину стадию танца на указанное время.
 */
@Action("entity_set_piglin_dancing")
external fun Entity.setPiglinDancing(
    dancingTime: Double = 0.0
)

/**
 * Установить позу сущности
 * Устанавливает определённую позу существу.
 */
@Action("entity_set_pose")
external fun Entity.setPose(
    pose: EntityPose = EntityPose.STANDING
)

/**
 * Установить радиус облака эффекта
 * Устанавливает радиус облака эффекта и скорость его расширения.
 */
@Action("entity_set_potion_cloud_radius")
external fun Entity.setPotionCloudRadius(
    radius: Double = 0.0,
    shrinkingSpeed: Double = 0.0
)

/**
 * Замаскировать зажжённый динамит под блок
 * Маскирует зажжённый динамит под указанный блок.
 */
@Action("entity_set_primed_tnt_block")
external fun Entity.setPrimedTntBlock(block: Item)

/**
 * Установить предмет снаряда
 * Устанавливает видимый предмет снаряду.
 */
@Action("entity_set_projectile_display_item")
external fun Entity.setProjectileDisplayItem(item: Item)

/**
 * Установить снаряду вектор движения
 * Устанавливает снаряду вектор движения.
 */
@Action("entity_set_projectile_power")
external fun Entity.setProjectilePower(
    power: Double = 0.0
)

/**
 * Установить стрелка снаряду
 * Устанавливает указанное существо как стрелка для снаряда.
 */
@Action("entity_set_projectile_shooter")
external fun Entity.setProjectileShooter(
    uuid: Text = ""
)

/**
 * Установить тип кролика
 * Устанавливает тип кролика.
 */
@Action("entity_set_rabbit_type")
external fun Entity.setRabbitType(
    rabbitType: EntityRabbitType = EntityRabbitType.BROWN
)

/**
 * Установить позу лошади
 * Устанавливает, будет ли лошадь стоять на задних ногах.
 */
@Action("entity_set_rearing")
external fun Entity.setRearing(
    rearing: Boolean = false
)

/**
 * Установить анимацию Тягун
 * Устанавливает существу анимацию использования зачарования трезубца Тягун.
 */
@Action("entity_set_riptiding")
external fun Entity.setRiptiding(
    riptiding: Boolean = false
)

/**
 * Установить поворот
 * Устанавливает поворот сущности.
 */
@Action("entity_set_rotation")
external fun Entity.setRotation(
    yaw: Double = 0.0,
    pitch: Double = 0.0
)

/**
 * Установить поворот по вектору
 * Устанавливает поворот сущности по вектору.
 */
@Action("entity_set_rotation_by_vector")
external fun Entity.setRotationByVector(
    vector: Vector? = null
)

/**
 * Установить шерсть овце
 * Устанавливает, будет ли шерсть на овце.
 */
@Action("entity_set_sheep_sheared")
external fun Entity.setSheepSheared(
    sheared: Boolean = false
)

/**
 * Установить цель снаряду Шалкера
 * Устанавливает цель атаки снаряду Шалкера.
 */
@Action("entity_set_shulker_bullet_target")
external fun Entity.setShulkerBulletTarget(
    target: Text = ""
)

/**
 * Установить процент открытия шалкера
 * Устанавливает шалкеру процент, на который он открыт.
 */
@Action("entity_set_shulker_peek")
external fun Entity.setShulkerPeek(
    rolling: Double = 0.0,
    silent: Boolean = false
)

/**
 * Заглушить сущность
 * Убирает звуки сущности.
 */
@Action("entity_set_silenced")
external fun Entity.setSilenced(
    silenced: Boolean = false
)

/**
 * Установить режим сидения
 * Устанавливает существу режим сидения.
 */
@Action("entity_set_sitting")
external fun Entity.setSitting(
    sitting: Boolean = false
)

/**
 * Установить размер существа
 * Устанавливает размер существу.
 */
@Action("entity_set_size")
external fun Entity.setSize(
    size: Double = 0.0
)

/**
 * Установить состояние нюхача
 * Устанавливает определённое состояние нюхачу.
 */
@Action("entity_set_sniffer_state")
external fun Entity.setSnifferState(
    state: EntitySnifferState = EntitySnifferState.IDLING
)

/**
 * Установить тыкву снеговику
 * Устанавливает видимость тыквы снеговику.
 */
@Action("entity_set_snowman_pumpkin")
external fun Entity.setSnowmanPumpkin(
    pumpkin: Boolean = false
)

/**
 * Приручить существо
 * Устанавливает привязанность существа к указанному хозяину.
 */
@Action("entity_set_tame")
external fun Entity.setTame(
    nameOrUuid: Text = ""
)

/**
 * Установить цель существу
 * Инструктирует ИИ существа нацеливаться на определённое существо.
 */
@Action("entity_set_target")
external fun Entity.setTarget(
    nameOrUuid: Text = ""
)

/**
 * Установить выравнивание текста
 * Устанавливает выравнивание текста визуализатору текста.
 */
@Action("entity_set_text_display_alignment")
external fun Entity.setTextDisplayAlignment(
    textAlignment: EntityTextAlignment = EntityTextAlignment.CENTER
)

/**
 * Установить цвет фона
 * Устанавливает цвет и прозрачность фона визуализатору текста.
 */
@Action("entity_set_text_display_background")
external fun Entity.setTextDisplayBackground(
    colorHexadecimal: Text = "",
    opacity: Double = 0.0
)

/**
 * Установить ширину строки
 * Устанавливает максимальную ширину строки визуализатору текста.
 */
@Action("entity_set_text_display_line_width")
external fun Entity.setTextDisplayLineWidth(
    lineWidth: Double = 0.0
)

/**
 * Установить прозрачность текста
 * Устанавливает прозрачность текста визуализатору текста.
 */
@Action("entity_set_text_display_opacity")
external fun Entity.setTextDisplayOpacity(
    textOpacity: Double = 0.0
)

/**
 * Установить видимость через блоки
 * Устанавливает видимость текста через блоки визуализатору текста.
 */
@Action("entity_set_text_display_see_through")
external fun Entity.setTextDisplaySeeThrough(
    enableSeeThrough: Boolean = false
)

/**
 * Установить отображаемый текст
 * Устанавливает отображаемый текст визуализатору текста.
 */
@Action("entity_set_text_display_text")
external fun Entity.setTextDisplayText(
    vararg displayedText: Text,
    mergingMode: EntityMergingMode = EntityMergingMode.SPACES
)

/**
 * Установить тень текста
 * Устанавливает видимость тени текста визуализатору текста.
 */
@Action("entity_set_text_display_text_shadow")
external fun Entity.setTextDisplayTextShadow(
    enableTextShadow: Boolean = false
)

/**
 * Установить узор рыбы
 * Устанавливает окрас и узор тропической рыбе.
 */
@Action("entity_set_tropical_fish_pattern")
external fun Entity.setTropicalFishPattern(
    patternColor: EntityPatternColor = EntityPatternColor.WHITE,
    bodyColor: EntityBodyColor = EntityBodyColor.WHITE,
    pattern: EntityPattern = EntityPattern.KOB
)

/**
 * Установить Вредине злость
 * Устанавливает Вредине стадию злости.
 */
@Action("entity_set_vex_charging")
external fun Entity.setVexCharging(
    charging: Boolean = false
)

/**
 * Установить время жизни Вредины
 * Устанавливает время жизни Вредины в тиках.
 */
@Action("entity_set_vex_limited_lifetime_ticks")
external fun Entity.setVexLimitedLifetimeTicks(
    lifetime: Double = 0.0
)

/**
 * Установить биом жителю
 * Устанавливает жителю окрас в зависимости от выбранного биома.
 */
@Action("entity_set_villager_biome")
external fun Entity.setVillagerBiome(
    biome: EntityBiome = EntityBiome.DESERT
)

/**
 * Установить опыт жителю
 * Устанавливает жителю количество опыта.
 */
@Action("entity_set_villager_experience")
external fun Entity.setVillagerExperience(
    experience: Double = 0.0
)

/**
 * Установить профессию жителю
 * Устанавливает определённую профессию жителю.
 */
@Action("entity_set_villager_profession")
external fun Entity.setVillagerProfession(
    profession: EntityProfession = EntityProfession.NONE
)

/**
 * Отображать огонь
 * Отображает огонь на существе.
 */
@Action("entity_set_visual_fire")
external fun Entity.setVisualFire(
    visualFire: EntityTriState = EntityTriState.NOT_SET
)

/**
 * Установить уровень гнева Хранителя
 * Устанавливает определённый уровень гнева Хранителя на указанное существо.
 */
@Action("entity_set_warden_anger_level")
external fun Entity.setWardenAngerLevel(
    nameOrUuid: Text = "",
    anger: Double = 0.0
)

/**
 * Установить Вардену тип копания
 * Устанавливает Вардену тип копания.
 */
@Action("entity_set_warden_digging")
external fun Entity.setWardenDigging(
    digging: EntityDigging = EntityDigging.EMERGE
)

/**
 * Установить цвет значка на локаторе
 * Устанавливает сущности цвет значка, отображаемого на локаторе.
 */
@Action("entity_set_waypoint_color")
external fun Entity.setWaypointColor(
    red: Double = 0.0,
    green: Double = 0.0,
    blue: Double = 0.0
)

/**
 * Установить стиль значка на локаторе
 * Устанавливает сущности стиль значка, отображаемого на локаторе.
 */
@Action("entity_set_waypoint_style")
external fun Entity.setWaypointStyle(
    style: Text = ""
)

/**
 * Установить видимость седла
 * Устанавливает существу седло.
 */
@Action("entity_set_wearing_saddle")
external fun Entity.setWearingSaddle(
    wearing: Boolean = false
)

/**
 * Установить неуязвимость иссушителю
 * Устанавливает длительность неуязвимости иссушителю.
 */
@Action("entity_set_wither_invulnerability_ticks")
external fun Entity.setWitherInvulnerabilityTicks(
    ticks: Double = 0.0
)

/**
 * Установить звук Волка
 * Устанавливает тип издаваемых звуков волку.
 */
@Action("entity_set_wolf_sound_variant")
external fun Entity.setWolfSoundVariant(
    soundVariant: EntitySoundVariant = EntitySoundVariant.ANGRY
)

/**
 * Установить тип волка
 * Устанавливает тип волка.
 */
@Action("entity_set_wolf_type")
external fun Entity.setWolfType(
    wolfType: EntityWolfType = EntityWolfType.ASHEN
)

/**
 * Установить поднятие рук зомби
 * Устанавливает анимацию поднятия рук для зомби.
 */
@Action("entity_set_zombie_arms_raised")
external fun Entity.setZombieArmsRaised(
    armsRaised: Boolean = false
)

/**
 * Установить тип зомби-наутилуса
 * Устанавливает тип зомби-наутилуса.
 */
@Action("entity_set_zombie_nautilus_variant")
external fun Entity.setZombieNautilusVariant(
    variant: EntityNautilusVariant = EntityNautilusVariant.TEMPERATE
)

/**
 * Подстричь сущность
 * Стрижёт сущность.
 */
@Action("entity_shear")
external fun Entity.shear()

/**
 * Подстричь овцу
 * Подстригает овцу.
 */
@Action("entity_shear_sheep")
external fun Entity.shearSheep()

/**
 * Установить анимацию сна
 * Устанавливает существу анимацию сна. Лучше всего использовать это действие в цикле.
 */
@Action("entity_sleep")
external fun Entity.sleep(
    sleep: Boolean = false
)

/**
 * Проиграть анимацию взмаха руки
 * Проигрывает для сущности анимацию взмаха руки.
 */
@Action("entity_swing_hand")
external fun Entity.swingHand(
    handType: EntityHandType = EntityHandType.MAIN
)

/**
 * Телепортация
 * Телепортирует существо в выбранное местоположение.
 */
@Action("entity_teleport")
external fun Entity.teleport(
    location: Location,
    keepRotation: Boolean = false
)

/**
 * Последовательность телепортаций
 * Телепортирует существо между местоположениями с заданной задержкой.
 */
@Action("entity_teleport_sequence")
external fun Entity.teleportSequence(
    vararg locations: Location,
    delay: Double = 0.0
)

/**
 * Использовать предмет
 * Инструктирует ИИ существа на использование предмета в его руке.
 */
@Action("entity_use_item")
external fun Entity.useItem(
    hand: EntityItemHand = EntityItemHand.MAIN_HAND,
    enable: Boolean = false
)
