package squaresofasortedarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun sortedSquares(A: IntArray): IntArray {
        var low = 0
        var high = A.size
        while (low < high) {
            val mid = low + (high - low) / 2
            if (A[mid] < 0) {
                low = mid + 1
            } else {
                high = mid
            }
        }

        var right = low
        var left = right - 1
        val result = IntArray(A.size)
        var index = 0
        while (left >= 0 || right < A.size) {
            if (right == A.size ||
                (left >= 0 && A[left] * A[left] < A[right] * A[right])
            ) {
                result[index++] = A[left] * A[left]
                --left
            } else {
                result[index++] = A[right] * A[right]
                ++right
            }
        }
        return result
    }
}
