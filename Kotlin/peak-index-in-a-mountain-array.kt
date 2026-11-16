package peakindexinamountainarray

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var left = 0
        var right = arr.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (arr[mid] > arr[mid + 1]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
