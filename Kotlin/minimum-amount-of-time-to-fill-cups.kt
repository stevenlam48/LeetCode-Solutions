package minimumamountoftimetofillcups

// Time:  O(1)
// Space: O(1)

class Solution {
    fun fillCups(amount: IntArray): Int {
        return maxOf(amount.max(), (amount.sum() + 1) / 2)
    }
}
