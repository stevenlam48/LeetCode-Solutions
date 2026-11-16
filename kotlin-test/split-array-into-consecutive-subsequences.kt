package splitarrayintoconsecutivesubsequences

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SplitArrayIntoConsecutiveSubsequencesTest {
    @Test
    fun firstLeetCodeExample() {
        assertTrue(Solution().isPossible(intArrayOf(1, 2, 3, 3, 4, 5)))
    }

    @Test
    fun secondLeetCodeExample() {
        assertTrue(Solution().isPossible(intArrayOf(1, 2, 3, 3, 4, 4, 5, 5)))
    }

    @Test
    fun thirdLeetCodeExample() {
        assertFalse(Solution().isPossible(intArrayOf(1, 2, 3, 4, 4, 5)))
    }

    @Test
    fun separateSubsequencesCanStartAfterGap() {
        assertTrue(Solution().isPossible(intArrayOf(1, 2, 3, 5, 6, 7)))
    }

    @Test
    fun negativeNumbersMayBeginSubsequence() {
        assertTrue(Solution().isPossible(intArrayOf(-1, 0, 0, 1, 1, 2)))
    }
}
