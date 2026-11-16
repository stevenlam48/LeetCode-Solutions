package smallestpalindromicrearrangementii
// Time:  O(26 * n)
// Space: O(26)

class Solution {
    fun smallestPalindrome(s: String, k: Int): String {
        val cnt = IntArray(26)
        for (index in 0 until s.length / 2) {
            ++cnt[s[index] - 'a']
        }
        var total = 0
        var count = 1
        var remain = 0
        var rank = k
        var i = cnt.lastIndex
        while (i >= 0) {
            for (c in 1..cnt[i]) {
                ++total
                count = count * total / c
                if (count >= rank) {
                    remain = cnt[i] - c
                    break
                }
            }
            if (count >= rank) {
                break
            }
            --i
        }
        if (count < rank) {
            return ""
        }
        val result = CharArray(s.length)
        var l = 0
        for (j in 0..i) {
            val x = 'a' + j
            val c = if (j != i) cnt[j] else remain
            repeat(c) {
                --cnt[j]
                result[l++] = x
            }
        }
        while (total != 0) {
            for (j in i until cnt.size) {
                if (cnt[j] == 0) {
                    continue
                }
                val newCount = count.toLong() * cnt[j] / total
                if (newCount < rank) {
                    rank -= newCount.toInt()
                    continue
                }
                count = newCount.toInt()
                --cnt[j]
                --total
                result[l++] = 'a' + j
                break
            }
        }
        if (s.length % 2 != 0) {
            result[l++] = s[s.length / 2]
        }
        for (index in l - 1 - s.length % 2 downTo 0) {
            result[l++] = result[index]
        }
        return String(result)
    }
}
