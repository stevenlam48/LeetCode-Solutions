package arraynesting

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ArrayNestingTest {
    private val solution = Solution()

    @Test
    fun testExample() {
        assertEquals(4, solution.arrayNesting(intArrayOf(5, 4, 0, 3, 1, 6, 2)))
    }

    @Test
    fun testSingleCycle() {
        assertEquals(1, solution.arrayNesting(intArrayOf(0, 1, 2)))
        assertEquals(3, solution.arrayNesting(intArrayOf(1, 2, 0)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, solution.arrayNesting(intArrayOf(0)))
    }
}
