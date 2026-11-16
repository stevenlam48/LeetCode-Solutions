package relocatemarbles

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RelocateMarblesTest {
    @Test
    fun standardExample() {
        val result = Solution().relocateMarbles(
            intArrayOf(1, 6, 7, 8), intArrayOf(1, 7, 2), intArrayOf(9, 5, 2)
        )
        assertArrayEquals(intArrayOf(2, 5, 6, 8, 9), result)
    }

    @Test
    fun duplicateStartingPositions() {
        val result = Solution().relocateMarbles(
            intArrayOf(1, 1, 3, 5, 7), intArrayOf(1, 3), intArrayOf(2, 4)
        )
        assertArrayEquals(intArrayOf(2, 4, 5, 7), result)
    }

    @Test
    fun destinationIsMovedAgain() {
        val result = Solution().relocateMarbles(intArrayOf(1), intArrayOf(1, 2), intArrayOf(2, 3))
        assertArrayEquals(intArrayOf(3), result)
    }

    @Test
    fun noMoves() {
        val result = Solution().relocateMarbles(intArrayOf(3, 1, 3), intArrayOf(), intArrayOf())
        assertArrayEquals(intArrayOf(1, 3), result)
    }
}
