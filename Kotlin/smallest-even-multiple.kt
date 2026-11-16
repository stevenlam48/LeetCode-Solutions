package smallestevenmultiple

// Time:  O(1)
// Space: O(1)

class Solution {
    fun smallestEvenMultiple(n: Int): Int {
        return n shl (n and 1)
    }
}
