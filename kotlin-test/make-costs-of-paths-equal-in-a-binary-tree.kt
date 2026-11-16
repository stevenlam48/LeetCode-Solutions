package makecostsofpathsequalinabinarytree

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MakeCostsOfPathsEqualInABinaryTreeTest {
    @Test
    fun `balances paths across multiple levels`() {
        assertEquals(6, Solution().minIncrements(7, intArrayOf(1, 5, 2, 2, 3, 3, 1)))
    }

    @Test
    fun `balances two unequal leaf paths`() {
        assertEquals(1, Solution().minIncrements(3, intArrayOf(1, 2, 3)))
    }

    @Test
    fun `handles already equal path costs`() {
        assertEquals(0, Solution().minIncrements(3, intArrayOf(5, 3, 3)))
    }

    @Test
    fun `handles tree with only a root`() {
        assertEquals(0, Solution().minIncrements(1, intArrayOf(5)))
    }
}
