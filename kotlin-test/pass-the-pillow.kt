package passthepillow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PassThePillowTest {
    private val solution = Solution()

    @Test
    fun handlesDirectionReversal() {
        assertEquals(2, solution.passThePillow(4, 5))
    }

    @Test
    fun returnsPositionBeforeReversal() {
        assertEquals(3, solution.passThePillow(3, 2))
    }

    @Test
    fun alternatesBetweenTwoPeople() {
        assertEquals(2, solution.passThePillow(2, 1))
        assertEquals(1, solution.passThePillow(2, 2))
    }

    @Test
    fun handlesMultipleCompleteCycles() {
        assertEquals(5, solution.passThePillow(5, 12))
    }
}
