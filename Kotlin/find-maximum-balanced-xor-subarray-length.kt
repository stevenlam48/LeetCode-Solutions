package findmaximumbalancedxorsubarraylength

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxBalancedSubarray(nums: IntArray): Int {
        var result = 0
        var total = 0
        var bal = 0
        val lookup = HashMap<Pair<Int, Int>, Int>()
        lookup[Pair(total, bal)] = -1
        for (i in nums.indices) {
            total = total xor nums[i]
            bal += if (nums[i] % 2 != 0) 1 else -1
            val key = Pair(total, bal)
            if (!lookup.containsKey(key)) {
                lookup[key] = i
            } else {
                result = maxOf(result, i - lookup[key]!!)
            }
        }
        return result
    }
}
