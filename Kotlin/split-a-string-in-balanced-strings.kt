package splitastringinbalancedstrings

// Time:  O(n)
// Space: O(1)

class Solution {
    fun balancedStringSplit(s: String): Int {
        var result = 0
        var count = 0
        for (c in s) {
            count += if (c == 'L') 1 else -1
            if (count == 0) {
                ++result
            }
        }
        return result
    }
}
