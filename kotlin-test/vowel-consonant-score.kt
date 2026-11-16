package vowelconsonantscore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VowelConsonantScoreTest {
    private val solution = Solution()

    @Test
    fun computesIntegerScore() {
        assertEquals(4, solution.vowelConsonantScore("cooee"))
        assertEquals(0, solution.vowelConsonantScore("abcde"))
    }

    @Test
    fun ignoresDigitsAndPunctuation() {
        assertEquals(1, solution.vowelConsonantScore("a1 b2!"))
    }

    @Test
    fun returnsZeroWithoutConsonants() {
        assertEquals(0, solution.vowelConsonantScore("aei123!!!"))
        assertEquals(0, solution.vowelConsonantScore(""))
    }
}
