package p3sumsmaller

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun threeSumSmaller(nums: IntArray, target: Int): Int {
        nums.sort()
        val n = nums.size

        var count = 0
        for (k in 2 until n) {
            var i = 0
            var j = k - 1
            while (i < j) {
                if (nums[i] + nums[j] + nums[k] >= target) {
                    --j
                } else {
                    count += j - i
                    ++i
                }
            }
        }

        return count
    }
}
