package top.kanetah.kotlin.pattern.statePattern

/**
 * create by kane on 2018/4/7.
 */
sealed class State {
    abstract fun onEnterState()
    abstract fun observe()
}

class AngryState(
        private val mammoth: Mammoth
) : State() {
    override fun onEnterState() {
        println("$mammoth is furious!")
    }

    override fun observe() {
        println("$mammoth gets angry!")
    }
}

val angryState = { mammoth: Mammoth -> AngryState(mammoth) }

class PeacefulState(
        private val mammoth: Mammoth
) : State() {
    override fun onEnterState() {
        println("$mammoth is calm and peaceful.")
    }

    override fun observe() {
        println("$mammoth calms down.")
    }
}

val peacefulState = { mammoth: Mammoth -> PeacefulState(mammoth) }
