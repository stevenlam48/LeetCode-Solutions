package maximizethetopmostelementafterkmoves

// Time:  O(min(n, k))
// Space: O(1)

class Solution {
    fun maximumTop(nums: IntArray, k: Int): Int {
        if (nums.size == 1 && k % 2 == 1) {
            return -1
        }
        if (k <= 1) {
            return nums[k]
        }
        var result = 0
        for (i in 0 until minOf(k + 1, nums.size)) {
            if (i != k - 1) {
                result = maxOf(result, nums[i])
            }
        }
        return result
    }
}
