package constructstringwithrepeatlimit

// Time:  O(26 * n)
// Space: O(26)

// greedy
class Solution {
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        val cnt = IntArray(26)
        for (c in s) {
            ++cnt[c - 'a']
        }
        val result = StringBuilder()
        var top1 = 25
        while (true) {
            while (top1 >= 0) {
                if (cnt[top1] != 0) {
                    break
                }
                --top1
            }
            if (top1 == -1) {
                break
            }
            val c = minOf(
                cnt[top1],
                repeatLimit - if (result.isNotEmpty() && result.last() == 'a' + top1) 1 else 0
            )
            cnt[top1] -= c
            repeat(c) { result.append('a' + top1) }
            var top2 = top1 - 1
            while (top2 >= 0) {
                if (cnt[top2] != 0) {
                    break
                }
                --top2
            }
            if (top2 == -1) {
                break
            }
            --cnt[top2]
            result.append('a' + top2)
        }
        return result.toString()
    }
}
