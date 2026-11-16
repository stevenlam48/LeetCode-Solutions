package longercontiguoussegmentsofonesthanzeros

// Time:  O(n)
// Space: O(1)

class Solution {
    fun checkZeroOnes(s: String): Boolean {
        val maxCnt = IntArray(2)
        var cnt = 0
        for (i in 0..s.length) {
            if (i == s.length || (i >= 1 && s[i] != s[i - 1])) {
                val idx = s[i - 1] - '0'
                maxCnt[idx] = maxOf(maxCnt[idx], cnt)
                cnt = 0
            }
            ++cnt
        }
        return maxCnt[0] < maxCnt[1]
    }
}
