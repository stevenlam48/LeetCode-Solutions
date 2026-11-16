package minimumnumberofoperationstosatisfyconditions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToSatisfyConditionsTest {
    private val solution = Solution()

    @Test
    fun alreadySatisfied() {
        val grid = arrayOf(
            intArrayOf(1, 0, 2),
            intArrayOf(1, 0, 2)
        )
        assertEquals(0, solution.minimumOperations(grid))
    }

    @Test
    fun secondExample() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 0)
        )
        assertEquals(3, solution.minimumOperations(grid))
    }

    @Test
    fun singleColumn() {
        val grid = arrayOf(
            intArrayOf(1),
            intArrayOf(2),
            intArrayOf(3)
        )
        assertEquals(2, solution.minimumOperations(grid))
    }

    @Test
    fun singleRow() {
        val grid = arrayOf(intArrayOf(1, 1, 1, 0, 0))
        assertEquals(2, solution.minimumOperations(grid))
    }

    @Test
    fun singleCell() {
        val grid = arrayOf(intArrayOf(7))
        assertEquals(0, solution.minimumOperations(grid))
    }
}
