package aggregatetwotimeseries

// Time:  O(n + m)
// Space: O(1)

class Solution {
    fun aggregateTimeSeries(series1: Array<IntArray>, series2: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var i = 0
        var j = 0
        while (i != series1.size || j != series2.size) {
            if (j == series2.size || (i != series1.size && series1[i][0] < series2[j][0])) {
                result.add(intArrayOf(series1[i][0], series1[i][1] + if (j != series2.size) series2[j][1] else 0))
                ++i
            } else if (i == series1.size || (j != series2.size && series2[j][0] < series1[i][0])) {
                result.add(intArrayOf(series2[j][0], series2[j][1] + if (i != series1.size) series1[i][1] else 0))
                ++j
            } else {
                result.add(intArrayOf(series1[i][0], series1[i][1] + series2[j][1]))
                ++i
                ++j
            }
        }
        return result.toTypedArray()
    }
}
