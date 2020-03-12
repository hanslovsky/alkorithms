package me.hanslovsky.alkorithms.compare

interface ByteComparator {
    fun compare(b1: Byte, b2: Byte): Int
    val reversed get() = this.let { object : ByteComparator { override fun compare(b1: Byte, b2: Byte) = it.compare(b2, b1) } }
    companion object {
        // TODO replace with SAM conversion when Kotlin 1.4 is available
        val naturalOrder = object : ByteComparator { override fun compare(b1: Byte, b2: Byte) = b1.compareTo(b2) }
        val naturalOrderReversed = naturalOrder.reversed
    }
}