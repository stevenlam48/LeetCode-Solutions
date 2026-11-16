package bestpokerhand

// Time:  O(1)
// Space: O(1)

class Solution {
    fun bestHand(ranks: IntArray, suits: CharArray): String {
        val lookup = arrayOf("", "High Card", "Pair", "Three of a Kind", "Three of a Kind", "Three of a Kind")
        if (suits.all { it == suits[0] }) {
            return "Flush"
        }
        val counts = IntArray(13)
        for (rank in ranks) {
            ++counts[rank - 1]
        }
        return lookup[counts.max()]
    }
}
