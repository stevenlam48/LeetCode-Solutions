package maximizesumofdeviceratings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeSumOfDeviceRatingsTest {
    @Test
    fun example() {
        assertEquals(5L, Solution().maxRatings(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))))
    }

    @Test
    fun singleColumn() {
        assertEquals(24L, Solution().maxRatings(arrayOf(intArrayOf(7), intArrayOf(8), intArrayOf(9))))
    }

    @Test
    fun duplicates() {
        assertEquals(10L, Solution().maxRatings(arrayOf(intArrayOf(5, 5), intArrayOf(5, 5))))
    }

    @Test
    fun threeColumns() {
        assertEquals(6L, Solution().maxRatings(arrayOf(intArrayOf(2, 3, 4), intArrayOf(1, 5, 6))))
    }
}
