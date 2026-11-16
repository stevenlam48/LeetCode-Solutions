package missingnumberinarithmeticprogression
// Time:  O(logn)
// Space: O(1)

class Solution {
    fun missingNumber(arr: IntArray): Int {
        val d = (arr[arr.size - 1] - arr[0]) / arr.size
        var left = 0
        var right = arr.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(arr, d, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return arr[0] + d * left
    }

    private fun check(arr: IntArray, d: Int, x: Int): Boolean {
        return arr[x] != arr[0] + d * x
    }
}
