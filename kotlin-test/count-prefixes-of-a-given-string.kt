package countprefixesofagivenstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountPrefixesOfAGivenStringTest {
    private val solution = Solution()

    @Test
    fun example() {
        assertEquals(
            3,
            solution.countPrefixes(listOf("a", "b", "c", "ab", "bc", "abc"), "abc")
        )
    }

    @Test
    fun duplicatePrefixes() {
        assertEquals(2, solution.countPrefixes(listOf("a", "a"), "aa"))
    }

    @Test
    fun noMatchingPrefix() {
        assertEquals(0, solution.countPrefixes(listOf("b", "bc", "abcd"), "abc"))
    }

    @Test
    fun noWords() {
        assertEquals(0, solution.countPrefixes(emptyList(), "abc"))
    }
}
