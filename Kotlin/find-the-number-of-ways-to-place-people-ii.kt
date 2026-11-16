package findthenumberofwaystoplacepeopleii

// Time:  O(n^2)
// Space: O(1)
class Solution {
    fun numberOfPairs(points: Array<IntArray>): Int {
        points.sortWith(Comparator { a, b ->
            if (a[0] != b[0]) a[0].compareTo(b[0]) else b[1].compareTo(a[1])
        })
        var result = 0
        for (i in points.indices) {
            var y = Int.MIN_VALUE
            for (j in i + 1 until points.size) {
                if (points[i][1] < points[j][1]) {
                    continue
                }
                if (points[j][1] > y) {
                    y = points[j][1]
                    ++result
                }
            }
        }
        return result
    }
}
