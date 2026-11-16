package countsubarrayswithmoreonesthanzeros
// Time:  O(n)
// Space: O(n)

class Solution {
    fun subarraysWithMoreZerosThanOnes(nums: IntArray): Int {
        val mod = 1_000_000_007
        val lookup = IntArray(2 * nums.size + 1)
        lookup[nums.size] = 1
        var result = 0
        var total = 0
        var same = 0
        var more = 0
        for (num in nums) {
            total += if (num == 1) 1 else -1
            val newSame = lookup[total + nums.size]
            val newMore = if (num == 1) (same + more + 1) % mod else (more - newSame + mod) % mod
            ++lookup[total + nums.size]
            result = (result + newMore) % mod
            same = newSame
            more = newMore
        }
        return result
    }
}
