package filteroccupiedintervals

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun filterOccupiedIntervals(occupiedIntervals: Array<IntArray>, freeStart: Int, freeEnd: Int): Array<IntArray> {
        val merged = mutableListOf<IntArray>()
        for (x in occupiedIntervals.sortedWith(compareBy { it[0] })) {
            if (merged.isEmpty() || merged.last()[1] + 1 < x[0]) {
                merged.add(x.copyOf())
            } else {
                merged.last()[1] = maxOf(merged.last()[1], x[1])
            }
        }

        val result = mutableListOf<IntArray>()
        for (x in merged) {
            if (!overlapped(x, intArrayOf(freeStart, freeEnd))) {
                result.add(x)
                continue
            }
            if (x[0] <= freeStart - 1) {
                result.add(intArrayOf(x[0], freeStart - 1))
            }
            if (freeEnd + 1 <= x[1]) {
                result.add(intArrayOf(freeEnd + 1, x[1]))
            }
        }
        return result.toTypedArray()
    }

    private fun overlapped(a: IntArray, b: IntArray): Boolean {
        return maxOf(a[0], b[0]) <= minOf(a[1], b[1])
    }
}
