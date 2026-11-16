package pathcrossing

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PathCrossingTest {
    private val solution = Solution()

    @Test
    fun detectsRevisitedPoint() {
        assertTrue(solution.isPathCrossing("NESWW"))
    }

    @Test
    fun acceptsPathWithoutRevisitedPoint() {
        assertFalse(solution.isPathCrossing("NES"))
    }

    @Test
    fun handlesEmptyPath() {
        assertFalse(solution.isPathCrossing(""))
    }

    @Test
    fun detectsReturnToOrigin() {
        assertTrue(solution.isPathCrossing("NNSS"))
    }
}
