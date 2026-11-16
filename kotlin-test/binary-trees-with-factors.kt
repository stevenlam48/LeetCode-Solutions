package binarytreeswithfactors

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreesWithFactorsTest {
    @Test
    fun oneFactorization() {
        assertEquals(3, Solution().numFactoredBinaryTrees(intArrayOf(2, 4)))
    }

    @Test
    fun multipleFactoredTrees() {
        assertEquals(7, Solution().numFactoredBinaryTrees(intArrayOf(2, 4, 5, 10)))
    }

    @Test
    fun orderedChildrenCreateDistinctTrees() {
        assertEquals(5, Solution().numFactoredBinaryTrees(intArrayOf(2, 3, 6)))
    }

    @Test
    fun primeSingletonsAndEmptyInput() {
        assertEquals(3, Solution().numFactoredBinaryTrees(intArrayOf(2, 3, 5)))
        assertEquals(0, Solution().numFactoredBinaryTrees(intArrayOf()))
    }
}
