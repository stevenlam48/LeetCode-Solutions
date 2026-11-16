package makethreestringsequal

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MakeThreeStringsEqualTest {
    @Test
    fun testExample1() {
        assertEquals(2, Solution().findMinimumOperations("abc", "abb", "ab"))
    }

    @Test
    fun testExample2() {
        assertEquals(-1, Solution().findMinimumOperations("dac", "bac", "cac"))
    }

    @Test
    fun testExample3() {
        assertEquals(0, Solution().findMinimumOperations("a", "a", "a"))
    }

    @Test
    fun testCommonPrefixShorterThanAll() {
        assertEquals(1, Solution().findMinimumOperations("ab", "ab", "abc"))
    }

    @Test
    fun testEmptyString() {
        assertEquals(-1, Solution().findMinimumOperations("", "a", "a"))
    }
}
