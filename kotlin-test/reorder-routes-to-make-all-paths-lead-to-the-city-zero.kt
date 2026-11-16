package reorderroutestomakeallpathsleadtothecityzero

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReorderRoutesToMakeAllPathsLeadToTheCityZeroTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        val connections = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 3), intArrayOf(2, 3),
            intArrayOf(4, 0), intArrayOf(4, 5)
        )
        assertEquals(3, solution.minReorder(6, connections))
    }

    @Test
    fun secondExample() {
        val connections = arrayOf(
            intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(3, 2), intArrayOf(3, 4)
        )
        assertEquals(2, solution.minReorder(5, connections))
    }

    @Test
    fun everyRouteAlreadyLeadsToZero() {
        val connections = arrayOf(intArrayOf(1, 0), intArrayOf(2, 0))
        assertEquals(0, solution.minReorder(3, connections))
    }

    @Test
    fun singleCityHasNoRoutes() {
        assertEquals(0, solution.minReorder(1, emptyArray()))
    }
}
