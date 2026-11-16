package minmaxgame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinMaxGameTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().minMaxGame(intArrayOf(1, 3, 5, 2, 4, 8, 2, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(3, Solution().minMaxGame(intArrayOf(3)))
    }

    @Test
    fun twoElements() {
        assertEquals(1, Solution().minMaxGame(intArrayOf(1, 2)))
    }

    @Test
    fun fourElements() {
        assertEquals(1, Solution().minMaxGame(intArrayOf(5, 1, 2, 4)))
    }
}
