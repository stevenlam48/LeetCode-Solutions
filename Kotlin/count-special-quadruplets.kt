package countspecialquadruplets

// Time:  O(n^3)
// Space: O(n)

class Solution {
    fun countQuadruplets(nums: IntArray): Int {
        var result = 0
        val lookup = HashMap<Int, Int>()
        lookup[nums[nums.size - 1]] = 1
        for (c in nums.size - 2 downTo 2) {
            for (b in 1 until c) {
                for (a in 0 until b) {
                    val key = nums[a] + nums[b] + nums[c]
                    lookup[key]?.let { result += it }
                }
            }
            lookup[nums[c]] = (lookup[nums[c]] ?: 0) + 1
        }
        return result
    }
}
