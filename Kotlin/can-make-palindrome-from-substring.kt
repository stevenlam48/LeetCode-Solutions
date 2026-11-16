package canmakepalindromefromsubstring

// Time:  O(m + n), m is the number of queries, n is the length of s
// Space: O(n)

class Solution {
    fun canMakePaliQueries(s: String, queries: Array<IntArray>): List<Boolean> {
        val charsetSize = 26
        val curr = IntArray(charsetSize)
        val count = mutableListOf(IntArray(charsetSize))
        for (c in s) {
            ++curr[c - 'a']
            count.add(curr.copyOf())
        }
        val result = mutableListOf<Boolean>()
        for (query in queries) {
            val left = query[0]
            val right = query[1]
            val k = query[2]
            var total = 0
            for (i in 0 until charsetSize) {
                total += (count[right + 1][i] - count[left][i]) % 2
            }
            result.add(total / 2 <= k)
        }
        return result
    }
}
