package processtasksusingservers

import java.util.PriorityQueue

// Time:  O(n + mlogn)
// Space: O(n)

class Solution {
    fun assignTasks(servers: IntArray, tasks: IntArray): IntArray {
        val idle = PriorityQueue(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        for (i in servers.indices) {
            idle.add(Pair(servers[i], i))
        }
        val working = PriorityQueue(
            compareBy<Triple<Int, Int, Int>> { it.first }.thenBy { it.second }.thenBy { it.third }
        )
        val result = IntArray(tasks.size)
        var t = 0
        for (i in tasks.indices) {
            t = if (idle.isNotEmpty()) maxOf(t, i) else working.peek().first
            while (working.isNotEmpty() && working.peek().first <= t) {
                val (_, w, idx) = working.poll()
                idle.add(Pair(w, idx))
            }
            val (w, idx) = idle.poll()
            working.add(Triple(t + tasks[i], w, idx))
            result[i] = idx
        }
        return result
    }
}
