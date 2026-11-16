package predictthewinner

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PredictTheWinnerTest {
    @Test
    fun exampleOne() {
        assertFalse(Solution().predictTheWinner(intArrayOf(1, 5, 2)))
    }

    @Test
    fun exampleTwo() {
        assertTrue(Solution().predictTheWinner(intArrayOf(1, 5, 233, 7)))
    }

    @Test
    fun singleElement() {
        assertTrue(Solution().predictTheWinner(intArrayOf(1)))
    }

    @Test
    fun twoElements() {
        assertTrue(Solution().predictTheWinner(intArrayOf(1, 2)))
    }

    @Test
    fun equalElements() {
        assertTrue(Solution().predictTheWinner(intArrayOf(1, 1, 1)))
    }

    @Test
    fun losingOddCase() {
        assertFalse(Solution().predictTheWinner(intArrayOf(2, 5, 1)))
    }
}
