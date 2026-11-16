package shiftinglettersii

// Time:  O(n)
// Space: O(n)

class Solution {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val events = IntArray(s.length + 1)
        for (shift in shifts) {
            val direction = if (shift[2] != 0) 1 else -1
            events[shift[0]] += direction
            events[shift[1] + 1] -= direction
        }
        val result = s.toCharArray()
        var current = 0
        for (i in result.indices) {
            current += events[i]
            val shift = ((result[i] - 'a' + current) % 26 + 26) % 26
            result[i] = ('a'.code + shift).toChar()
        }
        return String(result)
    }
}
