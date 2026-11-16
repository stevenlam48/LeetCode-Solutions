package findminimumtimetoreachlastroomii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinimumTimeToReachLastRoomIITest {
    @Test
    fun example1() {
        val moveTime = arrayOf(intArrayOf(0, 4), intArrayOf(4, 4))
        assertEquals(7, Solution().minTimeToReach(moveTime))
    }

    @Test
    fun example2() {
        val moveTime = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))
        assertEquals(4, Solution().minTimeToReach(moveTime))
    }

    @Test
    fun example3() {
        val moveTime = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(4, Solution().minTimeToReach(moveTime))
    }

    @Test
    fun singleCell() {
        assertEquals(0, Solution().minTimeToReach(arrayOf(intArrayOf(0))))
    }

    @Test
    fun singleRow() {
        val moveTime = arrayOf(intArrayOf(0, 0, 0, 0))
        assertEquals(4, Solution().minTimeToReach(moveTime))
    }

    @Test
    fun singleColumn() {
        val moveTime = arrayOf(intArrayOf(0), intArrayOf(0), intArrayOf(0))
        assertEquals(3, Solution().minTimeToReach(moveTime))
    }
}
