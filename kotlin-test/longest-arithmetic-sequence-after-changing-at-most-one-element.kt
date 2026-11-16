package longestarithmeticsequenceafterchangingatmostoneelement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestArithmeticSequenceAfterChangingAtMostOneElementTest {
    @Test
    fun alreadyArithmetic() {
        assertEquals(4, Solution().longestArithmetic(intArrayOf(1, 2, 3, 4)))
        assertEquals(5, Solution().longestArithmetic(intArrayOf(1, 3, 5, 7, 9)))
    }

    @Test
    fun oneElementChanged() {
        assertEquals(5, Solution().longestArithmetic(intArrayOf(3, 9, 15, 20, 27)))
    }

    @Test
    fun geometricSequence() {
        assertEquals(3, Solution().longestArithmetic(intArrayOf(1, 2, 4, 8)))
    }

    @Test
    fun equalElements() {
        assertEquals(4, Solution().longestArithmetic(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun twoElements() {
        assertEquals(2, Solution().longestArithmetic(intArrayOf(1, 2)))
    }
}
