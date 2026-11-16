package countconnectedsubgraphswithevennodesum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountConnectedSubgraphsWithEvenNodeSumTest {
    @Test
    fun emptyAndSingleNode() {
        assertEquals(0, Solution().evenSumSubgraphs(intArrayOf(), arrayOf()))
        assertEquals(1, Solution().evenSumSubgraphs(intArrayOf(0), arrayOf()))
    }

    @Test
    fun twoNodes() {
        assertEquals(1, Solution().evenSumSubgraphs(intArrayOf(1, 0), arrayOf(intArrayOf(0, 1))))
        assertEquals(2, Solution().evenSumSubgraphs(intArrayOf(0, 0), arrayOf()))
        assertEquals(3, Solution().evenSumSubgraphs(intArrayOf(0, 0), arrayOf(intArrayOf(0, 1))))
    }

    @Test
    fun connectedEvenParitySubgraphs() {
        assertEquals(
            3,
            Solution().evenSumSubgraphs(
                intArrayOf(1, 1, 0),
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
            )
        )
    }
}
