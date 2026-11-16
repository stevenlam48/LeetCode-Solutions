package findthemaximumlengthofagoodsubsequenceii
// Time:  O(n * k)
// Space: O(n * k)

class Solution {
    fun maximumLength(nums: IntArray, k: Int): Int {
        val lookup = HashMap<Int, Int>()
        for (x in nums) {
            if (!lookup.containsKey(x)) {
                lookup[x] = lookup.size
            }
        }
        val dp = Array(k + 1) { IntArray(lookup.size) }
        val result = IntArray(k + 1)
        for (value in nums) {
            val x = lookup[value]!!
            for (i in k downTo 0) {
                dp[i][x] = maxOf(dp[i][x], if (i - 1 >= 0) result[i - 1] else 0) + 1
                result[i] = maxOf(result[i], dp[i][x])
            }
        }
        return result[k]
    }
}
