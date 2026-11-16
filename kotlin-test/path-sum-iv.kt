package pathsumiv

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PathSumIVTest {
    private val solution = Solution()

    @Test
    fun sumsThreeRootToLeafPaths() {
        assertEquals(12, solution.pathSum(intArrayOf(113, 215, 221)))
    }

    @Test
    fun sumsSinglePathWithTwoNodes() {
        assertEquals(4, solution.pathSum(intArrayOf(113, 221)))
    }

    @Test
    fun sumsPathsWithDifferentDepths() {
        assertEquals(13, solution.pathSum(intArrayOf(113, 215, 221, 331)))
    }

    @Test
    fun handlesSingleNode() {
        assertEquals(5, solution.pathSum(intArrayOf(115)))
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals(0, solution.pathSum(IntArray(0)))
    }
}
