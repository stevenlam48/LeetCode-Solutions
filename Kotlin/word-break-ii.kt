package wordbreakii

// Time:  O(n * l^2 + n * r), l is the max length of the words, 
//                            r is the number of the results.
// Space: O(n^2)

class Solution {
    fun wordBreak(s: String, wordDict: Set<String>): List<String> {
        val n = s.length
        val maxLen = wordDict.maxOfOrNull { it.length } ?: 0
        val canBreak = BooleanArray(n + 1)
        val valid = Array(n) { BooleanArray(n) }
        canBreak[0] = true
        for (i in 1..n) {
            for (l in 1..maxLen) {
                if (i - l < 0) break
                if (canBreak[i - l] && s.substring(i - l, i) in wordDict) {
                    valid[i - l][i - 1] = true
                    canBreak[i] = true
                }
            }
        }

        val result = mutableListOf<String>()
        if (canBreak[n]) {
            wordBreakHelper(s, valid, 0, mutableListOf(), result)
        }
        return result
    }

    private fun wordBreakHelper(
        s: String,
        valid: Array<BooleanArray>,
        start: Int,
        path: MutableList<String>,
        result: MutableList<String>
    ) {
        if (start == s.length) {
            result.add(path.joinToString(" "))
            return
        }
        for (i in start until s.length) {
            if (valid[start][i]) {
                path.add(s.substring(start, i + 1))
                wordBreakHelper(s, valid, i + 1, path, result)
                path.removeAt(path.lastIndex)
            }
        }
    }
}
