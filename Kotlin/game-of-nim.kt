package gameofnim

// Time:  O(n)
// Space: O(1)

class Solution {
    fun nimGame(piles: IntArray): Boolean {
        var result = 0
        for (pile in piles) {
            result = result xor pile
        }
        return result != 0
    }
}
