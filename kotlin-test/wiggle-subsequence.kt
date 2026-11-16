package wigglesubsequence

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WiggleSubsequenceTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertEquals(6, solution.wiggleMaxLength(intArrayOf(1, 7, 4, 9, 2, 5)))
    }

    @Test
    fun example2() {
        assertEquals(
            7,
            solution.wiggleMaxLength(intArrayOf(1, 17, 5, 10, 13, 15, 10, 5, 16, 8))
        )
    }

    @Test
    fun monotonic() {
        assertEquals(2, solution.wiggleMaxLength(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)))
        assertEquals(2, solution.wiggleMaxLength(intArrayOf(9, 8, 7, 6, 5)))
    }

    @Test
    fun constantValues() {
        assertEquals(1, solution.wiggleMaxLength(intArrayOf(2, 2)))
        assertEquals(1, solution.wiggleMaxLength(intArrayOf(3, 3, 3, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(1, solution.wiggleMaxLength(intArrayOf(1)))
    }

    @Test
    fun singleWiggle() {
        assertEquals(3, solution.wiggleMaxLength(intArrayOf(3, 3, 3, 2, 5)))
    }
}
