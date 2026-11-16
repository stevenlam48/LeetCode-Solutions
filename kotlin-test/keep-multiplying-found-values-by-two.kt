package keepmultiplyingfoundvaluesbytwo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KeepMultiplyingFoundValuesByTwoTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(24, solution.findFinalValue(intArrayOf(5, 3, 6, 1, 12), 3))
    }

    @Test
    fun notFound() {
        assertEquals(4, solution.findFinalValue(intArrayOf(2, 7, 9), 4))
    }

    @Test
    fun singleElement() {
        assertEquals(2, solution.findFinalValue(intArrayOf(1), 1))
    }

    @Test
    fun chain() {
        assertEquals(32, solution.findFinalValue(intArrayOf(1, 2, 4, 8, 16), 1))
    }

    @Test
    fun emptyArray() {
        assertEquals(5, solution.findFinalValue(intArrayOf(), 5))
    }

    @Test
    fun stopsAtMissingValue() {
        assertEquals(8, solution.findFinalValue(intArrayOf(2, 4), 4))
    }
}
