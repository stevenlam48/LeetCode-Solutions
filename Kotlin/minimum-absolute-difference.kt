package minimumabsolutedifference

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minimumAbsDifference(arr: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var minDiff = Int.MAX_VALUE
        arr.sort()
        for (i in 0 until arr.size - 1) {
            val diff = arr[i + 1] - arr[i]
            if (diff < minDiff) {
                minDiff = diff
                result.clear()
                result.add(intArrayOf(arr[i], arr[i + 1]))
            } else if (diff == minDiff) {
                result.add(intArrayOf(arr[i], arr[i + 1]))
            }
        }
        return result.toTypedArray()
    }
}
