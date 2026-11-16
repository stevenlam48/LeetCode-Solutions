package longestturbulentsubarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxTurbulenceSize(A: IntArray): Int {
        var result = 1
        var start = 0
        for (i in 1 until A.size) {
            if (i == A.size - 1 ||
                cmp(A[i - 1], A[i]) * cmp(A[i], A[i + 1]) != -1
            ) {
                result = maxOf(result, i - start + 1)
                start = i
            }
        }
        return result
    }

    private fun cmp(a: Int, b: Int): Int {
        return if (a != b) (if (a < b) 1 else -1) else 0
    }
}
