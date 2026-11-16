package addingspacestoastring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun addSpaces(s: String, spaces: IntArray): String {
        var prev = s.length
        val result = CharArray(s.length + spaces.size)
        for (i in s.indices) {
            result[i] = s[i]
        }
        for (i in spaces.indices.reversed()) {
            for (j in prev - 1 downTo spaces[i]) {
                result[j + 1 + i] = s[j]
            }
            result[spaces[i] + i] = ' '
            prev = spaces[i]
        }
        return String(result)
    }
}
