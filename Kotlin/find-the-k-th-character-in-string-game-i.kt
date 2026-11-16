package findthekthcharacterinstringgamei

// Time:  O(1)
// Space: O(1)

class Solution {
    fun kthCharacter(k: Int): Char {
        return 'a' + Integer.bitCount(k - 1) % 26
    }
}
