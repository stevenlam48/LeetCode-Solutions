package uniquelength3palindromicsubsequences

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        val first = IntArray(26) { s.length }
        val last = IntArray(26) { -1 }
        for (i in s.indices) {
            val idx = s[i] - 'a'
            first[idx] = minOf(first[idx], i)
            last[idx] = maxOf(last[idx], i)
        }
        var result = 0
        for (i in 0 until 26) {
            if (first[i] < last[i]) {
                val seen = HashSet<Char>()
                for (j in first[i] + 1 until last[i]) {
                    seen.add(s[j])
                }
                result += seen.size
            }
        }
        return result
    }
}
