package minimumoperationstomakearrayequal

// Time:  O(1)
// Space: O(1)

class Solution {
    fun minOperations(n: Int): Int {
        return (n / 2) * ((n + 1) / 2)
    }
}
