package maximumscorefromperformingmultiplicationoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreFromPerformingMultiplicationOperationsTest {
    @Test
    fun exampleOne() {
        assertEquals(
            14,
            Solution().maximumScore(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))
        )
    }

    @Test
    fun exampleTwo() {
        assertEquals(
            102,
            Solution().maximumScore(
                intArrayOf(-5, -3, -3, -2, 7, 1),
                intArrayOf(-10, -5, 3, 4, 6)
            )
        )
    }

    @Test
    fun singleNegativeMultiplier() {
        assertEquals(-8, Solution().maximumScore(intArrayOf(4), intArrayOf(-2)))
    }

    @Test
    fun allNegativeValues() {
        assertEquals(17, Solution().maximumScore(intArrayOf(-5, -2), intArrayOf(-3, -1)))
    }
}
