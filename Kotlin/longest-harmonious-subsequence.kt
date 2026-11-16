package longestharmonioussubsequence

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findLHS(nums: IntArray): Int {
        val lookup = HashMap<Int, Int>()
        var result = 0
        for (num in nums) {
            lookup[num] = (lookup[num] ?: 0) + 1
            for (diff in intArrayOf(-1, 1)) {
                if (lookup.containsKey(num + diff)) {
                    result = maxOf(result, lookup[num]!! + lookup[num + diff]!!)
                }
            }
        }
        return result
    }
}
