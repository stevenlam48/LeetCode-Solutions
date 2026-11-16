package lengthofthelongestincreasingpath

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun maxPathLength(coordinates: Array<IntArray>, k: Int): Int {
        val longestIncreasingSubsequence = { arr: List<Int> ->
            val result = ArrayList<Int>()
            for (x in arr) {
                var lo = 0
                var hi = result.size
                while (lo < hi) {
                    val mid = (lo + hi) / 2
                    if (result[mid] < x) {
                        lo = mid + 1
                    } else {
                        hi = mid
                    }
                }
                if (lo == result.size) {
                    result.add(x)
                } else {
                    result[lo] = x
                }
            }
            result.size
        }

        val target = coordinates[k].copyOf()
        coordinates.sortWith(Comparator { a, b ->
            if (a[0] != b[0]) a[0].compareTo(b[0]) else b[1].compareTo(a[1])
        })
        val left = ArrayList<Int>()
        val right = ArrayList<Int>()
        for (x in coordinates) {
            if (x[0] < target[0] && x[1] < target[1]) {
                left.add(x[1])
            } else if (x[0] > target[0] && x[1] > target[1]) {
                right.add(x[1])
            }
        }
        return longestIncreasingSubsequence(left) + 1 + longestIncreasingSubsequence(right)
    }
}
