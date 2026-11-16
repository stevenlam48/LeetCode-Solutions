package maximumrequestswithoutviolatingthelimit
// Time:  O(nlogn)
// Space: O(n)

import java.util.ArrayDeque

class Solution {
    fun maxRequests(requests: Array<IntArray>, k: Int, window: Int): Int {
        val lookup = HashMap<Int, MutableList<Int>>()
        for (request in requests) {
            lookup.getOrPut(request[0]) { mutableListOf() }.add(request[1])
        }
        var result = requests.size
        for (times in lookup.values) {
            times.sort()
            val queue = ArrayDeque<Int>()
            for (time in times) {
                queue.addLast(time)
                if (queue.size <= k) {
                    continue
                }
                if (queue.peekLast() - queue.peekFirst() > window) {
                    queue.removeFirst()
                    continue
                }
                queue.removeLast()
                --result
            }
        }
        return result
    }
}
