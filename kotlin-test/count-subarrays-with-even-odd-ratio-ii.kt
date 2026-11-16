package countsubarrayswithevenoddratioii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountSubarraysWithEvenOddRatioIITest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(7L, solution.countRatioSubarrays(intArrayOf(1, 2, 3, 4), 1, 1))
    }

    @Test
    fun twoElements() {
        assertEquals(2L, solution.countRatioSubarrays(intArrayOf(1, 2), 2, 1))
    }

    @Test
    fun allOdd() {
        assertEquals(3L, solution.countRatioSubarrays(intArrayOf(1, 1), 1, 1))
    }

    @Test
    fun allEven() {
        assertEquals(0L, solution.countRatioSubarrays(intArrayOf(2, 2), 1, 1))
    }

    @Test
    fun largeWeights() {
        assertEquals(2L, solution.countRatioSubarrays(intArrayOf(1, 2), 1_000_000_000, 1_000_000_000))
    }
}
