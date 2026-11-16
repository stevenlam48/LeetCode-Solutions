package previouspermutationwithoneswap

// Time:  O(n)
// Space: O(1)

class Solution {
    fun prevPermOpt1(A: IntArray): IntArray {
        var left = A.size - 2
        while (left >= 0 && A[left] <= A[left + 1]) {
            --left
        }
        if (left < 0) {
            return A
        }
        var right = A.size - 1
        while (A[left] <= A[right]) {
            --right
        }
        while (A[right - 1] == A[right]) {
            --right
        }
        val tmp = A[left]
        A[left] = A[right]
        A[right] = tmp
        return A
    }
}
