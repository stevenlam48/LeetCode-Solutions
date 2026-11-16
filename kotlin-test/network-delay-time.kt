package networkdelaytime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NetworkDelayTimeTest {
    @Test
    fun `returns time needed for all nodes to receive signal`() {
        val times = arrayOf(intArrayOf(2, 1, 1), intArrayOf(2, 3, 1), intArrayOf(3, 4, 1))
        assertEquals(2, Solution().networkDelayTime(times, 4, 2))
    }

    @Test
    fun `returns delay for two nodes`() {
        assertEquals(1, Solution().networkDelayTime(arrayOf(intArrayOf(1, 2, 1)), 2, 1))
    }

    @Test
    fun `returns minus one when a node is unreachable`() {
        assertEquals(-1, Solution().networkDelayTime(arrayOf(intArrayOf(1, 2, 1)), 2, 2))
    }

    @Test
    fun `chooses shortest path among alternatives`() {
        val times = arrayOf(
            intArrayOf(1, 2, 9),
            intArrayOf(1, 3, 2),
            intArrayOf(3, 2, 3),
            intArrayOf(2, 4, 1),
            intArrayOf(3, 4, 8)
        )
        assertEquals(6, Solution().networkDelayTime(times, 4, 1))
    }
}
