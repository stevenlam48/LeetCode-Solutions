package minimumnumberofoperationstomakearraycontinuous

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToMakeArrayContinuousTest {
    private val solution = Solution()

    @Test
    fun alreadyContinuous() {
        assertEquals(0, solution.minOperations(intArrayOf(4, 2, 5, 3)))
    }

    @Test
    fun oneGap() {
        assertEquals(1, solution.minOperations(intArrayOf(1, 2, 3, 5, 6)))
    }

    @Test
    fun widelySpread() {
        assertEquals(3, solution.minOperations(intArrayOf(1, 10, 100, 1000)))
    }

    @Test
    fun duplicates() {
        assertEquals(1, solution.minOperations(intArrayOf(1, 1, 2, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, solution.minOperations(intArrayOf(5)))
    }
}
