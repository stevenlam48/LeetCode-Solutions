package minimumnumberoflinestocoverpoints

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfLinesToCoverPointsTest {
    private val solution = Solution()

    @Test
    fun threePointsWithoutCollinearTriple() {
        assertEquals(
            2,
            solution.minimumLines(arrayOf(intArrayOf(0, 1), intArrayOf(2, 2), intArrayOf(3, 3)))
        )
    }

    @Test
    fun threeCollinearPoints() {
        assertEquals(
            1,
            solution.minimumLines(arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(2, 2)))
        )
    }

    @Test
    fun squareNeedsTwoLines() {
        assertEquals(
            2,
            solution.minimumLines(
                arrayOf(
                    intArrayOf(0, 0), intArrayOf(0, 2),
                    intArrayOf(2, 0), intArrayOf(2, 2)
                )
            )
        )
    }

    @Test
    fun fourCollinearPoints() {
        assertEquals(
            1,
            solution.minimumLines(
                arrayOf(
                    intArrayOf(0, 0), intArrayOf(1, 0),
                    intArrayOf(2, 0), intArrayOf(3, 0)
                )
            )
        )
    }

    @Test
    fun twoPoints() {
        assertEquals(
            1,
            solution.minimumLines(arrayOf(intArrayOf(0, 0), intArrayOf(1, 1)))
        )
    }
}
