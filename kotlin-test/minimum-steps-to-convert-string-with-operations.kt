package minimumstepstoconvertstringwithoperations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumStepsToConvertStringWithOperationsTest {
    @Test
    fun `returns zero for identical strings`() {
        assertEquals(0, Solution().minOperations("abcde", "abcde"))
    }

    @Test
    fun `replaces one mismatched character`() {
        assertEquals(1, Solution().minOperations("a", "b"))
    }

    @Test
    fun `swaps two opposite mismatches in one operation`() {
        assertEquals(1, Solution().minOperations("ab", "ba"))
    }

    @Test
    fun `reverses a substring in one operation`() {
        assertEquals(1, Solution().minOperations("abcd", "dcba"))
    }

    @Test
    fun `handles independent replacements`() {
        assertEquals(2, Solution().minOperations("ab", "cd"))
        assertEquals(0, Solution().minOperations("", ""))
    }
}
