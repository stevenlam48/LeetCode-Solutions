package minimumroundstocompletealltasks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumRoundsToCompleteAllTasksTest {
    @Test
    fun example1() {
        assertEquals(4, Solution().minimumRounds(intArrayOf(2, 2, 3, 3, 2, 4, 4, 4, 4, 4)))
    }

    @Test
    fun impossible() {
        assertEquals(-1, Solution().minimumRounds(intArrayOf(2, 3, 3)))
    }

    @Test
    fun groupOfSix() {
        assertEquals(2, Solution().minimumRounds(intArrayOf(5, 5, 5, 5, 5, 5)))
    }

    @Test
    fun singleTask() {
        assertEquals(-1, Solution().minimumRounds(intArrayOf(7)))
    }

    @Test
    fun groupOfTwo() {
        assertEquals(1, Solution().minimumRounds(intArrayOf(1, 1)))
    }
}
