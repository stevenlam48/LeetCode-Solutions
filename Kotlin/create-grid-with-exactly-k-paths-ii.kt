package creategridwithexactlykpathsii

// Time:  O((logk)^2)
// Space: O(1)

class Solution {
    fun createGrid(k: Int): Array<String> {
        val l = Integer.SIZE - Integer.numberOfLeadingZeros(k)
        val m = 2 * l
        val n = l + 3
        val result = Array(m) { CharArray(n) { '#' } }
        for (i in 0 until l) {
            val r = 2 * i
            result[r][i] = '.'
            result[r][i + 1] = '.'
            result[r + 1][i] = '.'
            result[r + 1][i + 1] = '.'
            if (k and (1 shl i) == 0) {
                continue
            }
            for (c in i + 2 until n) {
                result[r][c] = '.'
            }
        }
        for (r in 0 until m) {
            result[r][n - 1] = '.'
        }
        return Array(m) { String(result[it]) }
    }
}
