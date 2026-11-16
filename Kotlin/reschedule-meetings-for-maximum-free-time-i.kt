package reschedulemeetingsformaximumfreetimei

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxFreeTime(eventTime: Int, k: Int, startTime: IntArray, endTime: IntArray): Int {
        val start = startTime.toMutableList().apply { add(eventTime) }
        val end = endTime.toMutableList().apply { add(0, 0) }
        var result = 0
        var curr = 0
        for (i in start.indices) {
            curr += start[i] - end[i]
            result = maxOf(result, curr)
            if (i - k >= 0) {
                curr -= start[i - k] - end[i - k]
            }
        }
        return result
    }
}
