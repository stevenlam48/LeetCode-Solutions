package countnodeswiththehighestscore

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountNodesWithTheHighestScoreTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.countHighestScoreNodes(intArrayOf(-1, 2, 0, 2, 0)))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.countHighestScoreNodes(intArrayOf(-1, 2, 0)))
    }

    @Test
    fun testSingleNode() {
        assertEquals(1, solution.countHighestScoreNodes(intArrayOf(-1)))
    }

    @Test
    fun testChain() {
        assertEquals(2, solution.countHighestScoreNodes(intArrayOf(-1, 0, 1, 2)))
    }
}
