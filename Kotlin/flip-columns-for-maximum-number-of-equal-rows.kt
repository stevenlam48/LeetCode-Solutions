package flipcolumnsformaximumnumberofequalrows

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun maxEqualRowsAfterFlips(matrix: Array<IntArray>): Int {
        val count = HashMap<String, Int>()
        for (row in matrix) {
            val key = encode(row)
            count[key] = (count[key] ?: 0) + 1
        }
        return count.values.maxOrNull()!!
    }

    private fun encode(s: IntArray): String {
        val result = StringBuilder(s.size)
        for (c in s) {
            result.append((c xor s[0]).toChar())
        }
        return result.toString()
    }
}
