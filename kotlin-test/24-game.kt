package p24game

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class P24gameTest {
    @Test
    fun example1() {
        assertTrue(Solution().judgePoint24(intArrayOf(4, 1, 8, 7)))
    }

    @Test
    fun example2() {
        assertFalse(Solution().judgePoint24(intArrayOf(1, 2, 1, 2)))
    }

    @Test
    fun allOnes() {
        assertFalse(Solution().judgePoint24(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun simpleProduct() {
        assertTrue(Solution().judgePoint24(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun divisionNeeded() {
        assertTrue(Solution().judgePoint24(intArrayOf(3, 3, 8, 8)))
    }

    @Test
    fun impossible() {
        assertFalse(Solution().judgePoint24(intArrayOf(1, 1, 1, 2)))
    }
}
