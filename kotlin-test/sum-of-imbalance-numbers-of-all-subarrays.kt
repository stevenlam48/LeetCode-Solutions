package sumofimbalancenumbersofallsubarrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfImbalanceNumbersOfAllSubarraysTest {
    @Test
    fun exampleOne() {
        assertEquals(3, Solution().sumImbalanceNumbers(intArrayOf(2, 3, 1, 4)))
    }

    @Test
    fun fullyConsecutiveArray() {
        assertEquals(0, Solution().sumImbalanceNumbers(intArrayOf(1, 2, 3)))
    }

    @Test
    fun oneGapPair() {
        assertEquals(1, Solution().sumImbalanceNumbers(intArrayOf(1, 3, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().sumImbalanceNumbers(intArrayOf(1)))
    }
}
