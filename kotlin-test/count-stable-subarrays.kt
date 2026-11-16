package countstablesubarrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountStableSubarraysTest {
    private val solution = Solution()

    @Test
    fun increasing() {
        val result = solution.countStableSubarrays(
            intArrayOf(1, 2, 3),
            arrayOf(intArrayOf(0, 2))
        )
        assertArrayEquals(longArrayOf(6L), result)
    }

    @Test
    fun withDrop() {
        val result = solution.countStableSubarrays(
            intArrayOf(3, 1, 2),
            arrayOf(intArrayOf(0, 2))
        )
        assertArrayEquals(longArrayOf(4L), result)
    }

    @Test
    fun equalElements() {
        val result = solution.countStableSubarrays(
            intArrayOf(1, 1, 1),
            arrayOf(intArrayOf(0, 2), intArrayOf(1, 2))
        )
        assertArrayEquals(longArrayOf(6L, 3L), result)
    }

    @Test
    fun decreasing() {
        val result = solution.countStableSubarrays(
            intArrayOf(2, 1),
            arrayOf(intArrayOf(0, 1))
        )
        assertArrayEquals(longArrayOf(2L), result)
    }

    @Test
    fun singleElement() {
        val result = solution.countStableSubarrays(
            intArrayOf(5),
            arrayOf(intArrayOf(0, 0))
        )
        assertArrayEquals(longArrayOf(1L), result)
    }
}
