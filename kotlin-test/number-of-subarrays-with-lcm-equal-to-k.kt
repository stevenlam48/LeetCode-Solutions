package numberofsubarrayswithlcmequaltok

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfSubarraysWithLcmEqualToKTest {
    private val solution = Solution()

    @Test
    fun singleElement() {
        assertEquals(1, solution.subarrayLCM(intArrayOf(3), 3))
        assertEquals(0, solution.subarrayLCM(intArrayOf(3), 2))
    }

    @Test
    fun example() {
        assertEquals(4, solution.subarrayLCM(intArrayOf(3, 6, 2, 7, 1), 6))
    }

    @Test
    fun multipleElementsReachTarget() {
        assertEquals(2, solution.subarrayLCM(intArrayOf(2, 3, 4), 12))
    }

    @Test
    fun nonDivisorInterruptsRun() {
        assertEquals(0, solution.subarrayLCM(intArrayOf(2, 5, 2), 4))
    }
}
