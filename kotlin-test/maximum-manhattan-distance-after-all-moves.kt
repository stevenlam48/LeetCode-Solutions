package maximummanhattandistanceafterallmoves

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumManhattanDistanceAfterAllMovesTest {
    private val solution = Solution()

    @Test
    fun `assigns wildcards away from the origin`() {
        assertEquals(3, solution.maxDistance("NW?"))
    }

    @Test
    fun `uses every wildcard for maximum distance`() {
        assertEquals(3, solution.maxDistance("_UU"))
    }

    @Test
    fun `handles moves without wildcards`() {
        assertEquals(2, solution.maxDistance("DR"))
    }

    @Test
    fun `handles no moves`() {
        assertEquals(0, solution.maxDistance(""))
    }
}
