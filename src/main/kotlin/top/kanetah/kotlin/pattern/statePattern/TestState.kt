package top.kanetah.kotlin.pattern.statePattern

import org.junit.Test

/**
 * create by kane on 2018/4/7.
 */
class TestState {
    @Test
    fun test() {
        Mammoth().apply {
            observe()
            timePasses()
            observe()
            timePasses()
            observe()
        }
    }
}
