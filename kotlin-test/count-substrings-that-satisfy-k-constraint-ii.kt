package countsubstringsthatsatisfykconstraintii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubstringsThatSatisfyKConstraintIiTest {
    private val solution = Solution()

    @Test
    fun `answers independent range queries`() {
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(1, 2), intArrayOf(2, 3))
        assertArrayEquals(longArrayOf(9, 3, 3), solution.countKConstraintSubstrings("0101", 1, queries))
    }

    @Test
    fun `handles invalid substrings inside ranges`() {
        val queries = arrayOf(intArrayOf(0, 4), intArrayOf(1, 3), intArrayOf(2, 4))
        assertArrayEquals(longArrayOf(12, 6, 6), solution.countKConstraintSubstrings("10101", 1, queries))
    }

    @Test
    fun `handles zero k`() {
        val queries = arrayOf(intArrayOf(0, 2), intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 2))
        assertArrayEquals(longArrayOf(4, 3, 2, 1), solution.countKConstraintSubstrings("001", 0, queries))
    }

    @Test
    fun `handles no queries`() {
        assertArrayEquals(longArrayOf(), solution.countKConstraintSubstrings("0", 0, arrayOf()))
    }
}
