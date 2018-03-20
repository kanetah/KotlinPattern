package top.kanetah.kotlin.pattern.factoryPattern

/**
 * created by kane on 2018/3/20
 * 工厂方法模式
 *
 * Kotlin 中，可以使用 when 子句来选择要实例化的实体类。
 */
class ShapeFactory {
    /**
     * 第一种简单工厂方法的实现方式：
     * 以目标类的类名为参数，依此生成具体的对象。
     */
    fun createShape(type: String): Shape? = when (type) {
        Shape::class.java.simpleName -> throw IllegalArgumentException("interface Shape cannot be instantiated.")
        Rectangle::class.java.simpleName -> Rectangle()
        Square::class.java.simpleName -> Square()
        Circle::class.java.simpleName -> Circle()
        else -> null
    }

    /**
     * 第二种简单工厂的实现方式：
     * 以目标类的 Class 对象为参数，生成具体的对象。
     */
    fun createShape(type: Class<out Shape>): Shape? = createShape(type.simpleName)

    /**
     * 第三种简单工厂的实现方式：
     * 将系统内已实现的实体类于枚举中列出，以枚举为参数生成具体的对象。
     */
    fun createShape(type: Shapes): Shape? = when (type) {
        Shapes.Rectangle -> Rectangle()
        Shapes.Square -> Square()
        Shapes.Circle -> Circle()
    }
}
