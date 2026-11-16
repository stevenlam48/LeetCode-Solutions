package maximumrepeatingsubstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumRepeatingSubstringTest {
    private val solution = Solution()

    @Test
    fun twoAdjacentRepeats() {
        assertEquals(2, solution.maxRepeating("ababc", "ab"))
    }

    @Test
    fun wordOccursInReverseOrder() {
        assertEquals(1, solution.maxRepeating("ababc", "ba"))
    }

    @Test
    fun wordDoesNotOccur() {
        assertEquals(0, solution.maxRepeating("ababc", "ac"))
    }

    @Test
    fun wordLongerThanSequence() {
        assertEquals(0, solution.maxRepeating("aa", "aaa"))
    }

    @Test
    fun singleCharacterWord() {
        assertEquals(4, solution.maxRepeating("aaaa", "a"))
    }
}
