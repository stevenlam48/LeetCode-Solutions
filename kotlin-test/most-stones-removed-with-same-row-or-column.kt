package moststonesremovedwithsameroworcolumn

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MostStonesRemovedWithSameRowOrColumnTest {
    private val solution = Solution()

    @Test
    fun removesAllButOneConnectedStone() {
        val stones = arrayOf(
            intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 0),
            intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(2, 2)
        )
        assertEquals(5, solution.removeStones(stones))
    }

    @Test
    fun handlesDiagonalConnectionsThroughSharedRowsAndColumns() {
        val stones = arrayOf(intArrayOf(0, 0), intArrayOf(0, 2), intArrayOf(1, 1), intArrayOf(2, 0), intArrayOf(2, 2))
        assertEquals(3, solution.removeStones(stones))
    }

    @Test
    fun handlesSingleStone() {
        assertEquals(0, solution.removeStones(arrayOf(intArrayOf(3, 7))))
    }

    @Test
    fun handlesDisconnectedStones() {
        assertEquals(0, solution.removeStones(arrayOf(intArrayOf(0, 0), intArrayOf(2, 2))))
    }
}
