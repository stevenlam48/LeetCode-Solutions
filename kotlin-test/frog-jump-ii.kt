package frogjumpii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FrogJumpIiTest {
    @Test
    fun example1() {
        assertEquals(5, Solution().maxJump(intArrayOf(0, 2, 5, 6, 7)))
    }

    @Test
    fun example2() {
        assertEquals(9, Solution().maxJump(intArrayOf(0, 3, 9)))
    }

    @Test
    fun twoStones() {
        assertEquals(1, Solution().maxJump(intArrayOf(0, 1)))
    }

    @Test
    fun evenlySpaced() {
        assertEquals(8, Solution().maxJump(intArrayOf(0, 4, 8, 12, 16)))
    }

    @Test
    fun unevenGaps() {
        assertEquals(10, Solution().maxJump(intArrayOf(0, 1, 10, 11, 20)))
    }
}
