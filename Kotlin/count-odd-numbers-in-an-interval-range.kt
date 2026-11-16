package countoddnumbersinanintervalrange

// Time:  O(n)
// Space: O(1)
class Solution {
    fun countOdds(low: Int, high: Int): Int {
        return (high + 1) / 2 - (low - 1 + 1) / 2
    }
}
