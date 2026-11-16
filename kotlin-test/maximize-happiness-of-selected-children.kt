package maximizehappinessofselectedchildren

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeHappinessOfSelectedChildrenTest {
    @Test
    fun firstLeetCodeExample() {
        assertEquals(4L, Solution().maximumHappinessSum(intArrayOf(1, 2, 3), 2))
    }

    @Test
    fun secondLeetCodeExample() {
        assertEquals(1L, Solution().maximumHappinessSum(intArrayOf(1, 1, 1, 1), 2))
    }

    @Test
    fun thirdLeetCodeExample() {
        assertEquals(53L, Solution().maximumHappinessSum(intArrayOf(12, 1, 42), 3))
    }

    @Test
    fun selectOnlyOneChild() {
        assertEquals(5L, Solution().maximumHappinessSum(intArrayOf(2, 3, 4, 5), 1))
    }

    @Test
    fun stopWhenRemainingHappinessIsNotPositive() {
        assertEquals(3L, Solution().maximumHappinessSum(intArrayOf(1, 2, 2), 3))
    }
}
