package canmakepalindromefromsubstring

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CanMakePalindromeFromSubstringTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val queries = arrayOf(
            intArrayOf(3, 3, 0),
            intArrayOf(1, 2, 0),
            intArrayOf(0, 3, 1),
            intArrayOf(0, 3, 2),
            intArrayOf(0, 4, 1)
        )
        assertEquals(listOf(true, false, false, true, true), solution.canMakePaliQueries("abcda", queries))
    }

    @Test
    fun testExample2() {
        val queries = arrayOf(intArrayOf(0, 1, 0), intArrayOf(2, 2, 1))
        assertEquals(listOf(false, true), solution.canMakePaliQueries("lyb", queries))
    }

    @Test
    fun testSingleCharacter() {
        val queries = arrayOf(intArrayOf(0, 0, 0))
        assertEquals(listOf(true), solution.canMakePaliQueries("a", queries))
    }

    @Test
    fun testNoQueries() {
        assertEquals(emptyList<Boolean>(), solution.canMakePaliQueries("abc", emptyArray()))
    }
}
