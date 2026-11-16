package sumofsubarrayminimums

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfSubarrayMinimumsTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(17, solution.sumSubarrayMins(intArrayOf(3, 1, 2, 4)))
    }

    @Test
    fun secondExample() {
        assertEquals(444, solution.sumSubarrayMins(intArrayOf(11, 81, 94, 43, 3)))
    }

    @Test
    fun duplicateMinimumsAreNotDoubleCounted() {
        assertEquals(6, solution.sumSubarrayMins(intArrayOf(1, 1, 1)))
    }

    @Test
    fun descendingValues() {
        assertEquals(10, solution.sumSubarrayMins(intArrayOf(3, 2, 1)))
    }

    @Test
    fun emptyArray() {
        assertEquals(0, solution.sumSubarrayMins(intArrayOf()))
    }
}
