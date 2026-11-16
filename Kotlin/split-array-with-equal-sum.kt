package splitarraywithequalsum
// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun splitArray(nums: IntArray): Boolean {
        if (nums.size < 7) {
            return false
        }

        val sum = IntArray(nums.size)
        sum[0] = nums[0]
        for (i in 1 until nums.size) {
            sum[i] = sum[i - 1] + nums[i]
        }
        for (j in 3 until nums.size - 3) {
            val lookup = hashSetOf<Int>()
            for (i in 1 until j - 1) {
                if (sum[i - 1] == sum[j - 1] - sum[i]) {
                    lookup.add(sum[i - 1])
                }
            }
            for (k in j + 2 until nums.size - 1) {
                if (sum[nums.size - 1] - sum[k] == sum[k - 1] - sum[j] &&
                    sum[k - 1] - sum[j] in lookup
                ) {
                    return true
                }
            }
        }
        return false
    }
}
