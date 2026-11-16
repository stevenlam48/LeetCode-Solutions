package minimumconsecutivecardstopickup

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minimumCardPickup(cards: IntArray): Int {
        val INF = Int.MAX_VALUE
        val lookup = HashMap<Int, Int>()
        var result = INF
        for (i in cards.indices) {
            if (lookup.containsKey(cards[i])) {
                result = minOf(result, i - lookup.getValue(cards[i]) + 1)
            }
            lookup[cards[i]] = i
        }
        return if (result != INF) result else -1
    }
}
