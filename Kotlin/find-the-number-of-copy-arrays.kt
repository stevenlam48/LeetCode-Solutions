package findthenumberofcopyarrays

// Time:  O(n)
// Space: O(1)

// greedy
class Solution {
    fun countArrays(original: IntArray, bounds: Array<IntArray>): Int {
        var left = bounds[0][0]
        var right = bounds[0][1]
        var result = right - left + 1
        for (i in 1 until original.size) {
            val diff = original[i] - original[i - 1]
            left = maxOf(left + diff, bounds[i][0])
            right = minOf(right + diff, bounds[i][1])
            result = minOf(result, maxOf(right - left + 1, 0))
        }
        return result
    }
}
