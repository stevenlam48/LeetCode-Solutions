package maximizethebeautyofthegarden

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeTheBeautyOfTheGardenTest {
    @Test
    fun example() {
        assertEquals(8, Solution().maximumBeauty(intArrayOf(1, 2, 3, 1, 2)))
    }

    @Test
    fun repeatedPositiveOne() {
        assertEquals(3, Solution().maximumBeauty(intArrayOf(100, 1, 1, 1)))
    }

    @Test
    fun zeroValue() {
        assertEquals(1, Solution().maximumBeauty(intArrayOf(0, 1, 0)))
    }

    @Test
    fun negativeValues() {
        assertEquals(-2, Solution().maximumBeauty(intArrayOf(-1, -2, -3, -2, -1)))
    }
}
