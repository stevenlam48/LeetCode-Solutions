package consecutivecharacters
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxPower(s: String): Int {
        var result = 1
        var count = 1
        for (i in 1 until s.length) {
            if (s[i] == s[i - 1]) {
                ++count
            } else {
                count = 1
            }
            result = maxOf(result, count)
        }
        return result
    }
}
