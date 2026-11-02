package justmc.flow

import justmc.annotation.Action
import justmc.annotation.Slot

enum class SelectionMode {
    DEFAULT, CURRENT, EMPTY, FOR_EACH
}

enum class MeasureDuration {
    NANOSECONDS, MICROSECONDS, MILLISECONDS
}

enum class ExceptionType {
    WARNING, ERROR, ALL
}

/**
 * Контроллер выполнения кода JustMC (controller_...).
 */
object Controller {

    /**
     * Помечает блок кода указанной меткой, позволяя прервать его выполнение через return@label или Control.breakLabel.
     */
    @Action("controller_label")
    external fun label(label: String, block: () -> Unit)

    inline fun label(noinline block: () -> Unit) = label("label", block)

    /**
     * Изолирует текущую выборку целей внутри блока.
     */
    @Action("controller_isolated_selection")
    external fun isolate(@Slot("selection_mode") mode: SelectionMode = SelectionMode.DEFAULT, block: () -> Unit)

    /**
     * Замеряет время выполнения блока кода и возвращает затраченное время.
     */
    @Action("controller_measure_time", returns = ["variable"])
    external fun measure(duration: MeasureDuration = MeasureDuration.MILLISECONDS, block: () -> Unit): Double

    /**
     * Замеряет время выполнения блока кода и передает затраченное время в параметр лямбды.
     */
    @Action("controller_measure_time", returns = ["variable"])
    external fun measureTimed(duration: MeasureDuration = MeasureDuration.MILLISECONDS, block: (time: Double) -> Unit)

    /**
     * Перехватывает ошибку выполнения внутри блока и возвращает её идентификатор.
     */
    @Action("controller_exception", returns = ["variable"])
    external fun catch(@Slot("exception_type") type: ExceptionType = ExceptionType.ALL, block: () -> Unit): String

    /**
     * Перехватывает ошибку выполнения внутри блока и передает её идентификатор в параметр лямбды.
     */
    @Action("controller_exception", returns = ["variable"])
    external fun catchError(@Slot("exception_type") type: ExceptionType = ExceptionType.ALL, block: (error: String) -> Unit)

    /**
     * Запускает код внутри блока в отдельном асинхронном потоке.
     */
    @Action("controller_async_run")
    external fun async(block: () -> Unit)

    /**
     * Игнорирует выполнение кода внутри блока во время работы программы.
     */
    @Action("controller_do_not_run")
    external fun ignore(block: () -> Unit)
}
