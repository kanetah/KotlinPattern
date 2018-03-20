package top.kanetah.kotlin.pattern.factoryPattern

import org.junit.Assert.*
import org.junit.Test

/**
 * created by kane on 2018/3/20
 * 工厂方法测试
 */
class FactoryMethodTest {

    // 实例化工厂对象
    private val shapeFactory = ShapeFactory()

    /**
     * 通过第一种工厂方法生产 Rectangle 对象
     */
    @Test
    fun testRectangle() {
        println("\n--- test rectangle ---")
        val rectangle = shapeFactory.createShape("Rectangle")
        assertTrue(rectangle != null)
        assertEquals(rectangle?.draw(), "Rectangle")
    }

    /**
     * 通过第二种工厂方法生产 Square 对象
     */
    @Test
    fun testSquare() {
        println("\n--- test square ---")
        val square = shapeFactory.createShape(Square::class.java)
        assertTrue(square != null)
        assertEquals(square?.draw(), "Square")
    }

    /**
     * 通过第三种工厂方法生产 Circle 对象
     */
    @Test
    fun testCircle() {
        println("\n--- test circle ---")
        val circle = shapeFactory.createShape(Shapes.Circle)
        assertTrue(circle != null)
        assertEquals(circle?.draw(), "Circle")
    }

    /**
     * 要求生产 Shape 接口将会抛出 IllegalArgumentException
     */
    @Test
    fun testInterfaceShape() {
        try {
            println("\n--- test interface shape ---")
            val shape = shapeFactory.createShape("Shape")
            fail("instantiate $shape will throw a IllegalArgumentException.")
        } catch (e: IllegalArgumentException) {
            println("catch IllegalArgumentException.")
        }
    }

    /**
     * 要求生产未实现的产品类型将会返回 null
     */
    @Test
    fun testNoImplShape() {
        println("\n--- test no impl ---")
        val noImpl = shapeFactory.createShape("Triangle")
        assertTrue(noImpl == null)
        println("factory method return null.")
    }
}
