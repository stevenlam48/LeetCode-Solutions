package maximumnumberofintersectionsonthechart
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun maxIntersectionCount(y: IntArray): Int {
        val sortedSetY = y.toHashSet().sorted()
        val valToIdx = HashMap<Int, Int>()
        for (i in sortedSetY.indices) {
            valToIdx[sortedSetY[i]] = i
        }
        val cnts = IntArray(2 * valToIdx.size + 1)
        for (i in 0 until y.size - 1) {
            val left = 2 * valToIdx.getValue(y[i])
            val right = 2 * valToIdx.getValue(y[i + 1]) + if (y[i] < y[i + 1]) -1 else 1
            ++cnts[minOf(left, right)]
            --cnts[maxOf(left, right) + 1]
        }
        ++cnts[2 * valToIdx.getValue(y.last())]
        --cnts[2 * valToIdx.getValue(y.last()) + 1]
        var result = 0
        var cnt = 0
        for (c in cnts) {
            cnt += c
            result = maxOf(result, cnt)
        }
        return result
    }
}
