package palindromeremoval

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PalindromeRemovalTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals(2, solution.minimumMoves(intArrayOf(1, 2)))
        assertEquals(3, solution.minimumMoves(intArrayOf(1, 3, 4, 1, 5)))
    }

    @Test
    fun wholeArrayIsPalindrome() {
        assertEquals(1, solution.minimumMoves(intArrayOf(1, 2, 3, 2, 1)))
        assertEquals(1, solution.minimumMoves(intArrayOf(1, 4, 4, 1)))
    }

    @Test
    fun repeatedValues() {
        assertEquals(1, solution.minimumMoves(intArrayOf(5, 5, 5)))
        assertEquals(2, solution.minimumMoves(intArrayOf(1, 2, 1, 2)))
    }

    @Test
    fun noMerging() {
        assertEquals(1, solution.minimumMoves(intArrayOf(7)))
        assertEquals(3, solution.minimumMoves(intArrayOf(1, 2, 3)))
    }
}
