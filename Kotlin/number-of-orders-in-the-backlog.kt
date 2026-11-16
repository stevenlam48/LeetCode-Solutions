package numberofordersinthebacklog

// Time:  O(nlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun getNumberOfBacklogOrders(orders: Array<IntArray>): Int {
        val mod = 1_000_000_007
        val comparator = compareBy<IntArray> { it[0] }
            .thenBy { it[1] }
            .thenBy { it[2] }
        val buy = PriorityQueue<IntArray>(comparator.reversed())
        val sell = PriorityQueue<IntArray>(comparator)

        for (order in orders) {
            if (order[2] == 0) {
                buy.add(order.copyOf())
            } else {
                sell.add(order.copyOf())
            }
            while (buy.isNotEmpty() && sell.isNotEmpty() && sell.peek()[0] <= buy.peek()[0]) {
                val amount = minOf(buy.peek()[1], sell.peek()[1])
                var current = buy.remove()
                current[1] -= amount
                if (current[1] != 0) {
                    buy.add(current)
                }
                current = sell.remove()
                current[1] -= amount
                if (current[1] != 0) {
                    sell.add(current)
                }
            }
        }

        var result = 0
        while (buy.isNotEmpty()) {
            result = (result + buy.remove()[1]) % mod
        }
        while (sell.isNotEmpty()) {
            result = (result + sell.remove()[1]) % mod
        }
        return result
    }
}
