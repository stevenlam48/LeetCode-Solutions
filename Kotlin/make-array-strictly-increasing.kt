package makearraystrictlyincreasing

// Time:  O(n^2 * logn)
// Space: O(n)

class Solution {
    fun makeArrayIncreasing(arr1: IntArray, arr2: IntArray): Int {
        arr2.sort()
        val values = arr2.distinct()
        var dp = hashMapOf(0 to -1)
        for (val1 in arr1) {
            val nextDp = HashMap<Int, Int>()
            for ((cost, value) in dp) {
                if (value < val1) {
                    nextDp[cost] = minOf(nextDp[cost] ?: val1, val1)
                }
                var left = 0
                var right = values.size
                while (left < right) {
                    val mid = left + (right - left) / 2
                    if (values[mid] <= value) {
                        left = mid + 1
                    } else {
                        right = mid
                    }
                }
                if (left < values.size) {
                    val replacement = values[left]
                    nextDp[cost + 1] = minOf(nextDp[cost + 1] ?: replacement, replacement)
                }
            }
            dp = nextDp
            if (dp.isEmpty()) {
                return -1
            }
        }
        return dp.keys.min()
    }
}
