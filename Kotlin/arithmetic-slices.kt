package arithmeticslices

// Time:  O(n)
// Space: O(1)

class Solution {
    fun numberOfArithmeticSlices(A: IntArray): Int {
        var result = 0
        var i = 0
        while (i + 2 < A.size) {
            val start = i
            while (i + 2 < A.size && A[i + 2] + A[i] == 2 * A[i + 1]) {
                result += i++ - start + 1
            }
            ++i
        }
        return result
    }
}
