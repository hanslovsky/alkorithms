package me.hanslovsky.alkorithms.sort

import org.junit.Assert
import org.junit.Test


private val shuffledIntArray = intArrayOf(34, 13, 30, 4601, 45, 13, 35, 4601, 4601, 0, -135, 35, -12, 2)
private val sortedIntArray = shuffledIntArray.sortedArray()

internal class SortTest {

    @Test
    fun testBubbleSortIntArray() {
        with (Sort) {
            Assert.assertArrayEquals(intArrayOf(-1, 0, 1), intArrayOf(1, 0, -1).bubbleSorted())
            Assert.assertArrayEquals(sortedIntArray, shuffledIntArray.bubbleSorted())
            Assert.assertArrayEquals(sortedIntArray.reversedArray(), shuffledIntArray.bubbleSorted(comparator = Sort.IntComparator.naturalOrderReversed))
        }
    }

    @Test
    fun testInsertionSortIntArray() {
        with (Sort) {
            Assert.assertArrayEquals(intArrayOf(-1, 0, 1), intArrayOf(1, 0, -1).insertionSorted())
            Assert.assertArrayEquals(sortedIntArray, shuffledIntArray.insertionSorted())
            Assert.assertArrayEquals(sortedIntArray.reversedArray(), shuffledIntArray.insertionSorted(comparator = Sort.IntComparator.naturalOrderReversed))
        }
    }

}