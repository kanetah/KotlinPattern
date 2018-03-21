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
        //no allow
        assertFalse(proxy.enter(Wizard("Green wizard")))
        assertFalse(proxy.enter(Wizard("Brown wizard")))
    }
}
