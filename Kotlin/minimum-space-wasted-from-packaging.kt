package minimumspacewastedfrompackaging

// Time:  O(mlogm + nlogn + mlogn)
// Space: O(1)

class Solution {
    fun minWastedSpace(packages: IntArray, boxes: Array<IntArray>): Int {
        val mod = 1_000_000_007L
        val inf = Long.MAX_VALUE
        packages.sort()
        var result = inf
        for (box in boxes) {
            box.sort()
            if (box.last() < packages.last()) {
                continue
            }
            var curr = 0L
            var left = 0
            for (b in box) {
                val right = upperBound(packages, left, b)
                curr += b.toLong() * (right - left)
                left = right
            }
            result = minOf(result, curr)
        }
        val total = packages.sumOf { it.toLong() }
        return if (result != inf) ((result - total) % mod).toInt() else -1
    }

    private fun upperBound(packages: IntArray, left: Int, value: Int): Int {
        var low = left
        var high = packages.size
        while (low < high) {
            val mid = low + (high - low) / 2
            if (packages[mid] <= value) {
                low = mid + 1
            } else {
                high = mid
            }
        }
        return low
    }
}
