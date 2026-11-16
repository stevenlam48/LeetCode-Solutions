package countallvalidpickupanddeliveryoptions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountAllValidPickupAndDeliveryOptionsTest {
    private val solution = Solution()

    @Test
    fun testOne() {
        assertEquals(1, solution.countOrders(1))
    }

    @Test
    fun testTwo() {
        assertEquals(6, solution.countOrders(2))
    }

    @Test
    fun testThree() {
        assertEquals(90, solution.countOrders(3))
    }
}
