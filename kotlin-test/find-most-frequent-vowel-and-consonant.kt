package findmostfrequentvowelandconsonant

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMostFrequentVowelAndConsonantTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(6, solution.maxFreqSum("successes"))
    }

    @Test
    fun exampleTwo() {
        assertEquals(3, solution.maxFreqSum("aeiaeia"))
    }

    @Test
    fun noConsonants() {
        assertEquals(2, solution.maxFreqSum("aau"))
    }

    @Test
    fun noVowels() {
        assertEquals(4, solution.maxFreqSum("bcdfbbb"))
    }
}
