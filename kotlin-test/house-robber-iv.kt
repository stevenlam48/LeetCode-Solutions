package houserobberiv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HouseRobberIvTest {
    @Test
    fun firstStandardExample() {
        assertEquals(5, Solution().minCapability(intArrayOf(2, 3, 5, 9), 2))
    }

    @Test
    fun secondStandardExample() {
        assertEquals(2, Solution().minCapability(intArrayOf(2, 7, 9, 3, 1), 2))
    }

    @Test
    fun duplicateValues() {
        assertEquals(4, Solution().minCapability(intArrayOf(4, 4, 4, 4), 2))
    }

    @Test
    fun greedySelectionMatters() {
        assertEquals(3, Solution().minCapability(intArrayOf(5, 3, 3, 5, 1), 2))
    }

    @Test
    fun singleHouse() {
        assertEquals(7, Solution().minCapability(intArrayOf(7), 1))
    }
}
