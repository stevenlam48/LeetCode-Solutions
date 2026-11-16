package maximumrowscoveredbycolumns
// Time:  O(m * n + m * C(n, k))
// Space: O(m)

class Solution {
    fun maximumRows(matrix: Array<IntArray>, numSelect: Int): Int {
        val masks = IntArray(matrix.size)
        for (row in matrix.indices) {
            var mask = 0
            for (column in matrix[0].indices) {
                mask = mask or (matrix[row][column] shl ((matrix[0].size - 1) - column))
            }
            masks[row] = mask
        }
        var result = 0
        var mask = (1 shl numSelect) - 1
        while (mask < (1 shl matrix[0].size)) {
            val count = masks.count { (it and mask) == it }
            result = maxOf(result, count)
            mask = nextPopcount(mask)
        }
        return result
    }

    private fun nextPopcount(mask: Int): Int {
        val lowestBit = mask and -mask
        val leftBits = mask + lowestBit
        val changedBits = mask xor leftBits
        val rightBits = Integer.divideUnsigned(changedBits, lowestBit) ushr 2
        return leftBits or rightBits
    }
}
