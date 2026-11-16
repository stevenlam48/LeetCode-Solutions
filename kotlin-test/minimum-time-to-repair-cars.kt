package minimumtimetorepaircars

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumTimeToRepairCarsTest {
    @Test
    fun differentRanks() {
        assertEquals(16L, Solution().repairCars(intArrayOf(4, 2, 3, 1), 10))
    }

    @Test
    fun repeatedRepairs() {
        assertEquals(16L, Solution().repairCars(intArrayOf(5, 1, 8), 6))
    }

    @Test
    fun oneMechanic() {
        assertEquals(25L, Solution().repairCars(intArrayOf(1), 5))
    }

    @Test
    fun duplicateRanks() {
        assertEquals(8L, Solution().repairCars(intArrayOf(2, 2), 4))
    }
}
