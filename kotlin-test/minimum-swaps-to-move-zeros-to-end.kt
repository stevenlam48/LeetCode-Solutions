package minimumswapstomovezerostoend

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSwapsToMoveZerosToEndTest {
    private val solution = Solution()

    @Test
    fun testMixedArray() {
        assertEquals(2, solution.minimumSwaps(intArrayOf(0, 1, 0, 3, 12)))
    }

    @Test
    fun testSingleZeroNotAtEnd() {
        assertEquals(1, solution.minimumSwaps(intArrayOf(4, 2, 0, 1)))
        assertEquals(1, solution.minimumSwaps(intArrayOf(0, 1)))
    }

    @Test
    fun testAllZeros() {
        assertEquals(0, solution.minimumSwaps(intArrayOf(0, 0, 0)))
    }

    @Test
    fun testNoZeros() {
        assertEquals(0, solution.minimumSwaps(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testZerosAlreadyAtEnd() {
        assertEquals(0, solution.minimumSwaps(intArrayOf(1, 2, 0, 0)))
    }
}
