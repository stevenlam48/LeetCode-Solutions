package climbingstairsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClimbingStairsIiTest {
    @Test
    fun noStairs() {
        assertEquals(0, Solution().climbStairs(0, intArrayOf()))
    }

    @Test
    fun singleStair() {
        assertEquals(8, Solution().climbStairs(1, intArrayOf(7)))
    }

    @Test
    fun directThreeStairJumpIsCheapest() {
        assertEquals(29, Solution().climbStairs(3, intArrayOf(10, 15, 20)))
    }

    @Test
    fun combinesDifferentJumpLengths() {
        assertEquals(13, Solution().climbStairs(4, intArrayOf(1, 2, 3, 4)))
    }
}
