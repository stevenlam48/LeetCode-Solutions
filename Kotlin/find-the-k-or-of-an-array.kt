package findthekorofanarray

// Time:  O(nlogr)
// Space: O(1)

class Solution {
    fun findKOr(nums: IntArray, k: Int): Int {
        var result = 0
        val mx = nums.max()
        val l = if (mx != 0) 31 - Integer.numberOfLeadingZeros(mx) else -1
        for (i in 0..l) {
            var cnt = 0
            for (x in nums) {
                if ((x and (1 shl i)) == 0) {
                    continue
                }
                if (++cnt == k) {
                    result += 1 shl i
                    break
                }
            }
        }
        return result
    }
}
