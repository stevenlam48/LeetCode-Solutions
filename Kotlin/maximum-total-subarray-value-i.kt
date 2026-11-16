package maximumtotalsubarrayvaluei

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxTotalValue(nums: IntArray, k: Int): Long {
        return k.toLong() * (nums.max() - nums.min())
    }
}
