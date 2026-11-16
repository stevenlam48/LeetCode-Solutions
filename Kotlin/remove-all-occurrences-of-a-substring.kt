package removealloccurrencesofasubstring
// Time:  O(n + m)
// Space: O(n + m)

class Solution {
    fun removeOccurrences(s: String, part: String): String {
        val prefix = getPrefix(part)
        val result = StringBuilder()
        val lookup = mutableListOf<Int>()
        var i = -1
        for (c in s) {
            while (i != -1 && part[i + 1] != c) {
                i = prefix[i]
            }
            if (part[i + 1] == c) {
                ++i
            }
            result.append(c)
            lookup.add(i)
            if (i == part.length - 1) {
                result.setLength(result.length - part.length)
                repeat(part.length) {
                    lookup.removeAt(lookup.lastIndex)
                }
                i = if (lookup.isNotEmpty()) lookup.last() else -1
            }
        }
        return result.toString()
    }

    private fun getPrefix(pattern: String): IntArray {
        val prefix = IntArray(pattern.length) { -1 }
        var j = -1
        for (i in 1 until pattern.length) {
            while (j != -1 && pattern[j + 1] != pattern[i]) {
                j = prefix[j]
            }
            if (pattern[j + 1] == pattern[i]) {
                ++j
            }
            prefix[i] = j
        }
        return prefix
    }
}
