package findkclosestelements
// Time:  O(logn + k)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): IntArray {
        var low = 0
        var high = arr.size
        while (low < high) {
            val mid = low + (high - low) / 2
            if (arr[mid] < x) {
                low = mid + 1
            } else {
                high = mid
            }
        }
        var left = low - 1
        var right = low
        var remaining = k
        while (remaining-- > 0) {
            if (right >= arr.size || left >= 0 && abs(arr[left] - x) <= abs(arr[right] - x)) {
                --left
            } else {
                ++right
            }
        }
        return arr.copyOfRange(left + 1, right)
    }
}
