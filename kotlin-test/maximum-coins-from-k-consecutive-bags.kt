package maximumcoinsfromkconsecutivebags

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumCoinsFromKConsecutiveBagsTest {
    @Test
    fun example() {
        assertEquals(
            10L,
            Solution().maximumCoins(
                arrayOf(intArrayOf(8, 10, 1), intArrayOf(1, 3, 2), intArrayOf(5, 6, 4)),
                4
            )
        )
    }

    @Test
    fun disjointRanges() {
        assertEquals(
            12L,
            Solution().maximumCoins(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)), 3)
        )
    }

    @Test
    fun singleBagUnits() {
        assertEquals(
            6L,
            Solution().maximumCoins(arrayOf(intArrayOf(1, 1, 5), intArrayOf(2, 2, 6)), 1)
        )
    }
}
