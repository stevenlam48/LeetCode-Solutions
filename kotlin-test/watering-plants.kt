package wateringplants

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WateringPlantsTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(14, solution.wateringPlants(intArrayOf(2, 2, 3, 3), 5))
    }

    @Test
    fun example2() {
        assertEquals(30, solution.wateringPlants(intArrayOf(1, 1, 1, 4, 2, 3), 4))
    }

    @Test
    fun refillEveryPlant() {
        assertEquals(49, solution.wateringPlants(intArrayOf(7, 7, 7, 7, 7, 7, 7), 8))
    }

    @Test
    fun singlePlant() {
        assertEquals(1, solution.wateringPlants(intArrayOf(3), 5))
    }

    @Test
    fun noRefillNeeded() {
        assertEquals(3, solution.wateringPlants(intArrayOf(1, 1, 1), 10))
    }
}
