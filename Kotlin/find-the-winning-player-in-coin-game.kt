package findthewinningplayerincoingame

// Time:  O(1)
// Space: O(1)

// math
class Solution {
    fun losingPlayer(x: Int, y: Int): String {
        return if (minOf(x, y / 4) % 2 != 0) "Alice" else "Bob"
    }
}
