package lengthofthelongestincreasingpath

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LengthOfTheLongestIncreasingPathTest {
    @Test
    fun example1() {
        val coordinates = arrayOf(
            intArrayOf(3, 1),
            intArrayOf(2, 2),
            intArrayOf(4, 1),
            intArrayOf(0, 0),
            intArrayOf(5, 3)
        )
        assertEquals(3, Solution().maxPathLength(coordinates, 1))
    }

    @Test
    fun singlePoint() {
        val coordinates = arrayOf(intArrayOf(1, 1))
        assertEquals(1, Solution().maxPathLength(coordinates, 0))
    }

    @Test
    fun pathThroughTarget() {
        val coordinates = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
            intArrayOf(2, 2)
        )
        assertEquals(3, Solution().maxPathLength(coordinates, 1))
    }

    @Test
    fun equalXRequiresYDescendingOrder() {
        val coordinates = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(2, 4),
            intArrayOf(3, 4)
        )
        assertEquals(3, Solution().maxPathLength(coordinates, 0))
    }
}
