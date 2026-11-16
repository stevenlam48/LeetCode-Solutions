package handofstraights

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class HandOfStraightsTest {
    @Test
    fun example1() {
        assertTrue(Solution().isNStraightHand(intArrayOf(1, 2, 3, 6, 2, 3, 4, 7, 8), 3))
    }

    @Test
    fun sizeNotDivisible() {
        assertFalse(Solution().isNStraightHand(intArrayOf(1, 2, 3, 4, 5), 4))
    }

    @Test
    fun notConsecutive() {
        assertFalse(Solution().isNStraightHand(intArrayOf(1, 2, 3, 4, 5), 2))
    }

    @Test
    fun duplicateGroups() {
        assertTrue(Solution().isNStraightHand(intArrayOf(1, 1, 2, 2, 3, 3), 3))
    }

    @Test
    fun missingAfterSecondGroup() {
        assertFalse(Solution().isNStraightHand(intArrayOf(1, 1, 2, 2, 2, 3), 3))
    }

    @Test
    fun singleGroup() {
        assertTrue(Solution().isNStraightHand(intArrayOf(1, 2, 3, 4), 4))
    }
}
