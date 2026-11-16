package percentageofletterinstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun percentageLetter(s: String, letter: Char): Int {
        return 100 * s.count { it == letter } / s.length
    }
}
