package minimumspeedtoarriveontime

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumSpeedToArriveOnTimeTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().minSpeedOnTime(intArrayOf(1, 3, 2), 6.0))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().minSpeedOnTime(intArrayOf(1, 3, 2), 2.7))
    }

    @Test
    fun example3() {
        assertEquals(-1, Solution().minSpeedOnTime(intArrayOf(1, 3, 2), 0.5))
    }

    @Test
    fun singleRoad() {
        assertEquals(2, Solution().minSpeedOnTime(intArrayOf(3), 1.5))
    }

    @Test
    fun maximumSpeedExactlyArrives() {
        assertEquals(10_000_000, Solution().minSpeedOnTime(intArrayOf(1, 1, 100_000), 2.01))
    }
}
