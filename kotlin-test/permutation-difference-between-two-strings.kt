package permutationdifferencebetweentwostrings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PermutationDifferenceBetweenTwoStringsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.findPermutationDifference("abc", "bac"))
    }

    @Test
    fun testExample2() {
        assertEquals(12, solution.findPermutationDifference("abcde", "edbac"))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(0, solution.findPermutationDifference("a", "a"))
    }

    @Test
    fun testReversed() {
        assertEquals(2, solution.findPermutationDifference("ab", "ba"))
    }
}
