package generalizedabbreviation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GeneralizedAbbreviationTest {
    private fun assertAbbreviations(expected: Set<String>, word: String) {
        val actual = Solution().generateAbbreviations(word)
        assertEquals(expected.size, actual.size)
        assertEquals(expected, actual.toSet())
    }

    @Test
    fun wordExample() {
        assertAbbreviations(
            setOf(
                "word", "wor1", "wo1d", "wo2", "w1rd", "w1r1", "w2d", "w3",
                "1ord", "1or1", "1o1d", "1o2", "2rd", "2r1", "3d", "4"
            ),
            "word"
        )
    }

    @Test
    fun twoLetters() {
        assertAbbreviations(setOf("ab", "1b", "a1", "2"), "ab")
    }

    @Test
    fun threeLetters() {
        assertAbbreviations(
            setOf("abc", "ab1", "a1c", "a2", "1bc", "1b1", "2c", "3"),
            "abc"
        )
    }

    @Test
    fun emptyWord() {
        assertAbbreviations(setOf(""), "")
    }

    @Test
    fun singleLetter() {
        assertAbbreviations(setOf("z", "1"), "z")
    }
}
