package findthewinnerofanarraygame

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheWinnerOfAnArrayGameTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(5, solution.getWinner(intArrayOf(2, 1, 3, 5, 4, 6, 7), 2))
    }

    @Test
    fun testExample2() {
        assertEquals(3, solution.getWinner(intArrayOf(3, 2, 1), 10))
    }

    @Test
    fun testExample3() {
        assertEquals(9, solution.getWinner(intArrayOf(1, 9, 8, 2, 3, 7, 6, 4, 5), 7))
    }

    @Test
    fun testKEqualsOne() {
        assertEquals(3, solution.getWinner(intArrayOf(1, 3, 2), 1))
    }

    @Test
    fun testSingleElement() {
        assertEquals(7, solution.getWinner(intArrayOf(7), 1))
    }
}
