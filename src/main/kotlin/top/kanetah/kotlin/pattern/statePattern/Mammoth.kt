package top.kanetah.kotlin.pattern.statePattern

import kotlin.properties.Delegates

/**
 * create by kane on 2018/4/7.
 */
class Mammoth {

    private var state by Delegates.observable(PeacefulState(this) as State) { _, _, new ->
        new.onEnterState()
    }

    /**
     * when 子句构成了一个状态机
     */
    fun timePasses() {
        when (state) {
            is PeacefulState -> this changeStateTo angryState
            else -> this changeStateTo peacefulState
        }
    }

    private infix fun Mammoth.changeStateTo(create: (Mammoth) -> State) {
        this.state = create(this@changeStateTo)
    }

    override fun toString() = "The mammoth"

    fun observe() = state.observe()
}
