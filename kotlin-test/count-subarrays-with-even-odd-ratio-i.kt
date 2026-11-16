package countsubarrayswithevenoddratioi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSubarraysWithEvenOddRatioITest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(7, solution.countRatioSubarrays(intArrayOf(1, 2, 3, 4), 1, 1))
    }

    @Test
    fun twoElements() {
        assertEquals(2, solution.countRatioSubarrays(intArrayOf(1, 2), 2, 1))
    }

    @Test
    fun allOdd() {
        assertEquals(3, solution.countRatioSubarrays(intArrayOf(1, 1), 1, 1))
    }

    @Test
    fun allEven() {
        assertEquals(0, solution.countRatioSubarrays(intArrayOf(2, 2), 1, 1))
    }
}
