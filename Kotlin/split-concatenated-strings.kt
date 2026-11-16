package splitconcatenatedstrings
// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun splitLoopedString(strs: List<String>): String {
        var s = ""
        for (str in strs) {
            s += maxOf(str, str.reversed())
        }
        var result = "a"
        var st = 0
        for (i in strs.indices) {
            val rev = strs[i].reversed()
            val body = s.substring(st + strs[i].length) + s.substring(0, st)
            for (p in arrayOf(strs[i], rev)) {
                for (j in strs[i].indices) {
                    if (p[j] >= result[0]) {
                        val tmp = p.substring(j) + body + p.substring(0, j)
                        result = maxOf(result, tmp)
                    }
                }
            }
            st += strs[i].length
        }
        return result
    }
}
