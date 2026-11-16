package frequenciesofshortestsupersequences

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FrequenciesOfShortestSupersequencesTest {
    @Test
    fun `cycle has two shortest supersequence frequency choices`() {
        val actual = Solution().supersequences(listOf("ab", "ba"))
        val expected = arrayOf(
            frequencies('a' to 2, 'b' to 1),
            frequencies('a' to 1, 'b' to 2)
        )

        assertArrayEquals(expected, actual)
    }

    @Test
    fun `self loop and cycle use repeated a only`() {
        val actual = Solution().supersequences(listOf("aa", "ab", "ba"))

        assertArrayEquals(arrayOf(frequencies('a' to 2, 'b' to 1)), actual)
    }

    @Test
    fun `acyclic example uses each character once`() {
        val actual = Solution().supersequences(listOf("ab", "bc"))

        assertArrayEquals(arrayOf(frequencies('a' to 1, 'b' to 1, 'c' to 1)), actual)
    }

    @Test
    fun `empty words produce one zero frequency array`() {
        val actual = Solution().supersequences(emptyList())

        assertArrayEquals(arrayOf(frequencies()), actual)
    }

    private fun frequencies(vararg counts: Pair<Char, Int>): IntArray {
        val result = IntArray(26)
        for ((character, count) in counts) {
            result[character - 'a'] = count
        }
        return result
    }
}
