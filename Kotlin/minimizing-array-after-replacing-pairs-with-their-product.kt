package minimizingarrayafterreplacingpairswiththeirproduct

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minArrayLength(nums: IntArray, k: Int): Int {
        if (nums.any { it == 0 }) {
            return 1
        }
        var result = nums.size
        var curr = nums[0].toLong()
        for (i in 1 until nums.size) {
            if (curr * nums[i] > k) {
                curr = nums[i].toLong()
            } else {
                curr *= nums[i]
                --result
            }
        }
        return result
    }
}
