package maximumbalancedshipments

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumBalancedShipmentsTest {
    @Test
    fun example() {
        assertEquals(2, Solution().maxBalancedShipments(intArrayOf(2, 5, 1, 4, 3)))
    }

    @Test
    fun strictlyDecreasing() {
        assertEquals(2, Solution().maxBalancedShipments(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun strictlyIncreasing() {
        assertEquals(0, Solution().maxBalancedShipments(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().maxBalancedShipments(intArrayOf(1)))
    }

    @Test
    fun dropInTheMiddle() {
        assertEquals(1, Solution().maxBalancedShipments(intArrayOf(3, 1, 2)))
    }
}
