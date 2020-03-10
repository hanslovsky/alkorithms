package me.hanslovsky.alkorithms.sort

class Sort private constructor() {

    interface IntComparator {
        fun compare(i1: Int, i2: Int): Int
        val reversedOrder get() = Reversed[this]
        companion object {
            val naturalOrder = object : IntComparator { override fun compare(i1: Int, i2: Int) = i1.compareTo(i2) }
            val naturalOrderReversed = naturalOrder.reversedOrder
        }

        object Reversed {
            operator fun get(comparator: IntComparator) = object : IntComparator { override fun compare(i1: Int, i2: Int) = comparator.compare(i2, i1) }
        }
    }

    companion object {

        fun IntArray.bubbleSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: IntComparator = IntComparator.naturalOrder) = clone().also { it.bubbleSort(startInclusive, stopExclusive, comparator) }

        fun IntArray.bubbleSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: IntComparator = IntComparator.naturalOrder) {
            val n = stopExclusive - startInclusive - 1
            repeat(n) {
                for (k in startInclusive + 1 until stopExclusive - it) {
                    val j = k - 1
                    val upper = this[k]
                    if (comparator.compare(upper, this[j]) < 0) {
                        this[k] = this[j]
                        this[j] = upper
                    }
                }
            }
        }

        fun IntArray.insertionSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: IntComparator = IntComparator.naturalOrder) = clone().also { it.insertionSort(startInclusive, stopExclusive, comparator) }

        fun IntArray.insertionSort(
                startInclusive: Int = 0,
                stopExclusive: Int = 0,
                comparator: IntComparator = IntComparator.naturalOrder) {
            for (k in startInclusive + 1 until stopExclusive) {
                var j = k - 1
                val element = this[k]
                while(j >= startInclusive && comparator.compare(element, this[j]) < 0) {
                    this[j+1] = this[j]
                    --j
                }
                this[j+1] = element
            }
        }
    }
}