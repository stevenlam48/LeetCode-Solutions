package minimumlengthofanagramconcatenation

// Time:  O(sqrt(n) * n + (26 * sum(n/i for i in range(1, n+1) if n%i == 0))) < O(sqrt(n) * n + 26 * sum(n/i for i in range(1, n+1)) = O(sqrt(n) * n + 26 * nlogn)
// Space: O(26)

class Solution {
    fun minAnagramLength(s: String): Int {
        val check = { l: Int ->
            val count = { i: Int ->
                val cnt = IntArray(26)
                for (j in i until i + l) {
                    ++cnt[s[j] - 'a']
                }
                cnt
            }

            val cnt = count(0)
            var i = l
            var ok = true
            while (i < s.length) {
                if (!count(i).contentEquals(cnt)) {
                    ok = false
                    break
                }
                i += l
            }
            ok
        }

        var result = s.length
        var i = 1
        while (i * i <= s.length) {
            if (s.length % i != 0) {
                ++i
                continue
            }
            if (check(i)) {
                result = minOf(result, i)
            }
            val j = s.length / i
            if (j != i) {
                if (check(j)) {
                    result = minOf(result, j)
                }
            }
            ++i
        }
        return result
    }
}
