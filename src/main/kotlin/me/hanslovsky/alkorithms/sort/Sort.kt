package me.hanslovsky.alkorithms.sort

import me.hanslovsky.alkorithms.compare.BooleanComparator
import me.hanslovsky.alkorithms.compare.ByteComparator
import me.hanslovsky.alkorithms.compare.CharComparator
import me.hanslovsky.alkorithms.compare.DoubleComparator
import me.hanslovsky.alkorithms.compare.FloatComparator
import me.hanslovsky.alkorithms.compare.IntComparator
import me.hanslovsky.alkorithms.compare.LongComparator
import me.hanslovsky.alkorithms.compare.ShortComparator

class Sort private constructor() {

    companion object {

        // Boolean arrays
        fun BooleanArray.bubbleSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: BooleanComparator = BooleanComparator.naturalOrder) = clone().also { it.bubbleSort(startInclusive, stopExclusive, comparator) }

        fun BooleanArray.bubbleSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: BooleanComparator = BooleanComparator.naturalOrder) {
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

        fun BooleanArray.insertionSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: BooleanComparator = BooleanComparator.naturalOrder) = clone().also { it.insertionSort(startInclusive, stopExclusive, comparator) }

        fun BooleanArray.insertionSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: BooleanComparator = BooleanComparator.naturalOrder) {
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


        // Byte arrays
        fun ByteArray.bubbleSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: ByteComparator = ByteComparator.naturalOrder) = clone().also { it.bubbleSort(startInclusive, stopExclusive, comparator) }

        fun ByteArray.bubbleSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: ByteComparator = ByteComparator.naturalOrder) {
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

        fun ByteArray.insertionSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: ByteComparator = ByteComparator.naturalOrder) = clone().also { it.insertionSort(startInclusive, stopExclusive, comparator) }

        fun ByteArray.insertionSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: ByteComparator = ByteComparator.naturalOrder) {
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


        // Char arrays
        fun CharArray.bubbleSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: CharComparator = CharComparator.naturalOrder) = clone().also { it.bubbleSort(startInclusive, stopExclusive, comparator) }

        fun CharArray.bubbleSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: CharComparator = CharComparator.naturalOrder) {
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

        fun CharArray.insertionSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: CharComparator = CharComparator.naturalOrder) = clone().also { it.insertionSort(startInclusive, stopExclusive, comparator) }

        fun CharArray.insertionSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: CharComparator = CharComparator.naturalOrder) {
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


        // Float arrays
        fun FloatArray.bubbleSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: FloatComparator = FloatComparator.naturalOrder) = clone().also { it.bubbleSort(startInclusive, stopExclusive, comparator) }

        fun FloatArray.bubbleSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: FloatComparator = FloatComparator.naturalOrder) {
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

        fun FloatArray.insertionSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: FloatComparator = FloatComparator.naturalOrder) = clone().also { it.insertionSort(startInclusive, stopExclusive, comparator) }

        fun FloatArray.insertionSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: FloatComparator = FloatComparator.naturalOrder) {
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


        // Double arrays
        fun DoubleArray.bubbleSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: DoubleComparator = DoubleComparator.naturalOrder) = clone().also { it.bubbleSort(startInclusive, stopExclusive, comparator) }

        fun DoubleArray.bubbleSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: DoubleComparator = DoubleComparator.naturalOrder) {
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

        fun DoubleArray.insertionSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: DoubleComparator = DoubleComparator.naturalOrder) = clone().also { it.insertionSort(startInclusive, stopExclusive, comparator) }

        fun DoubleArray.insertionSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: DoubleComparator = DoubleComparator.naturalOrder) {
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


        // Int arrays
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
                stopExclusive: Int = size,
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


        // Long arrays
        fun LongArray.bubbleSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: LongComparator = LongComparator.naturalOrder) = clone().also { it.bubbleSort(startInclusive, stopExclusive, comparator) }

        fun LongArray.bubbleSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: LongComparator = LongComparator.naturalOrder) {
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

        fun LongArray.insertionSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: LongComparator = LongComparator.naturalOrder) = clone().also { it.insertionSort(startInclusive, stopExclusive, comparator) }

        fun LongArray.insertionSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: LongComparator = LongComparator.naturalOrder) {
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


        // Short arrays
        fun ShortArray.bubbleSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: ShortComparator = ShortComparator.naturalOrder) = clone().also { it.bubbleSort(startInclusive, stopExclusive, comparator) }

        fun ShortArray.bubbleSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: ShortComparator = ShortComparator.naturalOrder) {
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

        fun ShortArray.insertionSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: ShortComparator = ShortComparator.naturalOrder) = clone().also { it.insertionSort(startInclusive, stopExclusive, comparator) }

        fun ShortArray.insertionSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: ShortComparator = ShortComparator.naturalOrder) {
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


        // generic arrays
        fun <T: Comparable<T>> Array<T>.bubbleSorted(startInclusive: Int = 0, stopExclusive: Int = size) = bubbleSorted(
                startInclusive,
                stopExclusive,
                Comparator { t1, t2 -> t1.compareTo(t2) })
        fun <T> Array<T>.bubbleSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: Comparator<T>) = clone().also { it.bubbleSort(startInclusive, stopExclusive, comparator) }

        fun <T: Comparable<T>> Array<T>.bubbleSort(startInclusive: Int = 0, stopExclusive: Int = size) = bubbleSort(
                startInclusive,
                stopExclusive,
                Comparator { t1, t2 -> t1.compareTo(t2) })
        fun <T> Array<T>.bubbleSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: Comparator<T>) {
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

        fun <T: Comparable<T>> Array<T>.insertionSorted(startInclusive: Int = 0, stopExclusive: Int = size) = insertionSorted(
                startInclusive,
                stopExclusive,
                object : Comparator<T> { override fun compare(t1: T, t2: T) = t1.compareTo(t2) })
        fun <T> Array<T>.insertionSorted(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: Comparator<T>) = clone().also { it.insertionSort(startInclusive, stopExclusive, comparator) }


        fun <T: Comparable<T>> Array<T>.insertionSort(startInclusive: Int = 0, stopExclusive: Int = size) = insertionSort(
                startInclusive,
                stopExclusive,
                object : Comparator<T> { override fun compare(t1: T, t2: T) = t1.compareTo(t2) })
        fun <T> Array<T>.insertionSort(
                startInclusive: Int = 0,
                stopExclusive: Int = size,
                comparator: Comparator<T>) {
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