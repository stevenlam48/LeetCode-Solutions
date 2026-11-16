package numberofprefixconnectedgroups

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfPrefixConnectedGroupsTest {
    @Test
    fun testExample1() {
        assertEquals(
            1,
            Solution().prefixConnected(listOf("apple", "apply", "banana"), 2)
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            2,
            Solution().prefixConnected(listOf("abcd", "abce", "bcde", "bcdx"), 2)
        )
    }

    @Test
    fun testShortWordsSkipped() {
        assertEquals(0, Solution().prefixConnected(listOf("a", "b", "ab"), 2))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, Solution().prefixConnected(listOf(), 1))
    }

    @Test
    fun testExactLength() {
        assertEquals(1, Solution().prefixConnected(listOf("ab", "ab", "abc"), 2))
    }
}
