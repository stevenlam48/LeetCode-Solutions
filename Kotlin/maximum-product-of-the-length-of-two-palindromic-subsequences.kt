package maximumproductofthelengthoftwopalindromicsubsequences

// Time:  O(3^n)
// Space: O(2^n)

class Solution {
    fun maxProduct(s: String): Int {
        val n = s.length
        val dp = IntArray(1 shl n)
        for (mask in dp.indices) {
            dp[mask] = palindromicSubsequenceLength(s, mask)
        }
        var result = 0
        for (mask in dp.indices) {
            if (dp[mask] * (n - dp[mask]) <= result) {
                continue
            }
            val inverseMask = (dp.size - 1) xor mask
            var submask = inverseMask
            while (submask != 0) {
                result = maxOf(result, dp[mask] * dp[submask])
                submask = (submask - 1) and inverseMask
            }
        }
        return result
    }

    private fun palindromicSubsequenceLength(s: String, mask: Int): Int {
        var result = 0
        var left = 0
        var right = s.length - 1
        var leftBit = 1 shl left
        var rightBit = 1 shl right
        while (left <= right) {
            if (mask and leftBit == 0) {
                ++left
                leftBit = leftBit shl 1
            } else if (mask and rightBit == 0) {
                --right
                rightBit = rightBit shr 1
            } else if (s[left] == s[right]) {
                result += if (left == right) 1 else 2
                ++left
                leftBit = leftBit shl 1
                --right
                rightBit = rightBit shr 1
            } else {
                return 0
            }
        }
        return result
    }
}
