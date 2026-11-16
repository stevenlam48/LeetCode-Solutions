package champagnetower

// Time:  O(n^2) = O(1), since n is at most 99
// Space: O(n) = O(1)

class Solution {
    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val result = DoubleArray(1 + query_row)
        result[0] = poured.toDouble()
        for (i in 1..query_row) {
            for (j in i downTo 0) {
                result[j] = maxOf(result[j] - 1, 0.0) / 2 +
                    if (j > 0) maxOf(result[j - 1] - 1, 0.0) / 2 else 0.0
            }
        }
        return minOf(result[query_glass], 1.0)
    }
}
