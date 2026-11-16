package minimumnumberoftapstoopentowateragarden

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfTapsToOpenToWaterAGardenTest {
    private val solution = Solution()

    @Test
    fun singleTapCoversGarden() {
        assertEquals(1, solution.minTaps(5, intArrayOf(3, 4, 1, 1, 0, 0)))
    }

    @Test
    fun gardenCannotBeCovered() {
        assertEquals(-1, solution.minTaps(3, intArrayOf(0, 0, 0, 0)))
    }

    @Test
    fun twoTapsAreRequired() {
        assertEquals(2, solution.minTaps(5, intArrayOf(2, 0, 0, 2, 0, 0)))
    }

    @Test
    fun gapBetweenCoverageAreas() {
        assertEquals(-1, solution.minTaps(5, intArrayOf(2, 0, 0, 0, 0, 0)))
    }

    @Test
    fun zeroLengthGarden() {
        assertEquals(0, solution.minTaps(0, intArrayOf(0)))
    }
}
