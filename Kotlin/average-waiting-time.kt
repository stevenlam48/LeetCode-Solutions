package averagewaitingtime

// Time:  O(n)
// Space: O(1)

class Solution {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        var avai = 0.0
        var wait = 0.0
        for (c in customers) {
            avai = maxOf(avai, c[0].toDouble()) + c[1]
            wait += avai - c[0]
        }
        return wait / customers.size
    }
}
