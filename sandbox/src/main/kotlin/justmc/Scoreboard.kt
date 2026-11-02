package justmc

import justmc.value.Text
import justmc.annotation.*

enum class ScoreboardFormat {
    BLANK,
    FIXED,
    STYLED,
    RESET
}

@InlineClass
class Scoreboard(val id: Text) {
    val name: Text inline get() = id
    @Inline fun create(displayName: Text) = Scoreboard.create(id, displayName)
    @Inline fun remove() = Scoreboard.remove(id)
    @Inline fun setTitle(title: Text) = Scoreboard.setTitle(id, title)
    var title: Text
        inline get() = id
        @JvmName("setTitleProp")
        inline set(value) { setTitle(value) }

    @Inline operator fun set(text: Text, score: Double) = setScore(text, score)
    @Inline operator fun set(line: Double, display: Text) = setLineDisplay(line, display)
    @Inline operator fun minusAssign(text: Text) { removeScoreByName(text) }
    @Inline operator fun minusAssign(score: Double) { removeScoreByScore(score) }
    @Inline fun setScore(text: Text, score: Double) = setScore(id, text, score)
    @Inline fun removeScoreByName(text: Text) = removeScoreByName(id, text)
    @Inline fun removeScoreByScore(score: Double) = removeScoreByScore(id, score)
    @Inline fun clearScores() = clearScores(id)
    @Inline fun setLine(line: Double, display: Text, format: ScoreboardFormat = ScoreboardFormat.RESET) = setLine(id, line, display, format)
    @Inline fun setLineDisplay(line: Double, display: Text) = setLineDisplay(id, line, display)
    @Inline fun setLineFormat(line: Double, formatContent: Text = "", format: ScoreboardFormat = ScoreboardFormat.RESET) =
        setLineFormat(id, line, formatContent, format)
    @Inline fun setNumberFormat(formatContent: Text = "", format: ScoreboardFormat = ScoreboardFormat.RESET) =
        setNumberFormat(id, formatContent, format)

    companion object {
        @Action("game_create_scoreboard")
        external fun create(id: Text, displayName: Text)

        @Action("game_remove_scoreboard")
        external fun remove(id: Text)

        @Action("game_set_scoreboard_title")
        external fun setTitle(id: Text, title: Text)

        @Action("game_set_scoreboard_score")
        external fun setScore(id: Text, text: Text, score: Double)

        @Action("game_remove_scoreboard_score_by_name")
        external fun removeScoreByName(id: Text, text: Text)

        @Action("game_remove_scoreboard_score_by_score")
        external fun removeScoreByScore(id: Text, score: Double)

        @Action("game_clear_scoreboard_scores")
        external fun clearScores(id: Text)

        @Action("game_set_scoreboard_line")
        external fun setLine(id: Text, line: Double, display: Text, format: ScoreboardFormat = ScoreboardFormat.RESET)

        @Action("game_set_scoreboard_line_display")
        external fun setLineDisplay(id: Text, line: Double, display: Text)

        @Action("game_set_scoreboard_line_format")
        external fun setLineFormat(id: Text, line: Double, formatContent: Text = "", format: ScoreboardFormat = ScoreboardFormat.RESET)

        @Action("game_set_scoreboard_number_format")
        external fun setNumberFormat(id: Text, formatContent: Text = "", format: ScoreboardFormat = ScoreboardFormat.RESET)
    }
}
