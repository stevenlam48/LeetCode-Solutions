package findandreplaceinstring

// Time:  O(n + m), m is the number of targets
// Space: O(n)

class Solution {
    fun findReplaceString(
        s: String,
        indexes: IntArray,
        sources: List<String>,
        targets: List<String>
    ): String {
        val lengths = IntArray(s.length)
        val replacements = arrayOfNulls<String>(s.length)
        for (i in indexes.indices) {
            if (s.startsWith(sources[i], indexes[i])) {
                lengths[indexes[i]] = sources[i].length
                replacements[indexes[i]] = targets[i]
            }
        }
        val result = StringBuilder()
        var i = 0
        while (i < s.length) {
            if (lengths[i] != 0) {
                result.append(replacements[i])
                i += lengths[i]
            } else {
                result.append(s[i++])
            }
        }
        return result.toString()
    }
}
