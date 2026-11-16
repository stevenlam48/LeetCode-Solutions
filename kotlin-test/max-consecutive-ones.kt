package maxconsecutiveones

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxConsecutiveOnesTest {
    private val solution = Solution()

    @Test
    fun computesExample() {
        assertEquals(3, solution.findMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 1)))
    }

    @Test
    fun returnsZeroWithoutOnes() {
        assertEquals(0, solution.findMaxConsecutiveOnes(intArrayOf(0, 0, 0)))
    }

    @Test
    fun countsTrailingRun() {
        assertEquals(4, solution.findMaxConsecutiveOnes(intArrayOf(0, 1, 1, 1, 1)))
    }

    @Test
    fun handlesSingleOne() {
        assertEquals(1, solution.findMaxConsecutiveOnes(intArrayOf(1)))
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals(0, solution.findMaxConsecutiveOnes(intArrayOf()))
    }
}
