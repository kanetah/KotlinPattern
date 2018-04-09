package top.kanetah.kotlin.pattern.statePattern

import kotlin.properties.Delegates

/**
 * create by kane on 2018/4/7.
 */
class Mammoth {

    private var state by Delegates.observable(peacefulState(this) as State) { _, _, newState ->
        newState.onEnterState()
    }

    /**
     * when 子句构成了一个状态机
     */
    fun timePasses() = when (state) {
        is PeacefulState -> state changeTo angryState
        else -> state changeTo peacefulState
    }

    private infix fun State.changeTo(create: (Mammoth) -> State) {
        state = create(this@Mammoth)
    }

    override fun toString() = "The mammoth"

    fun observe() = state.observe()
}
