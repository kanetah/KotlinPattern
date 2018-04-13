package top.kanetah.kotlin.pattern.flyweightPattern

/**
 * create by kane on 2018/4/13.
 *
 * 享元类
 */
sealed class Potion {
    abstract fun drink()
}

class HealingPotion : Potion() {
    override fun drink() = println("You feel healed. (Potion=${System.identityHashCode(this)})")
}

class InvisibilityPotion : Potion() {
    override fun drink() = println("You become invisible. (Potion=${System.identityHashCode(this)})")
}

class StrengthPotion : Potion() {
    override fun drink() = println("You feel strong. (Potion=${System.identityHashCode(this)})")
}

class HolyWaterPotion : Potion() {
    override fun drink() = println("You feel blessed. (Potion=${System.identityHashCode(this)})")
}

class PoisonPotion : Potion() {
    override fun drink() = println("Urgh! This is poisonous. (Potion=${System.identityHashCode(this)})")
}
