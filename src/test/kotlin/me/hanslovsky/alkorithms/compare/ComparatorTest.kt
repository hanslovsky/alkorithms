package me.hanslovsky.alkorithms.compare

import org.junit.Assert
import org.junit.Test



internal class ComparatorTest {

    @Test
    fun testBooleanComparator() {
        val smaller = false
        val larger = true
        Assert.assertEquals(-1, BooleanComparator.naturalOrder.compare(smaller, larger))
        Assert.assertEquals(+1, BooleanComparator.naturalOrder.compare(larger, smaller))
        Assert.assertEquals(+0, BooleanComparator.naturalOrder.compare(smaller, smaller))
        Assert.assertEquals(+0, BooleanComparator.naturalOrder.compare(larger, larger))

        Assert.assertEquals(BooleanComparator.naturalOrder.compare(larger, smaller), BooleanComparator.naturalOrderReversed.compare(smaller, larger))
        Assert.assertEquals(BooleanComparator.naturalOrder.compare(smaller, larger), BooleanComparator.naturalOrder.reversed.compare(larger, smaller))
    }

    @Test
    fun testByteComparator() {
        val smaller: Byte = -128
        val larger: Byte = 127
        Assert.assertEquals(-1, ByteComparator.naturalOrder.compare(smaller, larger))
        Assert.assertEquals(+1, ByteComparator.naturalOrder.compare(larger, smaller))
        Assert.assertEquals(+0, ByteComparator.naturalOrder.compare(smaller, smaller))
        Assert.assertEquals(+0, ByteComparator.naturalOrder.compare(larger, larger))

        Assert.assertEquals(ByteComparator.naturalOrder.compare(larger, smaller), ByteComparator.naturalOrderReversed.compare(smaller, larger))
        Assert.assertEquals(ByteComparator.naturalOrder.compare(smaller, larger), ByteComparator.naturalOrder.reversed.compare(larger, smaller))
    }

    @Test
    fun testCharComparator() {
        val smaller = 'a'
        val larger = 'z'
        Assert.assertEquals(-1, CharComparator.naturalOrder.compare(smaller, larger))
        Assert.assertEquals(+1, CharComparator.naturalOrder.compare(larger, smaller))
        Assert.assertEquals(+0, CharComparator.naturalOrder.compare(smaller, smaller))
        Assert.assertEquals(+0, CharComparator.naturalOrder.compare(larger, larger))

        Assert.assertEquals(CharComparator.naturalOrder.compare(larger, smaller), CharComparator.naturalOrderReversed.compare(smaller, larger))
        Assert.assertEquals(CharComparator.naturalOrder.compare(smaller, larger), CharComparator.naturalOrder.reversed.compare(larger, smaller))
    }

    @Test
    fun testDoubleComparator() {
        val smaller = -10.0
        val larger = 31.3
        Assert.assertEquals(-1, DoubleComparator.naturalOrder.compare(smaller, larger))
        Assert.assertEquals(+1, DoubleComparator.naturalOrder.compare(larger, smaller))
        Assert.assertEquals(+0, DoubleComparator.naturalOrder.compare(smaller, smaller))
        Assert.assertEquals(+0, DoubleComparator.naturalOrder.compare(larger, larger))

        Assert.assertEquals(DoubleComparator.naturalOrder.compare(larger, smaller), DoubleComparator.naturalOrderReversed.compare(smaller, larger))
        Assert.assertEquals(DoubleComparator.naturalOrder.compare(smaller, larger), DoubleComparator.naturalOrder.reversed.compare(larger, smaller))
    }

    @Test
    fun testFloatComparator() {
        val smaller = -10.0F
        val larger = 31.3F
        Assert.assertEquals(-1, FloatComparator.naturalOrder.compare(smaller, larger))
        Assert.assertEquals(+1, FloatComparator.naturalOrder.compare(larger, smaller))
        Assert.assertEquals(+0, FloatComparator.naturalOrder.compare(smaller, smaller))
        Assert.assertEquals(+0, FloatComparator.naturalOrder.compare(larger, larger))

        Assert.assertEquals(FloatComparator.naturalOrder.compare(larger, smaller), FloatComparator.naturalOrderReversed.compare(smaller, larger))
        Assert.assertEquals(FloatComparator.naturalOrder.compare(smaller, larger), FloatComparator.naturalOrder.reversed.compare(larger, smaller))
    }

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

    @Test
    fun testLongComparator() {
        val smaller = -10L
        val larger = 313L
        Assert.assertEquals(-1, LongComparator.naturalOrder.compare(smaller, larger))
        Assert.assertEquals(+1, LongComparator.naturalOrder.compare(larger, smaller))
        Assert.assertEquals(+0, LongComparator.naturalOrder.compare(smaller, smaller))
        Assert.assertEquals(+0, LongComparator.naturalOrder.compare(larger, larger))

        Assert.assertEquals(LongComparator.naturalOrder.compare(larger, smaller), LongComparator.naturalOrderReversed.compare(smaller, larger))
        Assert.assertEquals(LongComparator.naturalOrder.compare(smaller, larger), LongComparator.naturalOrder.reversed.compare(larger, smaller))
    }

    @Test
    fun testShortComparator() {
        val smaller: Short = -10
        val larger: Short = 313
        Assert.assertEquals(-1, ShortComparator.naturalOrder.compare(smaller, larger))
        Assert.assertEquals(+1, ShortComparator.naturalOrder.compare(larger, smaller))
        Assert.assertEquals(+0, ShortComparator.naturalOrder.compare(smaller, smaller))
        Assert.assertEquals(+0, ShortComparator.naturalOrder.compare(larger, larger))

        Assert.assertEquals(ShortComparator.naturalOrder.compare(larger, smaller), ShortComparator.naturalOrderReversed.compare(smaller, larger))
        Assert.assertEquals(ShortComparator.naturalOrder.compare(smaller, larger), ShortComparator.naturalOrder.reversed.compare(larger, smaller))
    }

}