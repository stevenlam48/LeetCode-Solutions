package minimumnumberofstringgroupsthroughtransformations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfStringGroupsThroughTransformationsTest {
    private val solution = Solution()

    @Test
    fun leetCodeExampleFormsTwoGroups() {
        assertEquals(3, solution.minimumGroups(listOf("abcd", "bcda", "abdc", "badc")))
    }

    @Test
    fun allCyclicRotationsFormOneGroup() {
        assertEquals(2, solution.minimumGroups(listOf("abcd", "bcda", "cdab", "dabc")))
    }

    @Test
    fun evenAndOddSubsequencesRotateIndependently() {
        assertEquals(2, solution.minimumGroups(listOf("abcd", "adcb", "badc")))
    }

    @Test
    fun duplicatesCollapseIntoOneGroup() {
        assertEquals(1, solution.minimumGroups(listOf("a", "a", "a")))
    }

    @Test
    fun emptyInputHasNoGroups() {
        assertEquals(0, solution.minimumGroups(emptyList()))
    }
}
