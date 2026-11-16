package mergeoperationstoturnarrayintoapalindrome

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeOperationsToTurnArrayIntoAPalindromeTest {
    @Test
    fun exampleOne() {
        assertEquals(2, Solution().minimumOperations(intArrayOf(4, 3, 2, 1, 2, 3, 1)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(3, Solution().minimumOperations(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun alreadyPalindrome() {
        assertEquals(0, Solution().minimumOperations(intArrayOf(1, 2, 2, 1)))
        assertEquals(0, Solution().minimumOperations(intArrayOf(1, 2, 3, 2, 1)))
    }

    @Test
    fun singleAndTwoElements() {
        assertEquals(0, Solution().minimumOperations(intArrayOf(5)))
        assertEquals(0, Solution().minimumOperations(intArrayOf(5, 5)))
        assertEquals(1, Solution().minimumOperations(intArrayOf(5, 6)))
    }
}
