package maximumproductofthreeelementsafteronereplacement

// Time:  O(n)
// Space: O(1)

// greedy
class Solution {
    fun maxProduct(nums: IntArray): Long {
        val top = IntArray(2)
        for (value in nums) {
            var x = if (value < 0) -value else value
            for (j in top.indices) {
                if (x > top[j]) {
                    val tmp = top[j]
                    top[j] = x
                    x = tmp
                }
            }
        }
        return 100000L * top[0] * top[1]
    }
}
