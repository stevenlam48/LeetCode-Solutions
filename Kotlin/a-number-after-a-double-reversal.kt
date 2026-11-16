package anumberafteradoublereversal

// Time:  O(1)
// Space: O(1)

class Solution {
    fun isSameAfterReversals(num: Int): Boolean {
        return num == 0 || num % 10 != 0
    }
}
