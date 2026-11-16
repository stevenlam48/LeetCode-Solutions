package maximizethetotalheightofuniquetowers

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maximumTotalSum(maximumHeight: IntArray): Long {
        maximumHeight.sortDescending()
        var result = 0L
        var prev = maximumHeight[0] + 1
        for (x in maximumHeight) {
            prev = minOf(x, prev - 1)
            if (prev == 0) {
                return -1
            }
            result += prev
        }
        return result
    }
}
