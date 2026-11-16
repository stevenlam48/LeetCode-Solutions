package compareversionnumbers

// Time:  O(n)
// Space: O(1)


class Solution {
    fun compareVersion(version1: String, version2: String): Int {
        val n1 = version1.length
        val n2 = version2.length
        var i = 0
        var j = 0
        while (i < n1 || j < n2) {
            var v1 = 0
            var v2 = 0
            while (i < n1 && version1[i] != '.') {
                v1 = v1 * 10 + (version1[i++] - '0')
            }
            while (j < n2 && version2[j] != '.') {
                v2 = v2 * 10 + (version2[j++] - '0')
            }
            if (v1 != v2) {
                return if (v1 > v2) 1 else -1
            }
            ++i
            ++j
        }
        return 0
    }
}
