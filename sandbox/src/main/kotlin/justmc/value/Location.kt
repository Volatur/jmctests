package justmc.value

import justmc.annotation.*
import justmc.entity.Entity
import justmc.flow.AdjacentPattern
import justmc.flow.Repeat
import justmc.flow.SphereRotation
import justmc.AngleUnit
import justmc.World
import kotlin.*

/**
 * Тип координаты местоположения.
 */
enum class CoordinateType {
    X, Y, Z, PITCH, YAW
}

/**
 * Направление смещения местоположения.
 */
enum class DirectionShift {
    FORWARD, UPWARD, SIDEWAYS
}

/**
 * Сторона блока.
 */
enum class BlockFace {
    NORTH, EAST, SOUTH, WEST, UP, DOWN,
    NORTH_EAST, NORTH_WEST, SOUTH_EAST, SOUTH_WEST,
    WEST_NORTH_WEST, NORTH_NORTH_WEST, NORTH_NORTH_EAST, EAST_NORTH_EAST,
    EAST_SOUTH_EAST, SOUTH_SOUTH_EAST, SOUTH_SOUTH_WEST, WEST_SOUTH_WEST,
    SELF
}

/**
 * Режим округления местоположения.
 */
enum class AlignMode {
    BLOCK_CENTER, CORNER
}

/**
 * Режим выбора координат для округления.
 */
enum class CoordinatesMode {
    ALL, X_Z, Y
}

/**
 * Режим выбора координат XYZ.
 */
enum class CoordinatesModeXYZ {
    XYZ, XZ, Y
}

/**
 * Режим сохранения поворота.
 */
enum class RotationMode {
    KEEP, REMOVE
}

/**
 * Тип вычисления дистанции между местоположениями.
 */
enum class DistanceType {
    THREE_D, TWO_D, ALTITUDE, SQUARED_3D, SQUARED_2D
}

/**
 * Режим поиска местоположения (ближайшее / дальнее).
 */
enum class LocationCompareMode {
    NEAREST, FARTHEST
}

/**
 * Режим обработки границ диапазона для местоположения.
 */
enum class BorderHandling {
    EXACT, BLOCK, FULL_BLOCK_RANGE
}

/**
 * Геометрическая фигура проверки близости.
 */
enum class NearShape {
    SPHERE, CIRCLE, CUBE, SQUARE
}

/**
 * Тип проверки пересечения регионов.
 */
enum class RangeCheckType {
    OVERLAPS, CONTAINS
}

/**
 * Режим столкновений для рейкаста.
 */
enum class RayCollisionMode {
    ONLY_BLOCKS, BLOCKS_AND_ENTITIES, ONLY_ENTITIES
}

/**
 * Режим обработки жидкостей для рейкаста.
 */
enum class FluidCollisionMode {
    NEVER, SOURCE_ONLY, ALWAYS
}



/**
 * Получить все координаты местоположения (set_variable_get_all_coordinates).
 */
@Action("set_variable_get_all_coordinates", returns = ["x", "y", "z", "yaw", "pitch"], thisArg = ["location"])
external fun Location.getAllCoordinates(): Tuple5<Double, Double, Double, Double, Double>

/**
 * Получить конкретную координату местоположения (set_variable_get_coordinate).
 */
@Action("set_variable_get_coordinate", returns = ["variable"], thisArg = ["location"])
external fun Location.getCoordinate(type: CoordinateType): Double

/**
 * Установить координату местоположения (set_variable_set_coordinate).
 */
@Action("set_variable_set_coordinate", returns = ["variable"], thisArg = ["location"])
external fun Location.setCoordinate(coordinate: Double, type: CoordinateType): Location

/**
 * Сдвинуть координату местоположения (set_variable_shift_coordinate).
 */
@Action("set_variable_shift_coordinate", returns = ["variable"], thisArg = ["location"])
external fun Location.shiftCoordinate(distance: Double, type: CoordinateType): Location

inline fun Location.shiftX(distance: Double): Location = shiftCoordinate(distance, CoordinateType.X)
inline fun Location.shiftY(distance: Double): Location = shiftCoordinate(distance, CoordinateType.Y)
inline fun Location.shiftZ(distance: Double): Location = shiftCoordinate(distance, CoordinateType.Z)
inline fun Location.shiftYaw(distance: Double): Location = shiftCoordinate(distance, CoordinateType.YAW)
inline fun Location.shiftPitch(distance: Double): Location = shiftCoordinate(distance, CoordinateType.PITCH)

/**
 * Сдвинуть местоположение в направлении взгляда/оси (set_variable_shift_location_in_direction).
 */
@Action("set_variable_shift_location_in_direction", returns = ["variable"], thisArg = ["location"])
external fun Location.shiftInDirection(shift: Double, direction: DirectionShift): Location

inline fun Location.forward(distance: Double = 1.0): Location = shiftInDirection(distance, DirectionShift.FORWARD)
inline fun Location.backward(distance: Double = 1.0): Location = shiftInDirection(-distance, DirectionShift.FORWARD)
inline fun Location.upward(distance: Double = 1.0): Location = shiftInDirection(distance, DirectionShift.UPWARD)
inline fun Location.downward(distance: Double = 1.0): Location = shiftInDirection(-distance, DirectionShift.UPWARD)
inline fun Location.sideways(distance: Double = 1.0): Location = shiftInDirection(distance, DirectionShift.SIDEWAYS)

/**
 * Сместить местоположение в сторону другого местоположения (set_variable_shift_location_towards_location).
 */
@Action("set_variable_shift_location_towards_location", returns = ["variable"], thisArg = ["location_from"])
external fun Location.shiftTowards(locationTo: Location, distance: Double): Location

/**
 * Сдвинуть указанное местоположение по вектору (set_variable_shift_location_on_vector).
 */
@Action("set_variable_shift_location_on_vector", returns = ["variable"], thisArg = ["location"])
external fun Location.shiftOnVector(vector: Vector, length: Double = 1.0): Location

inline operator fun Location.plus(vector: Vector): Location = shiftOnVector(vector, 1.0)
inline operator fun Location.minus(vector: Vector): Location = shiftOnVector(vector, -1.0)

/**
 * Создать вектор между двумя местоположениями (set_variable_get_vector_between_locations).
 */
@Action("set_variable_get_vector_between_locations", returns = ["variable"], thisArg = ["start_location"])
external fun Location.vectorTo(endLocation: Location): Vector

inline operator fun Location.minus(startLocation: Location): Vector = startLocation.vectorTo(this)

/**
 * Установить относительное местоположение от стороны блока (set_variable_location_relative).
 */
@Action("set_variable_location_relative", returns = ["variable"], thisArg = ["location"])
external fun Location.relative(blockFace: BlockFace, distance: Double = 1.0): Location

/**
 * Округлить местоположение к центру или углу блока (set_variable_align_location).
 */
@Action("set_variable_align_location", returns = ["variable"], thisArg = ["location"])
external fun Location.align(
    alignMode: AlignMode = AlignMode.BLOCK_CENTER,
    coordinatesMode: CoordinatesMode = CoordinatesMode.ALL,
    rotationMode: RotationMode = RotationMode.KEEP
): Location

/**
 * Ограничить местоположение рамками кубоида (set_variable_clamp_location).
 */
@Action("set_variable_clamp_location", returns = ["variable"], thisArg = ["location"])
external fun Location.clamp(
    corner1: Location,
    corner2: Location,
    coordinatesMode: CoordinatesModeXYZ = CoordinatesModeXYZ.XYZ
): Location

/**
 * Направить местоположение на другое местоположение (set_variable_face_location).
 */
@Action("set_variable_face_location", returns = ["variable"], thisArg = ["location"])
external fun Location.face(target: Location): Location

/**
 * Получить вектор направления местоположения (set_variable_get_location_direction).
 */
@Action("set_variable_get_location_direction", returns = ["variable"], thisArg = ["location"])
external fun Location.getDirection(): Vector

@get:JvmName("getDirectionProp")
val Location.direction: Vector inline get() = getDirection()

/**
 * Установить вектор направления местоположения (set_variable_set_location_direction).
 */
@Action("set_variable_set_location_direction", returns = ["variable"], thisArg = ["location"])
external fun Location.setDirection(vector: Vector): Location

/**
 * Получить расстояние между местоположениями (set_variable_locations_distance).
 */
@Action("set_variable_locations_distance", returns = ["variable"], thisArg = ["location_1"])
external fun Location.distanceTo(location2: Location, type: DistanceType = DistanceType.THREE_D): Double

/**
 * Получить центральное местоположение из списка (set_variable_center_location).
 */
@Action("set_variable_center_location", returns = ["variable"])
external fun centerLocation(vararg locations: Location): Location

@Action("set_variable_center_location", returns = ["variable"])
external fun centerLocation(locations: List<Location>): Location

inline fun Iterable<Location>.center(): Location = centerLocation(this.toList())

/**
 * Найти ближайшее/дальнее местоположение из списка (set_variable_find_nearest_location).
 */
@Action("set_variable_find_nearest_location", returns = ["variable"], thisArg = ["location"])
external fun Location.findNearest(
    vararg locations: Location,
    distanceType: CoordinatesModeXYZ = CoordinatesModeXYZ.XYZ,
    compareMode: LocationCompareMode = LocationCompareMode.NEAREST
): Location

@Action("set_variable_find_nearest_location", returns = ["variable"], thisArg = ["location"])
external fun Location.findNearest(
    locations: List<Location>,
    distanceType: CoordinatesModeXYZ = CoordinatesModeXYZ.XYZ,
    compareMode: LocationCompareMode = LocationCompareMode.NEAREST
): Location

inline fun Location.findFarthest(
    vararg locations: Location,
    distanceType: CoordinatesModeXYZ = CoordinatesModeXYZ.XYZ
): Location = findNearest(*locations, distanceType = distanceType, compareMode = LocationCompareMode.FARTHEST)

inline fun Location.findFarthest(
    locations: List<Location>,
    distanceType: CoordinatesModeXYZ = CoordinatesModeXYZ.XYZ
): Location = findNearest(locations, distanceType = distanceType, compareMode = LocationCompareMode.FARTHEST)

/**
 * Создать случайное местоположение в регионе между двумя углами (set_variable_random_location).
 */
@Action("set_variable_random_location", returns = ["variable"])
external fun randomLocation(location1: Location, location2: Location, integer: Boolean = false): Location

// ==========================================
// Условия над местоположениями (Conditions)
// ==========================================

/**
 * Проверить, находится ли местоположение в диапазоне (if_variable_location_in_range).
 */
@Action("if_variable_location_in_range", thisArg = ["value"])
external fun Location.isInRange(min: Location, max: Location, borderHandling: BorderHandling = BorderHandling.EXACT): Boolean

/**
 * Проверить, находится ли местоположение рядом с другим местоположением (if_variable_location_is_near).
 */
@Action("if_variable_location_is_near", thisArg = ["location"])
external fun Location.isNear(check: Location, radius: Double, shape: NearShape = NearShape.SPHERE): Boolean

/**
 * Проверить пересечение двух 3D-регионов (if_variable_range_intersects_range).
 */
@Action("if_variable_range_intersects_range")
external fun rangeIntersects(
    min1: Location,
    max1: Location,
    min2: Location,
    max2: Location,
    checkType: RangeCheckType = RangeCheckType.OVERLAPS
): Boolean

inline val Location.isChunkLoaded: Boolean get() = World.isChunkLoaded(this)

// ==========================================
// Рейкаст (Raytracing)
// ==========================================

@Action("set_variable_ray_trace_result", returns = ["variable_for_hit_location", "variable_for_hit_block_location", "variable_for_hit_block_face", "variable_for_hit_entity_uuid"], thisArg = ["start"])
external fun Location.rayTrace(
    raySize: Double = 0.0,
    maxDistance: Double = 50.0,
    rayCollisionMode: RayCollisionMode = RayCollisionMode.BLOCKS_AND_ENTITIES,
    ignorePassableBlocks: Boolean = true,
    fluidCollisionMode: FluidCollisionMode = FluidCollisionMode.NEVER,
    entities: List<Entity> = emptyList(),
    vararg blocks: Item = emptyArray()
): Tuple4<Location, Location, Text, Text>

// ==========================================
// Геометрические циклы (Repeat extensions)
// ==========================================

inline fun Location.gridTo(end: Location, noinline block: (Location) -> Unit) =
    Repeat.grid(this, end, block)

inline fun Location.circle(
    radius: Double,
    circlePoints: Double = 36.0,
    perpendicularToPlane: Vector = Vector(0.0, 1.0, 0.0),
    startAngle: Double = 0.0,
    angleUnit: AngleUnit = AngleUnit.DEGREES,
    noinline block: (Location) -> Unit
) = Repeat.circle(this, radius, circlePoints, perpendicularToPlane, startAngle, angleUnit, block)

inline fun Location.sphere(
    radius: Double,
    points: Double = 50.0,
    rotateLocation: SphereRotation = SphereRotation.NO_CHANGES,
    noinline block: (Location) -> Unit
) = Repeat.sphere(this, radius, points, rotateLocation, block)

inline fun Location.adjacently(
    pattern: AdjacentPattern = AdjacentPattern.CARDINAL,
    includeSelf: Boolean = false,
    changeRotation: Boolean = false,
    noinline block: (Location) -> Unit
) = Repeat.adjacently(this, changeRotation, includeSelf, pattern, block)
