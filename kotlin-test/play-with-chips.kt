package playwithchips

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PlayWithChipsTest {
    @Test
    fun mixedParities() {
        assertEquals(1, Solution().minCostToMoveChips(intArrayOf(1, 2, 3)))
    }

    @Test
    fun repeatedPositions() {
        assertEquals(2, Solution().minCostToMoveChips(intArrayOf(2, 2, 2, 3, 3)))
    }

    @Test
    fun allSameParity() {
        assertEquals(0, Solution().minCostToMoveChips(intArrayOf(2, 4, 6)))
    }

    @Test
    fun singleChip() {
        assertEquals(0, Solution().minCostToMoveChips(intArrayOf(1)))
    }
}
