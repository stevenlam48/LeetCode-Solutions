package grumpybookstoreowner

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GrumpyBookstoreOwnerTest {
    @Test
    fun example1() {
        val customers = intArrayOf(1, 0, 1, 2, 1, 1, 7, 5)
        val grumpy = intArrayOf(0, 1, 0, 1, 0, 1, 0, 1)
        assertEquals(16, Solution().maxSatisfied(customers, grumpy, 3))
    }

    @Test
    fun singleHappyOwner() {
        assertEquals(1, Solution().maxSatisfied(intArrayOf(1), intArrayOf(0), 1))
    }

    @Test
    fun singleGrumpyOwner() {
        assertEquals(1, Solution().maxSatisfied(intArrayOf(1), intArrayOf(1), 1))
    }

    @Test
    fun zeroWindow() {
        val customers = intArrayOf(1, 5, 3)
        val grumpy = intArrayOf(1, 0, 1)
        assertEquals(5, Solution().maxSatisfied(customers, grumpy, 0))
    }

    @Test
    fun windowLargerThanArray() {
        val customers = intArrayOf(2, 3, 4)
        val grumpy = intArrayOf(1, 1, 1)
        assertEquals(9, Solution().maxSatisfied(customers, grumpy, 5))
    }
}
