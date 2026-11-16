package numberofpossiblesetsofclosingbranches

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfPossibleSetsOfClosingBranchesTest {
    @Test
    fun testExample1() {
        val roads = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(1, 2, 10),
            intArrayOf(0, 2, 10)
        )
        assertEquals(5, Solution().numberOfSets(3, 5, roads))
    }

    @Test
    fun testExample2() {
        val roads = arrayOf(
            intArrayOf(0, 1, 20),
            intArrayOf(0, 1, 10),
            intArrayOf(1, 2, 2),
            intArrayOf(0, 2, 2)
        )
        assertEquals(7, Solution().numberOfSets(3, 5, roads))
    }

    @Test
    fun testSingleNode() {
        assertEquals(2, Solution().numberOfSets(1, 10, arrayOf()))
    }

    @Test
    fun testNoRoads() {
        assertEquals(3, Solution().numberOfSets(2, 5, arrayOf()))
    }
}
