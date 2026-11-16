package validatestacksequences

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidateStackSequencesTest {
    private val solution = Solution()

    @Test
    fun acceptsValidSequence() {
        assertTrue(
            solution.validateStackSequences(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(4, 5, 3, 2, 1)
            )
        )
    }

    @Test
    fun rejectsImpossibleSequence() {
        assertFalse(
            solution.validateStackSequences(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(4, 3, 5, 1, 2)
            )
        )
    }

    @Test
    fun handlesEmptyAndSingleSequences() {
        assertTrue(solution.validateStackSequences(intArrayOf(), intArrayOf()))
        assertTrue(solution.validateStackSequences(intArrayOf(7), intArrayOf(7)))
        assertFalse(solution.validateStackSequences(intArrayOf(7), intArrayOf(8)))
    }
}
