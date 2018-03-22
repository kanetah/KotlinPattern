package top.kanetah.kotlin.pattern.observerPattern

import kotlin.properties.Delegates

/**
 * created by kane on 2018/3/22
 */
class Weather(
        defaultWeatherType: WeatherType = WeatherType.SUNNY
) {
    init {
        println("Init weather.")
    }

    // 这个 object 其实是一个代理，通过它实现了类似 AOP 的功能，以此在列表添加删除时留下记录
    val observers = object /*ArrayListProxy*/ : ArrayList<WeatherObserver>() {
        override fun add(element: WeatherObserver) = super.add(element)
                .also { println("Add a observer: ${element::class.java.simpleName}.") }

        override fun remove(element: WeatherObserver) = super.remove(element)
                .also { println("Remove a observer: ${element::class.java.simpleName}.") }
    }
    // 这里将属性委托到了 Kotlin 提供的可观察属性工厂方法生产的对象上
    private var currentWeather: WeatherType by Delegates.observable(defaultWeatherType) { _, _, newWeather ->
        println("The weather changed to $newWeather:")
        observers.forEach { it.update(newWeather) }
    }

    fun timePasses() {
        // 修改 currentWeather 将会自动触发委托的 onChange 方法（即在 Delegate::observable 中传递的 lambda）
        currentWeather = WeatherType.values().let { it[(currentWeather.ordinal + 1) % it.size] }
    }
}

enum class WeatherType {
    SUNNY, RAINY, WINDY, COLD;

    override fun toString() = this.name.toLowerCase()
}
