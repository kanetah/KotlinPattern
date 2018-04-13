package top.kanetah.kotlin.pattern.flyweightPattern

import kotlin.reflect.KClass

/**
 * create by kane on 2018/4/13.
 * 享元工厂
 */
class PotionFactory {
    private val potions = HashMap<KClass<out Potion>, Potion>()
    internal fun createPotion(type: KClass<out Potion>): Potion {
        if (potions[type] === null)
            potions[type] = when (type) {
                HealingPotion::class -> HealingPotion()
                HolyWaterPotion::class -> HolyWaterPotion()
                InvisibilityPotion::class -> InvisibilityPotion()
                PoisonPotion::class -> PoisonPotion()
                StrengthPotion::class -> StrengthPotion()
                else -> throw IllegalArgumentException("sealed class Potion has not this subclass: $type")
            }
        return potions[type]!!
    }
}
