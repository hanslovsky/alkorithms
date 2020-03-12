package me.hanslovsky.alkorithms.compare

interface IntComparator {
    fun compare(i1: Int, i2: Int): Int
    val reversed get() = this.let { object : IntComparator { override fun compare(i1: Int, i2: Int) = it.compare(i2, i1) } }
    companion object {
        // TODO replace with SAM conversion when Kotlin 1.4 is available
        val naturalOrder = object : IntComparator { override fun compare(i1: Int, i2: Int) = i1.compareTo(i2) }
        val naturalOrderReversed = naturalOrder.reversed
    }
}