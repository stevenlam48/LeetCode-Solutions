package designhitcounter

// Time:  O(1), amortized
// Space: O(k), k is the count of seconds.
import java.util.ArrayDeque

class HitCounter {
    private val k = 300
    private var count = 0
    private val queue = ArrayDeque<Pair<Int, Int>>()

    fun hit(timestamp: Int) {
        getHits(timestamp)
        if (queue.isNotEmpty() && queue.last().first == timestamp) {
            val last = queue.removeLast()
            queue.addLast(last.first to last.second + 1)
        } else {
            queue.addLast(timestamp to 1)
        }
        ++count
    }

    fun getHits(timestamp: Int): Int {
        while (queue.isNotEmpty() && queue.first().first <= timestamp - k) {
            count -= queue.removeFirst().second
        }
        return count
    }
}
