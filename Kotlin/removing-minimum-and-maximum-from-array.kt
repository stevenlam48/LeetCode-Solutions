package removingminimumandmaximumfromarray
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumDeletions(nums: IntArray): Int {
        var i = 0
        var j = 0
        for (k in nums.indices) {
            if (nums[k] < nums[i]) {
                i = k
            }
            if (nums[k] > nums[j]) {
                j = k
            }
        }
        if (i > j) {
            val tmp = i
            i = j
            j = tmp
        }
        return minOf(i + 1 + nums.size - j, j + 1, nums.size - i)
    }
}
