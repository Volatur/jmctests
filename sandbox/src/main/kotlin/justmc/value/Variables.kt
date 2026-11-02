package justmc.value

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import justmc.annotation.*

/**
 * Режим проверки существования нескольких переменных (ANY / ALL).
 */
enum class ExistsCheckMode { ANY, ALL }

/**
 * Маркер инициализации значения только если переменная ещё не существует на сервере.
 * Компилятор оборачивает присваивание в блок `if (!variable.exists()) { ... }`.
 *
 * Пример:
 * ```kotlin
 * val playerStats = mapOf("kills" to 0.0, "deaths" to 0.0).ifNotExists()
 * ```
 */
inline fun <T> T.ifNotExists(): T = this

/**
 * Маркер однократной инициализации значения (синоним для [ifNotExists]).
 *
 * Пример:
 * ```kotlin
 * val starterKit = listOf("wooden_sword", "apple").once()
 * ```
 */
inline fun <T> T.once(): T = this

/**
 * Проверить, существует ли переменная на сервере (действие if_variable_exists).
 *
 * Пример:
 * ```kotlin
 * if (scores.exists()) { ... }
 * if (!scores.exists()) { ... }
 * ```
 */
@Action("if_variable_exists", thisArg = ["variable"])
external fun Any?.exists(
    @Slot("compare_type") checkMode: ExistsCheckMode = ExistsCheckMode.ANY
): Boolean

/**
 * Проверить, существует ли указанная переменная (действие if_variable_exists).
 */
@Action("if_variable_exists")
external fun variableExists(
    variable: Any?,
    @Slot("compare_type") checkMode: ExistsCheckMode = ExistsCheckMode.ANY
): Boolean

/**
 * Проверить, существуют ли все указанные переменные (действие if_variable_exists).
 */
@Action("if_variable_exists")
external fun allVariablesExist(
    @Slot("variable") vararg variables: Any?,
    @Slot("compare_type") checkMode: ExistsCheckMode = ExistsCheckMode.ALL
): Boolean

/**
 * Проверить, существует ли хотя бы одна из указанных переменных (действие if_variable_exists).
 */
@Action("if_variable_exists")
external fun anyVariableExists(
    @Slot("variable") vararg variables: Any?,
    @Slot("compare_type") checkMode: ExistsCheckMode = ExistsCheckMode.ANY
): Boolean

/**
 * Выполнить блок инициализации только если переменная ещё не существует на сервере.
 *
 * Пример:
 * ```kotlin
 * ifNotExists(leaderboard) {
 *     leaderboard = mapOf("Steve" to 100.0)
 * }
 * ```
 */
@OptIn(ExperimentalContracts::class)
inline fun ifNotExists(variable: Any?, block: () -> Unit) {
    contract {
        callsInPlace(block, InvocationKind.AT_MOST_ONCE)
    }
    if (!variable.exists()) {
        block()
    }
}
