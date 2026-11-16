package adjacentincreasingsubarraysdetectionii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AdjacentIncreasingSubarraysDetectionIiTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(3, solution.maxIncreasingSubarrays(intArrayOf(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)))
    }

    @Test
    fun secondExample() {
        assertEquals(2, solution.maxIncreasingSubarrays(intArrayOf(1, 2, 3, 4, 4, 4, 4, 5, 6, 7)))
    }

    @Test
    fun singleIncreasingRun() {
        assertEquals(3, solution.maxIncreasingSubarrays(intArrayOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun decreasingInput() {
        assertEquals(1, solution.maxIncreasingSubarrays(intArrayOf(5, 4, 3, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, solution.maxIncreasingSubarrays(intArrayOf(7)))
    }
}
