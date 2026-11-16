package minimumprocessingtime
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minProcessingTime(processorTime: IntArray, tasks: IntArray): Int {
        val k = 4
        processorTime.sort()
        tasks.sortDescending()
        var result = 0
        for (i in processorTime.indices) {
            for (j in 0 until k) {
                result = maxOf(result, processorTime[i] + tasks[i * k + j])
            }
        }
        return result
    }
}
