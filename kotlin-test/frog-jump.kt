package frogjump

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FrogJumpTest {
    @Test
    fun example1() {
        assertTrue(Solution().canCross(intArrayOf(0, 1, 3, 5, 6, 8, 12, 17)))
    }

    @Test
    fun example2() {
        assertFalse(Solution().canCross(intArrayOf(0, 1, 2, 3, 4, 8, 9, 11)))
    }

    @Test
    fun twoStones() {
        assertTrue(Solution().canCross(intArrayOf(0, 1)))
    }

    @Test
    fun missingFirstUnitJump() {
        assertFalse(Solution().canCross(intArrayOf(0, 2)))
    }

    @Test
    fun longGap() {
        assertFalse(Solution().canCross(intArrayOf(0, 1, 3, 6, 11)))
    }
}
