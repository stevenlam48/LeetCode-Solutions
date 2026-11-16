package checkifanumberismajorityelementinasortedarray

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfANumberIsMajorityElementInASortedArrayTest {
    private val solution = Solution()

    @Test
    fun targetIsMajority() {
        assertTrue(solution.isMajorityElement(intArrayOf(2, 4, 5, 5, 5, 5, 5, 6, 6), 5))
    }

    @Test
    fun targetIsNotMajority() {
        assertFalse(solution.isMajorityElement(intArrayOf(10, 100, 101, 101), 101))
    }

    @Test
    fun absentTarget() {
        assertFalse(solution.isMajorityElement(intArrayOf(1, 2, 3), 4))
    }

    @Test
    fun singleElement() {
        assertTrue(solution.isMajorityElement(intArrayOf(7), 7))
        assertFalse(solution.isMajorityElement(intArrayOf(7), 8))
    }

    @Test
    fun intMaxTargetDoesNotOverflowSearch() {
        assertTrue(solution.isMajorityElement(intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE), Int.MAX_VALUE))
    }
}
