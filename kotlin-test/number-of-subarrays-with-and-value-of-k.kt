package numberofsubarrayswithandvalueofk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubarraysWithAndValueOfKTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(6L, solution.countSubarrays(intArrayOf(1, 1, 1), 1))
    }

    @Test
    fun exampleTwo() {
        assertEquals(3L, solution.countSubarrays(intArrayOf(1, 1, 2), 1))
    }

    @Test
    fun interruptedRuns() {
        assertEquals(1L, solution.countSubarrays(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun empty() {
        assertEquals(0L, solution.countSubarrays(intArrayOf(), 0))
    }
}
