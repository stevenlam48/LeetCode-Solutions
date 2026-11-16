package numberofzerofilledsubarrays

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfZeroFilledSubarraysTest {
    @Test
    fun separatedZeroRuns() {
        assertEquals(6L, Solution().zeroFilledSubarray(intArrayOf(1, 3, 0, 0, 2, 0, 0)))
    }

    @Test
    fun multipleZeroRuns() {
        assertEquals(9L, Solution().zeroFilledSubarray(intArrayOf(0, 0, 0, 2, 0, 0)))
    }

    @Test
    fun noZeros() {
        assertEquals(0L, Solution().zeroFilledSubarray(intArrayOf(2, 10, 2019)))
    }

    @Test
    fun emptyInput() {
        assertEquals(0L, Solution().zeroFilledSubarray(intArrayOf()))
    }
}
