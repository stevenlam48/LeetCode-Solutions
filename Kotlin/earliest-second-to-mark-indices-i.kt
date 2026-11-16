package earliestsecondtomarkindicesi

// Time:  O(mlogm)
// Space: O(n)

// binary search, greedy
class Solution {
    fun earliestSecondToMarkIndices(nums: IntArray, changeIndices: IntArray): Int {
        fun check(t: Int): Boolean {
            val lookup = IntArray(nums.size) { -1 }
            for (i in 0 until t) {
                lookup[changeIndices[i] - 1] = i
            }
            if (lookup.any { it == -1 }) {
                return false
            }
            var cnt = 0
            for (i in 0 until t) {
                if (i != lookup[changeIndices[i] - 1]) {
                    ++cnt
                    continue
                }
                cnt -= nums[changeIndices[i] - 1]
                if (cnt < 0) {
                    return false
                }
            }
            return true
        }

        var left = nums.sumOf { it.toLong() } + nums.size
        var right = changeIndices.size.toLong()
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mid.toInt())) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return if (left <= changeIndices.size) left.toInt() else -1
    }
}
