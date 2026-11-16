package robotroomcleaner

// Time:  O(n), n is the number of cells
// Space: O(n)

interface Robot {
    fun move(): Boolean
    fun turnLeft()
    fun turnRight()
    fun clean()
}

class Solution {
    fun cleanRoom(robot: Robot) {
        val lookup = HashSet<Pair<Int, Int>>()
        dfs(Pair(0, 0), robot, 0, lookup)
    }

    private fun dfs(pos: Pair<Int, Int>, robot: Robot, dir: Int, lookup: HashSet<Pair<Int, Int>>) {
        robot.clean()
        var d = dir
        for (i in 0 until 4) {
            val newPos = Pair(pos.first + DIRECTIONS[d].first, pos.second + DIRECTIONS[d].second)
            if (newPos !in lookup) {
                lookup.add(newPos)
                if (robot.move()) {
                    dfs(newPos, robot, d, lookup)
                    goBack(robot)
                }
            }
            d = (d + 1) % 4
            robot.turnRight()
        }
    }

    private fun goBack(robot: Robot) {
        robot.turnLeft()
        robot.turnLeft()
        robot.move()
        robot.turnRight()
        robot.turnRight()
    }

    companion object {
        private val DIRECTIONS = arrayOf(
            Pair(0, 1),
            Pair(1, 0),
            Pair(0, -1),
            Pair(-1, 0)
        )
    }
}
