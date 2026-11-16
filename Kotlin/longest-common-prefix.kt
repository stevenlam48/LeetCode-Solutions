package longestcommonprefix

// Time:  O(n * k), k is the length of the common prefix
// Space: O(1)

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }

        for (i in strs[0].indices) {
            for (str in strs) {
                if (i >= str.length || str[i] != strs[0][i]) {
                    return strs[0].substring(0, i)
                }
            }
        }
        return strs[0]
    }
}
