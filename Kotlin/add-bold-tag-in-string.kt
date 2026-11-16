package addboldtaginstring

// Time:  O(n * d * l), l is the average string length
// Space: O(n)

class Solution {
    fun addBoldTag(s: String, dict: List<String>): String {
        val lookup = BooleanArray(s.length)
        for (d in dict) {
            var pos = -1
            while (true) {
                pos = s.indexOf(d, pos + 1)
                if (pos == -1) {
                    break
                }
                for (i in pos until pos + d.length) {
                    lookup[i] = true
                }
            }
        }
        val result = StringBuilder()
        for (i in s.indices) {
            if (lookup[i] && (i == 0 || !lookup[i - 1])) {
                result.append("<b>")
            }
            result.append(s[i])
            if (lookup[i] && (i == s.length - 1 || !lookup[i + 1])) {
                result.append("</b>")
            }
        }
        return result.toString()
    }
}
