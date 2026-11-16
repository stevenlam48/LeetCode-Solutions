package maximizealternatingsumusingswaps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeAlternatingSumUsingSwapsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            4L,
            solution.maxAlternatingSum(
                intArrayOf(1, 2, 3),
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
            )
        )
    }

    @Test
    fun testNoSwaps() {
        assertEquals(2L, solution.maxAlternatingSum(intArrayOf(1, 2, 3), arrayOf()))
    }

    @Test
    fun testFullyConnected() {
        assertEquals(
            9L,
            solution.maxAlternatingSum(
                intArrayOf(5, 4, 3, 2, 1),
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4)
                )
            )
        )
    }

    @Test
    fun testEqualValues() {
        assertEquals(
            0L,
            solution.maxAlternatingSum(intArrayOf(1, 1), arrayOf(intArrayOf(0, 1)))
        )
    }
}
