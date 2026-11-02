package justmc.value

import justmc.AngleUnit
import justmc.annotation.*
import kotlin.*

/**
 * Координата / ось вектора.
 */
enum class VectorAxis {
    X, Y, Z
}

/**
 * Тип длины вектора.
 */
enum class VectorLengthType {
    LENGTH, LENGTH_SQUARED
}

// ==========================================
// Действия над векторами (Vector)
// ==========================================

/**
 * Получить все координаты вектора (set_variable_get_vector_all_components).
 */
@Action("set_variable_get_vector_all_components", returns = ["x", "y", "z"], thisArg = ["vector"])
external fun Vector.getAllComponents(): Tuple3<Double, Double, Double>

/**
 * Получить определенную координату вектора (set_variable_get_vector_component).
 */
@Action("set_variable_get_vector_component", returns = ["variable"], thisArg = ["vector"])
external fun Vector.getComponent(vectorComponent: VectorAxis): Double

/**
 * Установить определенную координату вектора (set_variable_set_vector_component).
 */
@Action("set_variable_set_vector_component", returns = ["variable"], thisArg = ["vector"])
external fun Vector.setComponent(value: Double, vectorComponent: VectorAxis): Vector

/**
 * Получить длину вектора (set_variable_get_vector_length).
 */
@Action("set_variable_get_vector_length", returns = ["variable"], thisArg = ["vector"])
external fun Vector.getLength(lengthType: VectorLengthType = VectorLengthType.LENGTH): Double

val Vector.length: Double inline get() = getLength(VectorLengthType.LENGTH)
val Vector.lengthSquared: Double inline get() = getLength(VectorLengthType.LENGTH_SQUARED)

/**
 * Установить длину вектора (set_variable_set_vector_length).
 */
@Action("set_variable_set_vector_length", returns = ["variable"], thisArg = ["vector"])
external fun Vector.setLength(length: Double): Vector

/**
 * Сложить векторы (set_variable_add_vectors).
 */
@Action("set_variable_add_vectors", returns = ["variable"])
external fun addVectors(vararg vectors: Vector): Vector

@Action("set_variable_add_vectors", returns = ["variable"])
external fun addVectors(vectors: List<Vector>): Vector

inline operator fun Vector.plus(other: Vector): Vector = addVectors(this, other)

/**
 * Вычесть векторы (set_variable_subtract_vectors).
 */
@Action("set_variable_subtract_vectors", returns = ["variable"])
external fun subtractVectors(vararg vectors: Vector): Vector

@Action("set_variable_subtract_vectors", returns = ["variable"])
external fun subtractVectors(vectors: List<Vector>): Vector

inline operator fun Vector.minus(other: Vector): Vector = subtractVectors(this, other)

/**
 * Умножить вектор на число (set_variable_multiply_vector).
 */
@Action("set_variable_multiply_vector", returns = ["variable"], thisArg = ["vector"])
external fun Vector.multiply(multiplier: Double): Vector

inline operator fun Vector.times(multiplier: Double): Vector = multiply(multiplier)
inline operator fun Vector.times(multiplier: Int): Vector = multiply(multiplier.toDouble())
inline operator fun Double.times(vector: Vector): Vector = vector.multiply(this)
inline operator fun Int.times(vector: Vector): Vector = vector.multiply(this.toDouble())

/**
 * Деление векторов (set_variable_divide_vector).
 */
@Action("set_variable_divide_vector", returns = ["variable"], thisArg = ["vector"])
external fun Vector.divide(divider: Vector): Vector

inline operator fun Vector.div(divider: Vector): Vector = divide(divider)
inline operator fun Vector.div(divider: Double): Vector = multiply(1.0 / divider)
inline operator fun Vector.div(divider: Int): Vector = multiply(1.0 / divider.toDouble())

inline operator fun Vector.unaryMinus(): Vector = this * -1.0

/**
 * Выровнять вектор по осям (set_variable_align_to_axis_vector).
 */
@Action("set_variable_align_to_axis_vector", returns = ["variable"], thisArg = ["vector"])
external fun Vector.alignToAxis(normalize: Boolean = true): Vector

/**
 * Скалярное произведение двух векторов (set_variable_vector_dot_product).
 */
@Action("set_variable_vector_dot_product", returns = ["variable"])
external fun dotProduct(vector1: Vector, vector2: Vector): Double

inline fun Vector.dot(other: Vector): Double = dotProduct(this, other)

/**
 * Векторное произведение двух векторов (set_variable_vector_cross_product).
 */
@Action("set_variable_vector_cross_product", returns = ["variable"])
external fun crossProduct(vector1: Vector, vector2: Vector): Vector

inline fun Vector.cross(other: Vector): Vector = crossProduct(this, other)

/**
 * Адамарово (покомпонентное) произведение векторов (set_variable_hadamard_vector_product).
 */
@Action("set_variable_hadamard_vector_product", returns = ["variable"])
external fun hadamardProduct(vector1: Vector, vector2: Vector): Vector

inline fun Vector.hadamard(other: Vector): Vector = hadamardProduct(this, other)

/**
 * Получить угол между двумя векторами (set_variable_get_angle_between_vectors).
 */
@Action("set_variable_get_angle_between_vectors", returns = ["variable"])
external fun angleBetweenVectors(vector1: Vector, vector2: Vector, angleUnits: AngleUnit = AngleUnit.DEGREES): Double

inline fun Vector.angleTo(other: Vector, units: AngleUnit = AngleUnit.DEGREES): Double =
    angleBetweenVectors(this, other, units)

/**
 * Получить центральное значение (среднюю точку) между векторами (set_variable_get_midpoint_between_vectors).
 */
@Action("set_variable_get_midpoint_between_vectors", returns = ["variable"])
external fun midpoint(vector1: Vector, vector2: Vector): Vector

@JvmName("vectorMidpointExt")
inline fun Vector.midpoint(other: Vector): Vector = midpoint(this, other)

/**
 * Отразить вектор относительно второго вектора (set_variable_reflect_vector_product).
 */
@Action("set_variable_reflect_vector_product", returns = ["variable"])
external fun reflectVector(vector1: Vector, vector2: Vector, bounce: Double = 1.0): Vector

inline fun Vector.reflect(normal: Vector, bounce: Double = 1.0): Vector = reflectVector(this, normal, bounce)

/**
 * Повернуть вектор вокруг оси (set_variable_rotate_vector_around_axis).
 */
@Action("set_variable_rotate_vector_around_axis", returns = ["variable"], thisArg = ["vector"])
external fun Vector.rotateAroundAxis(angle: Double, axis: VectorAxis, angleUnits: AngleUnit = AngleUnit.DEGREES): Vector

/**
 * Повернуть вектор вокруг другого вектора (set_variable_rotate_vector_around_vector).
 */
@Action("set_variable_rotate_vector_around_vector", returns = ["variable"], thisArg = ["rotating_vector"])
external fun Vector.rotateAroundVector(axisVector: Vector, angle: Double, angleUnits: AngleUnit = AngleUnit.DEGREES): Vector

/**
 * Получить сторону света вектора (set_variable_vector_to_direction_name).
 */
@Action("set_variable_vector_to_direction_name", returns = ["variable"], thisArg = ["vector"])
external fun Vector.getDirectionName(): Text

@get:JvmName("getDirectionNameProp")
val Vector.directionName: Text inline get() = getDirectionName()

/**
 * Создать вектор из кардинального направления (set_variable_get_vector_from_block_face).
 */
@Action("set_variable_get_vector_from_block_face", returns = ["variable"])
external fun vectorFromBlockFace(blockFace: String): Vector
