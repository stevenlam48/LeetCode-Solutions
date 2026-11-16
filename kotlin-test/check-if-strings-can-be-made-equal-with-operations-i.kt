package checkifstringscanbemadeequalwithoperationsi

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfStringsCanBeMadeEqualWithOperationsITest {
    private val solution = Solution()

    @Test
    fun swapsInBothParityGroups() {
        assertTrue(solution.canBeEqual("abcd", "cdab"))
    }

    @Test
    fun parityGroupCountsDiffer() {
        assertFalse(solution.canBeEqual("abcd", "dcba"))
    }

    @Test
    fun equalStrings() {
        assertTrue(solution.canBeEqual("abcd", "abcd"))
    }

    @Test
    fun swapEvenIndicesOnly() {
        assertTrue(solution.canBeEqual("abcd", "cbad"))
    }

    @Test
    fun swapOddIndicesOnly() {
        assertTrue(solution.canBeEqual("abcd", "adcb"))
    }
}
