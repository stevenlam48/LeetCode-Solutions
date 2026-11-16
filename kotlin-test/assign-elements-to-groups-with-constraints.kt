package assignelementstogroupswithconstraints

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AssignElementsToGroupsWithConstraintsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(0, 0, -1, 1, 0),
            solution.assignElements(intArrayOf(8, 4, 3, 2, 4), intArrayOf(4, 2, 4, 2))
        )
    }

    @Test
    fun testExample2() {
        assertArrayEquals(
            intArrayOf(-1, 1, 0),
            solution.assignElements(intArrayOf(2, 3, 5), intArrayOf(5, 3, 3))
        )
    }

    @Test
    fun testNoDivisible() {
        assertArrayEquals(
            intArrayOf(-1, -1),
            solution.assignElements(intArrayOf(5, 7), intArrayOf(2, 3))
        )
    }

    @Test
    fun testFirstIndexWins() {
        assertArrayEquals(
            intArrayOf(1, 0),
            solution.assignElements(intArrayOf(2, 6), intArrayOf(6, 2))
        )
    }
}
