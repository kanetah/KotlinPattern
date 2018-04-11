package top.kanetah.kotlin.pattern.valueObjectPattern

import org.junit.Test

/**
 * create by kane on 2018/4/11.
 * VO 是一种不可变的对象，它可以当基本数据类型来使用，
 * 主要用于在系统中传递数据
 */
class TestValueObject {
    @Test
    fun test() {
        val statA = HeroStat.valueOf(10, 5, 0)
        val statB = HeroStat.valueOf(10, 5, 0)
        val statC = HeroStat.valueOf(5, 1, 8)

        println(statA.toString())

        println("Is statA and statB equal : ${statA == statB}")
        println("Is statA and statC equal : ${statA == statC}")
    }
}
