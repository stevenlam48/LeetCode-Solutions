package cuttingribbons

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CuttingRibbonsTest {
    @Test
    fun example1() {
        assertEquals(5, Solution().maxLength(intArrayOf(9, 7, 5), 3))
    }

    @Test
    fun example2() {
        assertEquals(5, Solution().maxLength(intArrayOf(7, 5, 5), 2))
    }

    @Test
    fun impossible() {
        assertEquals(0, Solution().maxLength(intArrayOf(5, 7, 9), 22))
    }

    @Test
    fun singleRibbon() {
        assertEquals(1, Solution().maxLength(intArrayOf(5), 5))
        assertEquals(2, Solution().maxLength(intArrayOf(5), 2))
    }

    @Test
    fun singleCut() {
        assertEquals(3, Solution().maxLength(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun largeValues() {
        assertEquals(100000000, Solution().maxLength(intArrayOf(100000000, 100000000), 2))
    }
}
