package maxconsecutiveonesiii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestOnes(A: IntArray, K: Int): Int {
        var k = K
        var result = 0
        var i = 0
        for (j in A.indices) {
            k -= if (A[j] == 0) 1 else 0
            while (k < 0) {
                k += if (A[i] == 0) 1 else 0
                i++
            }
            result = maxOf(result, j - i + 1)
        }
        return result
    }
}
