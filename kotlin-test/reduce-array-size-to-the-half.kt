package reducearraysizetothehalf

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReduceArraySizeToTheHalfTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.minSetSize(intArrayOf(3, 3, 3, 3, 5, 5, 5, 2, 2, 7)))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.minSetSize(intArrayOf(7, 7, 7, 7, 7, 7)))
    }

    @Test
    fun testAllDistinct() {
        assertEquals(3, solution.minSetSize(intArrayOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun testTwoValues() {
        assertEquals(1, solution.minSetSize(intArrayOf(1, 1, 1, 2, 2, 2)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, solution.minSetSize(intArrayOf(1)))
    }

    @Test
    fun testUnevenCounts() {
        assertEquals(1, solution.minSetSize(intArrayOf(1, 1, 1, 1, 2, 2, 2, 3)))
    }
}
