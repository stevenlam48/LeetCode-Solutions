package circulararrayloop

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CircularArrayLoopTest {
    private val solution = Solution()

    @Test
    fun forwardCycleWithMultipleElements() {
        assertTrue(solution.circularArrayLoop(intArrayOf(2, -1, 1, 2, 2)))
    }

    @Test
    fun backwardCycleWithMultipleElements() {
        assertTrue(solution.circularArrayLoop(intArrayOf(-1, -1)))
    }

    @Test
    fun singleElementSelfLoopsAreRejected() {
        assertFalse(solution.circularArrayLoop(intArrayOf(1)))
        assertFalse(solution.circularArrayLoop(intArrayOf(-1)))
    }

    @Test
    fun directionChangesPreventACycle() {
        assertFalse(solution.circularArrayLoop(intArrayOf(1, -1)))
        assertFalse(solution.circularArrayLoop(intArrayOf(0, 0)))
    }
}
