package hashdividedstring

// Time:  O(n)
// Space: O(1)
class Solution {
    fun stringHash(s: String, k: Int): String {
        val result = CharArray(s.length / k) { 'a' }
        var i = 0
        while (i < s.length) {
            var curr = 0
            for (j in 0 until k) {
                curr = (curr + (s[i + j] - 'a')) % 26
            }
            result[i / k] = (result[i / k] + curr)
            i += k
        }
        return String(result)
    }
}
