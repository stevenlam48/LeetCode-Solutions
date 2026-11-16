package countofunfinishedtasksaftereachshift

// Time:  O(n + mlogn)
// Space: O(n)

// prefix sum, binary search
class Solution {
    fun countTasks(tasks: IntArray, shifts: IntArray): IntArray {
        val prefix = LongArray(tasks.size + 1)
        for (i in tasks.indices) {
            prefix[i + 1] = prefix[i] + tasks[i]
        }
        val result = IntArray(shifts.size)
        var total = 0L
        for (i in shifts.indices) {
            total += shifts[i]
            if (total >= prefix.last()) {
                total = 0
                continue
            }
            result[i] = prefix.size - upperBound(prefix, total)
        }
        return result
    }

    private fun upperBound(a: LongArray, target: Long): Int {
        var lo = 0
        var hi = a.size
        while (lo < hi) {
            val mid = (lo + hi) ushr 1
            if (a[mid] <= target) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }
}
