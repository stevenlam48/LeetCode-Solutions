package determineifasimplegraphexists

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DetermineIfASimpleGraphExistsTest {
    private val solution = Solution()

    @Test
    fun completeGraphDegreeSequenceExists() {
        assertTrue(solution.simpleGraphExists(intArrayOf(3, 3, 3, 3)))
    }

    @Test
    fun impossibleHighDegreesDoNotExist() {
        assertFalse(solution.simpleGraphExists(intArrayOf(3, 3, 3, 1)))
    }

    @Test
    fun oddDegreeSumDoesNotExist() {
        assertFalse(solution.simpleGraphExists(intArrayOf(2, 2, 1)))
    }

    @Test
    fun pathAndIsolatedVerticesExist() {
        assertTrue(solution.simpleGraphExists(intArrayOf(1, 1, 0, 0)))
    }

    @Test
    fun emptyDegreeSequenceExists() {
        assertTrue(solution.simpleGraphExists(intArrayOf()))
    }
}
