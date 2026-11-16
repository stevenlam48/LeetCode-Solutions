package squirrelsimulation

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minDistance(height: Int, width: Int, tree: IntArray, squirrel: IntArray, nuts: Array<IntArray>): Int {
        var result = 0
        var d = Int.MAX_VALUE
        for (nut in nuts) {
            result += distance(nut, tree) * 2
            d = minOf(d, distance(nut, squirrel) - distance(nut, tree))
        }
        return result + d
    }

    private fun distance(a: IntArray, b: IntArray): Int {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1])
    }
}
