package justmc.value

import justmc.annotation.*
import kotlin.*

/**
 * Источник звука.
 */
enum class SoundSource {
    MASTER, MUSIC, RECORDS, WEATHER, BLOCKS, HOSTILE, NEUTRAL, PLAYERS, AMBIENT, VOICE
}

/**
 * Селектор игрового значения.
 */
enum class GameValueSelection {
    DEFAULT, CURRENT, DEFAULT_ENTITY, KILLER, DAMAGER, VICTIM, SHOOTER, PROJECTILE, LAST
}

@BuiltInValue("game_value")
external fun <T> gameValue(value: String, selection: Any? = null): T

@BuiltInValue("location")
class Location(
    var x: Double = 0.0,
    var y: Double = 0.0,
    var z: Double = 0.0,
    var yaw: Double = 0.0,
    var pitch: Double = 0.0
) {
    @Action("set_variable_shift_all_coordinates", returns = ["variable"], thisArg = ["location"])
    external fun shift(x: Double = .0, y: Double = .0, z: Double = .0, yaw: Double = .0, pitch: Double = .0): Location
}

@BuiltInValue("vector")
class Vector(
    var x: Double = 0.0,
    var y: Double = 0.0,
    var z: Double = 0.0
)

@BuiltInValue("potion")
class Potion(
    var id: String,
    var level: Int = 0,
    var duration: Int = -1
)

@BuiltInValue("sound")
class Sound(
    var id: String,
    var pitch: Double = 0.0,
    var volume: Double = 1.0,
    var variation: String = "",
    var source: SoundSource = SoundSource.MASTER
)

@BuiltInValue("particle")
class Particle(
    var id: String,
    var amount: Int = 1,
    var spreadX: Double = 0.0,
    var spreadY: Double = 0.0,
    var motion: Vector? = null,
    var material: String? = null,
    var size: Double? = null,
    var color: Double? = null,
    var toColor: Double? = null
)
