package validatebinarytreenodes

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidateBinaryTreeNodesTest {
    private val solution = Solution()

    @Test
    fun acceptsSingleConnectedTree() {
        assertTrue(
            solution.validateBinaryTreeNodes(
                4,
                intArrayOf(1, -1, 3, -1),
                intArrayOf(2, -1, -1, -1)
            )
        )
    }

    @Test
    fun rejectsNodeWithTwoParents() {
        assertFalse(
            solution.validateBinaryTreeNodes(
                4,
                intArrayOf(1, -1, 3, -1),
                intArrayOf(2, 3, -1, -1)
            )
        )
    }

    @Test
    fun rejectsMultipleRootsAndDisconnectedNodes() {
        assertFalse(
            solution.validateBinaryTreeNodes(
                2,
                intArrayOf(-1, -1),
                intArrayOf(-1, -1)
            )
        )
        assertFalse(
            solution.validateBinaryTreeNodes(
                4,
                intArrayOf(1, -1, 3, 2),
                intArrayOf(-1, -1, -1, -1)
            )
        )
    }

    @Test
    fun rejectsSelfCycle() {
        assertFalse(solution.validateBinaryTreeNodes(1, intArrayOf(0), intArrayOf(0)))
    }
}
