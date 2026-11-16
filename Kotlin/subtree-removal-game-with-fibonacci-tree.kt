package subtreeremovalgamewithfibonaccitree

// Time:  O(1)
// Space: O(1)
class Solution {
    fun findGameWinner(n: Int): Boolean {
        return n % 6 != 1
    }
}
