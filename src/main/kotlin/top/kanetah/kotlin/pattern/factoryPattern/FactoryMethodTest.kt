package top.kanetah.kotlin.pattern.factoryPattern

import org.junit.Assert.*
import org.junit.Test

/**
 * created by kane on 2018/3/20
 * 工厂方法测试
 */
class FactoryMethodTest {

    // 实例化工厂对象
    private val weaponFactory = WeaponFactory()

    /**
     * 通过第一种工厂方法生产 Spear 对象
     */
    @Test
    fun testSpear() {
        println("\n--- test spear ---")
        val spear = weaponFactory.createWeapon("Spear")
        assertTrue(spear != null)
        assertEquals(spear?.getWeaponType(), "Spear")
    }

    /**
     * 通过第二种工厂方法生产 Sword 对象
     */
    @Test
    fun testSword() {
        println("\n--- test sword ---")
        val sword = weaponFactory.createWeapon(Sword::class.java)
        assertTrue(sword != null)
        assertEquals(sword?.getWeaponType(), "Sword")
    }

    /**
     * 通过第三种工厂方法生产 Axe 对象
     */
    @Test
    fun testAxe() {
        println("\n--- test axe ---")
        val axe = weaponFactory.createWeapon(Weapons.Axe)
        assertTrue(axe != null)
        assertEquals(axe?.getWeaponType(), "Axe")
    }

    /**
     * 要求生产 Weapon 接口将会抛出 IllegalArgumentException
     */
    @Test
    fun testInterfaceShape() {
        try {
            println("\n--- test interface Weapon ---")
            val weapon = weaponFactory.createWeapon("Weapon")
            fail("instantiate $weapon will throw a IllegalArgumentException.")
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
        val noImpl = weaponFactory.createWeapon("Gun")
        assertTrue(noImpl == null)
        println("factory method return null.")
    }
}
