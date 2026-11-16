package sumofmutatedarrayclosesttotarget

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun findBestValue(arr: IntArray, target: Int): Int {
        arr.sortDescending()
        val maxArr = arr[0]
        var remaining = target
        var size = arr.size
        while (size > 0 && arr[size - 1] * size <= remaining) {
            remaining -= arr[size - 1]
            --size
        }
        return if (size == 0) {
            maxArr
        } else {
            (2 * remaining + size - 1) / (2 * size)
        }
    }
}
