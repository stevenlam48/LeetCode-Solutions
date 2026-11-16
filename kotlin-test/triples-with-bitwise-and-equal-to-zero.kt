package tripleswithbitwiseandequaltozero

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TriplesWithBitwiseAndEqualToZeroTest {
    @Test
    fun standardExample() {
        assertEquals(12, Solution().countTriplets(intArrayOf(2, 1, 3)))
    }

    @Test
    fun allZerosAndSingleElement() {
        assertEquals(27, Solution().countTriplets(intArrayOf(0, 0, 0)))
        assertEquals(0, Solution().countTriplets(intArrayOf(1)))
        assertEquals(1, Solution().countTriplets(intArrayOf(0)))
    }

    @Test
    fun orderedTriplesAndDuplicates() {
        assertEquals(48, Solution().countTriplets(intArrayOf(1, 2, 1, 2)))
        assertEquals(24, Solution().countTriplets(intArrayOf(1, 2, 4)))
    }
}
