package maximumgoodsubtreescore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumGoodSubtreeScoreTest {
    private val solution = Solution()

    @Test
    fun `combines disjoint digit masks across the tree`() {
        assertEquals(11, solution.goodSubtreeSum(intArrayOf(1, 2, 3), intArrayOf(-1, 0, 0)))
    }

    @Test
    fun `sums the best score from every subtree`() {
        assertEquals(22, solution.goodSubtreeSum(intArrayOf(2, 3, 7), intArrayOf(-1, 0, 0)))
    }

    @Test
    fun `handles a single node with unique digits`() {
        assertEquals(123, solution.goodSubtreeSum(intArrayOf(123), intArrayOf(-1)))
    }

    @Test
    fun `rejects repeated digits within a node`() {
        assertEquals(0, solution.goodSubtreeSum(intArrayOf(22), intArrayOf(-1)))
    }
}
