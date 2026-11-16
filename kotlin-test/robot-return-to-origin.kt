package robotreturntoorigin

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RobotReturnToOriginTest {
    @Test
    fun leetCodeExampleReturns() {
        assertTrue(Solution().judgeCircle("UD"))
    }

    @Test
    fun leetCodeExampleStaysRight() {
        assertFalse(Solution().judgeCircle("LL"))
    }

    @Test
    fun unequalVerticalAndHorizontalMoves() {
        assertFalse(Solution().judgeCircle("RRDD"))
    }

    @Test
    fun emptyMovesStaysAtOrigin() {
        assertTrue(Solution().judgeCircle(""))
    }

    @Test
    fun balancedLongSequence() {
        assertTrue(Solution().judgeCircle("ULDRULDR"))
    }

    @Test
    fun horizontalMismatch() {
        assertFalse(Solution().judgeCircle("LDRRLRUULR"))
    }
}
