package reconstructa2rowbinarymatrix

// Time:  O(n)
// Space: O(1)

class Solution {
    fun reconstructMatrix(upper: Int, lower: Int, colsum: IntArray): Array<IntArray> {
        var upperLeft = upper
        var lowerLeft = lower
        val upperMatrix = IntArray(colsum.size)
        val lowerMatrix = IntArray(colsum.size)
        for (i in colsum.indices) {
            upperMatrix[i] = if (upperLeft > 0 && colsum[i] > 0) 1 else 0
            lowerMatrix[i] = colsum[i] - upperMatrix[i]
            upperLeft -= upperMatrix[i]
            lowerLeft -= lowerMatrix[i]
        }
        if (upperLeft != 0 || lowerLeft != 0) {
            return emptyArray()
        }
        return arrayOf(upperMatrix, lowerMatrix)
    }
}
