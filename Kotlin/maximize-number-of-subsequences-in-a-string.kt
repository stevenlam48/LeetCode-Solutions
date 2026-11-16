package maximizenumberofsubsequencesinastring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumSubsequenceCount(text: String, pattern: String): Long {
        var result = 0L
        var cnt1 = 0
        var cnt2 = 0
        for (c in text) {
            if (c == pattern[1]) {
                result += cnt1
                ++cnt2
            }
            if (c == pattern[0]) {
                ++cnt1
            }
        }
        return result + maxOf(cnt1, cnt2)
    }
}
