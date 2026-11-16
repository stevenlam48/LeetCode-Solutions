package findtheminimumareatocoverallonesi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMinimumAreaToCoverAllOnesITest {
    @Test
    fun example1() {
        val grid = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(1, 0, 1)
        )
        assertEquals(6, Solution().minimumArea(grid))
    }

    @Test
    fun example2() {
        val grid = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 0)
        )
        assertEquals(1, Solution().minimumArea(grid))
    }

    @Test
    fun singleCell() {
        assertEquals(1, Solution().minimumArea(arrayOf(intArrayOf(1))))
    }
}
