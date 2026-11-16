package totaldistancetraveled

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalDistanceTraveledTest {
    @Test
    fun example() {
        assertEquals(60, Solution().distanceTraveled(5, 10))
    }

    @Test
    fun noRefill() {
        assertEquals(10, Solution().distanceTraveled(1, 2))
    }

    @Test
    fun notEnoughForRefill() {
        assertEquals(40, Solution().distanceTraveled(4, 1))
    }

    @Test
    fun singleRefill() {
        assertEquals(100, Solution().distanceTraveled(9, 1))
    }
}
