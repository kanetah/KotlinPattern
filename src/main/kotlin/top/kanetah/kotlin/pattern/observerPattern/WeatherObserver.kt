package top.kanetah.kotlin.pattern.observerPattern

import top.kanetah.kotlin.pattern.observerPattern.WeatherType.*

/**
 * created by kane on 2018/3/22
 * 观察者模式中的观察者类，
 * 一般需要实现一个 update/onUpdate 方法
 */
interface WeatherObserver {
    val feel: (WeatherType) -> String
    fun update(weatherType: WeatherType) {
        println("--${feel(weatherType)}")
    }
}

// 实现两个观察者类
class Orcs : WeatherObserver {
    override val feel = { type: WeatherType ->
        when (type) {
            SUNNY -> "The sun hurts the orcs' eyes."
            RAINY -> "The orcs are dripping wet."
            WINDY -> "The orc smell almost vanishes in the wind."
            COLD -> "The orcs are freezing cold."
        }
    }
}

class Hobbits : WeatherObserver {
    override val feel = { type: WeatherType ->
        when (type) {
            SUNNY -> "The happy hobbits bade in the warm sun."
            RAINY -> "The hobbits look for cover from the rain."
            WINDY -> "The hobbits hold their hats tightly in the windy weather."
            COLD -> "The hobbits are shivering in the cold weather."
        }
    }
}
