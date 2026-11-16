package mapofhighestpeak

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        val directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        var q = ArrayList<IntArray>()
        for (r in isWater.indices) {
            for (c in isWater[0].indices) {
                --isWater[r][c]
                if (isWater[r][c] == 0) {
                    q.add(intArrayOf(r, c))
                }
            }
        }
        while (q.isNotEmpty()) {
            val newQ = ArrayList<IntArray>()
            for (cell in q) {
                val r = cell[0]
                val c = cell[1]
                for (d in directions) {
                    val nr = r + d[0]
                    val nc = c + d[1]
                    if (!(nr in isWater.indices && nc in isWater[0].indices &&
                                isWater[nr][nc] == -1)
                    ) {
                        continue
                    }
                    isWater[nr][nc] = isWater[r][c] + 1
                    newQ.add(intArrayOf(nr, nc))
                }
            }
            q = newQ
        }
        return isWater
    }
}
