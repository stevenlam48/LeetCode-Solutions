package largestevennumber

// Time:  O(n)
// Space: O(1)

class Solution {
    fun largestEven(s: String): String {
        var end = s.length
        while (end > 0 && s[end - 1] == '1') {
            --end
        }
        return s.substring(0, end)
    }
}
