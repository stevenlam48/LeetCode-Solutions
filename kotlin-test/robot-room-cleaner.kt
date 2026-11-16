package robotroomcleaner

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RobotRoomCleanerTest {
    private class FakeRobot(
        private val room: Array<IntArray>,
        private var row: Int,
        private var col: Int,
        private var dir: Int = 0
    ) : Robot {
        val cleanedCells = HashSet<Pair<Int, Int>>()
        var moves = 0

        override fun move(): Boolean {
            val nr = row + DR[dir]
            val nc = col + DC[dir]
            if (nr in room.indices && nc in room[0].indices && room[nr][nc] == 1) {
                row = nr
                col = nc
                ++moves
                return true
            }
            return false
        }

        override fun turnLeft() {
            dir = (dir + 3) % 4
        }

        override fun turnRight() {
            dir = (dir + 1) % 4
        }

        override fun clean() {
            cleanedCells.add(Pair(row, col))
        }

        fun position(): Pair<Int, Int> = Pair(row, col)

        companion object {
            private val DR = intArrayOf(0, 1, 0, -1)
            private val DC = intArrayOf(1, 0, -1, 0)
        }
    }

    @Test
    fun cleansRingAroundBlockedCenter() {
        val room = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )
        val robot = FakeRobot(room, 0, 0)
        Solution().cleanRoom(robot)
        assertEquals(8, robot.cleanedCells.size)
        assertEquals(Pair(0, 0), robot.position())
    }

    @Test
    fun cleansCorridor() {
        val room = arrayOf(intArrayOf(1, 1, 1, 1))
        val robot = FakeRobot(room, 0, 0)
        Solution().cleanRoom(robot)
        assertEquals(4, robot.cleanedCells.size)
        assertEquals(Pair(0, 0), robot.position())
    }

    @Test
    fun singleCellRoom() {
        val room = arrayOf(intArrayOf(1))
        val robot = FakeRobot(room, 0, 0)
        Solution().cleanRoom(robot)
        assertEquals(1, robot.cleanedCells.size)
        assertEquals(0, robot.moves)
        assertEquals(Pair(0, 0), robot.position())
    }

    @Test
    fun cleansRoomWithInternalObstacles() {
        val room = arrayOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 0, 0, 1),
            intArrayOf(1, 1, 1, 1)
        )
        val robot = FakeRobot(room, 1, 0)
        Solution().cleanRoom(robot)
        assertEquals(10, robot.cleanedCells.size)
        assertEquals(Pair(1, 0), robot.position())
    }
}
