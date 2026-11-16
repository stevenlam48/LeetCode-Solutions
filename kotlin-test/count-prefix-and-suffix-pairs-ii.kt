package countprefixandsuffixpairsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountPrefixAndSuffixPairsIITest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(4L, solution.countPrefixSuffixPairs(listOf("a", "aba", "ababa", "aa")))
    }

    @Test
    fun exampleTwo() {
        assertEquals(2L, solution.countPrefixSuffixPairs(listOf("pa", "papa", "ma", "mama")))
    }

    @Test
    fun exampleThree() {
        assertEquals(0L, solution.countPrefixSuffixPairs(listOf("abab", "ab")))
    }

    @Test
    fun duplicateWords() {
        assertEquals(10L, solution.countPrefixSuffixPairs(List(5) { "aa" }))
    }
}
