package maximumgap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumGapTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().maximumGap(intArrayOf(3, 6, 9, 1)))
    }

    @Test
    fun example2() {
        assertEquals(0, Solution().maximumGap(intArrayOf(10)))
    }

    @Test
    fun allEqual() {
        assertEquals(0, Solution().maximumGap(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun twoElements() {
        assertEquals(9999999, Solution().maximumGap(intArrayOf(1, 10000000)))
    }

    @Test
    fun unsorted() {
        assertEquals(4, Solution().maximumGap(intArrayOf(5, 1, 9, 3)))
    }

    @Test
    fun largeGapAtEnd() {
        assertEquals(97, Solution().maximumGap(intArrayOf(1, 3, 100)))
    }
}
