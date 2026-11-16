package numberofsubstringswithonly1s
// Time:  O(n)
// Space: O(1)

class Solution {
    fun numSub(s: String): Int {
        val mod = 1_000_000_007
        var result = 0
        var count = 0
        for (character in s) {
            count = if (character == '1') count + 1 else 0
            result = (result + count) % mod
        }
        return result
    }
}
