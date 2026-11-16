package separateblackandwhiteballs

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumSteps(s: String): Long {
        var result = 0L
        var left = 0
        for (right in s.indices) {
            if (s[right] != '0') {
                continue
            }
            result += right - left
            ++left
        }
        return result
    }
}
