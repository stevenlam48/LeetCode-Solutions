package findthenumberofkevenarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheNumberOfKEvenArraysTest {
    @Test
    fun singleElementCanUseAnyValue() {
        assertEquals(5, Solution().countOfArrays(1, 5, 0))
    }

    @Test
    fun oneEvenAdjacencyWithTwoValues() {
        assertEquals(2, Solution().countOfArrays(3, 2, 1))
    }

    @Test
    fun noEvenAdjacency() {
        assertEquals(5, Solution().countOfArrays(3, 2, 0))
    }

    @Test
    fun separateEvenAdjacencies() {
        assertEquals(2, Solution().countOfArrays(4, 2, 2))
    }
}
