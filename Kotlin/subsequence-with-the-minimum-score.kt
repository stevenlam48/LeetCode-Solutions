package subsequencewiththeminimumscore

// Time:  O(n)
// Space: O(n)

// two pointers, dp
class Solution {
    fun minimumScore(s: String, t: String): Int {
        val right = IntArray(s.length) { -1 }
        var j = t.length - 1
        for (i in s.length - 1 downTo 0) {
            if (j >= 0 && t[j] == s[i]) {
                --j
            }
            right[i] = j
        }
        var result = j + 1
        var left = 0
        for (i in s.indices) {
            result = maxOf(minOf(result, right[i] - left + 1), 0)
            if (left < t.length && t[left] == s[i]) {
                ++left
            }
        }
        result = minOf(result, t.length - left)
        return result
    }
}
