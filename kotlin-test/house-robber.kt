package houserobber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HouseRobberTest {
    @Test
    fun firstStandardExample() {
        assertEquals(4, Solution().rob(intArrayOf(1, 2, 3, 1)))
    }

    @Test
    fun secondStandardExample() {
        assertEquals(12, Solution().rob(intArrayOf(2, 7, 9, 3, 1)))
    }

    @Test
    fun emptyAndSingleHouse() {
        assertEquals(0, Solution().rob(intArrayOf()))
        assertEquals(7, Solution().rob(intArrayOf(7)))
    }

    @Test
    fun alternatingChoices() {
        assertEquals(20, Solution().rob(intArrayOf(10, 1, 1, 10)))
    }

    @Test
    fun negativeValuesCanBeSkipped() {
        assertEquals(0, Solution().rob(intArrayOf(-3, -2, -1)))
    }
}
