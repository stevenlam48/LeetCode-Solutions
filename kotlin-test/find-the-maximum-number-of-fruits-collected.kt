package findthemaximumnumberoffruitscollected

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMaximumNumberOfFruitsCollectedTest {
    @Test
    fun example1() {
        val fruits = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 8, 7),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
        assertEquals(100, Solution().maxCollectedFruits(fruits))
    }

    @Test
    fun example2() {
        val fruits = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        assertEquals(4, Solution().maxCollectedFruits(fruits))
    }

    @Test
    fun threeByThree() {
        val fruits = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertEquals(39, Solution().maxCollectedFruits(fruits))
    }
}
