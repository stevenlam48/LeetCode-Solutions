package snakeinmatrix

// Time:  O(c)
// Space: O(1)

class Solution {
    fun finalPositionOfSnake(n: Int, commands: List<String>): Int {
        val lookup = mapOf(
            "UP" to Pair(-1, 0),
            "RIGHT" to Pair(0, 1),
            "DOWN" to Pair(1, 0),
            "LEFT" to Pair(0, -1)
        )

        var r = 0
        var c = 0
        for (x in commands) {
            val (dr, dc) = lookup.getValue(x)
            r += dr
            c += dc
        }
        return r * n + c
    }
}
