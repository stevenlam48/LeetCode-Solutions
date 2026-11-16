package specialarrayii

// Time:  O(n + q)
// Space: O(n)

class Solution {
    fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
        val prefix = IntArray(nums.size + 1)
        for (i in 0 until nums.size - 1) {
            prefix[i + 1] = prefix[i] + if ((nums[i + 1] and 1) != (nums[i] and 1)) 1 else 0
        }
        val result = BooleanArray(queries.size)
        for (i in queries.indices) {
            result[i] = prefix[queries[i][1]] - prefix[queries[i][0]] == queries[i][1] - queries[i][0]
        }
        return result
    }
}
