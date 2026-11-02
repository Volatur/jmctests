package justmc.player

import justmc.annotation.*

enum class PlayerSelection {
    DEFAULT, CURRENT, KILLER_PLAYER, DAMAGER_PLAYER, SHOOTER_PLAYER,
    VICTIM_PLAYER, RANDOM_PLAYER, ALL_PLAYERS
}

@Selection("player")
open class Player(val selection: PlayerSelection? = null) {

    companion object : Player(null) {
        val DEFAULT = Player(PlayerSelection.DEFAULT)
        val CURRENT = Player(PlayerSelection.CURRENT)
        val KILLER = Player(PlayerSelection.KILLER_PLAYER)
        val DAMAGER = Player(PlayerSelection.DAMAGER_PLAYER)
        val SHOOTER = Player(PlayerSelection.SHOOTER_PLAYER)
        val VICTIM = Player(PlayerSelection.VICTIM_PLAYER)
        val RANDOM = Player(PlayerSelection.RANDOM_PLAYER)
        val ALL = Player(PlayerSelection.ALL_PLAYERS)
    }
}
