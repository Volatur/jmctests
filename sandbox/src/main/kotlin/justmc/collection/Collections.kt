package justmc.collection

import justmc.annotation.*

import justmc.value.Tuple2
import justmc.value.Tuple3
import kotlin.jvm.JvmName

// ============================================================================
// Enums для коллекций (List & Map)
// ============================================================================

enum class SortOrder {
    ASCENDING,
    DESCENDING
}

enum class SearchMode {
    FIRST,
    LAST
}

enum class ListRemoveMode {
    FIRST,
    LAST,
    ALL
}

enum class CollectionCheckMode {
    ANY,
    ALL
}

enum class EmptyCheckMode {
    ANY,
    ALL
}

enum class MapSortType {
    KEYS,
    VALUES
}

enum class MapFindMode {
    FIRST,
    LAST,
    ALL
}

enum class VariableScope {
    GAME,
    SAVE,
    LOCAL,
    LINE
}

enum class VariableMatchMode {
    EQUALS,
    @SlotValue("NAME_CONTAINS") CONTAINS,
    PART_CONTAINS,
    STARTS_WITH,
    ENDS_WITH
}

// ============================================================================
// Действия со списками (List / MutableList)
// ============================================================================

/** Создать список из элементов (set_variable_create_list). */
@Action("set_variable_create_list", returns = ["variable"])
external fun <T> createList(@Slot("values") vararg values: T): List<T>

/** Объединить два списка (set_variable_append_list). */
@Action("set_variable_append_list", returns = ["variable"], thisArg = ["list_1"])
external operator fun <T> List<T>.plus(@Slot("list_2") other: List<T>): List<T>

/** Объединить несколько списков (set_variable_append_lists). */
@Action("set_variable_append_lists", returns = ["variable"])
external fun <T> concatLists(@Slot("lists") vararg lists: List<T>): List<T>

/** Получить значение из списка по индексу (set_variable_get_list_value). */
@Action("set_variable_get_list_value", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.getAt(
    @Slot("number") index: Double,
    defaultValue: T? = null,
    remove: Boolean = false
): T

inline fun <T> List<T>.getAt(index: Int): T = getAt(index.toDouble())

inline fun <T> List<T>.getOrElse(index: Int, defaultValue: T): T = getAt(index.toDouble(), defaultValue)

/** Получить размер списка (set_variable_get_list_length). */
@Action("set_variable_get_list_length", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.getLength(): Double

@get:JvmName("getListCountProp")
val <T> List<T>.count: Double inline get() = getLength()

/** Получить случайное значение из списка (set_variable_get_list_random_value). */
@Action("set_variable_get_list_random_value", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.random(): T

/** Найти индекс значения в списке (set_variable_get_list_index_of_value). */
@Action("set_variable_get_list_index_of_value", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.indexOf(
    value: T,
    searchMode: SearchMode = SearchMode.FIRST
): Double

inline fun <T> List<T>.lastIndexOf(value: T): Double = indexOf(value, SearchMode.LAST)

/** Удалить повторяющиеся значения из списка (set_variable_remove_list_duplicates). */
@Action("set_variable_remove_list_duplicates", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.distinct(): List<T>

/** Перевернуть порядок элементов списка (set_variable_reverse_list). */
@Action("set_variable_reverse_list", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.reversed(): List<T>

/** Рандомизировать порядок элементов списка (set_variable_randomize_list_order). */
@Action("set_variable_randomize_list_order", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.shuffled(): List<T>

/** Отсортировать список (set_variable_sort_any_list). */
@Action("set_variable_sort_any_list", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.sorted(sortMode: SortOrder = SortOrder.ASCENDING): List<T>

inline fun <T> List<T>.sortedDescending(): List<T> = sorted(SortOrder.DESCENDING)

/** Обрезать список по диапазону индексов (set_variable_trim_list). */
@Action("set_variable_trim_list", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.slice(start: Double, end: Double): List<T>

inline fun <T> List<T>.slice(start: Int, end: Int): List<T> = slice(start.toDouble(), end.toDouble())

/** Разбить список на фрагменты указанного размера (set_variable_chunk_list). */
@Action("set_variable_chunk_list", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.chunked(size: Double): List<List<T>>

inline fun <T> List<T>.chunked(size: Int): List<List<T>> = chunked(size.toDouble())

/** Сгладить вложенные списки в один плоский список (set_variable_flatten_list). */
@Action("set_variable_flatten_list", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.flatten(deep: Boolean = false): List<Any>

/** Вставить значение в список по индексу (set_variable_insert_list_value). */
@Action("set_variable_insert_list_value", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.inserted(@Slot("number") index: Double, value: T): List<T>

inline fun <T> List<T>.inserted(index: Int, value: T): List<T> = inserted(index.toDouble(), value)

/** Заменить значение списка по указанному индексу (set_variable_set_list_value). */
@Action("set_variable_set_list_value", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.withValueAt(@Slot("number") index: Double, value: T): List<T>

inline fun <T> List<T>.withValueAt(index: Int, value: T): List<T> = withValueAt(index.toDouble(), value)

/** Удалить значение из списка (set_variable_remove_list_value). */
@Action("set_variable_remove_list_value", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.withoutValue(
    value: T,
    removeMode: ListRemoveMode = ListRemoveMode.FIRST
): List<T>

inline fun <T> List<T>.withoutAll(value: T): List<T> = withoutValue(value, ListRemoveMode.ALL)

/** Удалить элемент списка по индексу, возвращает обновленный список (set_variable_remove_list_value_at_index). */
@Action("set_variable_remove_list_value_at_index", returns = ["variable"], thisArg = ["list"])
external fun <T> List<T>.withoutIndex(index: Double): List<T>

inline fun <T> List<T>.withoutIndex(index: Int): List<T> = withoutIndex(index.toDouble())

/** Удалить элемент списка по индексу с возвратом удаленного значения (set_variable_remove_list_value_at_index). */
@Action("set_variable_remove_list_value_at_index", returns = ["removed_value"], thisArg = ["variable", "list"])
external fun <T> MutableList<T>.removeAt(index: Double): T

inline fun <T> MutableList<T>.removeAt(index: Int): T = removeAt(index.toDouble())

/** Извлечь значение по индексу с удалением из списка (set_variable_get_list_value remove=true). */
inline fun <T> MutableList<T>.popAt(index: Double): T = getAt(index, remove = true)

inline fun <T> MutableList<T>.popAt(index: Int): T = popAt(index.toDouble())

/** Добавить значения в список (set_variable_append_value). */
@Action("set_variable_append_value", thisArg = ["variable"])
external fun <T> MutableList<T>.addValue(vararg values: T): MutableList<T>

/** Добавить значение в список (set_variable_append_value). */
@Action("set_variable_append_value", thisArg = ["variable"])
external operator fun <T> MutableList<T>.plusAssign(@Slot("values") value: T)

/** Разложить список на два значения в кортеж (set_variable_destructure_list). */
@Action("set_variable_destructure_list", returns = ["variables", "variables"], thisArg = ["list"])
external fun <T> List<T>.destructure2(): Tuple2<T, T>

/** Разложить список на три значения в кортеж (set_variable_destructure_list). */
@Action("set_variable_destructure_list", returns = ["variables", "variables", "variables"], thisArg = ["list"])
external fun <T> List<T>.destructure3(): Tuple3<T, T, T>

/** Получить список имён всех переменных (set_variable_get_list_variables). */
@Action("set_variable_get_list_variables", returns = ["variable"])
external fun getVariableNames(
    scope: VariableScope = VariableScope.LOCAL,
    match: VariableMatchMode = VariableMatchMode.EQUALS,
    ignoreCase: Boolean = false,
    @Slot("names") vararg names: String
): List<String>

// ============================================================================
// Условия над списками (Conditions / if_variable_*)
// ============================================================================

/** Проверить, содержит ли список указанное значение (if_variable_list_contains_value). */
@Action("if_variable_list_contains_value", thisArg = ["list"])
external fun <T> List<T>.containsValue(
    @Slot("values") value: T,
    checkMode: CollectionCheckMode = CollectionCheckMode.ANY
): Boolean

/** Проверить, содержит ли список все указанные значения (if_variable_list_contains_value). */
@Action("if_variable_list_contains_value", thisArg = ["list"])
external fun <T> List<T>.containsAllValues(
    @Slot("values") vararg values: T,
    checkMode: CollectionCheckMode = CollectionCheckMode.ALL
): Boolean

/** Проверить, равен ли элемент списка по индексу значению (if_variable_list_value_equals). */
@Action("if_variable_list_value_equals", thisArg = ["list"])
external fun <T> List<T>.elementEquals(
    index: Double,
    @Slot("values") vararg values: T
): Boolean

inline fun <T> List<T>.elementEquals(index: Int, vararg values: T): Boolean =
    elementEquals(index.toDouble(), *values)

/** Проверить, пуст ли список (if_variable_list_is_empty). */
@Action("if_variable_list_is_empty", thisArg = ["list"])
external fun <T> List<T>.isEmpty(
    compareType: EmptyCheckMode = EmptyCheckMode.ANY
): Boolean

// ============================================================================
// Действия со словарями (Map / MutableMap)
// ============================================================================

/** Создать словарь из параллельных списков ключей и значений (set_variable_create_map). */
@Action("set_variable_create_map", returns = ["variable"])
external fun <K, V> mapFrom(keys: List<K>, values: List<V>): Map<K, V>

/** Создать словарь из ключей и значений (set_variable_create_map_from_values). */
@Action("set_variable_create_map_from_values", returns = ["variable"])
external fun <K, V> mapFromValues(keys: List<K>, values: List<V>): Map<K, V>

inline fun <K, V> List<K>.zipToMap(values: List<V>): Map<K, V> = mapFrom(this, values)

/** Объединить два словаря (set_variable_append_map). */
@Action("set_variable_append_map", returns = ["variable"], thisArg = ["map"])
external operator fun <K, V> Map<K, V>.plus(otherMap: Map<K, V>): Map<K, V>

/** Объединить несколько словарей (set_variable_append_maps). */
@Action("set_variable_append_maps", returns = ["variable"])
external fun <K, V> concatMaps(@Slot("maps") vararg maps: Map<K, V>): Map<K, V>

/** Получить значение словаря по ключу (set_variable_get_map_value). */
@Action("set_variable_get_map_value", returns = ["variable"], thisArg = ["map"])
external fun <K, V> Map<K, V>.getValueByKey(key: K, defaultValue: V? = null): V

inline fun <K, V> Map<K, V>.getOrElse(key: K, defaultValue: V): V = getValueByKey(key, defaultValue)

/** Установить значение в словаре, возвращает обновленный словарь (set_variable_set_map_value). */
@Action("set_variable_set_map_value", returns = ["variable"], thisArg = ["map"])
external fun <K, V> Map<K, V>.with(key: K, value: V): Map<K, V>

/** Заменить значение в словаре по ключу с возвратом предыдущего значения (set_variable_put_map_value). */
@Action("set_variable_put_map_value", returns = ["replaced_value"], thisArg = ["map"])
external fun <K, V> MutableMap<K, V>.putValue(key: K, value: V): V?

/** Удалить элемент словаря по ключу с возвратом удаленного значения (set_variable_remove_map_entry). */
@Action("set_variable_remove_map_entry", returns = ["removed_value"], thisArg = ["map"])
external fun <K, V> MutableMap<K, V>.removeEntry(key: K): V?

/** Удалить элемент словаря по ключу, возвращает обновленный словарь (set_variable_remove_map_entry). */
@Action("set_variable_remove_map_entry", returns = ["variable"], thisArg = ["map"])
external fun <K, V> Map<K, V>.without(key: K): Map<K, V>

/** Очистить словарь (set_variable_clear_map). */
@Action("set_variable_clear_map", thisArg = ["map"])
external fun <K, V> MutableMap<K, V>.clear()

/** Получить список ключей словаря (set_variable_get_map_keys). */
@Action("set_variable_get_map_keys", returns = ["variable"], thisArg = ["map"])
external fun <K, V> Map<K, V>.getKeys(): List<K>

@get:JvmName("getMapKeysListProp")
val <K, V> Map<K, V>.mapKeys: List<K> inline get() = getKeys()

/** Получить список значений словаря (set_variable_get_map_values). */
@Action("set_variable_get_map_values", returns = ["variable"], thisArg = ["map"])
external fun <K, V> Map<K, V>.getValues(): List<V>

@get:JvmName("getMapValuesListProp")
val <K, V> Map<K, V>.mapValues: List<V> inline get() = getValues()

/** Получить размер словаря (set_variable_get_map_size). */
@Action("set_variable_get_map_size", returns = ["variable"], thisArg = ["map"])
external fun <K, V> Map<K, V>.getSize(): Double

@get:JvmName("getMapSizeNumberProp")
val <K, V> Map<K, V>.mapSize: Double inline get() = getSize()

/** Получить ключ словаря по индексу (set_variable_get_map_key_by_index). */
@Action("set_variable_get_map_key_by_index", returns = ["variable"], thisArg = ["map"])
external fun <K, V> Map<K, V>.keyAt(
    index: Double,
    defaultValue: K? = null
): K

inline fun <K, V> Map<K, V>.keyAt(index: Int): K = keyAt(index.toDouble())

/** Получить значение словаря по индексу (set_variable_get_map_value_by_index). */
@Action("set_variable_get_map_value_by_index", returns = ["variable"], thisArg = ["map"])
external fun <K, V> Map<K, V>.valueAt(
    index: Double,
    defaultValue: V? = null
): V

inline fun <K, V> Map<K, V>.valueAt(index: Int): V = valueAt(index.toDouble())

/** Получить пару ключ-значение словаря по индексу (set_variable_get_map_entry_by_index). */
@Action("set_variable_get_map_entry_by_index", returns = ["variable_key", "variable_value"], thisArg = ["map"])
external fun <K, V> Map<K, V>.entryAt(
    index: Double,
    defaultKey: K? = null,
    defaultValue: V? = null
): Tuple2<K, V>

inline fun <K, V> Map<K, V>.entryAt(index: Int): Tuple2<K, V> = entryAt(index.toDouble())

/** Получить случайную пару ключ-значение словаря (set_variable_get_map_random_entry). */
@Action("set_variable_get_map_random_entry", returns = ["variable_key", "variable_value"], thisArg = ["map"])
external fun <K, V> Map<K, V>.randomEntry(): Tuple2<K, V>

/** Найти ключи словаря по значению (set_variable_get_map_keys_by_value). */
@Action("set_variable_get_map_keys_by_value", returns = ["variable"], thisArg = ["map"])
external fun <K, V> Map<K, V>.keysForValue(
    value: V,
    defaultValue: K? = null,
    findMode: MapFindMode = MapFindMode.ALL
): List<K>

inline fun <K, V> Map<K, V>.keyForValue(value: V): K? =
    keysForValue(value, findMode = MapFindMode.FIRST).firstOrNull()

/** Отсортировать словарь (set_variable_sort_any_map). */
@Action("set_variable_sort_any_map", returns = ["variable"], thisArg = ["map"])
external fun <K, V> Map<K, V>.sorted(
    sortOrder: SortOrder = SortOrder.ASCENDING,
    sortType: MapSortType = MapSortType.KEYS
): Map<K, V>

/** Перевернуть порядок элементов словаря (set_variable_reverse_map). */
@Action("set_variable_reverse_map", returns = ["variable"], thisArg = ["map"])
external fun <K, V> Map<K, V>.reversed(): Map<K, V>

/** Рандомизировать порядок элементов словаря (set_variable_randomize_map_order). */
@Action("set_variable_randomize_map_order", returns = ["variable"], thisArg = ["map"])
external fun <K, V> Map<K, V>.shuffled(): Map<K, V>

// ============================================================================
// Условия над словарями (Conditions / if_variable_*)
// ============================================================================

/** Проверить, имеет ли словарь указанный ключ (if_variable_map_has_key). */
@Action("if_variable_map_has_key", thisArg = ["map"])
external fun <K, V> Map<K, V>.hasKey(
    key: K,
    checkMode: CollectionCheckMode = CollectionCheckMode.ANY
): Boolean

/** Проверить, имеет ли словарь все указанные ключи (if_variable_map_has_key). */
@Action("if_variable_map_has_key", thisArg = ["map"])
external fun <K, V> Map<K, V>.hasKeys(
    vararg key: K,
    checkMode: CollectionCheckMode = CollectionCheckMode.ALL
): Boolean

/** Проверить равенство значения элемента словаря по ключу (if_variable_map_value_equals). */
@Action("if_variable_map_value_equals", thisArg = ["map"])
external fun <K, V> Map<K, V>.valueEquals(
    key: K,
    @Slot("values") vararg values: V
): Boolean

// --- List: Итерация и инспекция ---

/** Выполнить действие для каждого элемента списка. */
@Action("repeat_for_each_in_list", returns = ["value_variable"], thisArg = ["list"])
external fun <T> List<T>.forEach(action: (item: T) -> Unit)

/** Выполнить действие для каждого элемента списка с его индексом. */
@Action("repeat_for_each_in_list", returns = ["index_variable", "value_variable"], thisArg = ["list"])
external fun <T> List<T>.forEachIndexed(action: (index: Int, item: T) -> Unit)

// --- List: Трансформация ---

/** Преобразовать каждый элемент списка с помощью функции трансформации. */
inline fun <T, R> List<T>.map(transform: (T) -> R): List<R> {
    val result = mutableListOf<R>()
    for (item in this) {
        result += transform(item)
    }
    return result
}

/** Преобразовать каждый элемент списка с индексом с помощью функции трансформации. */
inline fun <T, R> List<T>.mapIndexed(transform: (index: Double, item: T) -> R): List<R> {
    val result = mutableListOf<R>()
    var index = 0.0
    for (item in this) {
        result += transform(index, item)
        index += 1.0
    }
    return result
}

/** Преобразовать элементы списка и отфильтровать null-значения. */
inline fun <T, R> List<T>.mapNotNull(transform: (T) -> R?): List<R> {
    val result = mutableListOf<R>()
    for (item in this) {
        val transformed = transform(item)
        if (transformed != null) {
            result += transformed
        }
    }
    return result
}

/** Преобразовать каждый элемент в список и объединить результаты в один плоский список. */
inline fun <T, R> List<T>.flatMap(transform: (T) -> List<R>): List<R> {
    val result = mutableListOf<R>()
    for (item in this) {
        for (subItem in transform(item)) {
            result += subItem
        }
    }
    return result
}

// --- List: Фильтрация ---

/** Отфильтровать элементы списка по предикату. */
inline fun <T> List<T>.filter(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        if (predicate(item)) {
            result += item
        }
    }
    return result
}

/** Отфильтровать элементы списка по предикату с индексом. */
inline fun <T> List<T>.filterIndexed(predicate: (index: Double, item: T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    var index = 0.0
    for (item in this) {
        if (predicate(index, item)) {
            result += item
        }
        index += 1.0
    }
    return result
}

/** Отфильтровать элементы списка, исключая удовлетворяющие предикату. */
inline fun <T> List<T>.filterNot(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        if (!predicate(item)) {
            result += item
        }
    }
    return result
}

/** Отфильтровать элементы списка, исключая null. */
inline fun <T> List<T?>.filterNotNull(): List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        if (item != null) {
            result += item
        }
    }
    return result
}

/** Разделить список на пару списков по условию предиката. */
inline fun <T> List<T>.partition(predicate: (T) -> Boolean): Tuple2<List<T>, List<T>> {
    val first = mutableListOf<T>()
    val second = mutableListOf<T>()
    for (item in this) {
        if (predicate(item)) {
            first += item
        } else {
            second += item
        }
    }
    return Tuple2(first, second)
}

// --- List: Поиск и предикаты ---

/** Проверить, удовлетворяет ли хотя бы один элемент условию. */
inline fun <T> List<T>.any(predicate: (T) -> Boolean): Boolean {
    var found = false
    for (item in this) {
        if (predicate(item)) {
            found = true
            break
        }
    }
    return found
}

/** Проверить, удовлетворяют ли все элементы условию. */
inline fun <T> List<T>.all(predicate: (T) -> Boolean): Boolean {
    var allMatch = true
    for (item in this) {
        if (!predicate(item)) {
            allMatch = false
            break
        }
    }
    return allMatch
}

/** Проверить, что ни один элемент не удовлетворяет условию. */
inline fun <T> List<T>.none(predicate: (T) -> Boolean): Boolean {
    var noneMatch = true
    for (item in this) {
        if (predicate(item)) {
            noneMatch = false
            break
        }
    }
    return noneMatch
}

/** Найти первый элемент, удовлетворяющий условию, или вернуть null. */
inline fun <T> List<T>.firstOrNull(predicate: (T) -> Boolean): T? {
    var found: T? = null
    for (item in this) {
        if (predicate(item)) {
            found = item
            break
        }
    }
    return found
}

/** Найти первый элемент, удовлетворяющий условию, или вернуть null. */
inline fun <T> List<T>.find(predicate: (T) -> Boolean): T? = firstOrNull(predicate)

/** Найти последний элемент, удовлетворяющий условию, или вернуть null. */
inline fun <T> List<T>.lastOrNull(predicate: (T) -> Boolean): T? {
    var found: T? = null
    for (item in this) {
        if (predicate(item)) {
            found = item
        }
    }
    return found
}

/** Найти последний элемент, удовлетворяющий условию, или вернуть null. */
inline fun <T> List<T>.findLast(predicate: (T) -> Boolean): T? = lastOrNull(predicate)

/** Посчитать количество элементов, удовлетворяющих условию. */
inline fun <T> List<T>.count(predicate: (T) -> Boolean): Double {
    var total = 0.0
    for (item in this) {
        if (predicate(item)) {
            total += 1.0
        }
    }
    return total
}

// --- List: Группировка и ассоциация ---

/** Сгруппировать элементы по ключу в Map. */
inline fun <T, K> List<T>.groupBy(keySelector: (T) -> K): Map<K, List<T>> {
    var result = mapOf<K, List<T>>()
    for (item in this) {
        val key = keySelector(item)
        val currentGroup = if (result.hasKey(key)) result.getValueByKey(key) else listOf()
        val updatedGroup = currentGroup + listOf(item)
        result = result.with(key, updatedGroup)
    }
    return result
}

/** Ассоциировать элементы в словарь по парам Pair. */
inline fun <T, K, V> List<T>.associate(transform: (T) -> Pair<K, V>): Map<K, V> {
    var result = mapOf<K, V>()
    for (item in this) {
        val pair = transform(item)
        result = result.with(pair.first, pair.second)
    }
    return result
}

/** Ассоциировать элементы в словарь по парам Tuple2. */
inline fun <T, K, V> List<T>.associateTuple(transform: (T) -> Tuple2<K, V>): Map<K, V> {
    var result = mapOf<K, V>()
    for (item in this) {
        val pair = transform(item)
        result = result.with(pair.a, pair.b)
    }
    return result
}

/** Ассоциировать элементы по ключу. */
inline fun <T, K> List<T>.associateBy(keySelector: (T) -> K): Map<K, T> {
    var result = mapOf<K, T>()
    for (item in this) {
        result = result.with(keySelector(item), item)
    }
    return result
}

/** Ассоциировать элементы со значениями. */
inline fun <T, V> List<T>.associateWith(valueSelector: (T) -> V): Map<T, V> {
    var result = mapOf<T, V>()
    for (item in this) {
        result = result.with(item, valueSelector(item))
    }
    return result
}

// --- List: Числовые агрегации ---

/** Вычислить сумму значений, возвращаемых селектором. */
inline fun <T> List<T>.sumOf(selector: (T) -> Double): Double {
    var sum = 0.0
    for (item in this) {
        sum += selector(item)
    }
    return sum
}

/** Найти максимальное числовое значение по селектору. */
inline fun <T> List<T>.maxOf(selector: (T) -> Double): Double {
    var max = 0.0
    var first = true
    for (item in this) {
        val value = selector(item)
        if (first || value > max) {
            max = value
            first = false
        }
    }
    return max
}

/** Найти минимальное числовое значение по селектору. */
inline fun <T> List<T>.minOf(selector: (T) -> Double): Double {
    var min = 0.0
    var first = true
    for (item in this) {
        val value = selector(item)
        if (first || value < min) {
            min = value
            first = false
        }
    }
    return min
}

// --- List: Обрезка и выборка ---

/** Взять первые n элементов списка. */
inline fun <T> List<T>.take(n: Double): List<T> {
    val result = mutableListOf<T>()
    var count = 0.0
    for (item in this) {
        if (count >= n) break
        result += item
        count += 1.0
    }
    return result
}

inline fun <T> List<T>.take(n: Int): List<T> = take(n.toDouble())

/** Пропустить первые n элементов списка. */
inline fun <T> List<T>.drop(n: Double): List<T> {
    val result = mutableListOf<T>()
    var count = 0.0
    for (item in this) {
        if (count >= n) {
            result += item
        }
        count += 1.0
    }
    return result
}

inline fun <T> List<T>.drop(n: Int): List<T> = drop(n.toDouble())

/** Брать элементы пока выполняется условие. */
inline fun <T> List<T>.takeWhile(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    for (item in this) {
        if (!predicate(item)) break
        result += item
    }
    return result
}

/** Пропускать элементы пока выполняется условие. */
inline fun <T> List<T>.dropWhile(predicate: (T) -> Boolean): List<T> {
    val result = mutableListOf<T>()
    var dropping = true
    for (item in this) {
        if (dropping && !predicate(item)) {
            dropping = false
        }
        if (!dropping) {
            result += item
        }
    }
    return result
}

// ============================================================================
// Inline Extension-функции для словарей (Map) в стиле Kotlin
// ============================================================================

// --- Map: Итерация ---

/** Выполнить действие для каждой пары ключ-значение словаря. */
inline fun <K, V> Map<K, V>.forEach(action: (key: K, value: V) -> Unit) {
    for ((key, value) in this) {
        action(key, value)
    }
}

/** Выполнить действие для каждого элемента словаря в виде кортежа Tuple2. */
inline fun <K, V> Map<K, V>.forEach(action: (Tuple2<K, V>) -> Unit) {
    for ((key, value) in this) {
        action(Tuple2(key, value))
    }
}

/** Выполнить действие для каждой пары и вернуть исходный словарь. */
inline fun <K, V> Map<K, V>.onEach(action: (key: K, value: V) -> Unit): Map<K, V> {
    for ((key, value) in this) {
        action(key, value)
    }
    return this
}

/** Выполнить действие для каждого кортежа Tuple2 и вернуть исходный словарь. */
inline fun <K, V> Map<K, V>.onEach(action: (Tuple2<K, V>) -> Unit): Map<K, V> {
    for ((key, value) in this) {
        action(Tuple2(key, value))
    }
    return this
}

// --- Map: Трансформация ---

/** Преобразовать значения словаря. */
inline fun <K, V, R> Map<K, V>.mapValues(transform: (key: K, value: V) -> R): Map<K, R> {
    var result = mapOf<K, R>()
    for ((key, value) in this) {
        result = result.with(key, transform(key, value))
    }
    return result
}

/** Преобразовать значения словаря с передачей кортежа Tuple2. */
inline fun <K, V, R> Map<K, V>.mapValues(transform: (Tuple2<K, V>) -> R): Map<K, R> {
    var result = mapOf<K, R>()
    for ((key, value) in this) {
        result = result.with(key, transform(Tuple2(key, value)))
    }
    return result
}

/** Преобразовать ключи словаря. */
inline fun <K, V, R> Map<K, V>.mapKeys(transform: (key: K, value: V) -> R): Map<R, V> {
    var result = mapOf<R, V>()
    for ((key, value) in this) {
        result = result.with(transform(key, value), value)
    }
    return result
}

/** Преобразовать ключи словаря с передачей кортежа Tuple2. */
inline fun <K, V, R> Map<K, V>.mapKeys(transform: (Tuple2<K, V>) -> R): Map<R, V> {
    var result = mapOf<R, V>()
    for ((key, value) in this) {
        result = result.with(transform(Tuple2(key, value)), value)
    }
    return result
}

/** Преобразовать пары словаря в список. */
inline fun <K, V, R> Map<K, V>.map(transform: (key: K, value: V) -> R): List<R> {
    val result = mutableListOf<R>()
    for ((key, value) in this) {
        result += transform(key, value)
    }
    return result
}

/** Преобразовать пары словаря в список с передачей кортежа Tuple2. */
inline fun <K, V, R> Map<K, V>.map(transform: (Tuple2<K, V>) -> R): List<R> {
    val result = mutableListOf<R>()
    for ((key, value) in this) {
        result += transform(Tuple2(key, value))
    }
    return result
}

/** Преобразовать пары словаря в список и отфильтровать null-значения. */
inline fun <K, V, R : Any> Map<K, V>.mapNotNull(transform: (key: K, value: V) -> R?): List<R> {
    val result = mutableListOf<R>()
    for ((key, value) in this) {
        val transformed = transform(key, value)
        if (transformed != null) {
            result += transformed
        }
    }
    return result
}

/** Преобразовать пары словаря в список и отфильтровать null-значения с передачей кортежа Tuple2. */
inline fun <K, V, R : Any> Map<K, V>.mapNotNull(transform: (Tuple2<K, V>) -> R?): List<R> {
    val result = mutableListOf<R>()
    for ((key, value) in this) {
        val transformed = transform(Tuple2(key, value))
        if (transformed != null) {
            result += transformed
        }
    }
    return result
}

// --- Map: Фильтрация ---

/** Отфильтровать записи словаря по предикату (key, value). */
inline fun <K, V> Map<K, V>.filter(predicate: (key: K, value: V) -> Boolean): Map<K, V> {
    var result = mapOf<K, V>()
    for ((key, value) in this) {
        if (predicate(key, value)) {
            result = result.with(key, value)
        }
    }
    return result
}

/** Отфильтровать записи словаря по предикату с кортежем Tuple2. */
inline fun <K, V> Map<K, V>.filter(predicate: (Tuple2<K, V>) -> Boolean): Map<K, V> {
    var result = mapOf<K, V>()
    for ((key, value) in this) {
        if (predicate(Tuple2(key, value))) {
            result = result.with(key, value)
        }
    }
    return result
}

/** Отфильтровать записи словаря по ключам. */
inline fun <K, V> Map<K, V>.filterKeys(predicate: (K) -> Boolean): Map<K, V> {
    var result = mapOf<K, V>()
    for ((key, value) in this) {
        if (predicate(key)) {
            result = result.with(key, value)
        }
    }
    return result
}

/** Отфильтровать записи словаря по значениям. */
inline fun <K, V> Map<K, V>.filterValues(predicate: (V) -> Boolean): Map<K, V> {
    var result = mapOf<K, V>()
    for ((key, value) in this) {
        if (predicate(value)) {
            result = result.with(key, value)
        }
    }
    return result
}

/** Отфильтровать записи словаря, исключая удовлетворяющие предикату. */
inline fun <K, V> Map<K, V>.filterNot(predicate: (key: K, value: V) -> Boolean): Map<K, V> {
    var result = mapOf<K, V>()
    for ((key, value) in this) {
        if (!predicate(key, value)) {
            result = result.with(key, value)
        }
    }
    return result
}

/** Отфильтровать записи словаря, исключая удовлетворяющие предикату с кортежем Tuple2. */
inline fun <K, V> Map<K, V>.filterNot(predicate: (Tuple2<K, V>) -> Boolean): Map<K, V> {
    var result = mapOf<K, V>()
    for ((key, value) in this) {
        if (!predicate(Tuple2(key, value))) {
            result = result.with(key, value)
        }
    }
    return result
}

// --- Map: Поиск и предикаты ---

/** Проверить, удовлетворяет ли хотя бы одна пара условию. */
inline fun <K, V> Map<K, V>.any(predicate: (key: K, value: V) -> Boolean): Boolean {
    var found = false
    for ((key, value) in this) {
        if (predicate(key, value)) {
            found = true
            break
        }
    }
    return found
}

/** Проверить, удовлетворяет ли хотя бы один кортеж Tuple2 условию. */
inline fun <K, V> Map<K, V>.any(predicate: (Tuple2<K, V>) -> Boolean): Boolean {
    var found = false
    for ((key, value) in this) {
        if (predicate(Tuple2(key, value))) {
            found = true
            break
        }
    }
    return found
}

/** Проверить, удовлетворяют ли все пары условию. */
inline fun <K, V> Map<K, V>.all(predicate: (key: K, value: V) -> Boolean): Boolean {
    var allMatch = true
    for ((key, value) in this) {
        if (!predicate(key, value)) {
            allMatch = false
            break
        }
    }
    return allMatch
}

/** Проверить, удовлетворяют ли все кортежи Tuple2 условию. */
inline fun <K, V> Map<K, V>.all(predicate: (Tuple2<K, V>) -> Boolean): Boolean {
    var allMatch = true
    for ((key, value) in this) {
        if (!predicate(Tuple2(key, value))) {
            allMatch = false
            break
        }
    }
    return allMatch
}

/** Проверить, что ни одна пара не удовлетворяет условию. */
inline fun <K, V> Map<K, V>.none(predicate: (key: K, value: V) -> Boolean): Boolean {
    var noneMatch = true
    for ((key, value) in this) {
        if (predicate(key, value)) {
            noneMatch = false
            break
        }
    }
    return noneMatch
}

/** Проверить, что ни один кортеж Tuple2 не удовлетворяет условию. */
inline fun <K, V> Map<K, V>.none(predicate: (Tuple2<K, V>) -> Boolean): Boolean {
    var noneMatch = true
    for ((key, value) in this) {
        if (predicate(Tuple2(key, value))) {
            noneMatch = false
            break
        }
    }
    return noneMatch
}

/** Посчитать количество пар, удовлетворяющих условию. */
inline fun <K, V> Map<K, V>.count(predicate: (key: K, value: V) -> Boolean): Double {
    var total = 0.0
    for ((key, value) in this) {
        if (predicate(key, value)) {
            total += 1.0
        }
    }
    return total
}

/** Посчитать количество кортежей Tuple2, удовлетворяющих условию. */
inline fun <K, V> Map<K, V>.count(predicate: (Tuple2<K, V>) -> Boolean): Double {
    var total = 0.0
    for ((key, value) in this) {
        if (predicate(Tuple2(key, value))) {
            total += 1.0
        }
    }
    return total
}

/** Преобразовать словарь в список пар Tuple2. */
inline fun <K, V> Map<K, V>.toList(): List<Tuple2<K, V>> {
    val result = mutableListOf<Tuple2<K, V>>()
    for ((key, value) in this) {
        result += Tuple2(key, value)
    }
    return result
}
