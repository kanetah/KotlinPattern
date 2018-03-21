package top.kanetah.kotlin.pattern.proxyPattern

/**
 * created by kane on 2018/3/21
 * 代理模式
 *
 * WizardTowerProxy 接受一个 WizardTower 对象同时也实现了 WizardTower 接口，
 * 于是它可以在所接受的 WizardTower 对象与对这个对象的调用之间添加一个中间层，
 * 由此代理这个 WizardTower 对象
 * （代理还可以继续嵌套）
 */
class WizardTowerProxy(
        private val tower: WizardTower,
        private val maxWizardAllowed: Int = 3
) : WizardTower {
    override val enter: (Wizard) -> Boolean by lazy {
        var numWizards = 0 // 闭包
        { wizard: Wizard ->
            if (numWizards++ < maxWizardAllowed)
                tower.enter(wizard)
            else
                false.also { println("$wizard is not allowed to enter!") }
        }
    }
}
