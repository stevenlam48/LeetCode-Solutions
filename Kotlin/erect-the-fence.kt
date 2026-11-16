package erectthefence

// Time:  O(nlogn)
// Space: O(n)
class Solution {
    fun outerTrees(P: Array<IntArray>): Array<IntArray> {
        fun cross(O: IntArray, A: IntArray, B: IntArray): Int {
            return (A[0] - O[0]) * (B[1] - O[1]) - (A[1] - O[1]) * (B[0] - O[0])
        }

        val n = P.size
        if (n <= 3) {
            return P
        }
        var k = 0
        val H = Array(2 * n) { IntArray(0) }

        P.sortWith(compareBy({ it[0] }, { it[1] }))

        for (i in 0 until n) {
            while (k >= 2 && cross(H[k - 2], H[k - 1], P[i]) < 0) k--
            H[k++] = P[i]
        }

        val t = k + 1
        for (i in n - 1 downTo 1) {
            while (k >= t && cross(H[k - 2], H[k - 1], P[i - 1]) < 0) k--
            H[k++] = P[i - 1]
        }

        k--
        var result = Array(k) { H[it] }
        if (result[1].contentEquals(result[k - 1])) {
            result = Array(k / 2 + 1) { result[it] }
        }
        return result
    }
}
