package top.kanetah.kotlin.pattern.adapterPattern

/**
 * create by kanetah on 2018/3/26
 */
class Captain(
        private var rowingBoat: RowingBoat? = null
) {
    fun setRowingBoat(rowingBoat: RowingBoat) {
        this.rowingBoat = rowingBoat
    }

    fun row() {
        rowingBoat!!.row()
    }
}
