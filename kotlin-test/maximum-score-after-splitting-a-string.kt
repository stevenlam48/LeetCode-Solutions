package maximumscoreaftersplittingastring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreAfterSplittingAStringTest {
    @Test
    fun exampleOne() {
        assertEquals(5, Solution().maxScore("011101"))
    }

    @Test
    fun exampleTwo() {
        assertEquals(5, Solution().maxScore("00111"))
    }

    @Test
    fun exampleThree() {
        assertEquals(3, Solution().maxScore("1111"))
    }

    @Test
    fun shortestInput() {
        assertEquals(2, Solution().maxScore("01"))
    }
}
