package thenumberofthesmallestunoccupiedchair

import java.util.PriorityQueue

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun smallestChair(times: Array<IntArray>, targetFriend: Int): Int {
        val events = ArrayList<IntArray>()
        for (i in times.indices) {
            events.add(intArrayOf(times[i][0], 1, i))
            events.add(intArrayOf(times[i][1], 0, i))
        }
        events.sortWith(compareBy({ it[0] }, { it[1] }))

        val lookup = HashMap<Int, Int>()
        val minHeap = PriorityQueue<Int>()
        for (e in events) {
            val arrival = e[1] == 1
            val i = e[2]
            if (!arrival) {
                minHeap.add(lookup[i]!!)
                lookup.remove(i)
                continue
            }
            if (minHeap.isNotEmpty()) {
                lookup[i] = minHeap.poll()
            } else {
                lookup[i] = lookup.size
            }
            if (i == targetFriend) {
                break
            }
        }
        return lookup[targetFriend]!!
    }
}
