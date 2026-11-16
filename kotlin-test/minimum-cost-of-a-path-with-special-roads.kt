package minimumcostofapathwithspecialroads

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostOfAPathWithSpecialRoadsTest {
    @Test
    fun standardExample() {
        assertEquals(5, Solution().minimumCost(
            intArrayOf(1, 1), intArrayOf(4, 5),
            arrayOf(intArrayOf(1, 2, 3, 3, 2), intArrayOf(3, 4, 4, 5, 1))
        ))
    }

    @Test
    fun noSpecialRoads() {
        assertEquals(4, Solution().minimumCost(
            intArrayOf(1, 1), intArrayOf(3, 3), arrayOf()
        ))
    }

    @Test
    fun usesCheaperSpecialRoad() {
        assertEquals(3, Solution().minimumCost(
            intArrayOf(1, 1), intArrayOf(1, 5),
            arrayOf(intArrayOf(1, 2, 1, 4, 1))
        ))
    }

    @Test
    fun startEqualsTarget() {
        assertEquals(0, Solution().minimumCost(
            intArrayOf(2, 2), intArrayOf(2, 2), arrayOf()
        ))
    }
}
