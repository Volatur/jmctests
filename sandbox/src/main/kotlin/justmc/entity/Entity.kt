package justmc.entity

import justmc.annotation.Selection

enum class EntitySelection {
    CURRENT, DEFAULT_ENTITY, KILLER_ENTITY, DAMAGER_ENTITY, SHOOTER_ENTITY, PROJECTILE,
    VICTIM_ENTITY, RANDOM_ENTITY, ALL_ENTITIES, ALL_MOBS, LAST_ENTITY
}

@Selection("entity")
open class Entity(val selection: EntitySelection? = null) {

    companion object : Entity(null) {
        val DEFAULT = Entity(EntitySelection.DEFAULT_ENTITY)
        val CURRENT = Entity(EntitySelection.CURRENT)
        val KILLER = Entity(EntitySelection.KILLER_ENTITY)
        val DAMAGER = Entity(EntitySelection.DAMAGER_ENTITY)
        val SHOOTER = Entity(EntitySelection.SHOOTER_ENTITY)
        val PROJECTILE = Entity(EntitySelection.PROJECTILE)
        val VICTIM = Entity(EntitySelection.VICTIM_ENTITY)
        val RANDOM = Entity(EntitySelection.RANDOM_ENTITY)
        val ALL = Entity(EntitySelection.ALL_ENTITIES)
        val ALL_MOBS = Entity(EntitySelection.ALL_MOBS)
        val LAST = Entity(EntitySelection.LAST_ENTITY)
    }
}
