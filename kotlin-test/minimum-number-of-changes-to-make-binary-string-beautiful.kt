package minimumnumberofchangestomakebinarystringbeautiful

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumNumberOfChangesToMakeBinaryStringBeautifulTest {
    @Test
    fun exampleWithTwoDifferentPairs() {
        assertEquals(2, Solution().minChanges("1001"))
    }

    @Test
    fun singleDifferentPairNeedsOneChange() {
        assertEquals(1, Solution().minChanges("10"))
    }

    @Test
    fun matchingPairsNeedNoChanges() {
        assertEquals(0, Solution().minChanges("0000"))
        assertEquals(0, Solution().minChanges("110011"))
    }

    @Test
    fun everyPairCanRequireAChange() {
        assertEquals(3, Solution().minChanges("101010"))
    }

    @Test
    fun emptyStringNeedsNoChanges() {
        assertEquals(0, Solution().minChanges(""))
    }
}
