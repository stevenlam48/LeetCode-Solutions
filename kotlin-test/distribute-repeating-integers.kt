package distributerepeatingintegers

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DistributeRepeatingIntegersTest {
    private val solution = Solution()

    @Test
    fun oneCustomerCanUseDuplicate() {
        assertTrue(solution.canDistribute(intArrayOf(1, 2, 3, 3), intArrayOf(2)))
    }

    @Test
    fun noValueHasEnoughCopies() {
        assertFalse(solution.canDistribute(intArrayOf(1, 2, 3, 4), intArrayOf(2)))
    }

    @Test
    fun multipleCustomers() {
        assertTrue(solution.canDistribute(intArrayOf(1, 1, 2, 2), intArrayOf(2, 2)))
    }

    @Test
    fun splitCountsBetweenCustomers() {
        assertTrue(solution.canDistribute(intArrayOf(1, 1, 1, 2, 2), intArrayOf(2, 3)))
    }

    @Test
    fun demandExceedsSupply() {
        assertFalse(solution.canDistribute(intArrayOf(1, 1, 2, 2, 3), intArrayOf(2, 2, 2)))
    }
}
