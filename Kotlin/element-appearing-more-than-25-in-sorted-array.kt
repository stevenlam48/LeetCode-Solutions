package elementappearingmorethan25insortedarray

// Time:  O(logn)
// Space: O(1)
class Solution {
    fun findSpecialInteger(arr: IntArray): Int {
        for (x in intArrayOf(arr[arr.size / 4], arr[arr.size / 2], arr[arr.size * 3 / 4])) {
            if ((upperBound(arr, x) - lowerBound(arr, x)) * 4 > arr.size) {
                return x
            }
        }
        return -1
    }

    private fun lowerBound(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (arr[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

    private fun upperBound(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (arr[mid] <= target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
