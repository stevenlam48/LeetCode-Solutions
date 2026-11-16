package constructtargetarraywithmultiplesums

import java.util.PriorityQueue

// Time:  O(log(max(t)) * logn)
// Space: O(n)

class Solution {
    fun isPossible(target: IntArray): Boolean {
        // (1) x + remain = y
        // (2) y + remain = total
        // (1) - (2) => x - y = y - total
        //           => x = 2*y - total
        var total = 0L
        for (v in target) {
            total += v
        }
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        for (v in target) {
            maxHeap.add(v)
        }
        while (total != target.size.toLong()) {
            val y = maxHeap.poll()
            val remain = total - y
            var x = y - remain
            if (x <= 0) {
                return false
            }
            if (remain == 0L) {
                return false
            }
            if (x > remain) {  // for case [1, 1000000000]
                x = x % remain + remain
            }
            maxHeap.add(x.toInt())
            total = x + remain
        }
        return true
    }
}
