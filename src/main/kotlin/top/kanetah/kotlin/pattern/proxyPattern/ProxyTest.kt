package top.kanetah.kotlin.pattern.proxyPattern

import org.junit.Assert.*
import org.junit.Test

/**
 * created by kane on 2018/3/21
 * 代理模式测试
 */
class ProxyTest {
    @Test
    fun test() {
        val proxy = WizardTowerProxy(IvoryTower())
        // allow
        assertTrue(proxy.enter(Wizard("Red wizard")))
        assertTrue(proxy.enter(Wizard("White wizard")))
        assertTrue(proxy.enter(Wizard("Black wizard")))
        // no allow
        assertFalse(proxy.enter(Wizard("Green wizard")))
        assertFalse(proxy.enter(Wizard("Brown wizard")))

        // 也可以利用 object 实现代理模式
        val objectProxy = WizardTowerProxyObject
        // allow
        assertTrue(objectProxy.enter(Wizard("Red witch")))
        assertTrue(objectProxy.enter(Wizard("White witch")))
        assertTrue(objectProxy.enter(Wizard("Black witch")))
        // no allow
        assertFalse(objectProxy.enter(Wizard("Green witch")))
        assertFalse(objectProxy.enter(Wizard("Brown witch")))
    }
}
