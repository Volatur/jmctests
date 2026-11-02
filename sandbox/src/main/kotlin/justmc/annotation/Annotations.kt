package justmc.annotation

// Классы
annotation class Event(val id: String)
annotation class BuiltInValue(val id: String)
annotation class Selection(val id: String)
annotation class Tuple
annotation class InlineClass(val slot: String = "")

// Функции
annotation class EventHandler
annotation class Action(val id: String, val returns: Array<String> = [], val thisArg: Array<String> = [])
annotation class Process
annotation class Display(val name: String = "", val lore: String = "", val icon: String = "")

// Разное
annotation class Save
annotation class Inline
annotation class Slot(val name: String)
annotation class SlotValue(val value: String)
