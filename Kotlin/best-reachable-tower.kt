package bestreachabletower

// Time:  O(n)
// Space: O(1)

class Solution {
    fun bestTower(towers: Array<IntArray>, center: IntArray, radius: Int): IntArray {
        var best = -1
        var bestX = -1
        var bestY = -1
        for (t in towers) {
            val x = t[0]
            val y = t[1]
            val q = t[2]
            if (!(kotlin.math.abs(x - center[0]) + kotlin.math.abs(y - center[1]) <= radius)) {
                continue
            }
            if (q > best) {
                best = q
                bestX = x
                bestY = y
            } else if (q == best && (x < bestX || (x == bestX && y < bestY))) {
                bestX = x
                bestY = y
            }
        }
        return if (best != -1) intArrayOf(bestX, bestY) else intArrayOf(-1, -1)
    }
}
