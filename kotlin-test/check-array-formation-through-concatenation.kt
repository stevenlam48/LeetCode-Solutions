package checkarrayformationthroughconcatenation

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckArrayFormationThroughConcatenationTest {
    private val solution = Solution()

    @Test
    fun singleElementPiecesCanBeReordered() {
        assertTrue(solution.canFormArray(intArrayOf(15, 88), arrayOf(intArrayOf(88), intArrayOf(15))))
    }

    @Test
    fun orderInsidePieceCannotChange() {
        assertFalse(solution.canFormArray(intArrayOf(49, 18, 16), arrayOf(intArrayOf(16, 18, 49))))
    }

    @Test
    fun concatenatesWholePieces() {
        assertTrue(
            solution.canFormArray(
                intArrayOf(91, 4, 64, 78),
                arrayOf(intArrayOf(78), intArrayOf(4, 64), intArrayOf(91))
            )
        )
    }

    @Test
    fun partialPieceIsRejected() {
        assertFalse(solution.canFormArray(intArrayOf(1, 2), arrayOf(intArrayOf(1, 2, 3))))
    }

    @Test
    fun emptyInputs() {
        assertTrue(solution.canFormArray(intArrayOf(), emptyArray()))
    }
}
