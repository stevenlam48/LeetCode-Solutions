package maximumtotalbeautyofthegardens

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalBeautyOfTheGardensTest {
    private val solution = Solution()

    @Test
    fun completeOneFlower() {
        assertEquals(4L, solution.maximumBeauty(intArrayOf(2, 4, 5, 3), 1L, 6, 2, 1))
    }

    @Test
    fun raisePartialFlowers() {
        assertEquals(9L, solution.maximumBeauty(intArrayOf(1, 3, 1, 1), 7L, 6, 2, 3))
    }

    @Test
    fun allAlreadyFull() {
        assertEquals(6L, solution.maximumBeauty(intArrayOf(6, 6, 6), 0L, 6, 2, 1))
    }

    @Test
    fun singleFlower() {
        assertEquals(1L, solution.maximumBeauty(intArrayOf(1), 0L, 2, 1, 1))
    }

    @Test
    fun twoPartialFlowers() {
        assertEquals(2L, solution.maximumBeauty(intArrayOf(2, 2), 0L, 3, 1, 1))
    }
}
