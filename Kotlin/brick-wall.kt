package brickwall

// Time:  O(n), n is the total number of the bricks
// Space: O(m), m is the total number different widths

class Solution {
    fun leastBricks(wall: Array<IntArray>): Int {
        val widths = HashMap<Int, Int>()
        var result = wall.size
        for (row in wall) {
            var width = 0
            for (i in 0 until row.size - 1) {
                width += row[i]
                val count = (widths[width] ?: 0) + 1
                widths[width] = count
                result = minOf(result, wall.size - count)
            }
        }
        return result
    }
}
