package numberofwaystopaintn3grid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToPaintN3GridTest {
    @Test
    fun oneRow() {
        assertEquals(12, Solution().numOfWays(1))
    }

    @Test
    fun twoRows() {
        assertEquals(54, Solution().numOfWays(2))
    }

    @Test
    fun largeInput() {
        assertEquals(30228214, Solution().numOfWays(5000))
    }
}
