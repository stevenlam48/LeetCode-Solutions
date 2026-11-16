package pizzawith3nslices

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PizzaWith3nSlicesTest {
    @Test
    fun sixSlices() {
        assertEquals(10, Solution().maxSizeSlices(intArrayOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun threeSlices() {
        assertEquals(7, Solution().maxSizeSlices(intArrayOf(7, 2, 5)))
    }

    @Test
    fun unequalValues() {
        assertEquals(16, Solution().maxSizeSlices(intArrayOf(8, 9, 8, 6, 1, 1)))
    }

    @Test
    fun repeatedValues() {
        assertEquals(8, Solution().maxSizeSlices(intArrayOf(4, 1, 4, 1, 4, 1)))
    }
}
