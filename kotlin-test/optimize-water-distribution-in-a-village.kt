package optimizewaterdistributioninavillage

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OptimizeWaterDistributionInAVillageTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            3,
            solution.minCostToSupplyWater(
                3,
                intArrayOf(1, 2, 2),
                arrayOf(intArrayOf(1, 2, 1), intArrayOf(2, 3, 1))
            )
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            2,
            solution.minCostToSupplyWater(
                2,
                intArrayOf(1, 1),
                arrayOf(intArrayOf(1, 2, 1))
            )
        )
    }

    @Test
    fun testNoPipes() {
        assertEquals(
            6,
            solution.minCostToSupplyWater(3, intArrayOf(1, 2, 3), emptyArray())
        )
    }

    @Test
    fun testCheapPipe() {
        assertEquals(
            6,
            solution.minCostToSupplyWater(
                2,
                intArrayOf(5, 5),
                arrayOf(intArrayOf(1, 2, 1))
            )
        )
    }
}
