package countnumberoftexts

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countTexts(pressedKeys: String): Int {
        val mod = 1_000_000_007
        val dp = IntArray(5) { 1 }
        for (i in 1..pressedKeys.length) {
            dp[i % 5] = 0
            val start = if (pressedKeys[i - 1] == '7' || pressedKeys[i - 1] == '9') i - 4 else i - 3
            var j = i - 1
            while (j >= maxOf(start, 0) && pressedKeys[j] == pressedKeys[i - 1]) {
                dp[i % 5] = (dp[i % 5] + dp[j % 5]) % mod
                --j
            }
        }
        return dp[pressedKeys.length % 5]
    }
}
