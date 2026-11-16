package taskschedulerii
// Time:  O(n)
// Space: O(n)

class Solution {
    fun taskSchedulerII(tasks: IntArray, space: Int): Long {
        val lookup = HashMap<Int, Long>()
        var result = 0L
        for (task in tasks) {
            result = maxOf(lookup.getOrDefault(task, 0L), result + 1)
            lookup[task] = result + space + 1
        }
        return result
    }
}
