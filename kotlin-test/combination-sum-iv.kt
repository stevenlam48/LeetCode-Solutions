package combinationsumiv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CombinationSumIvTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(7, solution.combinationSum4(intArrayOf(1, 2, 3), 4))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.combinationSum4(intArrayOf(9), 3))
    }

    @Test
    fun testZeroTarget() {
        assertEquals(1, solution.combinationSum4(intArrayOf(1, 2), 0))
    }

    @Test
    fun testOrderMatters() {
        assertEquals(3, solution.combinationSum4(intArrayOf(1, 2), 3))
    }

    @Test
    fun testUnsortedInput() {
        assertEquals(7, solution.combinationSum4(intArrayOf(3, 1, 2), 4))
    }
}
