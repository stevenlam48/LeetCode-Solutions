package solvingquestionswithbrainpower

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolvingQuestionsWithBrainpowerTest {
    @Test
    fun example1() {
        val questions = arrayOf(
            intArrayOf(3, 2),
            intArrayOf(4, 3),
            intArrayOf(4, 4),
            intArrayOf(2, 5)
        )
        assertEquals(5L, Solution().mostPoints(questions))
    }

    @Test
    fun example2() {
        val questions = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 3),
            intArrayOf(4, 4),
            intArrayOf(5, 5)
        )
        assertEquals(7L, Solution().mostPoints(questions))
    }

    @Test
    fun singleQuestion() {
        assertEquals(2L, Solution().mostPoints(arrayOf(intArrayOf(2, 0))))
    }

    @Test
    fun skipAllButLast() {
        val questions = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(1, 0),
            intArrayOf(10, 0)
        )
        assertEquals(11L, Solution().mostPoints(questions))
    }
}
