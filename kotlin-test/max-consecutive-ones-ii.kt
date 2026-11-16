package maxconsecutiveonesii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxConsecutiveOnesIiTest {
    private val solution = Solution()

    @Test
    fun computesExample() {
        assertEquals(4, solution.findMaxConsecutiveOnes(intArrayOf(1, 0, 1, 1, 0)))
    }

    @Test
    fun canFlipOnlyZero() {
        assertEquals(1, solution.findMaxConsecutiveOnes(intArrayOf(0)))
    }

    @Test
    fun cannotExceedInputLengthWithoutZero() {
        assertEquals(4, solution.findMaxConsecutiveOnes(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun joinsRunsAcrossSingleZero() {
        assertEquals(7, solution.findMaxConsecutiveOnes(intArrayOf(1, 1, 1, 0, 1, 1, 1)))
    }

    @Test
    fun handlesAllZeroes() {
        assertEquals(1, solution.findMaxConsecutiveOnes(intArrayOf(0, 0, 0)))
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals(0, solution.findMaxConsecutiveOnes(intArrayOf()))
    }
}
