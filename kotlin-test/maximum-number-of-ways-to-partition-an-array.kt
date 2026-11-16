package maximumnumberofwaystopartitionanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumnumberofwaystopartitionanarrayTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().waysToPartition(intArrayOf(2, -1, 2), 3))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().waysToPartition(intArrayOf(0, 0, 0), 0))
    }

    @Test
    fun changingOneElementGainsNothing() {
        assertEquals(1, Solution().waysToPartition(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun allOnes() {
        assertEquals(1, Solution().waysToPartition(intArrayOf(1, 1, 1), 2))
    }
}
