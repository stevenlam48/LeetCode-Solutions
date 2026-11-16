package numberofflowersinfullbloom

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NumberOfFlowersInFullBloomTest {
    @Test
    fun testExample1() {
        val flowers = arrayOf(
            intArrayOf(1, 6), intArrayOf(3, 7), intArrayOf(9, 12), intArrayOf(4, 13)
        )
        assertArrayEquals(intArrayOf(1, 2, 2, 2), Solution().fullBloomFlowers(flowers, intArrayOf(2, 3, 7, 11)))
    }

    @Test
    fun testExample2() {
        val flowers = arrayOf(intArrayOf(1, 10), intArrayOf(3, 3))
        assertArrayEquals(intArrayOf(2, 2, 1), Solution().fullBloomFlowers(flowers, intArrayOf(3, 3, 2)))
    }

    @Test
    fun testOutsideAllIntervals() {
        val flowers = arrayOf(intArrayOf(5, 10))
        assertArrayEquals(intArrayOf(0, 0), Solution().fullBloomFlowers(flowers, intArrayOf(1, 11)))
    }
}
