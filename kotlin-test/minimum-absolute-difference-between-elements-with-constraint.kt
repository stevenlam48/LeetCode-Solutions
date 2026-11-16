package minimumabsolutedifferencebetweenelementswithconstraint

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAbsoluteDifferenceBetweenElementsWithConstraintTest {
    @Test
    fun example1() {
        assertEquals(0, Solution().minAbsoluteDifference(intArrayOf(4, 3, 2, 4), 2))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().minAbsoluteDifference(intArrayOf(5, 3, 2, 10, 15), 1))
    }

    @Test
    fun example3() {
        assertEquals(3, Solution().minAbsoluteDifference(intArrayOf(1, 2, 3, 4), 3))
    }

    @Test
    fun twoElements() {
        assertEquals(4, Solution().minAbsoluteDifference(intArrayOf(1, 5), 1))
    }

    @Test
    fun duplicates() {
        assertEquals(0, Solution().minAbsoluteDifference(intArrayOf(7, 7, 7), 1))
    }
}
