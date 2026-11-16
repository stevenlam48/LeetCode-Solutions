package verifypreordersequenceinbinarysearchtree

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class VerifyPreorderSequenceInBinarySearchTreeTest {
    private val solution = Solution()

    @Test
    fun acceptsValidPreorder() {
        assertTrue(solution.verifyPreorder(intArrayOf(5, 2, 1, 3, 6)))
        assertTrue(solution.verifyPreorder(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun rejectsInvalidPreorder() {
        assertFalse(solution.verifyPreorder(intArrayOf(5, 2, 6, 1, 3)))
        assertFalse(solution.verifyPreorder(intArrayOf(4, 2, 1, 5, 3)))
    }

    @Test
    fun handlesEmptyAndSingleInputs() {
        assertTrue(solution.verifyPreorder(intArrayOf()))
        assertTrue(solution.verifyPreorder(intArrayOf(Int.MIN_VALUE)))
    }
}
