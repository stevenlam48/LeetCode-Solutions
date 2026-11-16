package networkrecoverypathways

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NetworkRecoveryPathwaysTest {
    private val edges = arrayOf(
        intArrayOf(0, 1, 5),
        intArrayOf(1, 2, 5),
        intArrayOf(0, 2, 12)
    )

    @Test
    fun `finds maximum feasible minimum edge score`() {
        assertEquals(5, Solution().findMaxPathScore(edges, booleanArrayOf(true, true, true), 10))
        assertEquals(12, Solution().findMaxPathScore(edges, booleanArrayOf(true, true, true), 12))
    }

    @Test
    fun `ignores offline intermediate nodes`() {
        assertEquals(12, Solution().findMaxPathScore(edges, booleanArrayOf(true, false, true), 12))
    }

    @Test
    fun `returns minus one when no online path fits budget`() {
        assertEquals(-1, Solution().findMaxPathScore(edges, booleanArrayOf(true, false, true), 11))
    }

    @Test
    fun `supports paths with unequal edge scores`() {
        val paths = arrayOf(intArrayOf(0, 1, 4), intArrayOf(1, 3, 6), intArrayOf(0, 2, 8), intArrayOf(2, 3, 8))
        assertEquals(8, Solution().findMaxPathScore(paths, BooleanArray(4) { true }, 16))
        assertEquals(4, Solution().findMaxPathScore(paths, BooleanArray(4) { true }, 10))
    }
}
