package numberofintegerswithpopcountdepthequaltoki

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfIntegersWithPopcountDepthEqualToKITest {
    @Test
    fun testDepthOne() {
        assertEquals(2L, Solution().popcountDepth(4, 1))
    }

    @Test
    fun testDepthTwo() {
        assertEquals(1L, Solution().popcountDepth(4, 2))
    }

    @Test
    fun testDepthZero() {
        assertEquals(1L, Solution().popcountDepth(4, 0))
    }

    @Test
    fun testDepthThree() {
        assertEquals(1L, Solution().popcountDepth(7, 3))
    }

    @Test
    fun testDepthTwoUpToTen() {
        assertEquals(5L, Solution().popcountDepth(10, 2))
    }

    @Test
    fun testOne() {
        assertEquals(1L, Solution().popcountDepth(1, 0))
        assertEquals(0L, Solution().popcountDepth(1, 1))
    }
}
