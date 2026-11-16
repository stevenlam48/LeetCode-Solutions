package minimumtimetocompletealltasks

// Time:  O(nlogn + n * r), r = max(e for _, e in tasks)
// Space: O(r)

class Solution {
    fun findMinimumTime(tasks: Array<IntArray>): Int {
        tasks.sortBy { it[1] }
        val lookup = HashSet<Int>()
        for (task in tasks) {
            val start = task[0]
            val end = task[1]
            var duration = task[2]
            for (i in start..end) {
                if (i in lookup) {
                    --duration
                }
            }
            var i = end
            while (duration > 0) {
                if (i !in lookup) {
                    lookup.add(i)
                    --duration
                }
                --i
            }
        }
        return lookup.size
    }
}
