package smallestindexwithdigitsumequaltoindex

// Time:  O(nlogr)
// Space: O(1)

class Solution {
    fun smallestIndex(nums: IntArray): Int {
        fun total(x0: Int): Int {
            var x = x0
            var result = 0
            while (x != 0) {
                result += x % 10
                x /= 10
            }
            return result
        }

        for (i in nums.indices) {
            if (total(nums[i]) == i) {
                return i
            }
        }
        return -1
    }
}
