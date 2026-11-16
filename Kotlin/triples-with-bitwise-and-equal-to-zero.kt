package tripleswithbitwiseandequaltozero
// Time:  O(nlogn), n is the max of A
// Space: O(n)

class Solution {
    fun countTriplets(A: IntArray): Int {
        val maxA = A.max()
        var n = 1
        while (n <= maxA) {
            n = n shl 1
        }
        val B = IntArray(n)
        for (x in A) {
            ++B[x]
        }
        fwt(B, 1)
        for (i in B.indices) {
            B[i] = B[i] * B[i] * B[i]
        }
        fwt(B, -1)
        return B[0]
    }

    private fun fwt(A: IntArray, v: Int) {
        var d = 1
        while (d < A.size) {
            val m = d shl 1
            var i = 0
            while (i < A.size) {
                for (j in 0 until d) {
                    A[i + j] += A[i + j + d] * v
                }
                i += m
            }
            d = d shl 1
        }
    }
}
