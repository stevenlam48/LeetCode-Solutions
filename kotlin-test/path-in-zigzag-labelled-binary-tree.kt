package pathinzigzaglabelledbinarytree

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PathInZigzagLabelledBinaryTreeTest {
    private val solution = Solution()

    @Test
    fun findsPathAcrossAlternatingLevels() {
        assertArrayEquals(
            intArrayOf(1, 3, 4, 14),
            solution.pathInZigZagTree(14)
        )
    }

    @Test
    fun findsSecondExamplePath() {
        assertArrayEquals(intArrayOf(1, 2, 6, 10, 26), solution.pathInZigZagTree(26))
    }

    @Test
    fun handlesRoot() {
        assertArrayEquals(intArrayOf(1), solution.pathInZigZagTree(1))
    }

    @Test
    fun handlesFirstLevelChildren() {
        assertArrayEquals(intArrayOf(1, 2), solution.pathInZigZagTree(2))
        assertArrayEquals(intArrayOf(1, 3), solution.pathInZigZagTree(3))
    }
}
