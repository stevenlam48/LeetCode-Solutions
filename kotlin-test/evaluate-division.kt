package evaluatedivision

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EvaluateDivisionTest {
    private val solution = Solution()

    private fun assertResults(expected: DoubleArray, actual: DoubleArray) {
        assertEquals(expected.size, actual.size)
        for (i in expected.indices) {
            assertEquals(expected[i], actual[i], 1e-5, "query $i")
        }
    }

    @Test
    fun testExample1() {
        val result = solution.calcEquation(
            arrayOf(arrayOf("a", "b"), arrayOf("b", "c")),
            doubleArrayOf(2.0, 3.0),
            arrayOf(
                arrayOf("a", "c"), arrayOf("b", "a"),
                arrayOf("a", "e"), arrayOf("a", "a"), arrayOf("x", "x")
            )
        )
        assertResults(doubleArrayOf(6.0, 0.5, -1.0, 1.0, -1.0), result)
    }

    @Test
    fun testExample2() {
        val result = solution.calcEquation(
            arrayOf(arrayOf("a", "b"), arrayOf("b", "c"), arrayOf("bc", "cd")),
            doubleArrayOf(1.5, 2.5, 5.0),
            arrayOf(
                arrayOf("a", "c"), arrayOf("c", "b"),
                arrayOf("bc", "cd"), arrayOf("cd", "bc")
            )
        )
        assertResults(doubleArrayOf(3.75, 0.4, 5.0, 0.2), result)
    }

    @Test
    fun testExample3() {
        val result = solution.calcEquation(
            arrayOf(arrayOf("a", "b")),
            doubleArrayOf(0.5),
            arrayOf(
                arrayOf("a", "b"), arrayOf("b", "a"),
                arrayOf("a", "c"), arrayOf("x", "y")
            )
        )
        assertResults(doubleArrayOf(0.5, 2.0, -1.0, -1.0), result)
    }

    @Test
    fun testSelfQuery() {
        val result = solution.calcEquation(
            arrayOf(arrayOf("a", "b")),
            doubleArrayOf(2.0),
            arrayOf(arrayOf("a", "a"), arrayOf("b", "b"))
        )
        assertResults(doubleArrayOf(1.0, 1.0), result)
    }

    @Test
    fun testDisconnectedComponents() {
        val result = solution.calcEquation(
            arrayOf(arrayOf("a", "b"), arrayOf("c", "d")),
            doubleArrayOf(2.0, 3.0),
            arrayOf(arrayOf("a", "d"), arrayOf("c", "b"))
        )
        assertResults(doubleArrayOf(-1.0, -1.0), result)
    }

    @Test
    fun testEmptyQueries() {
        val result = solution.calcEquation(
            arrayOf(arrayOf("a", "b")),
            doubleArrayOf(2.0),
            arrayOf()
        )
        assertEquals(0, result.size)
    }
}
