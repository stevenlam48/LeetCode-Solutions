package countgoodcyclicrotations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountGoodCyclicRotationsTest {
    private val solution = Solution()

    @Test
    fun countsMixedRotations() {
        assertEquals(2, solution.countGoodRotations(intArrayOf(4, 1, 1, 1)))
    }

    @Test
    fun countsStrictlyGreaterHalfOnly() {
        assertEquals(1, solution.countGoodRotations(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun handlesSingleElement() {
        assertEquals(0, solution.countGoodRotations(intArrayOf(5)))
    }

    @Test
    fun handlesEqualHalves() {
        assertEquals(0, solution.countGoodRotations(intArrayOf(1, 1)))
    }
}
