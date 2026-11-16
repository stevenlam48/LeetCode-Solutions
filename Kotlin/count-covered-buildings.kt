package countcoveredbuildings

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countCoveredBuildings(n: Int, buildings: Array<IntArray>): Int {
        val left = IntArray(n) { n }
        val right = IntArray(n) { -1 }
        val up = IntArray(n) { -1 }
        val down = IntArray(n) { n }
        for (b in buildings) {
            val x = b[0] - 1
            val y = b[1] - 1
            left[y] = minOf(left[y], x)
            right[y] = maxOf(right[y], x)
            up[x] = maxOf(up[x], y)
            down[x] = minOf(down[x], y)
        }
        var result = 0
        for (b in buildings) {
            val x = b[0] - 1
            val y = b[1] - 1
            if (left[y] < x && x < right[y] && down[x] < y && y < up[x]) {
                ++result
            }
        }
        return result
    }
}
