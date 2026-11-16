package longestCommonLength

// Time Complexity: O(n1 + n2 + ...)
// Space Complexity: O(1)

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        for (idx in strs[0].indices) {
            for (i in 1 until strs.size) {
                if (idx >= strs[i].length || strs[0][idx] != strs[i][idx]) {
                    return strs[0].substring(0, idx)
                }
            }
        }
        return strs[0]
    }
}
