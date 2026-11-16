package minimuminitialenergytofinishtasks
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minimumEffort(tasks: Array<IntArray>): Int {
        tasks.sortWith(compareBy { it[1] - it[0] })
        var result = 0
        for (task in tasks) {
            result = maxOf(result + task[0], task[1])
        }
        return result
    }
}
