package climbingstairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClimbingStairsTest {
    @Test
    fun baseCases() {
        assertEquals(1, Solution().climbStairs(0))
        assertEquals(1, Solution().climbStairs(1))
    }

    @Test
    fun twoStairs() {
        assertEquals(2, Solution().climbStairs(2))
    }

    @Test
    fun threeStairs() {
        assertEquals(3, Solution().climbStairs(3))
    }

    @Test
    fun largerInput() {
        assertEquals(89, Solution().climbStairs(10))
    }
}
