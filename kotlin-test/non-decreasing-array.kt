package nondecreasingarray

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class NonDecreasingArrayTest {
    @Test
    fun example1() {
        assertTrue(Solution().checkPossibility(intArrayOf(4, 2, 3)))
    }

    @Test
    fun example2() {
        assertFalse(Solution().checkPossibility(intArrayOf(4, 2, 1)))
    }

    @Test
    fun alreadyNonDecreasing() {
        assertTrue(Solution().checkPossibility(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun singleElement() {
        assertTrue(Solution().checkPossibility(intArrayOf(1)))
    }

    @Test
    fun needsTwoChanges() {
        assertFalse(Solution().checkPossibility(intArrayOf(3, 4, 2, 3)))
    }

    @Test
    fun raisePreviousElement() {
        assertTrue(Solution().checkPossibility(intArrayOf(5, 7, 1, 8)))
    }
}
