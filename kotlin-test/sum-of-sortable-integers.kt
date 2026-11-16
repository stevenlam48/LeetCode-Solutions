package sumofsortableintegers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfSortableIntegersTest {
    private val solution = Solution()

    @Test
    fun sortedArrayAllowsEveryDivisorTested() {
        assertEquals(7, solution.sortableIntegers(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun rotatedArrayAllowsFullLengthOnly() {
        assertEquals(3, solution.sortableIntegers(intArrayOf(3, 1, 2)))
    }

    @Test
    fun multipleCircularDescentsAreRejected() {
        assertEquals(0, solution.sortableIntegers(intArrayOf(2, 1, 3)))
    }

    @Test
    fun duplicateValuesDoNotCountAsDescents() {
        assertEquals(4, solution.sortableIntegers(intArrayOf(1, 1, 1)))
    }

    @Test
    fun incompatibleBlocksAreRejected() {
        assertEquals(0, solution.sortableIntegers(intArrayOf(1, 3, 2, 4)))
    }
}
