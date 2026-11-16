package numberofnodeswithvalueone

// Time:  O(q + n)
// Space: O(n)

class Solution {
    fun numberOfNodes(n: Int, queries: IntArray): Int {
        val counts = IntArray(n)
        for (query in queries) {
            counts[query - 1]++
        }

        var result = 0
        var queue = ArrayDeque<Pair<Int, Int>>()
        queue.add(1 to 0)
        while (queue.isNotEmpty()) {
            val newQueue = ArrayDeque<Pair<Int, Int>>()
            for ((u, previous) in queue) {
                val current = previous xor (counts[u - 1] % 2)
                result += current
                for (v in 2 * u..minOf(2 * u + 1, n)) {
                    newQueue.add(v to current)
                }
            }
            queue = newQueue
        }
        return result
    }
}
