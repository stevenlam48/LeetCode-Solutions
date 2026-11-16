package oneeditdistance

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OneEditDistanceTest {
    private val solution = Solution()

    @Test
    fun testInsert() {
        assertTrue(solution.isOneEditDistance("ab", "acb"))
    }

    @Test
    fun testReplace() {
        assertTrue(solution.isOneEditDistance("1203", "1213"))
    }

    @Test
    fun testDelete() {
        assertTrue(solution.isOneEditDistance("abc", "ac"))
    }

    @Test
    fun testTooManyEdits() {
        assertFalse(solution.isOneEditDistance("cab", "ad"))
    }

    @Test
    fun testEqual() {
        assertFalse(solution.isOneEditDistance("ab", "ab"))
    }

    @Test
    fun testEmpty() {
        assertFalse(solution.isOneEditDistance("", ""))
        assertTrue(solution.isOneEditDistance("", "a"))
        assertFalse(solution.isOneEditDistance("", "ab"))
    }
}
