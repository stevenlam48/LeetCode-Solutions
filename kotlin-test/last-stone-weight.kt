package laststoneweight

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LastStoneWeightTest {
    private val solution = Solution()

    @Test
    fun smashesStonesInExample() {
        assertEquals(1, solution.lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
    }

    @Test
    fun returnsSingleStone() {
        assertEquals(10, solution.lastStoneWeight(intArrayOf(10)))
    }

    @Test
    fun destroysEqualStones() {
        assertEquals(0, solution.lastStoneWeight(intArrayOf(2, 2)))
    }

    @Test
    fun chainsSmashesUntilOneStoneRemains() {
        assertEquals(1, solution.lastStoneWeight(intArrayOf(1, 1, 2, 3, 4)))
    }
}
