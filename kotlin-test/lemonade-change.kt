package lemonadechange

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LemonadeChangeTest {
    @Test
    fun providesChangeForEveryCustomerInFirstExample() {
        assertTrue(Solution().lemonadeChange(intArrayOf(5, 5, 5, 10, 20)))
    }

    @Test
    fun rejectsSecondExampleWhenChangeIsUnavailable() {
        assertFalse(Solution().lemonadeChange(intArrayOf(5, 5, 10, 10, 20)))
    }

    @Test
    fun prefersTenDollarBillWhenMakingFifteenDollarsChange() {
        assertTrue(Solution().lemonadeChange(intArrayOf(5, 5, 5, 10, 10, 20)))
    }

    @Test
    fun rejectsTenDollarBillWithoutInitialFive() {
        assertFalse(Solution().lemonadeChange(intArrayOf(10)))
    }

    @Test
    fun acceptsEmptyQueue() {
        assertTrue(Solution().lemonadeChange(intArrayOf()))
    }
}
