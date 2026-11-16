package minimumoperationstotransformstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToTransformStringTest {
    private val solution = Solution()

    @Test
    fun handlesEmptyString() {
        assertEquals(0, solution.minOperations(""))
    }

    @Test
    fun handlesStringAlreadyContainingOnlyA() {
        assertEquals(0, solution.minOperations("aaaa"))
    }

    @Test
    fun usesTheEarliestLetter() {
        assertEquals(25, solution.minOperations("abc"))
    }

    @Test
    fun handlesMixedLetters() {
        assertEquals(24, solution.minOperations("leetcode"))
    }

    @Test
    fun wrapsZToAInOneOperation() {
        assertEquals(1, solution.minOperations("z"))
    }
}
