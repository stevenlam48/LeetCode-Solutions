package countartifactsthatcanbeextracted

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountArtifactsThatCanBeExtractedTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        val artifacts = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 1, 1, 1)
        )
        val dig = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1)
        )
        assertEquals(1, solution.digArtifacts(2, artifacts, dig))
    }

    @Test
    fun testExampleTwo() {
        val artifacts = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 1, 1, 1)
        )
        val dig = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 1)
        )
        assertEquals(2, solution.digArtifacts(2, artifacts, dig))
    }

    @Test
    fun testPartialDig() {
        val artifacts = arrayOf(intArrayOf(0, 0, 1, 1))
        val dig = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 0)
        )
        assertEquals(0, solution.digArtifacts(2, artifacts, dig))
    }
}
