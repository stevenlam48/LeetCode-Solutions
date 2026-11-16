package maximumbagswithfullcapacityofrocks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumBagsWithFullCapacityOfRocksTest {
    @Test
    fun example() {
        assertEquals(
            3,
            Solution().maximumBags(intArrayOf(2, 3, 4, 5), intArrayOf(1, 2, 4, 4), 2)
        )
    }

    @Test
    fun enoughRocksForAll() {
        assertEquals(
            3,
            Solution().maximumBags(intArrayOf(10, 2, 2), intArrayOf(2, 2, 0), 100)
        )
    }

    @Test
    fun noRocksNoEmptySpace() {
        assertEquals(0, Solution().maximumBags(intArrayOf(1), intArrayOf(0), 0))
    }

    @Test
    fun alreadyFull() {
        assertEquals(1, Solution().maximumBags(intArrayOf(5), intArrayOf(5), 0))
    }

    @Test
    fun partialFill() {
        assertEquals(1, Solution().maximumBags(intArrayOf(3, 3, 3), intArrayOf(2, 1, 1), 2))
    }
}
