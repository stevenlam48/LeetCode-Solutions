package minimumoperationstoachieveatleastkpeaks

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumOperationsToAchieveAtLeastKPeaksTest {

    @Test
    fun testAlreadyPeaks() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 2, 1, 2), 2))
    }

    @Test
    fun testUniformArray() {
        assertEquals(1, Solution().minOperations(intArrayOf(1, 1, 1, 1), 1))
        assertEquals(2, Solution().minOperations(intArrayOf(1, 1, 1, 1), 2))
    }

    @Test
    fun testCircularNeighbor() {
        assertEquals(1, Solution().minOperations(intArrayOf(3, 1, 3), 1))
        assertEquals(0, Solution().minOperations(intArrayOf(1, 5, 1), 1))
    }

    @Test
    fun testImpossible() {
        assertEquals(-1, Solution().minOperations(intArrayOf(1, 5, 1), 2))
        assertEquals(-1, Solution().minOperations(intArrayOf(1, 2, 3, 4), 3))
    }

    @Test
    fun testZeroPeaks() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 1, 1), 0))
    }

    @Test
    fun testMixedValues() {
        assertEquals(2, Solution().minOperations(intArrayOf(1, 2, 3, 4, 5), 2))
    }
}
