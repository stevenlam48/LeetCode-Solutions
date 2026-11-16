package generateastringwithcharactersthathaveoddcounts

// Time:  O(n)
// Space: O(1)

class Solution {
    fun generateTheString(n: Int): String {
        val result = StringBuilder()
        repeat(n - 1) {
            result.append('a')
        }
        result.append(if (n % 2 != 0) 'a' else 'b')
        return result.toString()
    }
}
