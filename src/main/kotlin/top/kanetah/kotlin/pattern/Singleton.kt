package top.kanetah.kotlin.pattern

import org.junit.Test

/*
 * created by kane on 2018/3/19
 * 单例模式
 */

interface Printable {
    fun print()
}

object Singleton : Printable {

    init {
        println("init object ${this::javaClass.name}")
    }

    override fun print() {
        println(this)
    }
}

class SingletonTest {
    @Test
    fun test() {
        println("--- start ---")
        Singleton // 此对象为单例
                .print()
        println("--- join ---")
        Singleton.print()
        println("--- end ---")
    }
}
