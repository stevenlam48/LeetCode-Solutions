package countthehiddensequences

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheHiddenSequencesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.numberOfArrays(intArrayOf(1, -3, 4), 1, 6))
    }

    @Test
    fun testExample2() {
        assertEquals(4, solution.numberOfArrays(intArrayOf(3, -4, 5, 1, -2), -4, 5))
    }

    @Test
    fun testExample3() {
        assertEquals(0, solution.numberOfArrays(intArrayOf(4, -7, 2), 3, 6))
    }

    @Test
    fun testSingleZeroDifference() {
        assertEquals(1, solution.numberOfArrays(intArrayOf(0), 0, 0))
    }

    @Test
    fun testSingleElementRange() {
        assertEquals(5, solution.numberOfArrays(intArrayOf(0), 1, 5))
    }
}
