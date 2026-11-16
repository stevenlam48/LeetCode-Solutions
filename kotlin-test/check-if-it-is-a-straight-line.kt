package checkifitisastraightline

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfItIsAStraightLineTest {
    private val solution = Solution()

    @Test
    fun diagonalLine() {
        assertTrue(solution.checkStraightLine(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
            intArrayOf(5, 6),
            intArrayOf(6, 7)
        )))
    }

    @Test
    fun nonCollinearPoint() {
        assertFalse(solution.checkStraightLine(arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
            intArrayOf(5, 6),
            intArrayOf(7, 7)
        )))
    }

    @Test
    fun verticalLine() {
        assertTrue(solution.checkStraightLine(arrayOf(
            intArrayOf(2, 1),
            intArrayOf(2, 5),
            intArrayOf(2, -3)
        )))
    }

    @Test
    fun twoPoints() {
        assertTrue(solution.checkStraightLine(arrayOf(intArrayOf(0, 0), intArrayOf(1, 1))))
    }
}
