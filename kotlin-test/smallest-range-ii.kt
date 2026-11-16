package smallestrangeii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestRangeIITest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals(0, solution.smallestRangeII(intArrayOf(1), 0))
        assertEquals(6, solution.smallestRangeII(intArrayOf(0, 10), 2))
        assertEquals(3, solution.smallestRangeII(intArrayOf(1, 3, 6), 3))
    }

    @Test
    fun unsortedInput() {
        assertEquals(1, solution.smallestRangeII(intArrayOf(4, 1, 2), 1))
    }

    @Test
    fun largeAdjustment() {
        assertEquals(5, solution.smallestRangeII(intArrayOf(2, 7, 2), 5))
    }
}
