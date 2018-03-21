package top.kanetah.kotlin.pattern.factoryPattern

/**
 * created by kane on 2018/3/20
 * 定义工厂方法生产的产品，及其接口、枚举
 */

interface Weapon {
    /**
     * 虽然在接口中定义了默认方法，但运行时 this 绑定到了真正实现此接口的类上
     */
    fun getWeaponType(): String = this::class.java.simpleName.also {
        println("Call $it::getWeaponType method.")
    }
}

class Spear : Weapon

class Sword : Weapon

class Axe : Weapon

enum class Weapons {
    Spear, Sword, Axe
}
