package top.kanetah.kotlin.pattern.valueObjectPattern

import java.io.Serializable

/**
 * create by kane on 2018/4/11.
 */
class HeroStat private constructor(
        val strength: Int, val intelligence: Int, val luck: Int
) : Serializable {
    override fun toString() = "HeroState[strength=$strength, intelligence=$intelligence, luck=$luck]"
    override fun hashCode() = setOf(strength, intelligence, luck).reduce { a, b -> (a * b).hashCode() }
    override fun equals(other: Any?) = if (other is HeroStat) {
        other.let { it.strength == strength && it.intelligence == intelligence && it.luck == luck }
    } else false

    companion object {
        fun valueOf(strength: Int, intelligence: Int, luck: Int): HeroStat {
            return HeroStat(strength, intelligence, luck)
        }
    }
}
