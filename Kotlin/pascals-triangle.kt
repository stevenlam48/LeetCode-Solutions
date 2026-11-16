package pascalstriangle

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun generate(numRows: Int): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        for (i in 0 until numRows) {
            result.add(IntArray(0))
            result[i] = IntArray(i + 1)
            for (j in 0..i) {
                if (j == 0 || j == i) {
                    result[i][j] = 1
                } else {
                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j]
                }
            }
        }
        return result.toTypedArray()
    }
}
