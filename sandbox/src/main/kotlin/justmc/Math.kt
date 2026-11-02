package justmc

import justmc.value.*
import justmc.annotation.*
import kotlin.*

/**
 * Режим округления чисел.
 */
enum class RoundType {
    ROUND, FLOOR, CEIL
}

/**
 * Единицы измерения углов.
 */
enum class AngleUnit {
    RADIANS, DEGREES
}

/**
 * Вариант вычисления синуса.
 */
enum class SineVariant {
    SINE, ARCSINE, HYPERBOLIC_SINE, HYPERBOLIC_ARCSINE
}

/**
 * Вариант вычисления косинуса.
 */
enum class CosineVariant {
    COSINE, ARCCOSINE, HYPERBOLIC_COSINE, HYPERBOLIC_ARCCOSINE
}

/**
 * Вариант вычисления тангенса.
 */
enum class TangentVariant {
    TANGENT, ARCTANGENT, HYPERBOLIC_TANGENT, HYPERBOLIC_ARCTANGENT
}

/**
 * Вариант вычисления котангенса.
 */
enum class CotangentVariant {
    COTANGENT, ARCCOTANGENT, HYPERBOLIC_COTANGENT, HYPERBOLIC_ARCCOTANGENT
}

/**
 * Тип среднего значения.
 */
enum class AverageType {
    ARITHMETIC, GEOMETRIC, HARMONIC, QUADRATIC
}

/**
 * Тип нормального распределения.
 */
enum class GaussianDistribution {
    NORMAL, FOLDER_NORMAL
}

/**
 * Диапазон вывода шума.
 */
enum class NoiseRange {
    ZERO_TO_ONE, FULL_RANGE
}

/**
 * Режим включения границ диапазона при проверке числа.
 */
enum class RangeInclusion {
    INCLUDE_ALL, INCLUDE_FIRST, INCLUDE_LAST, NOT_INCLUDE
}

/**
 * Математические операции и функции JustMC.
 */
object Math {

    const val PI = 3.141592653589793
    const val E = 2.718281828459045

    // ==========================================
    // Базовые математические функции
    // ==========================================

    /**
     * Модуль числа (set_variable_absolute)
     * Возвращает абсолютное значение числа (без знака).
     */
    @Action("set_variable_absolute", returns = ["variable"])
    external fun abs(number: Double): Double

    /**
     * Минимальное значение (set_variable_min)
     * Возвращает наименьшее из переданных чисел.
     */
    @Action("set_variable_min", returns = ["variable"])
    external fun min(vararg value: Double): Double

    /**
     * Максимальное значение (set_variable_max)
     * Возвращает наибольшее из переданных чисел.
     */
    @Action("set_variable_max", returns = ["variable"])
    external fun max(vararg value: Double): Double

    /**
     * Ограничить число (set_variable_clamp)
     * Ограничивает число диапазоном [min, max].
     */
    @Action("set_variable_clamp", returns = ["variable"])
    external fun clamp(number: Double, min: Double, max: Double): Double

    /**
     * Обернуть число (set_variable_warp)
     * Если число выходит за границы диапазона, оно циклически "оборачивается" в него.
     */
    @Action("set_variable_warp", returns = ["variable"])
    external fun warp(number: Double, min: Double, max: Double): Double

    /**
     * Округлить число (set_variable_round)
     * Округляет число до заданной точности указанным способом.
     */
    @Action("set_variable_round", returns = ["variable"])
    external fun round(number: Double, precision: Int = 0, roundType: RoundType = RoundType.ROUND): Double

    @Inline
    fun floor(number: Double, precision: Int = 0): Double = round(number, precision, RoundType.FLOOR)

    @Inline
    fun ceil(number: Double, precision: Int = 0): Double = round(number, precision, RoundType.CEIL)

    /**
     * Степень числа (set_variable_pow)
     * Возводит основание base в степень power.
     */
    @Action("set_variable_pow", returns = ["variable"])
    external fun pow(base: Double, power: Double): Double

    /**
     * Корень числа (set_variable_root)
     * Извлекает корень степени root из основания base.
     */
    @Action("set_variable_root", returns = ["variable"])
    external fun root(base: Double, root: Double = 2.0): Double

    @Inline
    fun sqrt(number: Double): Double = root(number, 2.0)

    /**
     * Логарифм числа (set_variable_log)
     * Вычисляет логарифм числа number по основанию base.
     */
    @Action("set_variable_log", returns = ["variable"])
    external fun log(number: Double, base: Double = E): Double

    @Inline
    fun ln(number: Double): Double = log(number, E)

    @Inline
    fun log10(number: Double): Double = log(number, 10.0)

    @Inline
    fun log2(number: Double): Double = log(number, 2.0)

    /**
     * Случайное число (set_variable_random_number)
     * Генерирует случайное число в диапазоне [min, max].
     */
    @Action("set_variable_random_number", returns = ["variable"])
    external fun random(min: Double, max: Double, integer: Boolean = false): Double

    /**
     * Нормально распределённое случайное число (set_variable_gaussian_distribution)
     * Выдаёт случайное число близкое к среднему значению mean со стандартным отклонением deviant.
     */
    @Action("set_variable_gaussian_distribution", returns = ["variable"])
    external fun gaussian(deviant: Double, mean: Double = 0.0, distribution: GaussianDistribution = GaussianDistribution.NORMAL): Double

    /**
     * Интерполировать число (set_variable_lerp_number)
     * Вычисляет линейную интерполяцию между start и stop с коэффициентом amount (от 0 до 1).
     */
    @Action("set_variable_lerp_number", returns = ["variable"])
    external fun lerp(start: Double, stop: Double, amount: Double): Double

    /**
     * Перевести число в другой диапазон (set_variable_map_range)
     * Масштабирует число из диапазона [fromStart, fromStop] в диапазон [toStart, toStop].
     */
    @Action("set_variable_map_range", returns = ["variable"])
    external fun mapRange(number: Double, fromStart: Double, fromStop: Double, toStart: Double, toStop: Double): Double

    /**
     * Гамма-функция (set_variable_gamma_function)
     * Вычисляет значение гамма-функции Г(number).
     */
    @Action("set_variable_gamma_function", returns = ["variable"])
    external fun gamma(number: Double): Double

    // ==========================================
    // Статистика и множества чисел
    // ==========================================

    /**
     * Среднее значение (set_variable_average)
     * Вычисляет среднее значение чисел указанного типа.
     */
    @Action("set_variable_average", returns = ["variable"])
    external fun average(vararg value: Double, type: AverageType = AverageType.ARITHMETIC): Double

    /**
     * Медианное значение (set_variable_median)
     * Находит медиану из переданных чисел.
     */
    @Action("set_variable_median", returns = ["variable"])
    external fun median(vararg value: Double): Double

    /**
     * Ближайшее число (set_variable_find_nearest_number)
     * Находит среди чисел numbers ближайшее к числу number.
     */
    @Action("set_variable_find_nearest_number", returns = ["variable"])
    external fun nearest(number: Double, vararg numbers: Double): Double

    /**
     * Математическое ожидание (set_variable_mathematical_expectation)
     * Вычисляет мат. ожидание по списку значений и списку вероятностей.
     */
    @Action("set_variable_mathematical_expectation", returns = ["variable"])
    external fun expectation(values: List<Double>, probabilities: List<Double>): Double

    // ==========================================
    // Тригонометрия
    // ==========================================

    /**
     * Синус числа (set_variable_sine)
     */
    @Action("set_variable_sine", returns = ["variable"])
    external fun sin(number: Double, variant: SineVariant = SineVariant.SINE, input: AngleUnit = AngleUnit.RADIANS): Double

    @Inline
    fun asin(number: Double, input: AngleUnit = AngleUnit.RADIANS): Double = sin(number, SineVariant.ARCSINE, input)

    @Inline
    fun sinh(number: Double, input: AngleUnit = AngleUnit.RADIANS): Double = sin(number, SineVariant.HYPERBOLIC_SINE, input)

    @Inline
    fun asinh(number: Double, input: AngleUnit = AngleUnit.RADIANS): Double = sin(number, SineVariant.HYPERBOLIC_ARCSINE, input)

    /**
     * Косинус числа (set_variable_cosine)
     */
    @Action("set_variable_cosine", returns = ["variable"])
    external fun cos(number: Double, variant: CosineVariant = CosineVariant.COSINE, input: AngleUnit = AngleUnit.RADIANS): Double

    @Inline
    fun acos(number: Double, input: AngleUnit = AngleUnit.RADIANS): Double = cos(number, CosineVariant.ARCCOSINE, input)

    @Inline
    fun cosh(number: Double, input: AngleUnit = AngleUnit.RADIANS): Double = cos(number, CosineVariant.HYPERBOLIC_COSINE, input)

    @Inline
    fun acosh(number: Double, input: AngleUnit = AngleUnit.RADIANS): Double = cos(number, CosineVariant.HYPERBOLIC_ARCCOSINE, input)

    /**
     * Тангенс числа (set_variable_tangent)
     */
    @Action("set_variable_tangent", returns = ["variable"])
    external fun tan(number: Double, variant: TangentVariant = TangentVariant.TANGENT, input: AngleUnit = AngleUnit.RADIANS): Double

    @Inline
    fun atan(number: Double, input: AngleUnit = AngleUnit.RADIANS): Double = tan(number, TangentVariant.ARCTANGENT, input)

    @Inline
    fun tanh(number: Double, input: AngleUnit = AngleUnit.RADIANS): Double = tan(number, TangentVariant.HYPERBOLIC_TANGENT, input)

    @Inline
    fun atanh(number: Double, input: AngleUnit = AngleUnit.RADIANS): Double = tan(number, TangentVariant.HYPERBOLIC_ARCTANGENT, input)

    /**
     * Котангенс числа (set_variable_cotangent)
     */
    @Action("set_variable_cotangent", returns = ["variable"])
    external fun cot(number: Double, variant: CotangentVariant = CotangentVariant.COTANGENT, input: AngleUnit = AngleUnit.RADIANS): Double

    @Inline
    fun acot(number: Double, input: AngleUnit = AngleUnit.RADIANS): Double = cot(number, CotangentVariant.ARCCOTANGENT, input)

    @Inline
    fun coth(number: Double, input: AngleUnit = AngleUnit.RADIANS): Double = cot(number, CotangentVariant.HYPERBOLIC_COTANGENT, input)

    @Inline
    fun acoth(number: Double, input: AngleUnit = AngleUnit.RADIANS): Double = cot(number, CotangentVariant.HYPERBOLIC_ARCCOTANGENT, input)

    /**
     * Арктангенс координат (set_variable_atan2)
     */
    @Action("set_variable_atan2", returns = ["variable"])
    external fun atan2(y: Double, x: Double): Double

    // ==========================================
    // Генерация шумов (3D Noise)
    // ==========================================

    /**
     * Шум Перлина (set_variable_perlin_noise_3d)
     */
    @Action("set_variable_perlin_noise_3d", returns = ["variable"])
    external fun perlinNoise(
        seed: Double,
        location: Location,
        locFrequency: Double = 1.0,
        octaves: Double = 1.0,
        frequency: Double = 1.0,
        amplitude: Double = 1.0,
        rangeMode: NoiseRange = NoiseRange.ZERO_TO_ONE,
        normalized: Boolean = true
    ): Double

    /**
     * Шум Симплекс (set_variable_simplex_noise_3d)
     */
    @Action("set_variable_simplex_noise_3d", returns = ["variable"])
    external fun simplexNoise(
        seed: Double,
        location: Location,
        locFrequency: Double = 1.0,
        octaves: Double = 1.0,
        frequency: Double = 1.0,
        amplitude: Double = 1.0,
        rangeMode: NoiseRange = NoiseRange.ZERO_TO_ONE,
        normalized: Boolean = true
    ): Double

    /**
     * Шум Вороного (set_variable_voronoi_noise_3d)
     */
    @Action("set_variable_voronoi_noise_3d", returns = ["variable"])
    external fun voronoiNoise(
        location: Location,
        seed: Double,
        frequency: Double = 1.0,
        displacement: Double = 1.0,
        rangeMode: NoiseRange = NoiseRange.ZERO_TO_ONE,
        enableDistance: Boolean = false
    ): Double

    // ==========================================
    // Цветовые функции
    // ==========================================

    /**
     * Создать RGB цвет (set_variable_to_rgb)
     * Создаёт HEX цвет на основе красного, зелёного и синего каналов (0 - 255).
     */
    @Action("set_variable_to_rgb", returns = ["variable"])
    external fun rgb(red: Double, green: Double, blue: Double): Text

    /**
     * Создать HSB цвет (set_variable_to_hsb)
     * Создаёт HEX цвет на основе оттенка (0 - 360), насыщенности (0 - 100) и яркости (0 - 100).
     */
    @Action("set_variable_to_hsb", returns = ["variable"])
    external fun hsb(hue: Double, saturation: Double, brightness: Double): Text

    /**
     * Создать HSL цвет (set_variable_to_hsl)
     * Создаёт HEX цвет на основе оттенка (0 - 360), насыщенности (0 - 100) и светлоты (0 - 100).
     */
    @Action("set_variable_to_hsl", returns = ["variable"])
    external fun hsl(hue: Double, saturation: Double, lightness: Double): Text
}

/**
 * Преобразовать число в текст (set_variable_convert_number_to_text)
 */
@Action("set_variable_convert_number_to_text", returns = ["variable"], thisArg = ["number"])
external fun Double.toString(radix: Int = 10): Text

@Inline
fun Double.toText(radix: Int = 10): Text = this.toString(radix)

/**
 * Получить символ по числу (set_variable_to_char)
 */
@Action("set_variable_to_char", returns = ["variable"], thisArg = ["number"])
external fun Double.toCharacter(): Text

@Inline
fun Double.toCharString(): Text = this.toCharacter()

@Inline
fun random(min: Double, max: Double, integer: Boolean = false): Double =
    Math.random(min, max, integer)

@Inline
fun round(number: Double, precision: Int = 0, roundType: RoundType = RoundType.ROUND): Double =
    Math.round(number, precision, roundType)

@Inline
fun abs(number: Double): Double =
    Math.abs(number)

