package maximizegridhappiness

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeGridHappinessTest {
    @Test
    fun mixedResidentsInTwoByThreeGrid() {
        assertEquals(240, Solution().getMaxGridHappiness(2, 3, 1, 2))
    }

    @Test
    fun mixedResidentsInThreeByOneGrid() {
        assertEquals(260, Solution().getMaxGridHappiness(3, 1, 2, 1))
    }

    @Test
    fun onlyIntroverts() {
        assertEquals(240, Solution().getMaxGridHappiness(2, 2, 4, 0))
    }

    @Test
    fun singleCell() {
        assertEquals(120, Solution().getMaxGridHappiness(1, 1, 1, 0))
    }

    @Test
    fun noResidents() {
        assertEquals(0, Solution().getMaxGridHappiness(2, 2, 0, 0))
    }
}
