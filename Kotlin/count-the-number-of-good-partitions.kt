package countthenumberofgoodpartitions

// Time:  O(n)
// Space: O(n)

// hash table, combinatorics
class Solution {
    fun numberOfGoodPartitions(nums: IntArray): Int {
        val MOD = 1_000_000_007

        val lookup = HashMap<Int, Int>()
        for (i in nums.indices) {
            lookup[nums[i]] = i
        }
        var result = 1
        var right = 0
        for (left in nums.indices) {
            if (left == right + 1) {
                result = (result shl 1) % MOD
            }
            right = maxOf(right, lookup[nums[left]]!!)
        }
        return result
    }
}
