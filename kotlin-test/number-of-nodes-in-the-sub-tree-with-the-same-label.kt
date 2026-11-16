package numberofnodesinthesubtreewiththesamelabel

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfNodesInTheSubTreeWithTheSameLabelTest {
    @Test
    fun standardExample() {
        val solution = Solution()
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 4),
            intArrayOf(1, 5), intArrayOf(2, 3), intArrayOf(2, 6)
        )
        assertArrayEquals(intArrayOf(2, 1, 1, 1, 1, 1, 1), solution.countSubTrees(7, edges, "abaedcd"))
    }

    @Test
    fun identicalLabels() {
        val solution = Solution()
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 3))
        assertArrayEquals(intArrayOf(4, 2, 1, 1), solution.countSubTrees(4, edges, "bbbb"))
    }

    @Test
    fun branchingMixedLabels() {
        val solution = Solution()
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 3), intArrayOf(0, 4))
        assertArrayEquals(intArrayOf(3, 2, 1, 1, 1), solution.countSubTrees(5, edges, "aabab"))
    }

    @Test
    fun singleNode() {
        val solution = Solution()
        assertArrayEquals(intArrayOf(1), solution.countSubTrees(1, emptyArray(), "z"))
    }
}
