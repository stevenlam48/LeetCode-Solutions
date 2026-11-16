package countsubarrayswithdistantsums

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSubarraysWithDistantSumsTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(4L, solution.distantSubarrays(intArrayOf(1, 2, 3), 3, 1))
    }

    @Test
    fun zeroK() {
        assertEquals(3L, solution.distantSubarrays(intArrayOf(1, 2), 5, 0))
    }

    @Test
    fun singleElementClose() {
        assertEquals(0L, solution.distantSubarrays(intArrayOf(5), 5, 1))
    }

    @Test
    fun singleElementZeroK() {
        assertEquals(1L, solution.distantSubarrays(intArrayOf(5), 5, 0))
    }

    @Test
    fun largeK() {
        assertEquals(1L, solution.distantSubarrays(intArrayOf(1, 2, 3), 3, 3))
    }
}
