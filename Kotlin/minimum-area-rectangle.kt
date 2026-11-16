package minimumarearectangle

// Time:  O(n^1.5) on average
//        O(n^2) on worst
// Space: O(n)

class Solution {
    fun minAreaRect(points: Array<IntArray>): Int {
        val xSet = HashSet<Int>()
        val ySet = HashSet<Int>()
        for (point in points) {
            xSet.add(point[0])
            ySet.add(point[1])
        }
        val grouped = sortedMapOf<Int, MutableList<Int>>()
        if (xSet.size > ySet.size) {
            for (point in points) {
                grouped.getOrPut(point[0]) { mutableListOf() }.add(point[1])
            }
        } else {
            for (point in points) {
                grouped.getOrPut(point[1]) { mutableListOf() }.add(point[0])
            }
        }
        val lookup = HashMap<Pair<Int, Int>, Int>()
        var result = Int.MAX_VALUE
        for ((x, values) in grouped) {
            values.sort()
            for (j in values.indices) {
                for (i in 0 until j) {
                    val pair = Pair(values[i], values[j])
                    lookup[pair]?.let {
                        result = minOf(result, (x - it) * kotlin.math.abs(pair.second - pair.first))
                    }
                    lookup[pair] = x
                }
            }
        }
        return if (result != Int.MAX_VALUE) result else 0
    }
}
