package wateringplantsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WateringPlantsIiTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(0, solution.minimumRefill(intArrayOf(2, 2, 3, 3), 5, 10))
    }

    @Test
    fun example2() {
        assertEquals(2, solution.minimumRefill(intArrayOf(2, 2, 3, 3), 3, 4))
    }

    @Test
    fun singlePlantFitsOneCan() {
        assertEquals(0, solution.minimumRefill(intArrayOf(5), 10, 8))
        assertEquals(0, solution.minimumRefill(intArrayOf(5), 5, 3))
    }

    @Test
    fun singlePlantNeedsRefill() {
        assertEquals(1, solution.minimumRefill(intArrayOf(6), 5, 5))
    }

    @Test
    fun bothGardenersRefill() {
        assertEquals(2, solution.minimumRefill(intArrayOf(1, 2, 4, 4, 5), 6, 5))
    }
}
