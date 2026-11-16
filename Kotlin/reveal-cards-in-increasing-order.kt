package revealcardsinincreasingorder

import java.util.ArrayDeque

// Time:  O(n)
// Space: O(n)

class Solution {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        val d = ArrayDeque<Int>()
        deck.sort()
        for (idx in deck.size - 1 downTo 0) {
            if (d.isNotEmpty()) {
                d.addFirst(d.removeLast())
            }
            d.addFirst(deck[idx])
        }
        return d.toIntArray()
    }
}
