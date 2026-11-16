package maximumarrayhoppingscoreii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumArrayHoppingScoreIITest {
    private val solution = Solution()

    @Test
    fun directLongHopIsBest() {
        assertEquals(16L, solution.maxScore(intArrayOf(1, 5, 8)))
    }

    @Test
    fun mixedHopLengths() {
        assertEquals(13L, solution.maxScore(intArrayOf(5, 5, 2, 4)))
    }

    @Test
    fun singleElement() {
        assertEquals(0L, solution.maxScore(intArrayOf(7)))
    }

    @Test
    fun resultUsesLongArithmetic() {
        assertEquals(4_294_967_294L, solution.maxScore(intArrayOf(0, Int.MAX_VALUE, Int.MAX_VALUE)))
    }
}
