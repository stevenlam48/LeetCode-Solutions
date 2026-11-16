package minimizearraysumusingdivisiblereplacements

// Time:  O(n + rlogr), r = max(nums)
// Space: O(r)

class Solution {
    fun minArraySum(nums: IntArray): Long {
        val mx = nums.max()
        val lookup = IntArray(mx + 1)
        for (x in nums) {
            lookup[x] = x
        }
        for (i in 1..mx) {
            if (lookup[i] == 0) {
                continue
            }
            var j = i + i
            while (j <= mx) {
                if (lookup[j] == j) {
                    lookup[j] = i
                }
                j += i
            }
        }
        var result = 0L
        for (x in nums) {
            result += lookup[x]
        }
        return result
    }
}
