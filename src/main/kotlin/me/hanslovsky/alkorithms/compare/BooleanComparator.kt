package me.hanslovsky.alkorithms.compare

interface BooleanComparator {
    fun compare(b1: Boolean, b2: Boolean): Int
    val reversed get() = this.let { object : BooleanComparator { override fun compare(b1: Boolean, b2: Boolean) = it.compare(b2, b1) } }
    companion object {
        val naturalOrder: BooleanComparator = object : BooleanComparator { override fun compare(b1: Boolean, b2: Boolean) = b1.compareTo(b2) }
        val naturalOrderReversed = naturalOrder.reversed
    }
}