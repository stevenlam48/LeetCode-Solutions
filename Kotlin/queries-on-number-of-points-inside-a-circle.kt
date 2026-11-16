package queriesonnumberofpointsinsideacircle

// Time:  O(q * n)
// Space: O(1)

class Solution {
    fun countPoints(points: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val result = mutableListOf<Int>()
        for (q in queries) {
            result.add(0)
            for (p in points) {
                val dx = p[0] - q[0]
                val dy = p[1] - q[1]
                if (dx * dx + dy * dy <= q[2] * q[2]) {
                    result[result.size - 1]++
                }
            }
        }
        return result.toIntArray()
    }
}
