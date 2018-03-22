package top.kanetah.kotlin.pattern.observerPattern

import org.junit.Test

/**
 * created by kane on 2018/3/22
 */
class ObserverTest {
    @Test
    fun test() {
        val weather = Weather()
        val orcsObserver = Orcs()
        weather.observers.add(orcsObserver)
        weather.observers.add(Hobbits())

        weather.timePasses()
        weather.timePasses()
        weather.timePasses()
        weather.observers.remove(orcsObserver)
        weather.timePasses()
    }
}
