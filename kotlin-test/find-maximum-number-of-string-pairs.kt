package findmaximumnumberofstringpairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMaximumNumberOfStringPairsTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().maximumNumberOfStringPairs(listOf("cd", "ac", "dc", "ca", "zz")))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().maximumNumberOfStringPairs(listOf("ab", "ba", "cc")))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().maximumNumberOfStringPairs(listOf("aa", "ab")))
    }

    @Test
    fun noPairs() {
        assertEquals(0, Solution().maximumNumberOfStringPairs(listOf("ab", "cd", "ef")))
    }

    @Test
    fun singleWord() {
        assertEquals(0, Solution().maximumNumberOfStringPairs(listOf("xy")))
    }

    @Test
    fun multiplePairs() {
        assertEquals(2, Solution().maximumNumberOfStringPairs(listOf("ab", "ba", "cd", "dc")))
    }
}
