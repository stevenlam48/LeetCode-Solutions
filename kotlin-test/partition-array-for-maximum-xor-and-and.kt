package partitionarrayformaximumxorandand

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PartitionArrayForMaximumXorAndAndTest {
    @Test
    fun testThreeElements() {
        assertEquals(6L, Solution().maximizeXorAndXor(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testTwoEqualElements() {
        assertEquals(4L, Solution().maximizeXorAndXor(intArrayOf(2, 2)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1L, Solution().maximizeXorAndXor(intArrayOf(1)))
    }

    @Test
    fun testZero() {
        assertEquals(0L, Solution().maximizeXorAndXor(intArrayOf(0)))
    }

    @Test
    fun testTwoElements() {
        assertEquals(3L, Solution().maximizeXorAndXor(intArrayOf(1, 2)))
    }
}
