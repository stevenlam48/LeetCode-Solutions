package findmissingandrepeatedvalues

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        val n = grid.size
        var aXorB = 0
        for (i in 0 until n * n) {
            val r = i / n
            val c = i % n
            aXorB = aXorB xor grid[r][c] xor (i + 1)
        }
        val base = aXorB and -aXorB
        val result = IntArray(2)
        for (i in 0 until n * n) {
            val r = i / n
            val c = i % n
            result[if ((i + 1) and base != 0) 1 else 0] = result[if ((i + 1) and base != 0) 1 else 0] xor (i + 1)
            result[if (grid[r][c] and base != 0) 1 else 0] = result[if (grid[r][c] and base != 0) 1 else 0] xor grid[r][c]
        }
        for (r in 0 until n) {
            for (c in 0 until n) {
                if (grid[r][c] == result[1]) {
                    val tmp = result[0]
                    result[0] = result[1]
                    result[1] = tmp
                    return result
                }
            }
        }
        return result
    }
}
