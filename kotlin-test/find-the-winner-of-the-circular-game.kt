package findthewinnerofthecirculargame

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheWinnerOfTheCircularGameTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.findTheWinner(5, 2))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.findTheWinner(6, 5))
    }

    @Test
    fun testSinglePlayer() {
        assertEquals(1, solution.findTheWinner(1, 1))
    }

    @Test
    fun testKEqualsOne() {
        assertEquals(5, solution.findTheWinner(5, 1))
    }

    @Test
    fun testLargeK() {
        assertEquals(2, solution.findTheWinner(3, 4))
    }
}
