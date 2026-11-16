package minimumjumpstoreachhome

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumJumpsToReachHomeTest {
    private val solution = Solution()

    @Test
    fun reachesHomeWithForwardJumps() {
        assertEquals(3, solution.minimumJumps(intArrayOf(14, 4, 18, 1, 15), 3, 15, 9))
    }

    @Test
    fun returnsMinusOneWhenHomeIsUnreachable() {
        assertEquals(-1, solution.minimumJumps(intArrayOf(8, 3, 16, 6, 12, 20), 15, 13, 11))
    }

    @Test
    fun backwardJumpAvoidsForbiddenPoints() {
        assertEquals(2, solution.minimumJumps(intArrayOf(1, 6, 2, 14, 5, 17, 4), 16, 9, 7))
    }

    @Test
    fun startingAtHomeNeedsNoJump() {
        assertEquals(0, solution.minimumJumps(intArrayOf(1, 2, 3), 2, 1, 0))
    }
}
