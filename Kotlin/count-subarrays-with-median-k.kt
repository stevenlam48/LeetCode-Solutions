package countsubarrayswithmediank
// Time:  O(n)
// Space: O(n)

class Solution {
    fun countSubarrays(nums: IntArray, k: Int): Int {
        val idx = nums.indexOf(k)
        val lookup = HashMap<Int, Int>()
        var curr = 0
        for (i in idx downTo 0) {
            curr += if (nums[i] == k) 0 else if (nums[i] < k) -1 else 1
            lookup[curr] = lookup.getOrDefault(curr, 0) + 1
        }
        var result = 0
        curr = 0
        for (i in idx until nums.size) {
            curr += if (nums[i] == k) 0 else if (nums[i] < k) -1 else 1
            result += lookup.getOrDefault(-curr, 0) + lookup.getOrDefault(-(curr - 1), 0)
        }
        return result
    }
}
