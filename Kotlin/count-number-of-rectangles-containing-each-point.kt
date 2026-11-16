package countnumberofrectanglescontainingeachpoint

// Time:  O(nlogn + m * max_y * logn), n = len(rectangles), m = len(points)
// Space: O(n)

class Solution {
    fun countRectangles(rectangles: Array<IntArray>, points: Array<IntArray>): IntArray {
        val maxY = rectangles.maxOf { it[1] }
        val buckets = Array(maxY + 1) { mutableListOf<Int>() }
        for (rec in rectangles) {
            buckets[rec[1]].add(rec[0])
        }
        for (bucket in buckets) {
            bucket.sort()
        }
        val result = IntArray(points.size)
        for ((i, p) in points.withIndex()) {
            var cnt = 0
            for (y in p[1]..maxY) {
                val bucket = buckets[y]
                var left = 0
                var right = bucket.size
                while (left < right) {
                    val mid = (left + right) ushr 1
                    if (bucket[mid] < p[0]) {
                        left = mid + 1
                    } else {
                        right = mid
                    }
                }
                cnt += bucket.size - left
            }
            result[i] = cnt
        }
        return result
    }
}
