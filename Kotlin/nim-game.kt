package nimgame
// Time:  O(1)
// Soace: O(1)

class Solution {
    fun canWinNim(n: Int): Boolean {
        return n % 4 != 0
    }
}
