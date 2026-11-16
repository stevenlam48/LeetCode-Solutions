package maximumcaloriesburntfromjumps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumCaloriesBurntFromJumpsTest {
    @Test
    fun example() {
        assertEquals(14L, Solution().maxCaloriesBurnt(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleHeight() {
        assertEquals(1L, Solution().maxCaloriesBurnt(intArrayOf(1)))
    }

    @Test
    fun withNegativeHeight() {
        assertEquals(13L, Solution().maxCaloriesBurnt(intArrayOf(-1, 2)))
    }

    @Test
    fun flatHeights() {
        assertEquals(0L, Solution().maxCaloriesBurnt(intArrayOf(0, 0)))
    }

    @Test
    fun descendingInput() {
        assertEquals(30L, Solution().maxCaloriesBurnt(intArrayOf(5, 4, 3)))
    }
}
