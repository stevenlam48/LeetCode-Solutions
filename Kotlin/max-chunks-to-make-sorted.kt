package maxchunkstomakesorted

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxChunksToSorted(arr: IntArray): Int {
        var result = 0
        var maxI = 0
        for (i in arr.indices) {
            maxI = maxOf(maxI, arr[i])
            if (maxI == i) {
                result++
            }
        }
        return result
    }
}
