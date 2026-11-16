package sortthestudentsbytheirkthscore

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SortTheStudentsByTheirKthScoreTest {
    @Test
    fun standardExample() {
        val score = arrayOf(
            intArrayOf(10, 6, 9, 1),
            intArrayOf(7, 5, 11, 2),
            intArrayOf(4, 8, 3, 15)
        )
        val expected = arrayOf(
            intArrayOf(7, 5, 11, 2),
            intArrayOf(10, 6, 9, 1),
            intArrayOf(4, 8, 3, 15)
        )
        assertMatrixEquals(expected, Solution().sortTheStudents(score, 2))
        assertMatrixEquals(expected, score)
    }

    @Test
    fun firstColumnCanBeSelected() {
        assertMatrixEquals(
            arrayOf(intArrayOf(9, 0), intArrayOf(5, 10), intArrayOf(1, 20)),
            Solution().sortTheStudents(
                arrayOf(intArrayOf(5, 10), intArrayOf(1, 20), intArrayOf(9, 0)),
                0
            )
        )
    }

    @Test
    fun singleStudentAndEmptyInput() {
        assertMatrixEquals(
            arrayOf(intArrayOf(2, 3)),
            Solution().sortTheStudents(arrayOf(intArrayOf(2, 3)), 1)
        )
        assertMatrixEquals(arrayOf(), Solution().sortTheStudents(arrayOf(), 0))
    }
}

private fun assertMatrixEquals(expected: Array<IntArray>, actual: Array<IntArray>) {
    assertEquals(expected.size, actual.size)
    for (i in expected.indices) {
        assertArrayEquals(expected[i], actual[i])
    }
}
