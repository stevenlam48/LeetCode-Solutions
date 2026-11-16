package numberofwonderfulsubstrings

// Time:  O(n)
// Space: O(2^10)

class Solution {
    fun wonderfulSubstrings(word: String): Long {
        val alphabetSize = 10
        val count = IntArray(1 shl alphabetSize)
        count[0] = 1
        var result = 0L
        var curr = 0
        for (c in word) {
            curr = curr xor (1 shl (c - 'a'))
            result += count[curr]
            for (i in 0 until alphabetSize) {
                result += count[curr xor (1 shl i)]
            }
            ++count[curr]
        }
        return result
    }
}
