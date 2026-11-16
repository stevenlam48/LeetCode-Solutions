package binaryprefixdivisibleby5

// Time:  O(n)
// Space: O(1)

class Solution {
    fun prefixesDivBy5(A: IntArray): List<Boolean> {
        for (i in 1 until A.size) {
            A[i] += A[i - 1] * 2 % 5
        }
        return A.map { it % 5 == 0 }
    }
}
