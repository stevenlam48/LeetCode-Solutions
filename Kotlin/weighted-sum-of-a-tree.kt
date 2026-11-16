package weightedsumofatree

// Time:  O(n)
// Space: O(n)

// tree dp
class Solution {
    fun weightedSum(parent: IntArray, nums: IntArray): Long {
        val lookup = IntArray(nums.size) { -1 }
        lookup[0] = 0
        for (i in 1 until nums.size) {
            var d = 0
            var j = i
            while (lookup[j] == -1) {
                ++d
                j = parent[j]
            }
            d += lookup[j]
            j = i
            while (lookup[j] == -1) {
                lookup[j] = d--
                j = parent[j]
            }
        }
        val h = lookup.max()
        var result = 0L
        for (i in nums.indices) {
            result += nums[i] * (h - lookup[i] + 1L)
        }
        return result
    }
}
