package minimumoperationstotransformstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minOperations(s: String): Int {
        var result = 0
        for (x in s) {
            result = maxOf(result, (26 - (x - 'a')) % 26)
        }
        return result
    }
}
