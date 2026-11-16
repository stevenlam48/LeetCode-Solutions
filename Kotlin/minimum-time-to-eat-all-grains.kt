package minimumtimetoeatallgrains

// Time:  O(mlogm + nlogn + (m + n) * logr), r = 2*(max(max(hens), max(grains))-min(min(hens), min(grains))
// Space: O(1)

class Solution {
    fun minimumTime(hens: IntArray, grains: IntArray): Int {
        fun check(x: Int): Boolean {
            var i = 0
            for (h in hens) {
                var capacity = x
                if (h - grains[i] > x) {
                    return false
                } else if (h - grains[i] > 0) {
                    val distance = h - grains[i]
                    capacity = maxOf(x - 2 * distance, (x - distance) / 2)
                }
                while (i < grains.size && grains[i] <= h + capacity) {
                    ++i
                }
                if (i == grains.size) {
                    return true
                }
            }
            return false
        }

        hens.sort()
        grains.sort()
        var left = 0
        var right = 2 * (maxOf(hens.last(), grains.last()) - minOf(hens.first(), grains.first()))
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
