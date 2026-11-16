package baseballgame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BaseballGameTest {
    private val solution = Solution()

    @Test
    fun firstLeetCodeExample() {
        assertEquals(30, solution.calPoints(listOf("5", "2", "C", "D", "+")))
    }

    @Test
    fun secondLeetCodeExample() {
        assertEquals(27, solution.calPoints(listOf("5", "-2", "4", "C", "D", "9", "+", "+")))
    }

    @Test
    fun cancellationCanEmptyRecords() {
        assertEquals(0, solution.calPoints(listOf("1", "C")))
    }

    @Test
    fun negativeScoresDoubleAndAdd() {
        assertEquals(-18, solution.calPoints(listOf("-3", "D", "+")))
    }

    @Test
    fun singleScore() {
        assertEquals(42, solution.calPoints(listOf("42")))
    }
}
