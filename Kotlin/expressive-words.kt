package expressivewords

// Time:  O(n + s), n is the sum of all word lengths, s is the length of S
// Space: O(l + s)

class Solution {
    fun expressiveWords(S: String, words: List<String>): Int {
        var result = 0
        val r = RLE(S)
        for (word in words) {
            val r2 = RLE(word)
            if (r.key != r2.key) {
                continue
            }
            var i = 0
            while (i < r.counts.size) {
                val c1 = r.counts[i]
                val c2 = r2.counts[i]
                if (c1 < maxOf(c2, 3) && c1 != c2) {
                    break
                }
                ++i
            }
            if (i == r.counts.size) {
                ++result
            }
        }
        return result
    }

    private class RLE(s: String) {
        val key: String
        val counts = mutableListOf<Int>()

        init {
            val key = StringBuilder()
            var prev = -1
            for (i in s.indices) {
                if (i == s.length - 1 || s[i] != s[i + 1]) {
                    key.append(s[i])
                    counts.add(i - prev)
                    prev = i
                }
            }
            this.key = key.toString()
        }
    }
}
