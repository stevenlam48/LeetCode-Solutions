package numberofwaystoreorderarraytogetsamebst

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToReorderArrayToGetSameBstTest {
    @Test
    fun balancedThreeNodes() {
        assertEquals(1, Solution().numOfWays(intArrayOf(2, 1, 3)))
    }

    @Test
    fun mixedTree() {
        assertEquals(5, Solution().numOfWays(intArrayOf(3, 4, 5, 1, 2)))
    }

    @Test
    fun increasingTree() {
        assertEquals(0, Solution().numOfWays(intArrayOf(1, 2, 3)))
    }

    @Test
    fun singleNode() {
        assertEquals(0, Solution().numOfWays(intArrayOf(1)))
    }
}
