package countsortedvowelstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountSortedVowelStringsTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(5, solution.countVowelStrings(1))
    }

    @Test
    fun exampleTwo() {
        assertEquals(15, solution.countVowelStrings(2))
    }

    @Test
    fun exampleThree() {
        assertEquals(66045, solution.countVowelStrings(33))
    }

    @Test
    fun additionalValues() {
        assertEquals(1, solution.countVowelStrings(0))
        assertEquals(70, solution.countVowelStrings(4))
    }
}
