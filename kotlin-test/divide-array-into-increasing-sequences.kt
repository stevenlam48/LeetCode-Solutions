package dividearrayintoincreasingsequences

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DivideArrayIntoIncreasingSequencesTest {
    private val solution = Solution()

    @Test
    fun duplicatesFitMinimumLength() {
        assertTrue(solution.canDivideIntoSubsequences(intArrayOf(1, 2, 2, 3, 3, 4), 3))
    }

    @Test
    fun duplicatesRequireLongerSequences() {
        assertFalse(solution.canDivideIntoSubsequences(intArrayOf(1, 2, 2, 3, 3, 4), 4))
    }

    @Test
    fun strictlyIncreasing() {
        assertTrue(solution.canDivideIntoSubsequences(intArrayOf(1, 2, 3, 4), 4))
    }

    @Test
    fun allEqual() {
        assertFalse(solution.canDivideIntoSubsequences(intArrayOf(5, 5, 5), 2))
    }
}
