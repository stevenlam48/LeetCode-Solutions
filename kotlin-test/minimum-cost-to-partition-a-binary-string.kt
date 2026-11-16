package minimumcosttopartitionabinarystring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToPartitionABinaryStringTest {
    @Test
    fun example1() {
        assertEquals(8L, Solution().minCost("1010", 2, 5))
    }

    @Test
    fun allZeros() {
        assertEquals(3L, Solution().minCost("0", 1, 3))
    }

    @Test
    fun singleOne() {
        assertEquals(5L, Solution().minCost("1", 5, 2))
    }

    @Test
    fun twoZeros() {
        assertEquals(3L, Solution().minCost("00", 1, 3))
    }

    @Test
    fun allOnes() {
        assertEquals(4L, Solution().minCost("1111", 1, 100))
    }

    @Test
    fun splitBeatsWhole() {
        assertEquals(4L, Solution().minCost("10", 3, 1))
    }
}
