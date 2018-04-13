package top.kanetah.kotlin.pattern.flyweightPattern

import org.junit.Test
import java.util.*

/**
 * create by kane on 2018/4/13.
 *
 * 享元模式
 * 使用共享物件，用来尽可能减少内存使用量以及分享资讯给尽可能多的相似物件。
 * 适合用于当大量物件只是重复因而导致无法令人接受的使用大量内存。
 * 通常物件中的部分状态是可以分享。
 * 常见做法是把它们放在外部数据结构，当需要使用时再将它们传递给享元。
 */
class TestFlyweight {
    private val topShelf = ArrayList<Potion>()
    private val bottomShelf = ArrayList<Potion>()

    init {
        PotionFactory().apply {
            topShelf.add(createPotion(InvisibilityPotion::class))
            topShelf.add(createPotion(InvisibilityPotion::class))
            topShelf.add(createPotion(StrengthPotion::class))
            topShelf.add(createPotion(HealingPotion::class))
            topShelf.add(createPotion(InvisibilityPotion::class))
            topShelf.add(createPotion(StrengthPotion::class))
            topShelf.add(createPotion(HealingPotion::class))
            topShelf.add(createPotion(HealingPotion::class))

            bottomShelf.add(createPotion(PoisonPotion::class))
            bottomShelf.add(createPotion(PoisonPotion::class))
            bottomShelf.add(createPotion(PoisonPotion::class))
            bottomShelf.add(createPotion(HolyWaterPotion::class))
            bottomShelf.add(createPotion(HolyWaterPotion::class))
        }
    }

    @Test
    fun enumerate() {
        println("Enumerating top shelf potions")
        topShelf.map { it.drink() }
        println("Enumerating bottom shelf potions")
        bottomShelf.map { it.drink() }
    }
}
