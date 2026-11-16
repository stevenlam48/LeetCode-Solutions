package getRow

// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    fun getRow(rowIndex: Int): IntArray {
        val result = IntArray(rowIndex + 1) { 1 }
        for (i in 2..rowIndex) {
            for (j in i - 1 downTo 1) {
                result[j] += result[j - 1]
            }
        }
        return result
    }
}
