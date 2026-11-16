package maximumcostoftripwithkhighways

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumCostOfTripWithKHighwaysTest {
    private val solution = Solution()

    @Test
    fun findsHighestCostSimplePath() {
        val highways = arrayOf(
            intArrayOf(0, 1, 4),
            intArrayOf(2, 1, 3),
            intArrayOf(1, 4, 1),
            intArrayOf(3, 2, 5),
            intArrayOf(3, 4, 2)
        )
        assertEquals(12, solution.maximumCost(5, highways, 3))
    }

    @Test
    fun singleHighwayUsesLargestToll() {
        val highways = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 3))
        assertEquals(3, solution.maximumCost(3, highways, 1))
    }

    @Test
    fun disconnectedGraphHasNoValidTrip() {
        val highways = arrayOf(intArrayOf(0, 1, 3), intArrayOf(2, 3, 2))
        assertEquals(-1, solution.maximumCost(4, highways, 2))
    }

    @Test
    fun tooManyHighwaysForCities() {
        val highways = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 3))
        assertEquals(-1, solution.maximumCost(3, highways, 3))
    }
}
