package findthescoredifferenceinagame

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheScoreDifferenceInAGameTest {
    private val solution = Solution()

    @Test
    fun mixedOddAndEvenValues() {
        assertEquals(-5, solution.scoreDifference(intArrayOf(2, 1, 2, 6, 2, 4)))
    }

    @Test
    fun oddValuesToggleTheSign() {
        assertEquals(0, solution.scoreDifference(intArrayOf(1, 2, 3)))
    }

    @Test
    fun sixthElementAlsoTogglesTheSign() {
        assertEquals(6, solution.scoreDifference(intArrayOf(2, 2, 2, 2, 2, 2, 2)))
    }

    @Test
    fun negativeOddValuesFollowTheSameRules() {
        assertEquals(0, solution.scoreDifference(intArrayOf(-1, -2, -3)))
    }

    @Test
    fun emptyInputHasZeroDifference() {
        assertEquals(0, solution.scoreDifference(intArrayOf()))
    }
}
