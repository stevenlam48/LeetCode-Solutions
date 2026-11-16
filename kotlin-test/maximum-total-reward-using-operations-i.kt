package maximumtotalrewardusingoperationsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalRewardUsingOperationsITest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(4, solution.maxTotalReward(intArrayOf(1, 1, 3, 3)))
    }

    @Test
    fun secondExample() {
        assertEquals(11, solution.maxTotalReward(intArrayOf(1, 6, 4, 3, 2)))
    }

    @Test
    fun singleValue() {
        assertEquals(1, solution.maxTotalReward(intArrayOf(1)))
    }

    @Test
    fun twoValues() {
        assertEquals(3, solution.maxTotalReward(intArrayOf(1, 2)))
    }

    @Test
    fun twoLargerValues() {
        assertEquals(5, solution.maxTotalReward(intArrayOf(2, 3)))
    }
}
