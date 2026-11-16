package sumofevennumbersafterqueries

// Time:  O(n + q)
// Space: O(1)
class Solution {
    fun sumEvenAfterQueries(A: IntArray, queries: Array<IntArray>): IntArray {
        var total = 0
        for (val0 in A) {
            total += if (val0 % 2 == 0) val0 else 0
        }

        val result = IntArray(queries.size)
        for (j in queries.indices) {
            val v = queries[j][0]
            val i = queries[j][1]
            if (A[i] % 2 == 0) {
                total -= A[i]
            }
            A[i] += v
            if (A[i] % 2 == 0) {
                total += A[i]
            }
            result[j] = total
        }
        return result
    }
}
