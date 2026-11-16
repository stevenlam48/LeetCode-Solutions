package robotboundedincircle

// Time:  O(n)
// Space: O(1)

class Solution {
    fun isRobotBounded(instructions: String): Boolean {
        var x = 0
        var y = 0
        var i = 0
        for (instruction in instructions) {
            when (instruction) {
                'R' -> i = (i + 1) % 4
                'L' -> i = (4 + i - 1) % 4
                else -> {
                    x += DIRECTIONS[i][0]
                    y += DIRECTIONS[i][1]
                }
            }
        }
        return (x == 0 && y == 0) || i > 0
    }

    companion object {
        private val DIRECTIONS = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0),
            intArrayOf(0, 1)
        )
    }
}
