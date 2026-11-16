package thescoreofstudentssolvingmathexpression

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheScoreOfStudentsSolvingMathExpressionTest {

    @Test
    fun testExample1() {
        assertEquals(19, Solution().scoreOfStudents("3+5*2", intArrayOf(13, 0, 10, 13, 13, 16, 16)))
    }

    @Test
    fun testExample2() {
        assertEquals(10, Solution().scoreOfStudents("6+0*1", intArrayOf(12, 9, 6, 4, 8, 6)))
    }

    @Test
    fun testSimpleAddition() {
        assertEquals(10, Solution().scoreOfStudents("1+2", intArrayOf(3, 2, 3)))
    }

    @Test
    fun testSimpleMultiplication() {
        assertEquals(5, Solution().scoreOfStudents("2*2", intArrayOf(4)))
    }

    @Test
    fun testAllWrong() {
        assertEquals(0, Solution().scoreOfStudents("1+1", intArrayOf(1, 11, 0)))
    }
}
