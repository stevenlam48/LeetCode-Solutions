package lexicographicallysmalleststringafteroperationswithconstraint

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestStringAfterOperationsWithConstraintTest {
    private val solution = Solution()

    @Test
    fun convertsCharactersToAUntilBudgetIsSpent() {
        assertEquals("aaaz", solution.getSmallestString("zbbz", 3))
    }

    @Test
    fun unusedBudgetDoesNotAffectEarlierCharacters() {
        assertEquals("aa", solution.getSmallestString("ax", 4))
    }

    @Test
    fun spendsPartialBudgetWhenCannotReachA() {
        assertEquals("h", solution.getSmallestString("j", 2))
    }

    @Test
    fun stopsImmediatelyWhenRemainingBudgetBecomesZero() {
        assertEquals("abdef", solution.getSmallestString("bcdef", 2))
    }

    @Test
    fun zeroBudgetLeavesStringUnchanged() {
        assertEquals("abc", solution.getSmallestString("abc", 0))
    }
}
