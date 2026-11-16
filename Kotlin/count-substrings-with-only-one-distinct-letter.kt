package countsubstringswithonlyonedistinctletter
// Time:  O(n)
// Space: O(1)

class Solution {
    fun countLetters(S: String): Int {
        var result = S.length
        var left = 0
        for (right in 1 until S.length) {
            if (S[right] == S[left]) {
                result += right - left
            } else {
                left = right
            }
        }
        return result
    }
}
