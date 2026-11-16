package minimumoperationstoreduceanintegerto0

// Time:  O(logn)
// Space: O(1)

// greedy, trick
class Solution {
    fun minOperations(n: Int): Int {
        return java.lang.Integer.bitCount(n xor (n * 0b11))
    }
}
