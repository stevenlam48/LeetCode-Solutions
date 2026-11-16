package maximizethetopmostelementafterkmoves

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeTheTopmostElementAfterKMovesTest {
    @Test
    fun example() {
        assertEquals(5, Solution().maximumTop(intArrayOf(5, 2, 2, 4, 0, 6), 4))
    }

    @Test
    fun singleElementOddMoves() {
        assertEquals(-1, Solution().maximumTop(intArrayOf(2), 1))
    }

    @Test
    fun singleElementEvenMoves() {
        assertEquals(2, Solution().maximumTop(intArrayOf(2), 2))
    }

    @Test
    fun oneMove() {
        assertEquals(2, Solution().maximumTop(intArrayOf(1, 2), 1))
    }

    @Test
    fun twoMoves() {
        assertEquals(3, Solution().maximumTop(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun largeKMoves() {
        assertEquals(100, Solution().maximumTop(intArrayOf(100, 1), 3))
    }
}
