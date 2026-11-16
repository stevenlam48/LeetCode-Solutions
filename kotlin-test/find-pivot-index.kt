package findpivotindex

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindPivotIndexTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(3, solution.pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)))
    }

    @Test
    fun exampleNoPivot() {
        assertEquals(-1, solution.pivotIndex(intArrayOf(1, 2, 3)))
    }

    @Test
    fun exampleLeftmostPivot() {
        assertEquals(0, solution.pivotIndex(intArrayOf(2, 1, -1)))
    }

    @Test
    fun emptyInput() {
        assertEquals(-1, solution.pivotIndex(intArrayOf()))
    }
}
