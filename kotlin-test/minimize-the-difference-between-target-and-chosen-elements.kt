package minimizethedifferencebetweentargetandchosenelements

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimizeTheDifferenceBetweenTargetAndChosenElementsTest {
    private val solution = Solution()

    @Test
    fun matchesTargetExactlyAcrossRows() {
        val mat = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertEquals(0, solution.minimizeTheDifference(mat, 13))
    }

    @Test
    fun returnsMinimumSumMinusTargetWhenTargetIsTooSmall() {
        val mat = arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3))
        assertEquals(94, solution.minimizeTheDifference(mat, 100))
    }

    @Test
    fun choosesClosestValueInSingleRow() {
        val mat = arrayOf(intArrayOf(1, 2, 9, 8, 7))
        assertEquals(1, solution.minimizeTheDifference(mat, 6))
    }

    @Test
    fun choosesClosestReachableSumWhenNoExactMatchExists() {
        val mat = arrayOf(intArrayOf(1, 4), intArrayOf(2, 8))
        assertEquals(1, solution.minimizeTheDifference(mat, 7))
    }
}
