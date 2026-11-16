package kthsmallestprimefraction

// Time:  O(nlogr)
// Space: O(1)

class Solution {
    fun kthSmallestPrimeFraction(A: IntArray, K: Int): IntArray {
        var result = IntArray(0)
        var left = 0.0
        var right = 1.0
        while (right - left > 1e-8) {
            val mid = left + (right - left) / 2.0
            val (found, count) = check(mid, A, K)
            if (count >= K) {
                right = mid
            } else {
                left = mid
            }
            if (found != null) {
                result = found
                break
            }
        }
        return result
    }

    private fun check(mid: Double, A: IntArray, K: Int): Pair<IntArray?, Int> {
        val tmp = IntArray(2)
        var count = 0
        var j = 0
        for (i in A.indices) {
            while (j < A.size) {
                if (i < j && A[i] < A[j] * mid) {
                    if (tmp[0] == 0 || tmp[0] * A[j] < tmp[1] * A[i]) {
                        tmp[0] = A[i]
                        tmp[1] = A[j]
                    }
                    break
                }
                ++j
            }
            count += A.size - j
        }
        return Pair(if (count == K) tmp.copyOf() else null, count)
    }
}
