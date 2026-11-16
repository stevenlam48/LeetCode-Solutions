package countsubstringsthatsatisfykconstrainti

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubstringsThatSatisfyKConstraintITest {
    private val solution = Solution()

    @Test
    fun `counts substrings satisfying either count constraint`() {
        assertEquals(9, solution.countKConstraintSubstrings("0101", 1))
        assertEquals(12, solution.countKConstraintSubstrings("10101", 1))
    }

    @Test
    fun `zero k accepts only single character runs`() {
        assertEquals(4, solution.countKConstraintSubstrings("001", 0))
    }

    @Test
    fun `counts every substring when one character is absent`() {
        assertEquals(10, solution.countKConstraintSubstrings("0000", 1))
    }

    @Test
    fun `handles empty and single character inputs`() {
        assertEquals(0, solution.countKConstraintSubstrings("", 0))
        assertEquals(1, solution.countKConstraintSubstrings("1", 0))
    }
}
