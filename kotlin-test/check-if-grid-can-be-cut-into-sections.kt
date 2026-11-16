package checkifgridcanbecutintosections

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfGridCanBeCutIntoSectionsTest {
    private val solution = Solution()

    @Test
    fun twoVerticalCuts() {
        assertTrue(solution.checkValidCuts(3, arrayOf(
            intArrayOf(0, 0, 1, 2),
            intArrayOf(2, 0, 3, 2),
            intArrayOf(1, 0, 2, 2)
        )))
    }

    @Test
    fun onlyOneHorizontalCut() {
        assertFalse(solution.checkValidCuts(3, arrayOf(
            intArrayOf(0, 0, 2, 1),
            intArrayOf(0, 2, 2, 3),
            intArrayOf(0, 1, 3, 3)
        )))
    }

    @Test
    fun singleRectangle() {
        assertFalse(solution.checkValidCuts(5, arrayOf(intArrayOf(1, 0, 5, 2))))
    }

    @Test
    fun twoHorizontalCuts() {
        assertTrue(solution.checkValidCuts(4, arrayOf(
            intArrayOf(0, 0, 2, 1),
            intArrayOf(0, 3, 2, 4),
            intArrayOf(0, 1, 2, 2)
        )))
    }
}
