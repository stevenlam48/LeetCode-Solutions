package lengthoflongestfibonaccisubsequence
// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun lenLongestFibSubseq(A: IntArray): Int {
        val lookup = A.toHashSet()
        var result = 0
        for (i in A.indices) {
            for (j in i + 1 until A.size) {
                var x = A[i]
                var y = A[j]
                var l = 2
                while (lookup.contains(x + y)) {
                    y = x + y
                    x = y - x
                    ++l
                }
                result = maxOf(result, l)
            }
        }
        return if (result > 2) result else 0
    }
}
