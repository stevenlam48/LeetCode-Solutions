package maximumunitsonatruck

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumUnitsOnATruckTest {
    @Test
    fun examples() {
        assertEquals(
            8,
            Solution().maximumUnits(
                arrayOf(intArrayOf(1, 3), intArrayOf(2, 2), intArrayOf(3, 1)),
                4
            )
        )
        assertEquals(
            10,
            Solution().maximumUnits(
                arrayOf(intArrayOf(1, 3), intArrayOf(2, 2), intArrayOf(3, 1)),
                10
            )
        )
    }

    @Test
    fun zeroTruckSize() {
        assertEquals(0, Solution().maximumUnits(arrayOf(intArrayOf(2, 5)), 0))
    }

    @Test
    fun emptyBoxTypes() {
        assertEquals(0, Solution().maximumUnits(arrayOf(), 4))
    }
}
