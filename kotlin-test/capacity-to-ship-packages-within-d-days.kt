package capacitytoshippackageswithinddays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CapacityToShipPackagesWithinDDaysTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(15, solution.shipWithinDays(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 5))
    }

    @Test
    fun testExample2() {
        assertEquals(6, solution.shipWithinDays(intArrayOf(3, 2, 2, 4, 1, 4), 3))
    }

    @Test
    fun testExample3() {
        assertEquals(3, solution.shipWithinDays(intArrayOf(1, 2, 3, 1, 1), 4))
    }

    @Test
    fun testSinglePackage() {
        assertEquals(5, solution.shipWithinDays(intArrayOf(5), 1))
    }

    @Test
    fun testOneDay() {
        assertEquals(10, solution.shipWithinDays(intArrayOf(1, 2, 3, 4), 1))
    }
}
