package anglebetweenhandsofaclock

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class AngleBetweenHandsOfAClockTest {
    private val solution = Solution()

    @Test
    fun clockExamples() {
        assertEquals(165.0, solution.angleClock(12, 30), 1e-9)
        assertEquals(75.0, solution.angleClock(3, 30), 1e-9)
        assertEquals(7.5, solution.angleClock(3, 15), 1e-9)
    }

    @Test
    fun handsOverlap() {
        assertEquals(0.0, solution.angleClock(12, 0), 1e-9)
    }

    @Test
    fun oppositeHands() {
        assertEquals(180.0, solution.angleClock(6, 0), 1e-9)
    }

    @Test
    fun smallerAngleIsReturned() {
        assertEquals(60.0, solution.angleClock(10, 0), 1e-9)
    }
}
