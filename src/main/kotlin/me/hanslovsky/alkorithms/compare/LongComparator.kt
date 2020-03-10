package me.hanslovsky.alkorithms.compare

interface LongComparator {
    fun compare(l1: Long, l2: Long): Int
    val reversed get() = this.let { object : LongComparator { override fun compare(l1: Long, l2: Long) = it.compare(l2, l1) } }
    companion object {
        val naturalOrder = object : LongComparator { override fun compare(l1: Long, l2: Long) = l1.compareTo(l2) }
        val naturalOrderReversed = naturalOrder.reversed
    }
}