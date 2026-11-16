package steppingnumbers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SteppingNumbersTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(
            intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 21),
            solution.countSteppingNumbers(0, 21)
        )
    }

    @Test
    fun testExample2() {
        assertArrayEquals(intArrayOf(0), solution.countSteppingNumbers(0, 0))
    }

    @Test
    fun testExample3() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
            solution.countSteppingNumbers(1, 11)
        )
    }

    @Test
    fun testEmptyRange() {
        assertArrayEquals(intArrayOf(), solution.countSteppingNumbers(11, 11))
    }

    @Test
    fun testLargeRange() {
        val result = solution.countSteppingNumbers(1000, 2000)
        assertArrayEquals(intArrayOf(1010, 1012, 1210, 1212, 1232, 1234), result)
    }
}
