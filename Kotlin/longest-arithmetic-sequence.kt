package longestarithmeticsequence

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun longestArithSeqLength(A: IntArray): Int {
        val dp = HashMap<Int, HashMap<Int, Int>>()
        var result = 2
        for (i in A.indices) {
            for (j in i + 1 until A.size) {
                val v = A[j] - A[i]
                val inner = dp.getOrPut(v) { HashMap() }
                inner[j] = maxOf(inner[j] ?: 0, (inner[i] ?: 0) + 1)
                result = maxOf(result, inner[j]!! + 1)
            }
        }
        return result
    }
}
