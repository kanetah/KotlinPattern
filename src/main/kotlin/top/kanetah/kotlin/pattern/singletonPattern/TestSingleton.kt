package top.kanetah.kotlin.pattern.singletonPattern

import org.junit.Test

/**
 * created by kane on 2018/3/20
 * 单例模式测试
 */
class TestSingleton {
    /**
     * 调用两次 Singleton 对象，可以发现只实例化一次，且两次调用中对象皆指向同一内存
     */
    @Test
    fun test() {
        println("--- start ---")
        // 此对象为单例
        Singleton.print()
        println("--- again ---")
        Singleton.print()
        println("--- end ---")
    }
}
