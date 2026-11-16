package minimumprefixremovaltomakearraystrictlyincreasing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumPrefixRemovalToMakeArrayStrictlyIncreasingTest {
    private val solution = Solution()

    @Test
    fun `already strictly increasing array needs no removal`() {
        assertEquals(0, solution.minimumPrefixLength(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun `removes prefix before a decreasing adjacent pair`() {
        assertEquals(2, solution.minimumPrefixLength(intArrayOf(2, 3, 1, 2)))
    }

    @Test
    fun `equal adjacent values break strict increase`() {
        assertEquals(2, solution.minimumPrefixLength(intArrayOf(1, 2, 2, 3)))
    }

    @Test
    fun `single element is strictly increasing`() {
        assertEquals(0, solution.minimumPrefixLength(intArrayOf(7)))
    }

    @Test
    fun `strictly decreasing array leaves only last element`() {
        assertEquals(2, solution.minimumPrefixLength(intArrayOf(5, 4, 3)))
    }
}
