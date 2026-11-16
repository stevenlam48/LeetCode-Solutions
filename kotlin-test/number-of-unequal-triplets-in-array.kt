package numberofunequaltripletsinarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfUnequalTripletsInArrayTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(3, solution.unequalTriplets(intArrayOf(4, 4, 2, 4, 3)))
    }

    @Test
    fun exampleTwo() {
        assertEquals(0, solution.unequalTriplets(intArrayOf(1, 1, 1, 1, 1)))
    }

    @Test
    fun allDistinct() {
        assertEquals(1, solution.unequalTriplets(intArrayOf(1, 2, 3)))
    }

    @Test
    fun negativeValuesAndEmpty() {
        assertEquals(2, solution.unequalTriplets(intArrayOf(-1, 0, -1, 1)))
        assertEquals(0, solution.unequalTriplets(intArrayOf()))
    }
}
