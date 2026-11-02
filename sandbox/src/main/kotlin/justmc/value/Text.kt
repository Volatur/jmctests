package justmc.value

import justmc.annotation.*

enum class TextParsing {
    PLAIN, LEGACY, @SlotValue("MINIMESSAGE") MINI, MINIMESSAGE, JSON
}

typealias Text = String

@BuiltInValue("text")
fun Text(value: String = "", parsing: TextParsing = TextParsing.LEGACY): Text = error("stub")

@BuiltInValue("text")
fun String.Companion.plain(value: String = ""): Text = error("stub")

@BuiltInValue("text")
fun String.Companion.legacy(value: String = ""): Text = error("stub")

@BuiltInValue("text")
fun String.Companion.json(value: String = ""): Text = error("stub")

@BuiltInValue("text")
fun String.Companion.mini(value: String = ""): Text = error("stub")

@BuiltInValue("text")
fun String.plain(): Text = error("stub")

@BuiltInValue("text")
fun String.legacy(): Text = error("stub")

@BuiltInValue("text")
fun String.json(): Text = error("stub")

@BuiltInValue("text")
fun String.mini(): Text = error("stub")

inline operator fun String.iterator(): Iterator<String> = this.split("").iterator()


@Action("set_variable_to_json", returns = ["variable"], thisArg = ["value"])
external fun Any?.toJson(prettyPrint: Boolean = false): String

@Action("set_variable_parse_json", returns = ["variable"], thisArg = ["json"])
external fun String.parseJson(): Any


@Action("set_variable_text", returns = ["variable"])
external fun joinTexts(vararg text: String, merging: TextMerging = TextMerging.CONCATENATION): String

@Action("set_variable_text", returns = ["variable"])
external fun joinTexts(text: List<String>, merging: TextMerging = TextMerging.CONCATENATION): String

inline fun joinWithSpaces(vararg text: String): String = joinTexts(*text, merging = TextMerging.SPACES)
inline fun joinLines(vararg text: String): String = joinTexts(*text, merging = TextMerging.SEPARATE_LINES)

inline fun Iterable<String>.joinTexts(merging: TextMerging = TextMerging.CONCATENATION): String =
    joinTexts(this.toList(), merging = merging)

inline fun Iterable<String>.joinWithSpaces(): String = joinTexts(merging = TextMerging.SPACES)
inline fun Iterable<String>.joinLines(): String = joinTexts(merging = TextMerging.SEPARATE_LINES)

@Action("set_variable_join_text", returns = ["variable"], thisArg = ["list"])
external fun <T> Iterable<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    limit: Double = -1.0,
    truncated: String = "..."
): String

@Action("set_variable_join_to_component", returns = ["variable"], thisArg = ["list"])
external fun <T> Iterable<T>.joinToComponent(
    separator: String = "",
    prefix: String = "",
    suffix: String = ""
): Text


@Action("set_variable_text_length", returns = ["variable"], thisArg = ["text"])
external fun String.length(): Int

@Action("set_variable_split_text", returns = ["variable"], thisArg = ["text"])
external fun String.split(delimiter: String): List<String>

@Action("set_variable_split_text_by_length", returns = ["variable"], thisArg = ["text"])
external fun String.splitByLength(maxLength: Double): List<String>

@Action("set_variable_chunk_text", returns = ["variable"], thisArg = ["text"])
external fun String.chunked(size: Double): List<String>

@Action("set_variable_trim_text", returns = ["variable"], thisArg = ["text"])
external fun String.substring(start: Double, end: Double): String

@Action("set_variable_trim_text", returns = ["variable"], thisArg = ["text"])
external fun String.substring(start: Int, end: Int): String

@Action("set_variable_strip_text", returns = ["variable"], thisArg = ["text"])
external fun String.strip(stripType: StripType = StripType.ALL): String

@Action("set_variable_replace_text", returns = ["variable"], thisArg = ["text"])
external fun String.replace(
    replace: String,
    replacement: String,
    first: ReplaceMode = ReplaceMode.ANY,
    ignoreCase: Boolean = false
): String

inline fun String.replaceFirst(replace: String, replacement: String, ignoreCase: Boolean = false): String =
    replace(replace, replacement, first = ReplaceMode.FIRST, ignoreCase = ignoreCase)

@Action("set_variable_regex_replace_text", returns = ["variable"], thisArg = ["text"])
external fun String.replaceRegex(
    regex: String,
    replacement: String,
    first: ReplaceMode = ReplaceMode.ANY,
    ignoreCase: Boolean = false,
    multiline: Boolean = false,
    dotMatchesAll: Boolean = false
): String

@Action("set_variable_remove_text", returns = ["variable"], thisArg = ["text"])
external fun String.remove(remove: String, regex: Boolean = false): String

@Action("set_variable_repeat_text", returns = ["variable"], thisArg = ["text"])
external fun String.repeat(repeat: Double): String

@Action("set_variable_text_case", returns = ["variable"], thisArg = ["text"])
external fun String.changeCase(caseType: TextCase): String

@Action("set_variable_convert_text_to_number", returns = ["variable"], thisArg = ["text"])
external fun String.toDouble(radix: Int = 10): Double

@Action("set_variable_parse_number_from_text", returns = ["variable"], thisArg = ["text"])
external fun String.parseNumber(): Double

@Action("set_variable_char_to_number", returns = ["variable"], thisArg = ["char"])
external fun String.charToNumber(): Double

@Action("set_variable_get_char_at", returns = ["variable"], thisArg = ["text"])
external fun String.charAt(index: Double): String

@Action("set_variable_get_index_of_subtext", returns = ["variable"], thisArg = ["text"])
external fun String.indexOf(
    subtext: String,
    startIndex: Double = 1.0,
    searchMode: SubtextSearchMode = SubtextSearchMode.FIRST
): Double

inline fun String.lastIndexOf(subtext: String, startIndex: Double = 1.0): Double =
    indexOf(subtext, startIndex = startIndex, searchMode = SubtextSearchMode.LAST)

@Action("set_variable_get_text_similarity", returns = ["variable"], thisArg = ["text_1"])
external fun String.similarity(
    @Slot("text_2") other: String,
    valueType: TextSimilarityType = TextSimilarityType.SIMILARITY
): Double

inline fun String.levenshteinDistance(other: String): Double =
    similarity(other, valueType = TextSimilarityType.LEVENSHTEIN_DISTANCE)

@Action("set_variable_get_text_width", returns = ["variable"], thisArg = ["text"])
external fun String.pixelWidth(): Double

@Action("set_variable_text_to_bytes", returns = ["variable"], thisArg = ["text"])
external fun String.toBytes(charset: TextCharset = TextCharset.UTF_8): List<Double>

@Action("set_variable_bytes_to_text", returns = ["variable"], thisArg = ["bytes"])
external fun List<Double>.toText(charset: TextCharset = TextCharset.UTF_8): String

@Action("set_variable_text_to_chars", returns = ["variable"], thisArg = ["text"])
external fun String.toChars(charsType: CharsType = CharsType.CHARS): List<Any>

@Suppress("UNCHECKED_CAST")
inline fun String.characters(): List<String> = toChars(CharsType.CHARS) as List<String>

@Suppress("UNCHECKED_CAST")
inline fun String.charCodes(): List<Double> = toChars(CharsType.CODES) as List<Double>

@Action("set_variable_get_text_regex_groups", returns = ["variable"], thisArg = ["text"])
external fun String.regexGroups(
    regex: String,
    group: String = "0",
    matchMode: RegexMatchMode = RegexMatchMode.ALL,
    getGroupBy: RegexGroupBy = RegexGroupBy.INDEX,
    ignoreCase: Boolean = false
): List<String>

@Action("set_variable_format_timestamp", returns = ["variable"], thisArg = ["time"])
external fun Double.formatTimestamp(
    format: TimestampFormat = TimestampFormat.CUSTOM,
    pattern: String = "",
    zoneId: String = "UTC",
    locale: String = "en"
): String


@Action("if_variable_text_matches", thisArg = ["match"])
external fun String.matchesPattern(values: String, ignoreCase: Boolean = false, regularExpressions: Boolean = true): Boolean


@Action("set_variable_parse_to_component", returns = ["variable"], thisArg = ["text"])
external fun String.toComponent(parsing: ComponentParsing = ComponentParsing.LEGACY): Text

@Action("set_variable_change_component_parsing", returns = ["variable"], thisArg = ["component"])
external fun Text.changeParsing(parsing: ComponentParsing): Text

@Action("set_variable_get_component_parsing", returns = ["variable"], thisArg = ["component"])
external fun Text.getComponentParsing(): String

@Action("set_variable_set_component_hex_color", returns = ["variable"], thisArg = ["component"])
external fun Text.color(color: String): Text

@Action("set_variable_get_component_hex_color", returns = ["variable"], thisArg = ["component"])
external fun Text.getHexColor(): String

@Action("set_variable_set_component_shadow_color", returns = ["variable"], thisArg = ["component"])
external fun Text.shadowColor(color: String): Text

@Action("set_variable_set_component_font", returns = ["variable"], thisArg = ["component"])
external fun Text.font(value: String, namespace: String = "minecraft"): Text

@Action("set_variable_set_component_decorations", returns = ["variable"], thisArg = ["component"])
external fun Text.decorations(
    bold: DecorationState = DecorationState.NOT_SET,
    italic: DecorationState = DecorationState.NOT_SET,
    underlined: DecorationState = DecorationState.NOT_SET,
    strikethrough: DecorationState = DecorationState.NOT_SET,
    obfuscated: DecorationState = DecorationState.NOT_SET
): Text

@Action("set_variable_get_component_decorations", returns = ["variable"], thisArg = ["component"])
external fun Text.getDecorations(): Map<String, Any>

inline fun Text.bold(enabled: Boolean = true): Text =
    decorations(bold = if (enabled) DecorationState.TRUE else DecorationState.FALSE)

inline fun Text.italic(enabled: Boolean = true): Text =
    decorations(italic = if (enabled) DecorationState.TRUE else DecorationState.FALSE)

inline fun Text.underlined(enabled: Boolean = true): Text =
    decorations(underlined = if (enabled) DecorationState.TRUE else DecorationState.FALSE)

inline fun Text.strikethrough(enabled: Boolean = true): Text =
    decorations(strikethrough = if (enabled) DecorationState.TRUE else DecorationState.FALSE)

inline fun Text.obfuscated(enabled: Boolean = true): Text =
    decorations(obfuscated = if (enabled) DecorationState.TRUE else DecorationState.FALSE)

@Action("set_variable_set_component_hover", returns = ["variable"], thisArg = ["component"])
external fun Text.hover(hover: Text): Text

@Action("set_variable_set_component_item_hover", returns = ["variable"], thisArg = ["component"])
external fun Text.hoverItem(hover: Any): Text

@Action("set_variable_set_component_entity_hover", returns = ["variable"], thisArg = ["component"])
external fun Text.hoverEntity(nameOrUuid: String): Text

@Action("set_variable_set_component_click", returns = ["variable"], thisArg = ["component"])
external fun Text.click(clickAction: ClickAction, value: String): Text

inline fun Text.onClickOpenUrl(url: String): Text = click(ClickAction.OPEN_URL, url)
inline fun Text.onClickSuggestCommand(command: String): Text = click(ClickAction.SUGGEST_COMMAND, command)
inline fun Text.onClickRunCommand(command: String): Text = click(ClickAction.SUGGEST_COMMAND, command)
inline fun Text.onClickCopyToClipboard(text: String): Text = click(ClickAction.COPY_TO_CLIPBOARD, text)
inline fun Text.onClickChangePage(page: String): Text = click(ClickAction.CHANGE_PAGE, page)

@Action("set_variable_set_component_insertion", returns = ["variable"], thisArg = ["component"])
external fun Text.insertion(insertion: String): Text

@Action("set_variable_compact_component", returns = ["variable"], thisArg = ["component"])
external fun Text.compact(): Text

@Action("set_variable_get_component_children", returns = ["variable"], thisArg = ["component"])
external fun Text.getChildren(): List<Text>

@Action("set_variable_set_component_children", returns = ["variable"], thisArg = ["component"])
external fun Text.setChildren(children: List<Text>): Text

@Action("set_variable_append_component", returns = ["variable"], thisArg = ["components"])
external fun Text.append(vararg components: Text, merging: TextMerging = TextMerging.CONCATENATION): Text

@Action("set_variable_append_component", returns = ["variable"])
external fun appendComponents(vararg components: Text, merging: TextMerging = TextMerging.CONCATENATION): Text
