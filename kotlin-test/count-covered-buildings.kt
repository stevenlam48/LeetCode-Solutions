package countcoveredbuildings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCoveredBuildingsTest {
    @Test
    fun fullGridOnlyCenterCovered() {
        val buildings = arrayOf(
            intArrayOf(1, 1), intArrayOf(1, 2), intArrayOf(1, 3),
            intArrayOf(2, 1), intArrayOf(2, 2), intArrayOf(2, 3),
            intArrayOf(3, 1), intArrayOf(3, 2), intArrayOf(3, 3)
        )
        assertEquals(1, Solution().countCoveredBuildings(3, buildings))
    }

    @Test
    fun crossShape() {
        val buildings = arrayOf(
            intArrayOf(3, 1), intArrayOf(3, 2), intArrayOf(3, 3),
            intArrayOf(1, 2), intArrayOf(2, 2), intArrayOf(4, 2), intArrayOf(5, 2)
        )
        assertEquals(1, Solution().countCoveredBuildings(5, buildings))
    }

    @Test
    fun noCoveredBuildings() {
        val buildings = arrayOf(
            intArrayOf(1, 1), intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(2, 2)
        )
        assertEquals(0, Solution().countCoveredBuildings(5, buildings))
    }

    @Test
    fun singleBuilding() {
        assertEquals(0, Solution().countCoveredBuildings(1, arrayOf(intArrayOf(1, 1))))
    }
}
