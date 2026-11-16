package selfcrossing

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SelfCrossingTest {
    @Test
    fun loopCrossing() {
        assertTrue(Solution().isSelfCrossing(intArrayOf(2, 1, 1, 2)))
    }

    @Test
    fun expandingSpiralDoesNotCross() {
        assertFalse(Solution().isSelfCrossing(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun squareOverlap() {
        assertTrue(Solution().isSelfCrossing(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun fiveSegmentLoopOverlap() {
        assertTrue(Solution().isSelfCrossing(intArrayOf(1, 1, 2, 1, 1)))
    }

    @Test
    fun touchingWithoutCrossing() {
        assertFalse(Solution().isSelfCrossing(intArrayOf(3, 3, 3, 2, 1)))
    }

    @Test
    fun tooFewSegments() {
        assertFalse(Solution().isSelfCrossing(intArrayOf(1, 1, 1)))
    }
}
