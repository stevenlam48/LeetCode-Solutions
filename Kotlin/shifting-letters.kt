package shiftingletters

// Time:  O(n)
// Space: O(1)

class Solution {
    fun shiftingLetters(s: String, shifts: IntArray): String {
        val result = StringBuilder()
        var times = shifts.sumOf { it.toLong() } % 26
        for (i in s.indices) {
            val shift = (s[i] - 'a' + times) % 26
            result.append(('a'.code + shift.toInt()).toChar())
            times = ((times - shifts[i]) % 26 + 26) % 26
        }
        return result.toString()
    }
}
