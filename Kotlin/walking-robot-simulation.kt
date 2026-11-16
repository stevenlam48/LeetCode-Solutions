package walkingrobotsimulation
// Time:  O(n + k)
// Space: O(k)

class Solution {
    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        val directions = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
        val lookup = HashSet<Pair<Int, Int>>()
        for (obstacle in obstacles) {
            lookup.add(obstacle[0] to obstacle[1])
        }
        var result = 0
        var x = 0
        var y = 0
        var i = 0
        for (cmd in commands) {
            if (cmd == -2) {
                i = (i - 1 + 4) % 4
            } else if (cmd == -1) {
                i = (i + 1).rem(4)
            } else {
                repeat(cmd) {
                    val next = x + directions[i].first to y + directions[i].second
                    if (next !in lookup) {
                        x = next.first
                        y = next.second
                        result = maxOf(result, x * x + y * y)
                    }
                }
            }
        }
        return result
    }
}
