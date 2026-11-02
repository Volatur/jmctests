package justmc.value

import justmc.annotation.*

enum class TextCase {
    UPPER, LOWER, PROPER, INVERT, RANDOM
}

enum class StripType {
    ALL, START, END, INDENT
}

enum class ReplaceMode {
    ANY, FIRST
}

enum class SubtextSearchMode {
    FIRST, LAST
}

enum class TextSimilarityType {
    SIMILARITY, LEVENSHTEIN_DISTANCE
}

enum class TextCharset {
    UTF_16, UTF_8, ASCII
}

enum class CharsType {
    CHARS, CODES, CODEPOINTS_CHARS, CODEPOINTS
}

enum class TextMerging {
    SPACES, CONCATENATION, SEPARATE_LINES
}

enum class ComponentParsing {
    PLAIN, LEGACY, MINIMESSAGE, JSON
}

enum class DecorationState {
    NOT_SET, FALSE, TRUE
}

enum class ClickAction {
    COPY_TO_CLIPBOARD, SUGGEST_COMMAND, OPEN_URL, CHANGE_PAGE
}

enum class TimestampFormat {
    CUSTOM,
    DD_MM_YYYY_HH_MM_S,
    DD_MM_YYYY,
    YYYY_MM_DD_HH_MM_S,
    YYYY_MM_DD,
    EEE_D_MMMM,
    EEE_MMMM_D,
    EEEE,
    HH_MM_SS,
    H_MM_A,
    H_H_M_M_S_S,
    S_S
}

enum class RegexMatchMode {
    ALL, FIRST
}

enum class RegexGroupBy {
    INDEX, NAME
}

object TextComponent {

    @Action("set_variable_create_translatable_component", returns = ["variable"])
    external fun translatable(key: String, args: Map<String, Any> = emptyMap(), fallback: String = ""): Text

    @Action("set_variable_create_keybind_component", returns = ["variable"])
    external fun keybind(key: String): Text

    @Action("set_variable_create_head_object_component", returns = ["variable"])
    external fun head(nameOrUuid: String, hat: Boolean = true): Text

    @Action("set_variable_create_sprite_object_component", returns = ["variable"])
    external fun sprite(sprite: String, atlas: String = ""): Text

    @Action("set_variable_component_of_children", returns = ["variable"])
    external fun ofChildren(vararg components: Text): Text

    @Action("set_variable_component_of_children", returns = ["variable"])
    external fun ofChildren(components: List<Text>): Text

    inline fun plain(value: String = ""): Text = Text.plain(value)
    inline fun legacy(value: String = ""): Text = Text.legacy(value)
    inline fun mini(value: String = ""): Text = Text.mini(value)
    inline fun json(value: String = ""): Text = Text.json(value)
}
