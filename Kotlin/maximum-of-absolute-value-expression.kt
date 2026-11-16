package maximumofabsolutevalueexpression
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxAbsValExpr(arr1: IntArray, arr2: IntArray): Int {
        var result = 0
        for (c1 in intArrayOf(1, -1)) {
            for (c2 in intArrayOf(1, -1)) {
                var minPrev = c1 * arr1[0] + c2 * arr2[0]
                for (i in 1 until arr1.size) {
                    val curr = c1 * arr1[i] + c2 * arr2[i] + i
                    result = maxOf(result, curr - minPrev)
                    minPrev = minOf(minPrev, curr)
                }
            }
        }
        return result
    }
}
