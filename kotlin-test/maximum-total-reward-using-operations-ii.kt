package maximumtotalrewardusingoperationsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalRewardUsingOperationsIiTest {
    @Test
    fun examples() {
        assertEquals(8, Solution().maxTotalReward(intArrayOf(2, 3, 5)))
        assertEquals(17, Solution().maxTotalReward(intArrayOf(2, 10, 5)))
    }

    @Test
    fun duplicates() {
        assertEquals(5, Solution().maxTotalReward(intArrayOf(1, 1, 2, 3)))
    }

    @Test
    fun singleValue() {
        assertEquals(7, Solution().maxTotalReward(intArrayOf(7)))
        assertEquals(1, Solution().maxTotalReward(intArrayOf(1)))
    }
}
