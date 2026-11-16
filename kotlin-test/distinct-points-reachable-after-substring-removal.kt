package distinctpointsreachableaftersubstringremoval

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DistinctPointsReachableAfterSubstringRemovalTest {
    private val solution = Solution()

    @Test
    fun differentWindowEndpoints() {
        assertEquals(2, solution.distinctPoints("UD", 1))
    }

    @Test
    fun repeatedWindowEndpoint() {
        assertEquals(1, solution.distinctPoints("UU", 1))
    }

    @Test
    fun closedPath() {
        assertEquals(2, solution.distinctPoints("UDLR", 2))
    }

    @Test
    fun windowCoversWholeString() {
        assertEquals(1, solution.distinctPoints("URDL", 4))
    }
}
