package me.hanslovsky.alkorithms.sort

import me.hanslovsky.alkorithms.compare.ByteComparator
import me.hanslovsky.alkorithms.compare.CharComparator
import me.hanslovsky.alkorithms.compare.DoubleComparator
import me.hanslovsky.alkorithms.compare.FloatComparator
import me.hanslovsky.alkorithms.compare.IntComparator
import me.hanslovsky.alkorithms.compare.LongComparator
import me.hanslovsky.alkorithms.compare.ShortComparator
import org.junit.Assert
import org.junit.Test


private val shuffledIntArray = intArrayOf(34, 13, 30, 4601, 45, 13, 35, 4601, 4601, 0, -135, 35, -12, 2)
private val sortedIntArray = shuffledIntArray.sortedArray()

private val shuffledByteArray = shuffledIntArray.map { it.toByte() }.toByteArray()
private val sortedByteArray = shuffledByteArray.sortedArray()

private val shuffledBooleanArray = sortedIntArray[sortedIntArray.size/2].let { m -> shuffledIntArray.map { it > m } }.toBooleanArray()
//private val sortedBooleanArray = shuffledBooleanArray.sor

private val shuffledCharArray = shuffledIntArray.map { it.toChar() }.toCharArray()
private val sortedCharArray = shuffledCharArray.sortedArray()

private val shuffledDoubleArray = shuffledIntArray.map { it.toDouble() }.toDoubleArray()
private val sortedDoubleArray = shuffledDoubleArray.sortedArray()

private val shuffledFloatArray = shuffledIntArray.map { it.toFloat() }.toFloatArray()
private val sortedFloatArray = shuffledFloatArray.sortedArray()

private val shuffledLongArray = shuffledIntArray.map { it.toLong() }.toLongArray()
private val sortedLongArray = shuffledLongArray.sortedArray()

private val shuffledShortArray = shuffledIntArray.map { it.toShort() }.toShortArray()
private val sortedShortArray = shuffledShortArray.sortedArray()


internal class SortTest {


    @Test
    fun testBubbleSortByteArray() {
        with (Sort) {
            Assert.assertArrayEquals(byteArrayOf(-1, 0, 1), byteArrayOf(1, 0, -1).bubbleSorted())
            Assert.assertArrayEquals(sortedByteArray, shuffledByteArray.bubbleSorted())
            Assert.assertArrayEquals(sortedByteArray.reversedArray(), shuffledByteArray.bubbleSorted(comparator = ByteComparator.naturalOrderReversed))
            Assert.assertArrayEquals(sortedByteArray, shuffledByteArray.clone().also { it.bubbleSort() })
        }
    }

    @Test
    fun testInsertionSortByteArray() {
        with (Sort) {
            Assert.assertArrayEquals(byteArrayOf(-1, 0, 1), byteArrayOf(1, 0, -1).insertionSorted())
            Assert.assertArrayEquals(sortedByteArray, shuffledByteArray.insertionSorted())
            Assert.assertArrayEquals(sortedByteArray.reversedArray(), shuffledByteArray.insertionSorted(comparator = ByteComparator.naturalOrderReversed))
            Assert.assertArrayEquals(sortedByteArray, shuffledByteArray.clone().also { it.insertionSort() })
        }
    }


    @Test
    fun testBubbleSortCharArray() {
        with (Sort) {
            Assert.assertArrayEquals(charArrayOf('a', 'b', 'c'), charArrayOf('c', 'b', 'a').bubbleSorted())
            Assert.assertArrayEquals(sortedCharArray, shuffledCharArray.bubbleSorted())
            Assert.assertArrayEquals(sortedCharArray.reversedArray(), shuffledCharArray.bubbleSorted(comparator = CharComparator.naturalOrderReversed))
            Assert.assertArrayEquals(sortedCharArray, shuffledCharArray.clone().also { it.bubbleSort() })
        }
    }

    @Test
    fun testInsertionSortCharArray() {
        with (Sort) {
            Assert.assertArrayEquals(charArrayOf('a', 'b', 'c'), charArrayOf('c', 'b', 'a').insertionSorted())
            Assert.assertArrayEquals(sortedCharArray, shuffledCharArray.insertionSorted())
            Assert.assertArrayEquals(sortedCharArray.reversedArray(), shuffledCharArray.insertionSorted(comparator = CharComparator.naturalOrderReversed))
            Assert.assertArrayEquals(sortedCharArray, shuffledCharArray.clone().also { it.insertionSort() })
        }
    }


    @Test
    fun testBubbleSortDoubleArray() {
        with (Sort) {
            Assert.assertArrayEquals(doubleArrayOf(-1.0, 0.0, 1.0), doubleArrayOf(1.0, 0.0, -1.0).bubbleSorted(), 0.0)
            Assert.assertArrayEquals(sortedDoubleArray, shuffledDoubleArray.bubbleSorted(), 0.0)
            Assert.assertArrayEquals(sortedDoubleArray.reversedArray(), shuffledDoubleArray.bubbleSorted(comparator = DoubleComparator.naturalOrderReversed), 0.0)
            Assert.assertArrayEquals(sortedDoubleArray, shuffledDoubleArray.clone().also { it.bubbleSort() }, 0.0)
        }
    }

    @Test
    fun testInsertionSortDoubleArray() {
        with (Sort) {
            Assert.assertArrayEquals(doubleArrayOf(-1.0, 0.0, 1.0), doubleArrayOf(1.0, 0.0, -1.0).insertionSorted(), 0.0)
            Assert.assertArrayEquals(sortedDoubleArray, shuffledDoubleArray.insertionSorted(), 0.0)
            Assert.assertArrayEquals(sortedDoubleArray.reversedArray(), shuffledDoubleArray.insertionSorted(comparator = DoubleComparator.naturalOrderReversed), 0.0)
            Assert.assertArrayEquals(sortedDoubleArray, shuffledDoubleArray.clone().also { it.insertionSort() }, 0.0)
        }
    }


    @Test
    fun testBubbleSortFloatArray() {
        with (Sort) {
            Assert.assertArrayEquals(floatArrayOf(-1F, 0F, 1F), floatArrayOf(1F, 0F, -1F).bubbleSorted(), 0.0F)
            Assert.assertArrayEquals(sortedFloatArray, shuffledFloatArray.bubbleSorted(), 0.0F)
            Assert.assertArrayEquals(sortedFloatArray.reversedArray(), shuffledFloatArray.bubbleSorted(comparator = FloatComparator.naturalOrderReversed), 0.0F)
            Assert.assertArrayEquals(sortedFloatArray, shuffledFloatArray.clone().also { it.bubbleSort() }, 0.0F)
        }
    }

    @Test
    fun testInsertionSortFloatArray() {
        with (Sort) {
            Assert.assertArrayEquals(floatArrayOf(-1F, 0F, 1F), floatArrayOf(1F, 0F, -1F).insertionSorted(), 0.0F)
            Assert.assertArrayEquals(sortedFloatArray, shuffledFloatArray.insertionSorted(), 0.0F)
            Assert.assertArrayEquals(sortedFloatArray.reversedArray(), shuffledFloatArray.insertionSorted(comparator = FloatComparator.naturalOrderReversed), 0.0F)
            Assert.assertArrayEquals(sortedFloatArray, shuffledFloatArray.clone().also { it.insertionSort() }, 0.0F)
        }
    }


    @Test
    fun testBubbleSortIntArray() {
        with (Sort) {
            Assert.assertArrayEquals(intArrayOf(-1, 0, 1), intArrayOf(1, 0, -1).bubbleSorted())
            Assert.assertArrayEquals(sortedIntArray, shuffledIntArray.bubbleSorted())
            Assert.assertArrayEquals(sortedIntArray.reversedArray(), shuffledIntArray.bubbleSorted(comparator = IntComparator.naturalOrderReversed))
            Assert.assertArrayEquals(sortedIntArray, shuffledIntArray.clone().also { it.bubbleSort() })
        }
    }

    @Test
    fun testInsertionSortIntArray() {
        with (Sort) {
            Assert.assertArrayEquals(intArrayOf(-1, 0, 1), intArrayOf(1, 0, -1).insertionSorted())
            Assert.assertArrayEquals(sortedIntArray, shuffledIntArray.insertionSorted())
            Assert.assertArrayEquals(sortedIntArray.reversedArray(), shuffledIntArray.insertionSorted(comparator = IntComparator.naturalOrderReversed))
            Assert.assertArrayEquals(sortedIntArray, shuffledIntArray.clone().also { it.insertionSort() })
        }
    }


    @Test
    fun testBubbleSortLongArray() {
        with (Sort) {
            Assert.assertArrayEquals(longArrayOf(-1, 0, 1), longArrayOf(1, 0, -1).bubbleSorted())
            Assert.assertArrayEquals(sortedLongArray, shuffledLongArray.bubbleSorted())
            Assert.assertArrayEquals(sortedLongArray.reversedArray(), shuffledLongArray.bubbleSorted(comparator = LongComparator.naturalOrderReversed))
            Assert.assertArrayEquals(sortedLongArray, shuffledLongArray.clone().also { it.bubbleSort() })
        }
    }

    @Test
    fun testInsertionSortLongArray() {
        with (Sort) {
            Assert.assertArrayEquals(longArrayOf(-1, 0, 1), longArrayOf(1, 0, -1).insertionSorted())
            Assert.assertArrayEquals(sortedLongArray, shuffledLongArray.insertionSorted())
            Assert.assertArrayEquals(sortedLongArray.reversedArray(), shuffledLongArray.insertionSorted(comparator = LongComparator.naturalOrderReversed))
            Assert.assertArrayEquals(sortedLongArray, shuffledLongArray.clone().also { it.insertionSort() })
        }
    }


    @Test
    fun testBubbleSortShortArray() {
        with (Sort) {
            Assert.assertArrayEquals(shortArrayOf(-1, 0, 1), shortArrayOf(1, 0, -1).bubbleSorted())
            Assert.assertArrayEquals(sortedShortArray, shuffledShortArray.bubbleSorted())
            Assert.assertArrayEquals(sortedShortArray.reversedArray(), shuffledShortArray.bubbleSorted(comparator = ShortComparator.naturalOrderReversed))
            Assert.assertArrayEquals(sortedShortArray, shuffledShortArray.clone().also { it.bubbleSort() })
        }
    }

    @Test
    fun testInsertionSortShortArray() {
        with (Sort) {
            Assert.assertArrayEquals(shortArrayOf(-1, 0, 1), shortArrayOf(1, 0, -1).insertionSorted())
            Assert.assertArrayEquals(sortedShortArray, shuffledShortArray.insertionSorted())
            Assert.assertArrayEquals(sortedShortArray.reversedArray(), shuffledShortArray.insertionSorted(comparator = ShortComparator.naturalOrderReversed))
            Assert.assertArrayEquals(sortedShortArray, shuffledShortArray.clone().also { it.insertionSort() })
        }
    }


    @Test
    fun testBubbleSortTypedIntArray() {
        with (Sort) {
            Assert.assertArrayEquals(intArrayOf(-1, 0, 1).toTypedArray(), intArrayOf(1, 0, -1).toTypedArray().bubbleSorted())
            Assert.assertArrayEquals(sortedIntArray.toTypedArray(), shuffledIntArray.toTypedArray().bubbleSorted())
            Assert.assertArrayEquals(sortedIntArray.toTypedArray().reversedArray(), shuffledIntArray.toTypedArray().bubbleSorted(comparator = Comparator.reverseOrder()))
            Assert.assertArrayEquals(sortedIntArray.toTypedArray(), shuffledIntArray.toTypedArray().also { it.bubbleSort() })
        }
    }

    @Test
    fun testInsertionSortTypedIntArray() {
        with (Sort) {
            Assert.assertArrayEquals(intArrayOf(-1, 0, 1).toTypedArray(), intArrayOf(1, 0, -1).toTypedArray().insertionSorted())
            Assert.assertArrayEquals(sortedIntArray.toTypedArray(), shuffledIntArray.toTypedArray().insertionSorted())
            Assert.assertArrayEquals(sortedIntArray.toTypedArray().reversedArray(), shuffledIntArray.toTypedArray().insertionSorted(comparator = Comparator.reverseOrder()))
            Assert.assertArrayEquals(sortedIntArray.toTypedArray(), shuffledIntArray.toTypedArray().also { it.insertionSort() })
        }
    }

}