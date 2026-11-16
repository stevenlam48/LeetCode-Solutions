package singlethreadedcpu

// Time:  O(nlogn)
// Space: O(n)
class Solution {
    fun getOrder(tasks: Array<IntArray>): IntArray {
        val result = mutableListOf<Int>()
        val idx = Array(tasks.size) { it }
        idx.sortWith(compareBy { tasks[it][0] })
        val minHeap = java.util.PriorityQueue<Pair<Int, Int>>(
            compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second }
        )
        var i = 0
        var time = tasks[idx[i]][0].toLong()
        while (i < idx.size || minHeap.isNotEmpty()) {
            while (i < idx.size && tasks[idx[i]][0].toLong() <= time) {
                minHeap.add(tasks[idx[i]][1] to idx[i])
                ++i
            }
            if (minHeap.isEmpty()) {
                time = tasks[idx[i]][0].toLong()
                continue
            }
            val (t, j) = minHeap.remove()
            time += t
            result.add(j)
        }
        return result.toIntArray()
    }
}
