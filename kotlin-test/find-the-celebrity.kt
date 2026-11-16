package findthecelebrity

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheCelebrityTest {
    @Test
    fun findsCelebrity() {
        val matrix = arrayOf(
            booleanArrayOf(true, true, false),
            booleanArrayOf(false, true, false),
            booleanArrayOf(true, true, true)
        )
        assertEquals(1, Solution { a, b -> matrix[a][b] }.findCelebrity(3))
    }

    @Test
    fun returnsMinusOneWhenThereIsNoCelebrity() {
        val matrix = arrayOf(
            booleanArrayOf(true, true, false),
            booleanArrayOf(false, true, true),
            booleanArrayOf(false, false, true)
        )
        assertEquals(-1, Solution { a, b -> matrix[a][b] }.findCelebrity(3))
    }

    @Test
    fun handlesSinglePerson() {
        assertEquals(0, Solution { _, _ -> false }.findCelebrity(1))
    }

    @Test
    fun rejectsCandidateUnknownByAnotherPerson() {
        val matrix = arrayOf(
            booleanArrayOf(true, false),
            booleanArrayOf(false, true)
        )
        assertEquals(-1, Solution { a, b -> matrix[a][b] }.findCelebrity(2))
    }
}
