package maximummanhattandistanceafterkchanges

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumManhattanDistanceAfterKChangesTest {
    private val solution = Solution()

    @Test
    fun `maximizes distance at an intermediate prefix`() {
        assertEquals(3, solution.maxDistance("NWSE", 1))
    }

    @Test
    fun `uses changes while respecting prefix length`() {
        assertEquals(3, solution.maxDistance("NSW", 1))
    }

    @Test
    fun `handles zero changes`() {
        assertEquals(1, solution.maxDistance("NS", 0))
    }

    @Test
    fun `handles an empty path`() {
        assertEquals(0, solution.maxDistance("", 2))
    }
}
