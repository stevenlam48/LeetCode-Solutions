package countnonadjacentsubsetsinarootedtree

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountNonAdjacentSubsetsInARootedTreeTest {
    private val solution = Solution()

    @Test
    fun testNoValidSubset() {
        assertEquals(0, solution.countValidSubsets(intArrayOf(-1, 0), intArrayOf(1, 1), 2))
    }

    @Test
    fun testKOne() {
        assertEquals(2, solution.countValidSubsets(intArrayOf(-1, 0), intArrayOf(1, 1), 1))
    }

    @Test
    fun testStar() {
        assertEquals(1, solution.countValidSubsets(intArrayOf(-1, 0, 0), intArrayOf(1, 1, 1), 2))
    }

    @Test
    fun testPath() {
        assertEquals(1, solution.countValidSubsets(intArrayOf(-1, 0, 1), intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun testLongerPath() {
        assertEquals(
            3,
            solution.countValidSubsets(intArrayOf(-1, 0, 1, 2), intArrayOf(1, 1, 1, 1), 2)
        )
    }
}
