package countthenumberofarrayswithkmatchingadjacentelements

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfArraysWithKMatchingAdjacentElementsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(4, solution.countGoodArrays(3, 2, 1))
    }

    @Test
    fun testExample2() {
        assertEquals(6, solution.countGoodArrays(2, 3, 0))
    }

    @Test
    fun testExample3() {
        assertEquals(2, solution.countGoodArrays(2, 2, 0))
    }

    @Test
    fun testSingleElement() {
        assertEquals(5, solution.countGoodArrays(1, 5, 0))
    }

    @Test
    fun testAllAdjacentMatching() {
        assertEquals(2, solution.countGoodArrays(3, 2, 2))
    }
}
