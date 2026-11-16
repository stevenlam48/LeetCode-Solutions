package longestuncommonsubsequenceii

// Time:  O(l * n^2)
// Space: O(1)

class Solution {
    fun findLUSlength(strs: Array<String>): Int {
        strs.sortByDescending { it.length }
        for (i in strs.indices) {
            var allOf = true
            var j = 0
            while (j < strs.size && strs[j].length >= strs[i].length) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    allOf = false
                    break
                }
                ++j
            }
            if (allOf) {
                return strs[i].length
            }
        }
        return -1
    }

    private fun isSubsequence(a: String, b: String): Boolean {
        var i = 0
        var j = 0
        while (j < b.length && i < a.length) {
            if (a[i] == b[j]) {
                ++i
            }
            ++j
        }
        return i == a.length
    }
}
