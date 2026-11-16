package makesumdivisiblebyp

// Time:  O(n)
// Space: O(p)

class Solution {
    fun minSubarray(nums: IntArray, p: Int): Int {
        var residue = 0
        for (num in nums) {
            residue = (residue + num) % p
        }
        if (residue == 0) {
            return 0
        }
        var result = nums.size
        val lookup = HashMap<Int, Int>()
        lookup[0] = -1
        var curr = 0
        for (i in nums.indices) {
            curr = (curr + nums[i]) % p
            lookup[curr] = i
            val need = (curr - residue + p) % p
            val prev = lookup[need]
            if (prev != null) {
                result = minOf(result, i - prev)
            }
        }
        return if (result < nums.size) result else -1
    }
}
