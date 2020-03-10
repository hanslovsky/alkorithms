package me.hanslovsky.alkorithms.compare

interface FloatComparator {
    fun compare(f1: Float, f2: Float): Int
    val reversed get() = this.let { object : FloatComparator { override fun compare(f1: Float, f2: Float) = it.compare(f2, f1) } }
    companion object {
        val naturalOrder = object : FloatComparator { override fun compare(f1: Float, f2: Float) = f1.compareTo(f2) }
        val naturalOrderReversed = naturalOrder.reversed
    }
}