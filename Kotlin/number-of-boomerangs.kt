package numberofboomerangs

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun numberOfBoomerangs(points: Array<IntArray>): Int {
        var result = 0

        for (i in points.indices) {
            val group = HashMap<Int, Int>()
            for (j in points.indices) {
                if (j == i) {
                    continue
                }
                val dx = points[i][0] - points[j][0]
                val dy = points[i][1] - points[j][1]
                val key = dx * dx + dy * dy
                group[key] = (group[key] ?: 0) + 1
            }

            for (p in group.values) {
                if (p > 1) {
                    result += p * (p - 1)
                }
            }
        }

        return result
    }
}
