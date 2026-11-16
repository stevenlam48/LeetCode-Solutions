package minimumtotalspacewastedwithkresizingoperations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumTotalSpaceWastedWithKResizingOperationsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(10, solution.minSpaceWastedKResizing(intArrayOf(10, 20), 0))
    }

    @Test
    fun testExample2() {
        assertEquals(10, solution.minSpaceWastedKResizing(intArrayOf(10, 20, 30), 1))
    }

    @Test
    fun testExample3() {
        assertEquals(15, solution.minSpaceWastedKResizing(intArrayOf(10, 20, 15, 30, 20), 2))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.minSpaceWastedKResizing(intArrayOf(5), 0))
    }

    @Test
    fun testEnoughResizes() {
        assertEquals(0, solution.minSpaceWastedKResizing(intArrayOf(1, 2, 3, 4), 3))
    }
}
