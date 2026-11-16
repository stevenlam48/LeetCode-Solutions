package bestreachabletower

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class BestReachableTowerTest {
    @Test
    fun example1() {
        val towers = arrayOf(intArrayOf(1, 2, 5), intArrayOf(2, 1, 7), intArrayOf(3, 1, 9))
        assertArrayEquals(intArrayOf(1, 2), Solution().bestTower(towers, intArrayOf(1, 2), 1))
    }

    @Test
    fun highestQualityInRangeWins() {
        val towers = arrayOf(intArrayOf(1, 1, 3), intArrayOf(2, 2, 5), intArrayOf(3, 3, 1))
        assertArrayEquals(intArrayOf(2, 2), Solution().bestTower(towers, intArrayOf(2, 2), 2))
    }

    @Test
    fun tieBreaksBySmallerX() {
        val towers = arrayOf(intArrayOf(3, 1, 5), intArrayOf(1, 1, 5))
        assertArrayEquals(intArrayOf(1, 1), Solution().bestTower(towers, intArrayOf(2, 1), 5))
    }

    @Test
    fun tieBreaksBySmallerY() {
        val towers = arrayOf(intArrayOf(1, 3, 5), intArrayOf(1, 1, 5))
        assertArrayEquals(intArrayOf(1, 1), Solution().bestTower(towers, intArrayOf(1, 2), 5))
    }

    @Test
    fun noneInRange() {
        val towers = arrayOf(intArrayOf(5, 5, 9))
        assertArrayEquals(intArrayOf(-1, -1), Solution().bestTower(towers, intArrayOf(0, 0), 1))
    }

    @Test
    fun boundaryIsInclusive() {
        val towers = arrayOf(intArrayOf(0, 0, 7))
        assertArrayEquals(intArrayOf(0, 0), Solution().bestTower(towers, intArrayOf(0, 3), 3))
    }
}
