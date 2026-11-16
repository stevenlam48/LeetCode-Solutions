package countroutestoclimbarectangulargrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountRoutesToClimbARectangularGridTest {
    private val solution = Solution()

    @Test
    fun singleOpenRow() {
        assertEquals(7, solution.numberOfRoutes(listOf("..."), 1))
    }

    @Test
    fun openGrid() {
        assertEquals(8, solution.numberOfRoutes(listOf("..", ".."), 1))
    }

    @Test
    fun singleVerticalRoute() {
        assertEquals(1, solution.numberOfRoutes(listOf(".", "."), 1))
    }

    @Test
    fun blockedCell() {
        assertEquals(0, solution.numberOfRoutes(listOf("#"), 1))
    }
}
