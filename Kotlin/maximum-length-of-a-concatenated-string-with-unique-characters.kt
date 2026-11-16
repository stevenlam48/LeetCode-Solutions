package maximumlengthofaconcatenatedstringwithuniquecharacters

// Time:  O(n) ~ O(2^n)
// Space: O(1) ~ O(2^n)

class Solution {
    fun maxLength(arr: List<String>): Int {
        val dp = mutableListOf(0)
        for (x in arr) {
            val xSet = bitset(x)
            if (xSet == 0) {
                continue
            }
            val currSize = dp.size
            for (i in 0 until currSize) {
                if (dp[i] and xSet != 0) {
                    continue
                }
                dp.add(dp[i] or xSet)
            }
        }
        return dp.maxOf { it.countOneBits() }
    }

    private fun bitset(s: String): Int {
        var result = 0
        for (c in s) {
            val bit = 1 shl (c - 'a')
            if (result and bit != 0) {
                return 0
            }
            result = result or bit
        }
        return result
    }
}
