package findthedifferenceoftwoarrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheDifferenceOfTwoArraysTest {
    @Test
    fun findsBothDistinctDifferences() {
        val result = Solution().findDifference(intArrayOf(1, 2, 3), intArrayOf(2, 4, 6))
        assertEquals(setOf(1, 3), result[0].toSet())
        assertEquals(setOf(4, 6), result[1].toSet())
    }

    @Test
    fun removesDuplicatesAndHandlesEmptyResult() {
        val result = Solution().findDifference(intArrayOf(1, 2, 3, 3), intArrayOf(1, 1, 2, 2))
        assertEquals(setOf(3), result[0].toSet())
        assertTrue(result[1].isEmpty())
    }

    @Test
    fun handlesDisjointArraysWithNegatives() {
        val result = Solution().findDifference(intArrayOf(-1, -1, 2), intArrayOf(3, 4))
        assertEquals(setOf(-1, 2), result[0].toSet())
        assertEquals(setOf(3, 4), result[1].toSet())
    }
}
