package maximumelementafterdecreasingandrearranging

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        arr.sort()
        var result = 1
        for (i in 1 until arr.size) {
            result = minOf(result + 1, arr[i])
        }
        return result
    }
}
