package me.hanslovsky.alkorithms.compare

interface DoubleComparator {
    fun compare(d1: Double, d2: Double): Int
    val reversed get() = this.let { object : DoubleComparator { override fun compare(d1: Double, d2: Double) = it.compare(d2, d1) } }
    companion object {
        // TODO replace with SAM conversion when Kotlin 1.4 is available
        val naturalOrder = object : DoubleComparator { override fun compare(d1: Double, d2: Double) = d1.compareTo(d2) }
        val naturalOrderReversed = naturalOrder.reversed
    }
}