package kthmissingpositivenumber

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        var left = 0
        var right = arr.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(arr, k, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right + 1 + k
    }

    private fun check(arr: IntArray, k: Int, x: Int): Boolean {
        return arr[x] - (x + 1) < k
    }
}
