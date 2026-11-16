package nearestavailabledrone
// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun nearestDrone(drones: Array<IntArray>, target: IntArray): Int {
        var result = -1
        var mn = Int.MAX_VALUE
        for (i in drones.indices) {
            val dist = abs(drones[i][0] - target[0]) + abs(drones[i][1] - target[1])
            if (dist > drones[i][2] || dist >= mn) {
                continue
            }
            mn = dist
            result = i
        }
        return result
    }
}
