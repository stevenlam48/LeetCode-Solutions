package smallestmissinggeneticvalueineachsubtree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestMissingGeneticValueInEachSubtreeTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(5, 1, 1, 1),
            solution.smallestMissingValueSubtree(intArrayOf(-1, 0, 0, 2), intArrayOf(1, 2, 3, 4))
        )
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            intArrayOf(7, 1, 1, 4, 2, 1),
            solution.smallestMissingValueSubtree(
                intArrayOf(-1, 0, 1, 0, 3, 3),
                intArrayOf(5, 4, 6, 2, 1, 3)
            )
        )
    }

    @Test
    fun testExample3() {
        assertArrayEquals(
            intArrayOf(1, 1, 1, 1, 1, 1, 1),
            solution.smallestMissingValueSubtree(
                intArrayOf(-1, 2, 3, 0, 2, 4, 1),
                intArrayOf(2, 3, 4, 5, 6, 7, 8)
            )
        )
    }

    @Test
    fun testSingleNode() {
        assertArrayEquals(
            intArrayOf(2),
            solution.smallestMissingValueSubtree(intArrayOf(-1), intArrayOf(1))
        )
    }

    @Test
    fun testSingleNodeWithoutOne() {
        assertArrayEquals(
            intArrayOf(1),
            solution.smallestMissingValueSubtree(intArrayOf(-1), intArrayOf(5))
        )
    }
}
