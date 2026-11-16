package minimumcosttoconnecttwogroupsofpoints

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostToConnectTwoGroupsOfPointsTest {
    private val solution = Solution()

    @Test
    fun firstLeetCodeExample() {
        assertEquals(17, solution.connectTwoGroups(arrayOf(intArrayOf(15, 96), intArrayOf(36, 2))))
    }

    @Test
    fun secondLeetCodeExample() {
        val cost = arrayOf(intArrayOf(1, 3, 5), intArrayOf(4, 1, 1), intArrayOf(1, 5, 3))
        assertEquals(4, solution.connectTwoGroups(cost))
    }

    @Test
    fun thirdLeetCodeExample() {
        val cost = arrayOf(
            intArrayOf(2, 5, 1), intArrayOf(3, 4, 7), intArrayOf(8, 1, 2),
            intArrayOf(6, 2, 4), intArrayOf(3, 8, 8)
        )
        assertEquals(10, solution.connectTwoGroups(cost))
    }

    @Test
    fun onePointInEachGroup() {
        assertEquals(7, solution.connectTwoGroups(arrayOf(intArrayOf(7))))
    }
}
