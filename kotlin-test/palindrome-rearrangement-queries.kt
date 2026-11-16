package palindromerearrangementqueries

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PalindromeRearrangementQueriesTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        val queries = arrayOf(intArrayOf(1, 1, 3, 5), intArrayOf(0, 2, 5, 5))
        assertArrayEquals(booleanArrayOf(true, true), solution.canMakePalindromeQueries("abcabc", queries))
    }

    @Test
    fun impossibleRearrangement() {
        val queries = arrayOf(intArrayOf(0, 2, 7, 9))
        assertArrayEquals(booleanArrayOf(false), solution.canMakePalindromeQueries("abbcdecbba", queries))
    }

    @Test
    fun partiallyOverlappingIntervals() {
        val queries = arrayOf(intArrayOf(0, 1, 3, 4))
        assertArrayEquals(booleanArrayOf(false), solution.canMakePalindromeQueries("aabbba", queries))
    }

    @Test
    fun alreadyPalindromicAndNoQueries() {
        val queries = arrayOf(intArrayOf(0, 1, 2, 3), intArrayOf(0, 0, 3, 3))
        assertArrayEquals(booleanArrayOf(true, true), solution.canMakePalindromeQueries("abba", queries))
        assertArrayEquals(booleanArrayOf(), solution.canMakePalindromeQueries("abba", emptyArray()))
    }
}
