package beautifularrangement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BeautifulArrangementTest {
    private val solution = Solution()

    @Test
    fun singlePositionHasOneArrangement() {
        assertEquals(1, solution.countArrangement(1))
    }

    @Test
    fun twoPositionsHaveTwoArrangements() {
        assertEquals(2, solution.countArrangement(2))
    }

    @Test
    fun threePositionsHaveThreeArrangements() {
        assertEquals(3, solution.countArrangement(3))
    }

    @Test
    fun fourPositionsHaveEightArrangements() {
        assertEquals(8, solution.countArrangement(4))
    }
}
