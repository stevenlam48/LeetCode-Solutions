package maximalscoreafterapplyingkoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximalScoreAfterApplyingKOperationsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(50L, solution.maxKelements(intArrayOf(10, 10, 10, 10, 10), 5))
    }

    @Test
    fun testExample2() {
        assertEquals(17L, solution.maxKelements(intArrayOf(1, 10, 3, 3, 3), 3))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1L, solution.maxKelements(intArrayOf(1), 1))
    }
}
