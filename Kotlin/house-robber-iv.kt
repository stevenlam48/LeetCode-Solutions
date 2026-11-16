package houserobberiv
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minCapability(nums: IntArray, k: Int): Int {
        fun check(x: Int): Boolean {
            var cnt = 0
            var i = 0
            while (i < nums.size) {
                if (nums[i] <= x) {
                    ++cnt
                    ++i
                }
                ++i
            }
            return cnt >= k
        }

        val sortedNums = nums.toHashSet().sorted()
        var left = 0
        var right = sortedNums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(sortedNums[mid])) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return sortedNums[left]
    }
}
