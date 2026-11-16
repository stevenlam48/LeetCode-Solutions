package creategridwithexactlykpathsi

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun createGrid(m: Int, n: Int, k: Int): Array<String> {
        for (p in PATTERNS[k]) {
            if (p.size > m || p[0].length > n) {
                continue
            }
            val result = Array(m) { CharArray(n) { '#' } }
            for (i in p.indices) {
                for (j in p[0].indices) {
                    result[i][j] = p[i][j]
                }
            }
            for (i in p.size until m) {
                result[i][p[0].lastIndex] = '.'
            }
            for (j in p[0].length until n) {
                result[m - 1][j] = '.'
            }
            return Array(m) { String(result[it]) }
        }
        return emptyArray()
    }

    private companion object {
        val PATTERNS = arrayOf(
            arrayOf<Array<String>>(),
            arrayOf(arrayOf(".")),
            arrayOf(arrayOf("..", "..")),
            arrayOf(arrayOf("..", "..", ".."), arrayOf("...", "...")),
            arrayOf(
                arrayOf("..", "..", "..", ".."),
                arrayOf("....", "...."),
                arrayOf("..#", "...", "#..")
            )
        )
    }
}
