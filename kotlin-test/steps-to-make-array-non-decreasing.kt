package stepstomakearraynondecreasing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StepsToMakeArrayNonDecreasingTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.totalSteps(intArrayOf(5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11)))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.totalSteps(intArrayOf(4, 5, 7, 7, 13)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.totalSteps(intArrayOf(1)))
    }

    @Test
    fun testStrictlyDecreasing() {
        assertEquals(1, solution.totalSteps(intArrayOf(3, 2, 1)))
    }

    @Test
    fun testAllEqual() {
        assertEquals(0, solution.totalSteps(intArrayOf(2, 2, 2, 2)))
    }
}
