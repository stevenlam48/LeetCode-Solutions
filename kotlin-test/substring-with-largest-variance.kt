package substringwithlargestvariance

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SubstringWithLargestVarianceTest {
    @Test
    fun exampleOne() {
        assertEquals(3, Solution().largestVariance("aababbb"))
    }

    @Test
    fun allDistinctCharacters() {
        assertEquals(0, Solution().largestVariance("abcde"))
    }

    @Test
    fun alternatingCharacters() {
        assertEquals(1, Solution().largestVariance("ababab"))
    }

    @Test
    fun singleCharacterAndEmptyString() {
        assertEquals(0, Solution().largestVariance("aaaa"))
        assertEquals(0, Solution().largestVariance(""))
    }
}
