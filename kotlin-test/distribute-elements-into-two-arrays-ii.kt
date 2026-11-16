package distributeelementsintotwoarraysii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DistributeElementsIntoTwoArraysIiTest {
    private val solution = Solution()

    @Test
    fun duplicatesUseSizeTieBreaker() {
        assertArrayEquals(intArrayOf(2, 3, 1, 3), solution.resultArray(intArrayOf(2, 1, 3, 3)))
    }

    @Test
    fun compareGreaterCounts() {
        assertArrayEquals(intArrayOf(5, 3, 4, 2, 1), solution.resultArray(intArrayOf(5, 1, 3, 4, 2)))
    }

    @Test
    fun negativeNumbers() {
        assertArrayEquals(intArrayOf(-1, 0, -2), solution.resultArray(intArrayOf(-1, -2, 0)))
    }
}
