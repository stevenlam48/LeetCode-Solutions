package largestsubmatrixwithrearrangements

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LargestSubmatrixWithRearrangementsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            4,
            solution.largestSubmatrix(
                arrayOf(
                    intArrayOf(0, 0, 1),
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 0, 1)
                )
            )
        )
    }

    @Test
    fun testExample2() {
        assertEquals(3, solution.largestSubmatrix(arrayOf(intArrayOf(1, 0, 1, 0, 1))))
    }

    @Test
    fun testExample3() {
        assertEquals(
            2,
            solution.largestSubmatrix(
                arrayOf(
                    intArrayOf(1, 1, 0),
                    intArrayOf(1, 0, 1)
                )
            )
        )
    }

    @Test
    fun testAllZeros() {
        assertEquals(
            0,
            solution.largestSubmatrix(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(0, 0)
                )
            )
        )
    }

    @Test
    fun testAllOnes() {
        assertEquals(
            4,
            solution.largestSubmatrix(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 1)
                )
            )
        )
    }
}
