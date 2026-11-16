package maximizetheminimumpoweredcity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeTheMinimumPoweredCityTest {
    @Test
    fun example() {
        assertEquals(5L, Solution().maxPower(intArrayOf(1, 2, 4, 5, 0), 1, 2))
    }

    @Test
    fun singleCity() {
        assertEquals(4L, Solution().maxPower(intArrayOf(1), 0, 3))
    }

    @Test
    fun coversWholeCity() {
        assertEquals(10L, Solution().maxPower(intArrayOf(4, 1, 2), 2, 3))
    }
}
