package maximumnumberofballsinabox

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfBallsInABoxTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(2, solution.countBalls(1, 10))
    }

    @Test
    fun exampleTwo() {
        assertEquals(2, solution.countBalls(5, 15))
    }

    @Test
    fun exampleThree() {
        assertEquals(2, solution.countBalls(19, 28))
    }

    @Test
    fun singleBox() {
        assertEquals(1, solution.countBalls(1, 1))
    }

    @Test
    fun repeatedDigitSums() {
        assertEquals(2, solution.countBalls(1, 11))
    }
}
