package maximumnumberofintegerstochoosefromarangeii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfIntegersToChooseFromARangeIITest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(2, solution.maxCount(intArrayOf(1, 6, 5), 5, 6L))
    }

    @Test
    fun allAffordableSmallIntegersAreBanned() {
        assertEquals(0, solution.maxCount(intArrayOf(1, 2, 3, 4, 5, 6, 7), 8, 1L))
    }

    @Test
    fun entireRangeFitsLargeBudget() {
        assertEquals(7, solution.maxCount(intArrayOf(11), 7, 1_000_000_000_000L))
    }

    @Test
    fun duplicateBans() {
        assertEquals(3, solution.maxCount(intArrayOf(2, 2), 4, 100L))
    }

    @Test
    fun zeroBudget() {
        assertEquals(0, solution.maxCount(intArrayOf(), 10, 0L))
    }
}
