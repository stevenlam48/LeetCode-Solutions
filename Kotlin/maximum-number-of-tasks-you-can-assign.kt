package maximumnumberoftasksyoucanassign

// Time:  O(n * (logn)^2)
// Space: O(n)

class Solution {
    fun maxTaskAssign(tasks: IntArray, workers: IntArray, pills: Int, strength: Int): Int {
        tasks.sort()
        workers.sort()
        var left = 1
        var right = minOf(tasks.size, workers.size)
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (!check(tasks, workers, pills, strength, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return right
    }

    private fun check(tasks: IntArray, workers: IntArray, pills: Int, strength: Int, x: Int): Boolean {
        val t = java.util.TreeMap<Int, Int>()
        for (i in 0 until x) {
            t.merge(tasks[i], 1, Int::plus)
        }
        var remainingPills = pills
        for (i in workers.size - x until workers.size) {
            val key = t.floorKey(workers[i])
            if (key != null) {
                removeOne(t, key)
                continue
            }
            if (remainingPills > 0) {
                val keyWithPill = t.floorKey(workers[i] + strength)
                if (keyWithPill != null) {
                    removeOne(t, keyWithPill)
                    --remainingPills
                    continue
                }
            }
            return false
        }
        return true
    }

    private fun removeOne(t: java.util.TreeMap<Int, Int>, key: Int) {
        val v = t[key]!!
        if (v == 1) {
            t.remove(key)
        } else {
            t[key] = v - 1
        }
    }
}
