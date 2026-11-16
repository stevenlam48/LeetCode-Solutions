package averageheightofbuildingsineachsegment

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun averageHeightOfBuildings(buildings: Array<IntArray>): Array<IntArray> {
        val points = mutableListOf<IntArray>()
        for (b in buildings) {
            points.add(intArrayOf(b[0], 1, b[2]))
            points.add(intArrayOf(b[1], -1, b[2]))
        }
        points.sortWith(compareBy({ it[0] }, { it[1] }, { it[2] }))
        val result = mutableListOf<IntArray>()
        var total = 0
        var cnt = 0
        var prev = -1
        for ((curr, c, h) in points) {
            if (cnt != 0 && prev != curr) {
                if (result.isNotEmpty() && result.last()[1] == prev && result.last()[2] == total / cnt) {
                    result.last()[1] = curr
                } else {
                    result.add(intArrayOf(prev, curr, total / cnt))
                }
            }
            total += h * c
            cnt += c
            prev = curr
        }
        return result.toTypedArray()
    }
}
