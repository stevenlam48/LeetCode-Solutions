package findthecitywiththesmallestnumberofneighborsatathresholddistance

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistanceTest {
    @Test
    fun findsCityUsingShortestPaths() {
        val edges = arrayOf(
            intArrayOf(0, 1, 3),
            intArrayOf(1, 2, 1),
            intArrayOf(1, 3, 4),
            intArrayOf(2, 3, 1)
        )
        assertEquals(3, Solution().findTheCity(4, edges, 4))
    }

    @Test
    fun handlesFiveCityExample() {
        val edges = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(0, 4, 8),
            intArrayOf(1, 2, 3),
            intArrayOf(1, 4, 2),
            intArrayOf(2, 3, 1),
            intArrayOf(3, 4, 1)
        )
        assertEquals(0, Solution().findTheCity(5, edges, 2))
    }

    @Test
    fun breaksTiesByChoosingGreatestIndex() {
        assertEquals(2, Solution().findTheCity(3, arrayOf(), 0))
    }

    @Test
    fun handlesSingleCity() {
        assertEquals(0, Solution().findTheCity(1, arrayOf(), 0))
    }
}
