package countsequencestok

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountSequencesToKTest {
    private val solution = Solution()

    @Test
    fun multiplyBothNumbers() {
        assertEquals(1, solution.countSequences(intArrayOf(2, 3), 6L))
        assertEquals(1, solution.countSequences(intArrayOf(2, 5), 10L))
    }

    @Test
    fun duplicateFactorsCancelEachOther() {
        assertEquals(3, solution.countSequences(intArrayOf(2, 2), 1L))
    }

    @Test
    fun targetHasUnsupportedFactor() {
        assertEquals(0, solution.countSequences(intArrayOf(2, 3), 7L))
    }

    @Test
    fun singleElement() {
        assertEquals(1, solution.countSequences(intArrayOf(4), 4L))
        assertEquals(1, solution.countSequences(intArrayOf(4), 1L))
    }
}
