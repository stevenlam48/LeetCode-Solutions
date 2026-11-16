package countuniquecharactersofallsubstringsofagivenstring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun uniqueLetterString(s: String): Int {
        val mod = 1_000_000_007L
        var result = 0L
        val index = Array(26) { IntArray(2) { -1 } }
        for (i in s.indices) {
            val c = s[i] - 'A'
            result = (result + (i - index[c][1]).toLong() *
                (index[c][1] - index[c][0])) % mod
            index[c][0] = index[c][1]
            index[c][1] = i
        }
        for (c in 0 until 26) {
            result = (result + (s.length - index[c][1]).toLong() *
                (index[c][1] - index[c][0])) % mod
        }
        return result.toInt()
    }
}
