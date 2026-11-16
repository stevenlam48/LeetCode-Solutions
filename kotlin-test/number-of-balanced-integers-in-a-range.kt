package numberofbalancedintegersinarange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfBalancedIntegersInARangeTest {
    @Test
    fun oneToHundred() {
        assertEquals(9, Solution().countBalanced(1, 100))
    }

    @Test
    fun singleDigitRange() {
        assertEquals(0, Solution().countBalanced(1, 9))
    }

    @Test
    fun oneToThousandExclusive() {
        assertEquals(54, Solution().countBalanced(1, 999))
    }

    @Test
    fun fourDigitRange() {
        assertEquals(615, Solution().countBalanced(1000, 9999))
    }

    @Test
    fun repeatedDigits() {
        assertEquals(1, Solution().countBalanced(11, 11))
    }
}
