package walkingrobotsimulationii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WalkingRobotSimulationIiTest {
    @Test
    fun mirrorsLeetCodeOperationSequence() {
        val robot = Robot(6, 3)
        robot.move(2)
        assertArrayEquals(intArrayOf(2, 0), robot.getPos())
        assertEquals("East", robot.getDir())
        robot.move(2)
        assertArrayEquals(intArrayOf(4, 0), robot.getPos())
        assertEquals("East", robot.getDir())
        robot.move(2)
        assertArrayEquals(intArrayOf(5, 1), robot.getPos())
        assertEquals("North", robot.getDir())
        robot.move(1)
        assertArrayEquals(intArrayOf(5, 2), robot.getPos())
        assertEquals("North", robot.getDir())
        robot.move(3)
        assertArrayEquals(intArrayOf(2, 2), robot.getPos())
        assertEquals("West", robot.getDir())
    }

    @Test
    fun handlesInitialStateAndFullCircuit() {
        val robot = Robot(6, 3)
        assertArrayEquals(intArrayOf(0, 0), robot.getPos())
        assertEquals("East", robot.getDir())
        robot.move(14)
        assertArrayEquals(intArrayOf(0, 0), robot.getPos())
        assertEquals("South", robot.getDir())
        robot.move(14)
        assertArrayEquals(intArrayOf(0, 0), robot.getPos())
        assertEquals("South", robot.getDir())
    }

    @Test
    fun usesPerimeterModuloForLongMoves() {
        val robot = Robot(4, 2)
        robot.move(12)
        assertArrayEquals(intArrayOf(3, 1), robot.getPos())
        assertEquals("North", robot.getDir())
        robot.move(4)
        assertArrayEquals(intArrayOf(0, 0), robot.getPos())
        assertEquals("South", robot.getDir())
    }
}
