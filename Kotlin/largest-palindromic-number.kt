package largestpalindromicnumber

// Time:  O(n)
// Space: O(1)

// freq table, greedy
class Solution {
    fun largestPalindromic(num: String): String {
        val cnt = IntArray(10)
        for (c in num) {
            ++cnt[c - '0']
        }
        val result = StringBuilder()
        for (c in '9' downTo '0') {
            if (cnt[c - '0'] / 2 == 0 || (c == '0' && result.isEmpty())) {
                continue
            }
            repeat(cnt[c - '0'] / 2) { result.append(c) }
        }
        val l = result.length
        for (c in '9' downTo '0') {
            if (cnt[c - '0'] % 2 != 0) {
                result.append(c)
                break
            }
        }
        for (i in l - 1 downTo 0) {
            result.append(result[i])
        }
        return if (result.isNotEmpty()) result.toString() else "0"
    }
}
