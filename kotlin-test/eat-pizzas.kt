package eatpizzas

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EatPizzasTest {
    @Test
    fun example() {
        assertEquals(14L, Solution().maxWeight(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)))
    }

    @Test
    fun duplicates() {
        assertEquals(3L, Solution().maxWeight(intArrayOf(2, 1, 1, 1, 1, 1, 1, 1)))
    }

    @Test
    fun oneDay() {
        assertEquals(4L, Solution().maxWeight(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun threeDays() {
        assertEquals(32L, Solution().maxWeight(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)))
    }
}
