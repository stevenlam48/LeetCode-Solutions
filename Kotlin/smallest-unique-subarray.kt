package smallestuniquesubarray

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun smallestUniqueSubarray(nums: IntArray): Int {
        val mod = 1_000_000_007L
        val b = 29L
        val n = nums.size
        val prefix = LongArray(n + 1)
        for (i in 0 until n) {
            prefix[i + 1] = (prefix[i] * b + nums[i]) % mod
        }
        val base = LongArray(n + 1) { 1L }
        for (i in 0 until n) {
            base[i + 1] = base[i] * b % mod
        }

        fun getHash(l: Int, r: Int): Long {
            if (l > r) {
                return 0L
            }
            return (prefix[r + 1] - prefix[l] * base[r - l + 1] % mod + mod) % mod
        }

        fun check(l: Int): Boolean {
            val cnt = HashMap<Long, Int>()
            var i = 0
            while (i + l - 1 < n) {
                val h = getHash(i, i + l - 1)
                cnt[h] = (cnt[h] ?: 0) + 1
                ++i
            }
            for (x in cnt.values) {
                if (x == 1) {
                    return true
                }
            }
            return false
        }

        var left = 1
        var right = n - 1
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
