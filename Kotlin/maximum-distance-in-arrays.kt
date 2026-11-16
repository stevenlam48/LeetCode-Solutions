package maximumdistanceinarrays
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxDistance(arrays: Array<IntArray>): Int {
        var result = 0
        var minValue = arrays[0].first()
        var maxValue = arrays[0].last()
        for (i in 1 until arrays.size) {
            result = maxOf(
                result,
                maxOf(maxValue - arrays[i].first(), arrays[i].last() - minValue)
            )
            minValue = minOf(minValue, arrays[i].first())
            maxValue = maxOf(maxValue, arrays[i].last())
        }
        return result
    }
}
