package maximumweightintwobags

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumWeightInTwoBagsTest {
    private val solution = Solution()

    @Test
    fun fillBothBags() {
        assertEquals(9, solution.maxWeight(intArrayOf(1, 3, 5), 4, 5))
    }

    @Test
    fun splitSmallWeightsBetweenBags() {
        assertEquals(6, solution.maxWeight(intArrayOf(1, 2, 3, 4, 5), 3, 3))
    }

    @Test
    fun weightTooHeavyForBothBags() {
        assertEquals(0, solution.maxWeight(intArrayOf(7), 5, 5))
    }

    @Test
    fun bothBagsTakeOneEqualWeight() {
        assertEquals(4, solution.maxWeight(intArrayOf(2, 2), 2, 2))
    }

    @Test
    fun emptyWeights() {
        assertEquals(0, solution.maxWeight(intArrayOf(), 5, 5))
    }
}
