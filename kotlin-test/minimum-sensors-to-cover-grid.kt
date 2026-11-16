package minimumsensorstocovergrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumSensorsToCoverGridTest {
    @Test
    fun singleCell() {
        assertEquals(1, Solution().minSensors(1, 1, 0))
    }

    @Test
    fun exactCoverage() {
        assertEquals(1, Solution().minSensors(3, 3, 1))
    }

    @Test
    fun twoByTwoSensors() {
        assertEquals(4, Solution().minSensors(4, 4, 1))
    }

    @Test
    fun noRange() {
        assertEquals(6, Solution().minSensors(2, 3, 0))
    }

    @Test
    fun largeRange() {
        assertEquals(1, Solution().minSensors(5, 5, 2))
    }
}
