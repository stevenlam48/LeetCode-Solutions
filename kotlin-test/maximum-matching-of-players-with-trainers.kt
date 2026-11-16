package maximummatchingofplayerswithtrainers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumMatchingOfPlayersWithTrainersTest {
    private val solution = Solution()

    @Test
    fun `matches players greedily with suitable trainers`() {
        assertEquals(2, solution.matchPlayersAndTrainers(intArrayOf(4, 7, 9), intArrayOf(8, 2, 5, 8)))
    }

    @Test
    fun `uses a trainer only once`() {
        assertEquals(1, solution.matchPlayersAndTrainers(intArrayOf(1, 1, 1), intArrayOf(10)))
    }

    @Test
    fun `skips trainers with insufficient capacity`() {
        assertEquals(0, solution.matchPlayersAndTrainers(intArrayOf(5, 6), intArrayOf(1, 2)))
    }

    @Test
    fun `handles an empty player list`() {
        assertEquals(0, solution.matchPlayersAndTrainers(intArrayOf(), intArrayOf(1, 2)))
    }
}
