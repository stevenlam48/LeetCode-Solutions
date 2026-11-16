package longestarithmeticsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestArithmeticSequenceTest {
    @Test
    fun increasingArithmetic() {
        assertEquals(4, Solution().longestArithSeqLength(intArrayOf(3, 6, 9, 12)))
    }

    @Test
    fun subsequenceNotSubarray() {
        assertEquals(3, Solution().longestArithSeqLength(intArrayOf(9, 4, 7, 2, 10)))
    }

    @Test
    fun scatteredArithmeticSubsequence() {
        assertEquals(4, Solution().longestArithSeqLength(intArrayOf(20, 1, 15, 3, 10, 5, 8)))
    }

    @Test
    fun twoElements() {
        assertEquals(2, Solution().longestArithSeqLength(intArrayOf(1, 2)))
    }

    @Test
    fun equalElements() {
        assertEquals(3, Solution().longestArithSeqLength(intArrayOf(1, 1, 1)))
    }
}
