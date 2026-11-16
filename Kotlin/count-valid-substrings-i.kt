package countvalidsubstringsi

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countValidSubstrings(s: String): Long {
        var result = 0L
        var l = 0L
        for (i in s.indices) {
            ++l
            if (!(i - 2 >= 0 && s.substring(i - 2, i + 1) == "abc")) {
                continue
            }
            result += (l - 1) * l / 2 - 1
            l = 2
        }
        result += l * (l + 1) / 2
        return result
    }
}
