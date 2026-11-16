package countsubstringsstartingandendingwithgivencharacter
// Time:  O(n)
// Space: O(1)

class Solution {
    fun countSubstrings(s: String, c: Char): Long {
        val n = s.count { it == c }.toLong()
        return (n + 1) * n / 2
    }
}
