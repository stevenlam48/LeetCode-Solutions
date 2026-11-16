package minimumwindowsubsequence

// Time:  O(s * t)
// Space: O(s)

class Solution {
    fun minWindow(S: String, T: String): String {
        val lookup = Array(S.length + 1) { IntArray(26) { -1 } }
        val findCharNextPos = IntArray(26) { -1 }
        for (i in S.length - 1 downTo 0) {
            findCharNextPos[S[i] - 'a'] = i + 1
            lookup[i] = findCharNextPos.copyOf()
        }

        var minI = -1
        var minLen = Int.MAX_VALUE
        for (i in S.indices) {
            if (S[i] != T[0]) {
                continue
            }
            var start = i
            for (c in T) {
                start = lookup[start][c - 'a']
                if (start == -1) {
                    break
                }
            }
            if (start != -1) {
                if (start - i < minLen) {
                    minI = i
                    minLen = start - i
                }
            }
        }
        return if (minI != -1) S.substring(minI, minI + minLen) else ""
    }
}
