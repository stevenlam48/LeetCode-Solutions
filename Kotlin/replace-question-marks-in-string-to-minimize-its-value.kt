package replacequestionmarksinstringtominimizeitsvalue

// Time:  O(n + 26 * log(26))
// Space: O(26)

class Solution {
    fun minimizeStringValue(s: String): String {
        val countingSort = { cnt: IntArray ->
            val result = IntArray(cnt.sum())
            var j = 0
            for (i in cnt.indices) {
                repeat(cnt[i]) { result[j++] = i }
            }
            result
        }

        val fill = { cnt: IntArray ->
            val result = IntArray(26)
            val pairs = Array(26) { intArrayOf(cnt[it], it) }
            pairs.sortWith(compareBy({ it[0] }, { it[1] }))
            val total = s.count { it == '?' }
            var curr = 0
            var i = 0
            while (i + 1 < pairs.size) {
                if (curr + (pairs[i + 1][0] - pairs[i][0]) * (i + 1) > total) {
                    break
                }
                curr += (pairs[i + 1][0] - pairs[i][0]) * (i + 1)
                ++i
            }
            val q = (total - curr) / (i + 1)
            val r = (total - curr) % (i + 1)
            for (j in 0..i) {
                result[pairs[j][1]] = (pairs[i][0] - pairs[j][0]) + q
            }
            val cnt2 = IntArray(26)
            for (j in 0..i) {
                ++cnt2[pairs[j][1]]
            }
            val idxs = countingSort(cnt2)
            var j = 0
            repeat(r) { ++result[idxs[j++]] }
            result
        }

        val cnt = IntArray(26)
        for (x in s) {
            if (x == '?') {
                continue
            }
            ++cnt[x - 'a']
        }
        val idxs = countingSort(fill(cnt))
        val chars = s.toCharArray()
        var i = 0
        for (j in chars.indices) {
            if (chars[j] != '?') {
                continue
            }
            chars[j] = 'a' + idxs[i++]
        }
        return String(chars)
    }
}
