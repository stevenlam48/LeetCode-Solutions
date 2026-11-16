package minimumnumberofswapstomakethestringbalanced

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfSwapsToMakeTheStringBalancedTest {
    private val solution = Solution()

    @Test
    fun oneSwap() {
        assertEquals(1, solution.minSwaps("][]["))
    }

    @Test
    fun twoSwaps() {
        assertEquals(2, solution.minSwaps("]]][["))
    }

    @Test
    fun alreadyBalanced() {
        assertEquals(0, solution.minSwaps("[]"))
        assertEquals(0, solution.minSwaps("[[]]"))
    }

    @Test
    fun separatedUnbalancedSections() {
        assertEquals(1, solution.minSwaps("][[]][][["))
    }
}
