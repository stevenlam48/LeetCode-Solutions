package lastdaywhereyoucanstillcross

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LastDayWhereYouCanStillCrossTest {
    private val solution = Solution()

    @Test
    fun findsLatestDayWithVerticalFloodOrder() {
        assertEquals(
            2,
            solution.latestDayToCross(
                2,
                2,
                arrayOf(intArrayOf(1, 1), intArrayOf(2, 1), intArrayOf(1, 2), intArrayOf(2, 2))
            )
        )
    }

    @Test
    fun findsLatestDayWithHorizontalFloodOrder() {
        assertEquals(
            1,
            solution.latestDayToCross(
                2,
                2,
                arrayOf(intArrayOf(1, 1), intArrayOf(1, 2), intArrayOf(2, 1), intArrayOf(2, 2))
            )
        )
    }

    @Test
    fun handlesThreeByThreeGrid() {
        assertEquals(
            3,
            solution.latestDayToCross(
                3,
                3,
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 1),
                    intArrayOf(3, 3),
                    intArrayOf(2, 2),
                    intArrayOf(1, 1),
                    intArrayOf(3, 1),
                    intArrayOf(2, 3),
                    intArrayOf(3, 2),
                    intArrayOf(1, 3)
                )
            )
        )
    }

    @Test
    fun handlesSingleCell() {
        assertEquals(0, solution.latestDayToCross(1, 1, arrayOf(intArrayOf(1, 1))))
    }
}
