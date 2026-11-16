package longestcommonprefixbetweenadjacentstringsafterremovals

// Time:  O(n * l)
// Space: O(n)

class Solution {
    fun longestCommonPrefix(words: Array<String>): IntArray {
        fun lcp(i: Int, j: Int): Int {
            if (i < 0 || j >= words.size) {
                return 0
            }
            val s1 = words[i]
            val s2 = words[j]
            val l = minOf(s1.length, s2.length)
            for (k in 0 until l) {
                if (s1[k] != s2[k]) {
                    return k
                }
            }
            return l
        }

        val lcps = IntArray(words.size - 1)
        for (i in lcps.indices) {
            lcps[i] = lcp(i, i + 1)
        }
        val right = IntArray(lcps.size + 2)
        for (i in lcps.size - 1 downTo 0) {
            right[i] = maxOf(right[i + 1], lcps[i])
        }
        val result = IntArray(words.size)
        var left = 0
        for (i in words.indices) {
            if (i - 2 >= 0) {
                left = maxOf(left, lcps[i - 2])
            }
            result[i] = maxOf(left, right[i + 1], lcp(i - 1, i + 1))
        }
        return result
    }
}
