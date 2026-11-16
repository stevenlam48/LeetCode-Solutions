package imageoverlap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ImageOverlapTest {
    @Test
    fun example1() {
        val a = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 1, 0)
        )
        val b = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 0, 1)
        )
        assertEquals(3, Solution().largestOverlap(a, b))
    }

    @Test
    fun singleOne() {
        assertEquals(1, Solution().largestOverlap(arrayOf(intArrayOf(1)), arrayOf(intArrayOf(1))))
    }

    @Test
    fun singleZero() {
        assertEquals(0, Solution().largestOverlap(arrayOf(intArrayOf(0)), arrayOf(intArrayOf(0))))
    }

    @Test
    fun diagonal() {
        val a = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1)
        )
        val b = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0)
        )
        assertEquals(1, Solution().largestOverlap(a, b))
    }

    @Test
    fun identical() {
        val a = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        assertEquals(4, Solution().largestOverlap(a, a))
    }
}
