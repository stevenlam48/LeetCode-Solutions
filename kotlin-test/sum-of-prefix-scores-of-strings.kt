package sumofprefixscoresofstrings

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SumOfPrefixScoresOfStringsTest {
    private val solution = Solution()

    @Test
    fun exampleWords() {
        assertArrayEquals(
            intArrayOf(5, 4, 3, 2),
            solution.sumPrefixScores(listOf("abc", "ab", "bc", "b"))
        )
    }

    @Test
    fun repeatedWords() {
        assertArrayEquals(intArrayOf(3, 3, 3), solution.sumPrefixScores(listOf("a", "a", "a")))
    }

    @Test
    fun identicalLongerWords() {
        assertArrayEquals(intArrayOf(8, 8), solution.sumPrefixScores(listOf("abcd", "abcd")))
    }

    @Test
    fun disjointWords() {
        assertArrayEquals(intArrayOf(1, 1), solution.sumPrefixScores(listOf("a", "b")))
    }

    @Test
    fun emptyWord() {
        assertArrayEquals(intArrayOf(0), solution.sumPrefixScores(listOf("")))
    }
}
