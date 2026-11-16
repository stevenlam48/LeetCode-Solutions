package numberofpathswithmaxscore

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NumberOfPathsWithMaxScoreTest {
    private val solution = Solution()

    @Test
    fun `finds the unique maximum score path`() {
        assertArrayEquals(
            intArrayOf(7, 1),
            solution.pathsWithMaxScore(listOf("E23", "2X2", "12S"))
        )
    }

    @Test
    fun `combines paths with equal maximum scores`() {
        assertArrayEquals(
            intArrayOf(4, 2),
            solution.pathsWithMaxScore(listOf("E12", "1X1", "21S"))
        )
    }

    @Test
    fun `returns zero when obstacles block every path`() {
        assertArrayEquals(
            intArrayOf(0, 0),
            solution.pathsWithMaxScore(listOf("E11", "XXX", "11S"))
        )
    }

    @Test
    fun `handles a single step and diagonal movement`() {
        assertArrayEquals(intArrayOf(0, 1), solution.pathsWithMaxScore(listOf("ES")))
        assertArrayEquals(intArrayOf(1, 1), solution.pathsWithMaxScore(listOf("E1", "XS")))
    }
}
