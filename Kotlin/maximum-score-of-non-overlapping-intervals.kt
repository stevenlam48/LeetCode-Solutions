package maximumscoreofnonoverlappingintervals

// Time:  O(nlogn + n * k^2)
// Space: O(n * k^2)

import java.util.TreeMap

private data class State(val weight: Long, val indices: List<Int>)

class Solution {
    fun maximumWeight(intervals: Array<IntArray>): IntArray {
        val k = 4
        val intervalComparator = compareBy<Triple<Int, Int, Int>> { it.first }
            .thenBy { it.second }
            .thenBy { it.third }
        val lookup = TreeMap<Triple<Int, Int, Int>, Int>(intervalComparator)
        for (i in intervals.indices) {
            val l = intervals[i][0]
            val r = intervals[i][1]
            val w = intervals[i][2]
            val key = Triple(r, l, w)
            if (!lookup.containsKey(key)) {
                lookup[key] = i
            }
        }
        val sortedIntervals = lookup.keys.toList()
        val dp = Array(sortedIntervals.size + 1) {
            Array(k + 1) { State(0L, emptyList()) }
        }

        fun upperBound(target: Triple<Int, Int, Int>): Int {
            var left = 0
            var right = sortedIntervals.size
            while (left < right) {
                val mid = (left + right).ushr(1)
                if (intervalComparator.compare(sortedIntervals[mid], target) <= 0) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            return left
        }

        fun isBetter(a: State, b: State): Boolean {
            if (a.weight != b.weight) {
                return a.weight < b.weight
            }
            for (i in 0 until minOf(a.indices.size, b.indices.size)) {
                if (a.indices[i] != b.indices[i]) {
                    return a.indices[i] < b.indices[i]
                }
            }
            return a.indices.size < b.indices.size
        }

        for (i in 0 until sortedIntervals.size) {
            val j = upperBound(Triple(sortedIntervals[i].second, 0, 0)) - 1
            val idx = lookup[sortedIntervals[i]]!!
            for (count in 1..k) {
                val previous = dp[j + 1][count - 1]
                val newIndices = previous.indices.toMutableList()
                val insertionPoint = newIndices.binarySearch(idx)
                newIndices.add(
                    if (insertionPoint >= 0) insertionPoint + 1 else -insertionPoint - 1,
                    idx
                )
                val newState = State(previous.weight - sortedIntervals[i].third, newIndices)
                dp[i + 1][count] = if (isBetter(newState, dp[i][count])) {
                    newState
                } else {
                    dp[i][count]
                }
            }
        }
        return dp[sortedIntervals.size][k].indices.toIntArray()
    }
}
