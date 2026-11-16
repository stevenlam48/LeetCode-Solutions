package numberofsubmatricesthatsumtotarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubmatricesThatSumToTargetTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        val matrix = arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 0))
        assertEquals(4, solution.numSubmatrixSumTarget(matrix, 0))
    }

    @Test
    fun exampleTwo() {
        val matrix = arrayOf(intArrayOf(1, -1), intArrayOf(-1, 1))
        assertEquals(5, solution.numSubmatrixSumTarget(matrix, 0))
    }

    @Test
    fun exampleThree() {
        assertEquals(0, solution.numSubmatrixSumTarget(arrayOf(intArrayOf(904)), 0))
    }

    @Test
    fun tallMatrix() {
        val matrix = arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3))
        assertEquals(2, solution.numSubmatrixSumTarget(matrix, 3))
    }
}
