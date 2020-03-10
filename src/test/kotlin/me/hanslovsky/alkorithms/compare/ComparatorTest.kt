package me.hanslovsky.alkorithms.compare

import org.junit.Assert
import org.junit.Test



internal class ComparatorTest {

    @Test
    fun testIntComparator() {
        val smaller = -10
        val larger = 313
        Assert.assertEquals(-1, IntComparator.naturalOrder.compare(smaller, larger))
        Assert.assertEquals(+1, IntComparator.naturalOrder.compare(larger, smaller))
        Assert.assertEquals(+0, IntComparator.naturalOrder.compare(smaller, smaller))
        Assert.assertEquals(+0, IntComparator.naturalOrder.compare(larger, larger))

        Assert.assertEquals(IntComparator.naturalOrder.compare(larger, smaller), IntComparator.naturalOrderReversed.compare(smaller, larger))
        Assert.assertEquals(IntComparator.naturalOrder.compare(smaller, larger), IntComparator.naturalOrder.reversed.compare(larger, smaller))
    }

}