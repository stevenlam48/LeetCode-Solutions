package minimumdifferenceinsumsafterremovalofelements
// Time:  O(nlogn)
// Space: O(n)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDifferenceInSumsAfterRemovalOfElementsTest {
    private val solution = Solution()

    @Test
    fun leetCodeExamples() {
        assertEquals(-1L, solution.minimumDifference(intArrayOf(3, 1, 2)))
        assertEquals(1L, solution.minimumDifference(intArrayOf(7, 9, 5, 8, 1, 3)))
    }

    @Test
    fun negativeDifferenceIsPossible() {
        assertEquals(-8L, solution.minimumDifference(intArrayOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun equalSumsGiveZero() {
        assertEquals(0L, solution.minimumDifference(intArrayOf(2, 2, 2, 2, 2, 2)))
    }
}
