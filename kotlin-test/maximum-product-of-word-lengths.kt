package maximumproductofwordlengths

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfWordLengthsTest {
    @Test
    fun example1() {
        assertEquals(16, Solution().maxProduct(listOf("abcw", "baz", "foo", "bar", "xtfn", "abcdef")))
    }

    @Test
    fun example2() {
        assertEquals(4, Solution().maxProduct(listOf("a", "ab", "abc", "d", "cd", "bcd", "abcd")))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().maxProduct(listOf("a", "aa", "aaa", "aaaa")))
    }

    @Test
    fun singleWord() {
        assertEquals(0, Solution().maxProduct(listOf("abc")))
    }

    @Test
    fun disjointPairs() {
        assertEquals(4, Solution().maxProduct(listOf("ab", "cd")))
    }
}
