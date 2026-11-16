package minimumthresholdforinversionpairscount

// Time:  O(nlogn * logr)
// Space: O(n)

class Solution {
    fun minThreshold(nums: IntArray, k: Int): Int {
        val sorted = nums.toSortedSet().toIntArray()

        fun lowerBound(v: Int): Int {
            var lo = 0
            var hi = sorted.size
            while (lo < hi) {
                val mid = lo + (hi - lo) / 2
                if (sorted[mid] < v) {
                    lo = mid + 1
                } else {
                    hi = mid
                }
            }
            return lo
        }

        fun check(x: Int): Boolean {
            val fenwick = Fenwick(sorted.size)
            var cnt = 0L
            for (i in nums.indices.reversed()) {
                cnt += fenwick.sum(lowerBound(nums[i])) - fenwick.sum(lowerBound(nums[i] - x))
                fenwick.add(lowerBound(nums[i]))
            }
            return cnt >= k
        }

        var mx = nums[0]
        var right = 0
        for (i in 1 until nums.size) {
            right = maxOf(right, mx - nums[i])
            mx = maxOf(mx, nums[i])
        }
        var left = 0
        var hi = right
        while (left <= hi) {
            val mid = left + (hi - left) / 2
            if (check(mid)) {
                hi = mid - 1
            } else {
                left = mid + 1
            }
        }
        return if (left <= right) left else -1
    }

    private class Fenwick(n: Int) {
        private val size = n
        private val tree = IntArray(n + 1)

        fun add(i: Int) {
            var x = i + 1
            while (x <= size) {
                ++tree[x]
                x += x and -x
            }
        }

        fun sum(i: Int): Int {
            var x = i
            var result = 0
            while (x > 0) {
                result += tree[x]
                x -= x and -x
            }
            return result
        }
    }
}
