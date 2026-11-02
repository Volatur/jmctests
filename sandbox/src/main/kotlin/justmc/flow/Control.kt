package justmc.flow

import justmc.annotation.Action
import justmc.annotation.Slot

enum class TimeUnit {
    TICKS, SECONDS, MINUTES
}

enum class ErrorType {
    WARNING, ERROR, FATAL
}

/**
 * Управление ходом выполнения действий JustMC (control_...).
 */
object Control {

    /**
     * Приостанавливает выполнение на указанный промежуток времени.
     */
    @Action("control_wait")
    external fun wait(
        duration: Double = 1.0,
        @Slot("time_unit") unit: TimeUnit = TimeUnit.TICKS
    )

    inline fun wait(duration: Int, unit: TimeUnit = TimeUnit.TICKS) = wait(duration.toDouble(), unit)
    inline fun wait(time: Pair<Double, TimeUnit>) = wait(time.first, time.second)

    /**
     * Немедленно останавливает выполнение текущей последовательности действий (потока).
     */
    @Action("control_end_thread")
    external fun exit()

    /**
     * Вызывает исключение/ошибку с указанным сообщением и уровнем критичности.
     */
    @Action("control_call_exception")
    external fun error(
        message: String,
        id: String = "error",
        type: ErrorType = ErrorType.ERROR
    ): Nothing

    /**
     * Прерывает блок с меткой (controller_label).
     */
    @Action("control_break_label")
    external fun breakLabel(label: String)

    /**
     * Останавливает текущий цикл повторения (break).
     */
    @Action("control_stop_repeat")
    external fun stopRepeat()

    /**
     * Пропускает текущую итерацию цикла повторения (continue).
     */
    @Action("control_skip_iteration")
    external fun skipIteration()
}

// --- Удобные функции верхнего уровня ---

/**
 * Приостанавливает выполнение на указанный промежуток времени.
 */
@Action("control_wait")
external fun wait(
    duration: Double = 1.0,
    @Slot("time_unit") unit: TimeUnit = TimeUnit.TICKS
)
inline fun wait(duration: Int, unit: TimeUnit = TimeUnit.TICKS) = wait(duration.toDouble(), unit)
inline fun wait(time: Pair<Double, TimeUnit>) = wait(time.first, time.second)

inline fun delay(duration: Double = 1.0, unit: TimeUnit = TimeUnit.TICKS) = wait(duration, unit)
inline fun delay(duration: Int, unit: TimeUnit = TimeUnit.TICKS) = wait(duration.toDouble(), unit)
inline fun delay(time: Pair<Double, TimeUnit>) = wait(time.first, time.second)

// --- Расширения времени (Time extensions) ---

inline val Int.ticks: Pair<Double, TimeUnit> get() = toDouble() to TimeUnit.TICKS
inline val Double.ticks: Pair<Double, TimeUnit> get() = this to TimeUnit.TICKS
inline val Int.seconds: Pair<Double, TimeUnit> get() = toDouble() to TimeUnit.SECONDS
inline val Double.seconds: Pair<Double, TimeUnit> get() = this to TimeUnit.SECONDS
inline val Int.minutes: Pair<Double, TimeUnit> get() = toDouble() to TimeUnit.MINUTES
inline val Double.minutes: Pair<Double, TimeUnit> get() = this to TimeUnit.MINUTES

/**
 * Немедленно останавливает выполнение текущей последовательности действий (потока).
 */
@Action("control_end_thread")
external fun exit()

/**
 * Вызывает исключение/ошибку с указанным сообщением и уровнем критичности.
 */
@Action("control_call_exception")
external fun error(
    message: String,
    id: String = "error",
    type: ErrorType = ErrorType.ERROR
): Nothing

/**
 * Прерывает блок с меткой (controller_label).
 */
@Action("control_break_label")
external fun breakLabel(label: String)

/**
 * Останавливает текущий цикл повторения (break).
 */
@Action("control_stop_repeat")
external fun stopRepeat()

/**
 * Пропускает текущую итерацию цикла повторения (continue).
 */
@Action("control_skip_iteration")
external fun skipIteration()
