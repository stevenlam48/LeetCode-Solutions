package minimumnumberofstepstomaketwostringsanagram

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfStepsToMakeTwoStringsAnagramTest {
    private val solution = Solution()

    @Test
    fun leetCodeExampleWithOneReplacement() {
        assertEquals(1, solution.minSteps("bab", "aba"))
    }

    @Test
    fun leetCodeExampleWithFiveReplacements() {
        assertEquals(5, solution.minSteps("leetcode", "practice"))
    }

    @Test
    fun existingAnagramRequiresNoSteps() {
        assertEquals(0, solution.minSteps("anagram", "mangaar"))
    }

    @Test
    fun emptyStringsRequireNoSteps() {
        assertEquals(0, solution.minSteps("", ""))
    }
}
