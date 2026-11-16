package getequalsubstringswithinbudget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GetEqualSubstringsWithinBudgetTest {
    @Test
    fun `standard examples`() {
        val solution = Solution()
        assertEquals(3, solution.equalSubstring("abcd", "bcdf", 3))
        assertEquals(1, solution.equalSubstring("abcd", "cdef", 3))
        assertEquals(1, solution.equalSubstring("abcd", "acde", 0))
    }

    @Test
    fun `zero cost matching strings`() {
        assertEquals(5, Solution().equalSubstring("abcde", "abcde", 0))
    }

    @Test
    fun `single element and empty strings`() {
        val solution = Solution()
        assertEquals(0, solution.equalSubstring("", "", 10))
        assertEquals(1, solution.equalSubstring("a", "b", 1))
        assertEquals(0, solution.equalSubstring("a", "z", 1))
    }
}
