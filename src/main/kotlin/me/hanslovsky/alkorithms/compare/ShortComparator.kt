package me.hanslovsky.alkorithms.compare

interface ShortComparator {
    fun compare(s1: Short, s2: Short): Int
    val reversed get() = this.let { object : ShortComparator { override fun compare(s1: Short, s2: Short) = it.compare(s2, s1) } }
    companion object {
        val naturalOrder = object : ShortComparator { override fun compare(s1: Short, s2: Short) = s1.compareTo(s2) }
        val naturalOrderReversed = naturalOrder.reversed
    }
}