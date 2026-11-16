package richestcustomerwealth

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RichestCustomerWealthTest {
    @Test
    fun exampleOne() {
        assertEquals(6, Solution().maximumWealth(arrayOf(intArrayOf(1, 2, 3), intArrayOf(3, 2, 1))))
    }

    @Test
    fun exampleTwo() {
        assertEquals(10, Solution().maximumWealth(arrayOf(intArrayOf(1, 5), intArrayOf(7, 3), intArrayOf(3, 5))))
    }

    @Test
    fun exampleThree() {
        assertEquals(17, Solution().maximumWealth(arrayOf(intArrayOf(2, 8, 7), intArrayOf(7, 1, 3), intArrayOf(1, 9, 5))))
    }

    @Test
    fun noAccounts() {
        assertEquals(0, Solution().maximumWealth(arrayOf()))
    }
}
