package reachingpoints
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ReachingPointsTest {
    @Test
    fun leetCodeExamples() {
        assertTrue(Solution().reachingPoints(1, 1, 3, 5))
        assertFalse(Solution().reachingPoints(1, 1, 2, 2))
        assertTrue(Solution().reachingPoints(1, 1, 1, 1))
    }

    @Test
    fun longerReachableSequence() {
        assertTrue(Solution().reachingPoints(2, 3, 13, 8))
        assertTrue(Solution().reachingPoints(3, 2, 8, 13))
    }

    @Test
    fun unreachableAndLargeCoordinates() {
        assertFalse(Solution().reachingPoints(2, 3, 5, 7))
        assertFalse(Solution().reachingPoints(9, 5, 12, 8))
        assertTrue(Solution().reachingPoints(1, 1, 1_000_000_000, 1))
    }
}
