package shortestsubarraytoberemovedtomakearraysorted

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        var j = arr.size - 1
        while (j >= 1) {
            if (arr[j - 1] > arr[j]) {
                break
            }
            --j
        }
        if (j == 0) {
            return 0
        }
        var result = j
        for (i in arr.indices) {
            if (i > 0 && arr[i - 1] > arr[i]) {
                break
            }
            while (j < arr.size && arr[i] > arr[j]) {
                ++j
            }
            result = minOf(result, (j - i + 1) - 2)
        }
        return result
    }
}
