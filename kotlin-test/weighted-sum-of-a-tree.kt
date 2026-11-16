package weightedsumofatree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WeightedSumOfATreeTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(17L, solution.weightedSum(intArrayOf(-1, 0, 0, 1), intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun example2() {
        assertEquals(12L, solution.weightedSum(intArrayOf(-1, 0, 0, 0), intArrayOf(2, 1, 3, 4)))
    }

    @Test
    fun singleNode() {
        assertEquals(5L, solution.weightedSum(intArrayOf(-1), intArrayOf(5)))
    }

    @Test
    fun chain() {
        assertEquals(15L, solution.weightedSum(intArrayOf(-1, 0, 1, 2, 3), intArrayOf(1, 1, 1, 1, 1)))
    }

    @Test
    fun zeroWeights() {
        assertEquals(0L, solution.weightedSum(intArrayOf(-1, 0, 1), intArrayOf(0, 0, 0)))
    }
}
