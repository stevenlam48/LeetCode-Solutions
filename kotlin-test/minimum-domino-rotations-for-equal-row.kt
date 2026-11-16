package minimumdominorotationsforequalrow
// Time:  O(n)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDominoRotationsForEqualRowTest {
    private val solution = Solution()

    @Test
    fun leetCodeExamples() {
        assertEquals(
            2,
            solution.minDominoRotations(
                intArrayOf(2, 1, 2, 4, 2, 2),
                intArrayOf(5, 2, 6, 2, 3, 2)
            )
        )
        assertEquals(
            -1,
            solution.minDominoRotations(
                intArrayOf(3, 5, 1, 2, 3),
                intArrayOf(3, 6, 3, 3, 4)
            )
        )
    }

    @Test
    fun allValuesAlreadyMatch() {
        assertEquals(0, solution.minDominoRotations(intArrayOf(6, 6, 6), intArrayOf(1, 2, 3)))
    }

    @Test
    fun chooseFewerBottomRotations() {
        assertEquals(
            1,
            solution.minDominoRotations(
                intArrayOf(4, 2, 2),
                intArrayOf(2, 4, 4)
            )
        )
    }
}
