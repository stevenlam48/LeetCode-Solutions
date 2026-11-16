package minimumnumberofflipstomakethebinarystringalternating

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minFlips(s: String): Int {
        var result = Int.MAX_VALUE
        var cnt1 = 0
        var cnt2 = 0
        val l = if (s.length % 2 != 0) 2 * s.length - 1 else s.length
        for (i in 0 until l) {
            if (i >= s.length) {
                cnt1 -= (s[i % s.length] - '0') xor ((i - s.length) % 2) xor 0
                cnt2 -= (s[i % s.length] - '0') xor ((i - s.length) % 2) xor 1
            }
            cnt1 += (s[i % s.length] - '0') xor (i % 2) xor 0
            cnt2 += (s[i % s.length] - '0') xor (i % 2) xor 1
            if (i >= s.length - 1) {
                result = minOf(result, cnt1, cnt2)
            }
        }
        return result
    }
}
