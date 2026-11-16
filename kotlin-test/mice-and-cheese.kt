package miceandcheese

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MiceAndCheeseTest {
    @Test
    fun example1() {
        assertEquals(15, Solution().miceAndCheese(intArrayOf(1, 1, 3, 4), intArrayOf(4, 4, 1, 1), 2))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().miceAndCheese(intArrayOf(1, 1), intArrayOf(1, 1), 2))
    }

    @Test
    fun picksBestSingleCheese() {
        assertEquals(7, Solution().miceAndCheese(intArrayOf(1, 3), intArrayOf(4, 1), 1))
    }

    @Test
    fun allFromFirst() {
        assertEquals(6, Solution().miceAndCheese(intArrayOf(1, 2, 3), intArrayOf(5, 5, 5), 3))
    }
}
