package flipgame

// Time:  O(c * n + n) = O(n * (c+1)), n is length of string, c is count of "++"
// Space: O(1), no extra space excluding the result which requires at most O(n^2) space

class Solution {
    fun generatePossibleNextMoves(s: String): List<String> {
        val res = mutableListOf<String>()
        val current = s.toCharArray()
        val n = current.size
        var i = 0
        while (i < n - 1) {
            if (current[i] == '+') {
                while (i < n - 1 && current[i + 1] == '+') {
                    current[i] = '-'
                    current[i + 1] = '-'
                    res.add(String(current))
                    current[i] = '+'
                    current[i + 1] = '+'
                    i++
                }
            }
            i++
        }
        return res
    }
}
