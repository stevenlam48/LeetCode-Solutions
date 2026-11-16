package minimumnumberofstepstomaketwostringsanagramii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfStepsToMakeTwoStringsAnagramIiTest {
    private val solution = Solution()

    @Test
    fun leetCodeExampleWithAdditionsAndDeletions() {
        assertEquals(7, solution.minSteps("leetcode", "coats"))
    }

    @Test
    fun reversedStringsAreAlreadyAnagrams() {
        assertEquals(0, solution.minSteps("night", "thing"))
    }

    @Test
    fun duplicateCountsAreAlreadyEqual() {
        assertEquals(0, solution.minSteps("aba", "aab"))
    }

    @Test
    fun allCharactersMustBeRemoved() {
        assertEquals(4, solution.minSteps("aaaa", ""))
    }

    @Test
    fun differentLengthsCountOnlyAbsoluteDifferences() {
        assertEquals(3, solution.minSteps("a", "aaab"))
    }
}
