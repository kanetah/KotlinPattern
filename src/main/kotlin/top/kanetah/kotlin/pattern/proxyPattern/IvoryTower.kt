package top.kanetah.kotlin.pattern.proxyPattern

/**
 * created by kane on 2018/3/21
 */
class IvoryTower : WizardTower {
    override val enter: (Wizard) -> Boolean = {
        true.also { println("$it enter the ivory tower") }
    }
}
