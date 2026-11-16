package determinewhethermatrixcanbeobtainedbyrotation

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DetermineWhetherMatrixCanBeObtainedByRotationTest {
    private val solution = Solution()

    @Test
    fun ninetyDegreeRotationMatches() {
        val mat = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
        val target = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
        assertTrue(solution.findRotation(mat, target))
    }

    @Test
    fun noRotationMatches() {
        val mat = arrayOf(intArrayOf(0, 1), intArrayOf(1, 1))
        val target = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
        assertFalse(solution.findRotation(mat, target))
    }

    @Test
    fun oneHundredEightyDegreeRotationMatches() {
        val mat = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1)
        )
        val target = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 0)
        )
        assertTrue(solution.findRotation(mat, target))
    }

    @Test
    fun zeroDegreeRotationMatches() {
        val mat = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        assertTrue(solution.findRotation(mat, mat))
    }

    @Test
    fun singleElementAlwaysMatchesItself() {
        assertTrue(solution.findRotation(arrayOf(intArrayOf(7)), arrayOf(intArrayOf(7))))
    }
}
