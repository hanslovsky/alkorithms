package me.hanslovsky.alkorithms.compare

interface CharComparator {
    fun compare(c1: Char, c2: Char): Int
    val reversed get() = this.let { object : CharComparator { override fun compare(c1: Char, c2: Char) = it.compare(c2, c1) } }
    companion object {
        // TODO replace with SAM conversion when Kotlin 1.4 is available
        val naturalOrder = object : CharComparator { override fun compare(c1: Char, c2: Char) = c1.compareTo(c2) }
        val naturalOrderReversed = naturalOrder.reversed
    }
}