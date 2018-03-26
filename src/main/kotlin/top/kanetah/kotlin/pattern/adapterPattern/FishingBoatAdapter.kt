package top.kanetah.kotlin.pattern.adapterPattern

/**
 * create by kanetah on 2018/3/26
 */
class FishingBoatAdapter : RowingBoat {
    private val boat = FishingBoat()
    override fun row() {
        boat.sail()
    }
}
