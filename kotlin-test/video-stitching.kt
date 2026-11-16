package videostitching

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class VideoStitchingTest {
    private val solution = Solution()

    @Test
    fun stitchesStandardClips() {
        assertEquals(
            3,
            solution.videoStitching(clipsOf(0, 2, 4, 6, 8, 10, 1, 9, 1, 5, 5, 9), 10)
        )
    }

    @Test
    fun rejectsGapsAndUnreachableTargets() {
        assertEquals(-1, solution.videoStitching(clipsOf(0, 1, 1, 2), 5))
        assertEquals(-1, solution.videoStitching(clipsOf(1, 4), 3))
    }

    @Test
    fun choosesMinimumAvailableSeries() {
        assertEquals(2, solution.videoStitching(clipsOf(0, 4, 2, 8), 5))
        assertEquals(0, solution.videoStitching(emptyArray(), 0))
    }
}

private fun clipsOf(vararg values: Int): Array<IntArray> {
    return Array(values.size / 2) { intArrayOf(values[it * 2], values[it * 2 + 1]) }
}
