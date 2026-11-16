package timeneededtobuytickets
// Time:  O(n)
// Space: O(1)

class Solution {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        var result = 0
        for (i in tickets.indices) {
            result += minOf(tickets[i], if (i <= k) tickets[k] else tickets[k] - 1)
        }
        return result
    }
}
