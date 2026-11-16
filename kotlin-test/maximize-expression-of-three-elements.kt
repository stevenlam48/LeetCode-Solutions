package maximizeexpressionofthreeelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeExpressionOfThreeElementsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(8, solution.maximizeExpressionOfThree(intArrayOf(1, 4, 2, 5)))
    }

    @Test
    fun testExample2() {
        assertEquals(11, solution.maximizeExpressionOfThree(intArrayOf(-2, 0, 5, -2, 4)))
    }

    @Test
    fun testAllEqual() {
        assertEquals(1, solution.maximizeExpressionOfThree(intArrayOf(1, 1, 1)))
        assertEquals(5, solution.maximizeExpressionOfThree(intArrayOf(5, 5, 5)))
    }

    @Test
    fun testAllNegative() {
        assertEquals(0, solution.maximizeExpressionOfThree(intArrayOf(-1, -2, -3)))
    }
}
