package sumofflooredpairs

// Time:  O(n/1+n/2+...+n/n) = O(nlogn), n is the max of nums
// Space: O(n)
class Solution {
    fun sumOfFlooredPairs(nums: IntArray): Int {
        val MOD = 1_000_000_007
        val prefix = IntArray((nums.maxOrNull() ?: 0) + 1)
        val count = HashMap<Int, Int>()
        for (num in nums) {
            count[num] = (count[num] ?: 0) + 1
        }
        for ((num, cnt) in count) {
            var j = num
            while (j < prefix.size) {
                prefix[j] += cnt
                j += num
            }
        }
        for (i in 0 until prefix.size - 1) {
            prefix[i + 1] += prefix[i]
        }
        var total = 0
        for (x in nums) {
            total = (total + prefix[x]) % MOD
        }
        return total
    }
}
