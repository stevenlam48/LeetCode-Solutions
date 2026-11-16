package pascalstriangleii

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun getRow(rowIndex: Int): IntArray {
        val result = IntArray(rowIndex + 1)
        for (i in result.indices) {
            result[0] = 1
            var prevResult = result[0]
            for (j in 1..i) {
                val tmp = result[j]
                result[j] += prevResult
                prevResult = tmp
            }
        }
        return result
    }
}
