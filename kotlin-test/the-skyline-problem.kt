package theskylineproblem

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheSkylineProblemTest {

    @Test
    fun testExample1() {
        val buildings = arrayOf(
            intArrayOf(2, 9, 10),
            intArrayOf(3, 7, 15),
            intArrayOf(5, 12, 12),
            intArrayOf(15, 20, 10),
            intArrayOf(19, 24, 8)
        )
        val expected = listOf(
            listOf(2, 10),
            listOf(3, 15),
            listOf(7, 12),
            listOf(12, 0),
            listOf(15, 10),
            listOf(20, 8),
            listOf(24, 0)
        )
        assertEquals(expected, Solution().getSkyline(buildings))
    }

    @Test
    fun testSingleBuilding() {
        val buildings = arrayOf(intArrayOf(0, 2, 3))
        val expected = listOf(listOf(0, 3), listOf(2, 0))
        assertEquals(expected, Solution().getSkyline(buildings))
    }

    @Test
    fun testSameIntervalDifferentHeights() {
        val buildings = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(1, 2, 2),
            intArrayOf(1, 2, 3)
        )
        val expected = listOf(listOf(1, 3), listOf(2, 0))
        assertEquals(expected, Solution().getSkyline(buildings))
    }

    @Test
    fun testAdjacentBuildings() {
        val buildings = arrayOf(
            intArrayOf(1, 3, 3),
            intArrayOf(3, 5, 2)
        )
        val expected = listOf(listOf(1, 3), listOf(3, 2), listOf(5, 0))
        assertEquals(expected, Solution().getSkyline(buildings))
    }
}
