package minimumcosttomakearraysidentical
// Time:  O(nlogn)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun minCost(arr: IntArray, brr: IntArray, k: Long): Long {
        fun cost(): Long {
            var result = 0L
            for (i in arr.indices) {
                result += abs(arr[i] - brr[i])
            }
            return result
        }

        var result = cost()
        arr.sort()
        brr.sort()
        result = minOf(result, k + cost())
        return result
    }
}
