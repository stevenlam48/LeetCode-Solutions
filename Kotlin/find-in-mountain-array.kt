package findinmountainarray
// Time:  O(logn)
// Space: O(1)

interface MountainArray {
    fun get(index: Int): Int
    fun length(): Int
}

class Solution {
    fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
        val peak = binarySearch(mountainArr, 0, mountainArr.length() - 1) { x ->
            mountainArr.get(x) >= mountainArr.get(x + 1)
        }
        val left = binarySearch(mountainArr, 0, peak) { x ->
            mountainArr.get(x) >= target
        }
        if (left <= peak && mountainArr.get(left) == target) {
            return left
        }
        val right = binarySearch(mountainArr, peak, mountainArr.length() - 1) { x ->
            mountainArr.get(x) <= target
        }
        if (right <= mountainArr.length() - 1 && mountainArr.get(right) == target) {
            return right
        }
        return -1
    }

    private fun binarySearch(
        array: MountainArray,
        initialLeft: Int,
        initialRight: Int,
        check: (Int) -> Boolean
    ): Int {
        var left = initialLeft
        var right = initialRight
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
