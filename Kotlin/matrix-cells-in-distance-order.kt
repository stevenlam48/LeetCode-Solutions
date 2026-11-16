package matrixcellsindistanceorder

// Time:  O(m * n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
        val result = mutableListOf(intArrayOf(r0, c0))
        for (d in 1 until R + C) {
            append(R, C, r0 - d, c0, result)
            for (x in -d + 1 until d) {
                append(R, C, r0 + x, c0 + d - abs(x), result)
                append(R, C, r0 + x, c0 + abs(x) - d, result)
            }
            append(R, C, r0 + d, c0, result)
        }
        return result.toTypedArray()
    }

    private fun append(R: Int, C: Int, r: Int, c: Int, result: MutableList<IntArray>) {
        if (r in 0 until R && c in 0 until C) {
            result.add(intArrayOf(r, c))
        }
    }
}
