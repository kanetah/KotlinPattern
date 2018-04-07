package top.kanetah.kotlin.pattern.adapterPattern

import org.junit.Test

/**
 * create by kanetah on 2018/3/26
 * 适配器将一个类的接口转换成客户希望的另外一个接口。
 * 适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 */
class TestAdapterPattern {
    @Test
    fun test() {
        val captain = Captain(FishingBoatAdapter())
        captain.row()
    }
}
