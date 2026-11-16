package robotboundedincircle

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RobotBoundedInCircleTest {
    @Test
    fun leetCodeExampleBounded() {
        assertTrue(Solution().isRobotBounded("GGLLGG"))
    }

    @Test
    fun leetCodeExampleUnbounded() {
        assertFalse(Solution().isRobotBounded("GG"))
    }

    @Test
    fun leetCodeExampleSingleLoop() {
        assertTrue(Solution().isRobotBounded("GL"))
    }

    @Test
    fun emptyInstructionsStaysAtOrigin() {
        assertTrue(Solution().isRobotBounded(""))
    }

    @Test
    fun onlyTurnsStaysAtOrigin() {
        assertTrue(Solution().isRobotBounded("GRGRGR"))
    }

    @Test
    fun movesNorthAndFacesNorth() {
        assertFalse(Solution().isRobotBounded("GGRRRR"))
    }
}
