package maximumstudentstakingexam

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumStudentsTakingExamTest {
    @Test
    fun example1() {
        val seats = arrayOf(
            charArrayOf('#', '.', '#', '#', '.', '#'),
            charArrayOf('.', '#', '#', '#', '#', '.'),
            charArrayOf('#', '.', '#', '#', '.', '#')
        )
        assertEquals(4, Solution().maxStudents(seats))
    }

    @Test
    fun example2() {
        val seats = arrayOf(
            charArrayOf('.', '#'),
            charArrayOf('#', '#'),
            charArrayOf('#', '.'),
            charArrayOf('#', '#'),
            charArrayOf('.', '#')
        )
        assertEquals(3, Solution().maxStudents(seats))
    }

    @Test
    fun example3() {
        val seats = arrayOf(
            charArrayOf('#', '.', '.', '.', '#'),
            charArrayOf('.', '#', '.', '#', '.'),
            charArrayOf('.', '.', '#', '.', '.'),
            charArrayOf('.', '#', '.', '#', '.'),
            charArrayOf('#', '.', '.', '.', '#')
        )
        assertEquals(10, Solution().maxStudents(seats))
    }

    @Test
    fun singleSeat() {
        assertEquals(1, Solution().maxStudents(arrayOf(charArrayOf('.'))))
    }

    @Test
    fun singleBrokenSeat() {
        assertEquals(0, Solution().maxStudents(arrayOf(charArrayOf('#'))))
    }
}
