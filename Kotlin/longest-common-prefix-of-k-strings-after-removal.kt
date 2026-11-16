package longestcommonprefixofkstringsafterremoval

// Time:  O(l * nlogn)
// Space: O(n)

class Solution {
    fun longestCommonPrefix(words: Array<String>, k: Int): IntArray {
        val idxs = IntArray(words.size) { it }
            .sortedWith(compareBy { words[it] })
            .toIntArray()

        fun longestCommonPrefix(k: Int): IntArray {
            val lcp = IntArray(words.size)
            for (i in 0..words.size - k) {
                val left = words[idxs[i]]
                val right = words[idxs[i + k - 1]]
                var j = 0
                while (j < minOf(left.length, right.length)) {
                    if (left[j] != right[j]) {
                        break
                    }
                    ++j
                }
                lcp[i] = j
            }
            return lcp
        }

        val lcp = longestCommonPrefix(k)
        val prefix = IntArray(words.size)
        prefix[0] = lcp[0]
        for (i in 0 until prefix.size - 1) {
            prefix[i + 1] = maxOf(prefix[i], lcp[i + 1])
        }
        val suffix = IntArray(words.size)
        suffix[words.size - 1] = lcp[words.size - 1]
        for (i in suffix.size - 2 downTo 0) {
            suffix[i] = maxOf(suffix[i + 1], lcp[i])
        }
        val result = IntArray(words.size)
        val mx = longestCommonPrefix(k + 1).max()
        for (i in words.indices) {
            val idx = idxs[i]
            val mx1 = if (i - k >= 0) prefix[i - k] else 0
            val mx2 = if (i + 1 < words.size) suffix[i + 1] else 0
            result[idx] = maxOf(mx, mx1, mx2)
        }
        return result
    }
}
