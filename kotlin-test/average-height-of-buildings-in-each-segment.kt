package averageheightofbuildingsineachsegment

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AverageHeightOfBuildingsInEachSegmentTest {
    private val solution = Solution()

    private fun assertResult(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i])
        }
    }

    @Test
    fun testExample() {
        assertResult(
            arrayOf(intArrayOf(1, 3, 2), intArrayOf(3, 4, 3), intArrayOf(4, 9, 4)),
            solution.averageHeightOfBuildings(arrayOf(intArrayOf(1, 4, 2), intArrayOf(3, 9, 4)))
        )
    }

    @Test
    fun testSingleBuilding() {
        assertResult(
            arrayOf(intArrayOf(1, 2, 5)),
            solution.averageHeightOfBuildings(arrayOf(intArrayOf(1, 2, 5)))
        )
    }

    @Test
    fun testMergedSameHeight() {
        assertResult(
            arrayOf(intArrayOf(1, 3, 5)),
            solution.averageHeightOfBuildings(arrayOf(intArrayOf(1, 2, 5), intArrayOf(2, 3, 5)))
        )
    }

    @Test
    fun testOverlappingSameSegment() {
        assertResult(
            arrayOf(intArrayOf(1, 4, 2)),
            solution.averageHeightOfBuildings(arrayOf(intArrayOf(1, 4, 2), intArrayOf(1, 4, 2)))
        )
    }
}
