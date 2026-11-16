package totalsumofinteractioncostintreegroups

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalSumOfInteractionCostInTreeGroupsTest {
    @Test
    fun allSameGroupChain() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(4L, Solution().interactionCosts(3, edges, intArrayOf(1, 1, 1)))
    }

    @Test
    fun alternatingGroupsChain() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
        )
        assertEquals(10L, Solution().interactionCosts(5, edges, intArrayOf(1, 2, 1, 2, 1)))
    }

    @Test
    fun singleNode() {
        assertEquals(0L, Solution().interactionCosts(1, arrayOf(), intArrayOf(1)))
    }

    @Test
    fun starAllSameGroup() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3),
        )
        assertEquals(9L, Solution().interactionCosts(4, edges, intArrayOf(2, 2, 2, 2)))
    }
}
