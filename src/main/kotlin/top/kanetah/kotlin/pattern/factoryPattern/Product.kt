package top.kanetah.kotlin.pattern.factoryPattern

/**
 * created by kane on 2018/3/20
 * 定义工厂方法生产的产品
 */

interface Shape {
    fun draw(): String = this::class.java.simpleName.also {
        println("Call $it::draw method.")
    }
}

class Rectangle : Shape

class Square : Shape

class Circle : Shape

enum class Shapes {
    Rectangle, Square, Circle
}
