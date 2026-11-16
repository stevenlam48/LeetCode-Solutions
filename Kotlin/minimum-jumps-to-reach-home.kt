package minimumjumpstoreachhome

// Time:  O(max(x, max(forbidden)) + a + (b+a))
// Space: O(max(x, max(forbidden)) + a + (b+a))

class Solution {
    fun minimumJumps(forbidden: IntArray, a: Int, b: Int, x: Int): Int {
        val maxF = forbidden.max()
        val maxVal = if (a >= b) x + b else maxOf(x, maxF) + a + b
        val lookup = arrayOf(hashSetOf<Int>(), hashSetOf<Int>())
        for (pos in forbidden) {
            lookup[0].add(pos)
            lookup[1].add(pos)
        }
        var result = 0
        var queue = mutableListOf(0 to true)
        lookup[0].add(0)
        while (queue.isNotEmpty()) {
            val newQueue = mutableListOf<Pair<Int, Boolean>>()
            for ((pos, canBack) in queue) {
                if (pos == x) {
                    return result
                }
                if (pos + a <= maxVal && !lookup[0].contains(pos + a)) {
                    lookup[0].add(pos + a)
                    newQueue.add(pos + a to true)
                }
                if (!canBack) {
                    continue
                }
                if (pos - b >= 0 && !lookup[1].contains(pos - b)) {
                    lookup[1].add(pos - b)
                    newQueue.add(pos - b to false)
                }
            }
            queue = newQueue
            ++result
        }
        return -1
    }
}
