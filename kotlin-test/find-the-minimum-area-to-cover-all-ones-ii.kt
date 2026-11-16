package findtheminimumareatocoverallonesii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMinimumAreaToCoverAllOnesIITest {
    @Test
    fun example1() {
        val grid = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(5, Solution().minimumSum(grid))
    }

    @Test
    fun example2() {
        val grid = arrayOf(
            intArrayOf(1, 0, 1, 0),
            intArrayOf(0, 1, 0, 1)
        )
        assertEquals(5, Solution().minimumSum(grid))
    }

    @Test
    fun example3() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertEquals(6, Solution().minimumSum(grid))
    }
}
