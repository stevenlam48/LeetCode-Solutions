package convert
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    fun convert(s: String, nRows: Int): String {
        val row = Array(nRows) { StringBuilder() }
        val ans = StringBuilder()
        var cnt = 0
        if (nRows == 1) {
            return s
        }
        for (c in s) {
            if (cnt < nRows) {
                row[cnt].append(c)
            } else {
                row[2 * nRows - 2 - cnt].append(c)
            }
            cnt = (cnt + 1) % (2 * nRows - 2)
        }
        for (r in row) {
            ans.append(r)
        }
        return ans.toString()
    }
}
