package graphconnectivitywiththreshold

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class GraphConnectivityWithThresholdTest {
    @Test
    fun `standard example`() {
        val queries = arrayOf(intArrayOf(1, 4), intArrayOf(2, 5), intArrayOf(3, 6))
        assertArrayEquals(booleanArrayOf(false, false, true), Solution().areConnected(6, 2, queries))
    }

    @Test
    fun `multiple connectivity paths`() {
        val queries = arrayOf(intArrayOf(1, 4), intArrayOf(2, 3), intArrayOf(3, 6), intArrayOf(2, 5))
        assertArrayEquals(booleanArrayOf(false, true, true, false), Solution().areConnected(6, 1, queries))
    }

    @Test
    fun `zero and high thresholds`() {
        val solution = Solution()
        assertArrayEquals(booleanArrayOf(true, true), solution.areConnected(5, 0, arrayOf(intArrayOf(1, 5), intArrayOf(2, 3))))
        assertArrayEquals(booleanArrayOf(true, false), solution.areConnected(4, 4, arrayOf(intArrayOf(3, 3), intArrayOf(1, 2))))
        assertArrayEquals(BooleanArray(0), solution.areConnected(3, 1, arrayOf()))
    }
}
