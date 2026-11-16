package teemoattacking
// Time:  O(n)
// Space: O(1)

class Solution {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        var result = duration * timeSeries.size
        for (i in 1 until timeSeries.size) {
            result -= maxOf(0, duration - (timeSeries[i] - timeSeries[i - 1]))
        }
        return result
    }
}
