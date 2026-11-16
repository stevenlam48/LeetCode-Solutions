package waystomakeafairarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WaysToMakeAFairArrayTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(1, solution.waysToMakeFair(intArrayOf(2, 1, 6, 4)))
    }

    @Test
    fun example2() {
        assertEquals(3, solution.waysToMakeFair(intArrayOf(1, 1, 1)))
    }

    @Test
    fun example3() {
        assertEquals(0, solution.waysToMakeFair(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, solution.waysToMakeFair(intArrayOf(1)))
    }

    @Test
    fun twoElements() {
        assertEquals(0, solution.waysToMakeFair(intArrayOf(1, 1)))
    }

    @Test
    fun negatives() {
        assertEquals(1, solution.waysToMakeFair(intArrayOf(-2, 1, 3, -1)))
        assertEquals(0, solution.waysToMakeFair(intArrayOf(-1, 1, -1, 1)))
    }
}
