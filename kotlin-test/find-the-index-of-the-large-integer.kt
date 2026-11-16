package findtheindexofthelargeinteger

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheIndexOfTheLargeIntegerTest {
    private class FakeReader(private val a: IntArray) : ArrayReader {
        override fun length(): Int = a.size

        override fun get(index: Int): Int = a[index]

        override fun compareSub(l: Int, r: Int, x: Int, y: Int): Int {
            var s1 = 0
            var s2 = 0
            for (i in l..r) {
                s1 += a[i]
            }
            for (i in x..y) {
                s2 += a[i]
            }
            return s1.compareTo(s2)
        }
    }

    @Test
    fun largestAtEnd() {
        assertEquals(4, Solution().getIndex(FakeReader(intArrayOf(1, 2, 3, 4, 5))))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().getIndex(FakeReader(intArrayOf(7))))
    }

    @Test
    fun largestInMiddle() {
        assertEquals(3, Solution().getIndex(FakeReader(intArrayOf(1, 1, 1, 5, 1, 1))))
    }

    @Test
    fun largestAtStart() {
        assertEquals(0, Solution().getIndex(FakeReader(intArrayOf(9, 1, 1, 1, 1))))
    }

    @Test
    fun evenLength() {
        assertEquals(2, Solution().getIndex(FakeReader(intArrayOf(1, 1, 8, 1))))
    }
}
