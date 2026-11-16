package maximumtransactionswithoutnegativebalance

// Time:  O(nlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun maxTransactions(transactions: IntArray): Int {
        val minHeap = PriorityQueue<Int>()
        var current = 0L
        for (x in transactions) {
            minHeap.add(x)
            current += x
            if (current < 0) {
                current -= minHeap.remove()
            }
        }
        return minHeap.size
    }
}
