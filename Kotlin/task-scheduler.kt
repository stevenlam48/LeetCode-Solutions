package taskscheduler
// Time:  O(n)
// Space: O(26) = O(1)

class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val count = HashMap<Char, Int>()
        var maxCount = 0
        for (task in tasks) {
            count[task] = count.getOrDefault(task, 0) + 1
            maxCount = maxOf(maxCount, count[task]!!)
        }
        var result = (maxCount - 1) * (n + 1)
        for (value in count.values) {
            if (value == maxCount) {
                ++result
            }
        }
        return maxOf(result, tasks.size)
    }
}
