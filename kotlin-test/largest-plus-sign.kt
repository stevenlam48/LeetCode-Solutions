package largestplussign

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestPlusSignTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.orderOfLargestPlusSign(5, arrayOf(intArrayOf(4, 2))))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.orderOfLargestPlusSign(1, arrayOf(intArrayOf(0, 0))))
    }

    @Test
    fun testNoMines() {
        assertEquals(2, solution.orderOfLargestPlusSign(3, emptyArray()))
    }

    @Test
    fun testSmallGrid() {
        assertEquals(1, solution.orderOfLargestPlusSign(2, emptyArray()))
    }

    @Test
    fun testAllMined() {
        assertEquals(
            0,
            solution.orderOfLargestPlusSign(
                2,
                arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, 1))
            )
        )
    }
}
