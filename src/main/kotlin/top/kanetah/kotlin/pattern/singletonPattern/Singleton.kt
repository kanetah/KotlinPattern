package top.kanetah.kotlin.pattern.singletonPattern

/**
 * created by kane on 2018/3/19
 * 单例模式
 *
 * 在 Kotlin 中，单例模式只需要 object 关键字即可实现
 * 从运行时的表现来看，可以确定 Kotlin 实现的是懒汉式的单例模式
 */
object Singleton {
    init {
        println("init object ${this::class.java.canonicalName}")
    }

    fun print() {
        println(this)
    }
}
