package minimumsidewayjumps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumSidewayJumpsTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().minSideJumps(intArrayOf(0, 1, 2, 3, 0)))
    }

    @Test
    fun noObstaclesInLane() {
        assertEquals(0, Solution().minSideJumps(intArrayOf(0, 1, 1, 3, 3, 0)))
    }

    @Test
    fun example3() {
        assertEquals(2, Solution().minSideJumps(intArrayOf(0, 2, 1, 0, 3, 0)))
    }

    @Test
    fun singlePosition() {
        assertEquals(0, Solution().minSideJumps(intArrayOf(0)))
    }

    @Test
    fun laneThreeBlocked() {
        assertEquals(0, Solution().minSideJumps(intArrayOf(0, 3)))
    }
}
