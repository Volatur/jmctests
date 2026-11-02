package justmc.flow

import justmc.value.Location
import justmc.value.Vector
import justmc.annotation.*
import justmc.AngleUnit

enum class AdjacentPattern {
    CARDINAL, SQUARE, ADJACENT, CUBE
}

enum class SphereRotation {
    NO_CHANGES, INWARDS, OUTWARDS
}

/**
 * Циклы и повторения действий JustMC (repeat_...).
 */
object Repeat {

    /**
     * Повторять вечно: выполняет действия внутри поршней бесконечно.
     */
    @Action("repeat_forever")
    external fun forever(block: () -> Unit)

    /**
     * Цикл со счётчиком: выполняет действия указанное количество раз.
     */
    @Action("repeat_multi_times", returns = ["variable"])
    external fun times(amount: Double, block: (index: Double) -> Unit)
    inline fun times(amount: Int, noinline block: (index: Double) -> Unit) = times(amount.toDouble(), block)

    /**
     * Цикл в диапазоне: выполняет действия на числовом промежутке от start до end с шагом interval.
     */
    @Action("repeat_on_range", returns = ["variable"])
    external fun range(
        start: Double,
        end: Double,
        interval: Double = 1.0,
        block: (i: Double) -> Unit
    )
    inline fun range(start: Int, end: Int, interval: Int = 1, noinline block: (i: Double) -> Unit) =
        range(start.toDouble(), end.toDouble(), interval.toDouble(), block)

    /**
     * Проход по региональной сетке между двумя точками.
     */
    @Action("repeat_on_grid", returns = ["variable"])
    external fun grid(start: Location, end: Location, block: (location: Location) -> Unit)

    /**
     * Проход по окружности вокруг центральной точки.
     */
    @Action("repeat_on_circle", returns = ["variable"])
    external fun circle(
        center: Location,
        radius: Double,
        circlePoints: Double = 36.0,
        perpendicularToPlane: Vector = Vector(0.0, 1.0, 0.0),
        startAngle: Double = 0.0,
        angleUnit: AngleUnit = AngleUnit.DEGREES,
        block: (location: Location) -> Unit
    )

    /**
     * Проход по сфере вокруг центральной точки.
     */
    @Action("repeat_on_sphere", returns = ["variable"])
    external fun sphere(
        center: Location,
        radius: Double,
        points: Double = 50.0,
        rotateLocation: SphereRotation = SphereRotation.NO_CHANGES,
        block: (location: Location) -> Unit
    )

    /**
     * Проход по пути между местоположениями с шагом step.
     */
    @Action("repeat_on_path", returns = ["variable"])
    external fun path(
        locations: Location,
        step: Double = 1.0,
        rotation: Boolean = false,
        block: (location: Location) -> Unit
    )

    /**
     * Проход по смежным блокам вокруг точки origin.
     */
    @Action("repeat_adjacently", returns = ["variable"])
    external fun adjacently(
        origin: Location,
        changeRotation: Boolean = false,
        includeSelf: Boolean = false,
        pattern: AdjacentPattern = AdjacentPattern.CARDINAL,
        block: (location: Location) -> Unit
    )
}

// --- Удобные функции верхнего уровня ---

/**
 * Бесконечный цикл (repeat_forever).
 */
@Action("repeat_forever")
external fun loop(block: () -> Unit)

/**
 * Цикл со счётчиком (repeat_multi_times).
 * Принимает количество повторений (Double). Для Int используется стандартный kotlin.repeat,
 * который автоматически транслируется компилятором в repeat_multi_times.
 */
@Action("repeat_multi_times", returns = ["variable"])
external fun repeat(amount: Double, block: (index: Double) -> Unit)
