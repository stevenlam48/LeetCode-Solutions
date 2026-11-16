package countsubstringsdivisiblebylastdigit
// Time:  O(d * n)
// Space: O(d)

class Solution {
    fun countSubstrings(s: String): Long {
        var result = 0L
        var cnt: IntArray
        for (i in s.indices) {
            if (s[i] == '1' || s[i] == '2' || s[i] == '5') {
                result += i + 1
            }
        }
        cnt = IntArray(3)
        cnt[0] = 1
        var remain = 0
        for (i in s.indices) {
            remain = (remain + (s[i] - '0')) % 3
            if (s[i] == '3' || s[i] == '6') {
                result += cnt[remain]
            }
            ++cnt[remain]
        }
        cnt = IntArray(9)
        cnt[0] = 1
        remain = 0
        for (i in s.indices) {
            remain = (remain + (s[i] - '0')) % 9
            if (s[i] == '9') {
                result += cnt[remain]
            }
            ++cnt[remain]
        }
        for (i in s.indices) {
            if (s[i] == '4') {
                ++result
                if (i > 0 && s.substring(i - 1, i + 1).toInt() % 4 == 0) {
                    result += i
                }
            }
        }
        for (i in s.indices) {
            if (s[i] == '8') {
                ++result
                if (i > 0 && s.substring(i - 1, i + 1).toInt() % 8 == 0) {
                    ++result
                }
                if (i > 1 && s.substring(i - 2, i + 1).toInt() % 8 == 0) {
                    result += i - 1
                }
            }
        }
        cnt = IntArray(7)
        remain = 0
        var base = 1
        for (i in s.indices) {
            val j = s.length - 1 - i
            remain = (remain + base * (s[j] - '0')) % 7
            result += cnt[remain]
            if (s[j] == '7') {
                ++result
                ++cnt[remain]
            }
            base = base * 10 % 7
        }
        return result
    }
}
