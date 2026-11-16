package checkifstringscanbemadeequalwithoperationsii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfStringsCanBeMadeEqualWithOperationsIITest {
    private val solution = Solution()

    @Test
    fun parityGroupsAreRearrangements() {
        assertTrue(solution.checkStrings("abcdba", "cabdab"))
    }

    @Test
    fun differentParityGroups() {
        assertFalse(solution.checkStrings("abe", "bea"))
    }

    @Test
    fun sameMultisetButWrongParity() {
        assertFalse(solution.checkStrings("aabc", "abca"))
    }

    @Test
    fun identicalStrings() {
        assertTrue(solution.checkStrings("abcdef", "abcdef"))
    }
}
